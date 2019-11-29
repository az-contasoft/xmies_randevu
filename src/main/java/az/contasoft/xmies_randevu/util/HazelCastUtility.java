package az.contasoft.xmies_randevu.util;

import az.contasoft.xmies_randevu.db.entity.Randevu;
import az.contasoft.xmies_randevu.db.services.DataBaseServices;
import com.hazelcast.core.IMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HazelCastUtility {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final IMap<Long, Randevu> mapOfRandevu;
    private final DataBaseServices dataBaseServices;

    public HazelCastUtility(IMap<Long, Randevu> mapOfRandevu, DataBaseServices dataBaseServices) {
        this.mapOfRandevu = mapOfRandevu;
        this.dataBaseServices = dataBaseServices;
    }

    public Randevu saveOrUpdateRandevu(Randevu randevu) throws Exception {
        logger.info("{}", "Trying to add or update Randevu to hazelcast.. " + randevu.toString());
        randevu = dataBaseServices.insertOrUpdate(randevu);
        mapOfRandevu.put(randevu.getIdRandevu(), randevu);
        logger.info("{}", "mapOfRandevu ELAVE OLUNDU" + mapOfRandevu);
        return randevu;
    }


    public Randevu getRandevuByIdRandevu(long idRandevu) throws Exception {
        logger.info("{}", "Trying to get Randevu from hazelcast idRandevu : " + idRandevu);
        Randevu randevu = mapOfRandevu.get(idRandevu);
        if (randevu == null) {
            logger.info("{}", "Randevu not found in hazelcast. trying to get from DB");
            if (mapOfRandevu.size() > 0) {
                randevu = dataBaseServices.getRandevu(idRandevu);
                logger.info("\n-->HAZEL: " + (randevu == null ? "not found\n\n" : "found randevu : {}\n\n"), randevu);
                if (randevu != null) {
                    mapOfRandevu.put(idRandevu, randevu);
                }
            } else {
                logger.info("{}", "mapOfRandevu is empty. trying to cache");
                startCaching();
                randevu = mapOfRandevu.get(idRandevu);
            }
        }
        return randevu;
    }

    public void startCaching() {
        try {
            mapOfRandevu.clear();
            mapOfRandevu.destroy();
            logger.info("{}", "Starting to cache Randevu");
            List<Randevu> listOfRandevu = dataBaseServices.getAll();
            for (Randevu randevu : listOfRandevu) {
                mapOfRandevu.put(randevu.getIdRandevu(), randevu);
            }
            logger.info("{}", "Randevu : " + listOfRandevu.size());
        } catch (Exception e) {
            logger.error("Error {} : {}", "problem occurred when  caching", e, e);
        }
    }

    public IMap<Long, Randevu> getMapOfRandevu() {
        if (mapOfRandevu.isEmpty()) {
            logger.info("\n---> mapOfRandevu was empty therefore trying to cache\n\n");
            startCaching();
        }
        logger.info("\n-->HAZEL: got mapOfRandevu.size(): {}\n\n", mapOfRandevu.size());
        return mapOfRandevu;
    }

}
