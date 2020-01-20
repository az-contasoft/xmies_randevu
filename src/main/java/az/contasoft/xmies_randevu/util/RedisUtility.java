package az.contasoft.xmies_randevu.util;

import az.contasoft.xmies_randevu.db.entity.Randevu;
import az.contasoft.xmies_randevu.db.services.DataBaseServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RedisUtility {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final DataBaseServices dataBaseServices;

    private final RedisService redisService;

    public RedisUtility(DataBaseServices dataBaseServices, RedisService redisService) {
        this.dataBaseServices = dataBaseServices;
        this.redisService = redisService;
    }

    public Randevu saveOrUpdateRandevu(Randevu randevu) throws Exception {
        logger.info("{}", "Trying to add or update Randevu to hazelcast.. " + randevu.toString());
        randevu = dataBaseServices.insertOrUpdate(randevu);
        logger.info("MAP_OF_RANDEVU ELAVE OLUNANNAN EVVEL SAYI : {} ", redisService.getMap(RedisMapKey.MAP_OF_RANDEVU).size());
        redisService.add(randevu.getIdRandevu(), randevu, RedisMapKey.MAP_OF_RANDEVU);
        logger.info("MAP_OF_RANDEVU ELAVE OLUNANNAN SONRA SAYI : {} ", redisService.getMap(RedisMapKey.MAP_OF_RANDEVU).size());
        return randevu;
    }

    public void addOrUpdateRandevuToRedis(Randevu randevu) {
        logger.info("{}", "Trying to add or update randevu to redis.. " + randevu.toString());
        redisService.add(randevu.getIdRandevu(), randevu, RedisMapKey.MAP_OF_RANDEVU);
    }

    public void startCachingRandevuToRedis() {
        try {
            logger.info("starting Randevu redis caching.*******************.");
            List<Randevu> list = dataBaseServices.getAll();
            logger.info("list of radevu from database : " + list.size());
            for (Randevu randevu : list) {
                addOrUpdateRandevuToRedis(randevu);
            }
        } catch (Exception e) {
            logger.error("Error {} : {}", "problem occurred when trying to add Randevu to REDIS", e, e);
        }
    }

    public void startRedisCaching() {
        redisService.deleteMap(RedisMapKey.MAP_OF_RANDEVU);
        logger.info("redis cache start time : {}", LocalDateTime.now());
        startCachingRandevuToRedis();
        logger.info("redis cache end time : {}", LocalDateTime.now());
    }


    public Map<Long, Randevu> getAllMapOFRandevuFromRedis() {
        logger.info("trying to get all Randevu map...");
        try {
            Map<Long, Randevu> randevuMap = redisService.getMap(RedisMapKey.MAP_OF_RANDEVU);
            if (randevuMap == null || randevuMap.isEmpty()) {
                logger.debug("map of Randevu [not] found ");
                startRedisCaching();
                randevuMap = redisService.getMap(RedisMapKey.MAP_OF_RANDEVU);
            }
            if (randevuMap == null || randevuMap.isEmpty()) {
                logger.debug("redis not working getting from database...");
                List<Randevu> list = dataBaseServices.getAll();
                randevuMap = list.stream().collect(Collectors.toMap(Randevu::getIdRandevu, randevu -> randevu));
            }
            return randevuMap;
        } catch (Exception e) {
            logger.error("Error getting Randevu map : {} ", e, e);
            return null;
        }
    }


    public Randevu getRandevuByIdRandevu(long idRandevu) throws Exception {
        logger.info("{}", "Trying to get Randevu from redi idRandevu : " + idRandevu);
        try {
            Map<Long, Randevu> mapOfRandevu = redisService.getMap(RedisMapKey.MAP_OF_RANDEVU);
            Randevu randevu;
            if (mapOfRandevu == null || mapOfRandevu.isEmpty()) {
                logger.info("map of Randevu is null or empty trying to start cache..");
                startRedisCaching();
            } else {
                randevu = mapOfRandevu.get(idRandevu);
                if (randevu != null) {
                    logger.info("permissions found from redis : {}", randevu.toString());
                    return randevu;
                } else {
                    logger.info("randevu not Found  from redis ");
                    randevu = dataBaseServices.getRandevu(idRandevu);
                    if (randevu != null) {
                        logger.debug("permissions found from dataBase : {}", randevu.toString());
                        redisService.add(randevu.getIdRandevu(), randevu, RedisMapKey.MAP_OF_RANDEVU);
                        return randevu;
                    } else {
                        logger.debug("permissions [not] found from redis and DATABASE... randevu id : {}", idRandevu);
                    }

                }
            }
        } catch (Exception e) {
            logger.error("Error getting Randevu : {} ", e, e);
        }
        return null;
    }

}
