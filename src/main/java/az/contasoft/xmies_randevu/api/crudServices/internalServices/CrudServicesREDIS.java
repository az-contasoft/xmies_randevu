package az.contasoft.xmies_randevu.api.crudServices.internalServices;

import az.contasoft.xmies_randevu.api.crudServices.internal.UpdateRandevu;
import az.contasoft.xmies_randevu.db.entity.Randevu;
import az.contasoft.xmies_randevu.proxy.NoteProxy;
import az.contasoft.xmies_randevu.util.RedisMapKey;
import az.contasoft.xmies_randevu.util.RedisService;
import az.contasoft.xmies_randevu.util.RedisUtility;
import az.contasoft.xmies_randevu_data.api.searchServices.internal.RandevuData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CrudServicesREDIS {
    private final NoteProxy noteProxy;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final RedisUtility redisUtility;
    private final RedisService redisService;


    public CrudServicesREDIS(NoteProxy noteProxy, RedisUtility redisUtility, RedisService redisService) {
        this.noteProxy = noteProxy;

        this.redisUtility = redisUtility;
        this.redisService = redisService;
    }

    public ResponseEntity<RandevuData> saveRandevu(RandevuData randevuData) {
        try {
            logger.info("saveRandevu response : {}", randevuData.getRandevu().toString());
//            Randevu randevu = new Randevu();
//            randevu.setAdi(saveRandevu.getAdi());
//            randevu.setSoyAdi(saveRandevu.getSoyAdi());
//            randevu.setAtaAdi(saveRandevu.getAtaAdi());
//            randevu.setTelNomresi(saveRandevu.getTelNomresi());
//            randevu.setDate(saveRandevu.getDate());
//            randevu.setIdPersonal(saveRandevu.getIdPersonal());
//            randevu.setStatus(50);
//            randevu.setIdYonlendiren(saveRandevu.getIdYonlendiren());
//            randevu.setIdSigortaMuqavile(saveRandevu.getIdSigortaMuqavile());
//            randevu.setIdXidmetler(saveRandevu.getIdXidmetler());
//            randevu.setIdPatient(saveRandevu.getIdPatient());
//            randevu.setNote(saveRandevu.getNote());
            randevuData.getRandevu().setIdPatient(randevuData.getPatientInfo().getPatient().getIdPatient());
            randevuData.getRandevu().setIdPersonal(randevuData.getHekim().getPersonal().getIdPersonal());

            randevuData.getRandevu().setIdSigortaMuqavile(randevuData.getSigortaMuqavileData() != null ?
                    randevuData.getSigortaMuqavileData().getSigortaMuqavile().getIdSigortaMuqavile() : 0);
            randevuData.getRandevu().setIdXidmetler(randevuData.getXidmetler() != null ?
                    randevuData.getXidmetler().getIdXidmetler() : 0);
            randevuData.getRandevu().setIdYonlendiren(randevuData.getYonlendiren() != null ?
                    randevuData.getYonlendiren().getPersonal().getIdPersonal() : 0);
            randevuData.getRandevu().setStatus(50);
            randevuData.setRandevu(redisUtility.saveOrUpdateRandevu(randevuData.getRandevu()));
            logger.info("MAP_OF_RANDEVUDATA ELAVE OLUNANNAN EVVEL SAYI : {} ", redisService.getMap(RedisMapKey.MAP_OF_RANDEVUDATA).size());
            redisService.add(randevuData.getRandevu().getIdRandevu(), randevuData, RedisMapKey.MAP_OF_RANDEVUDATA);
            logger.info("MAP_OF_RANDEVUDATA ELAVE OLUNANNAN SONRA SAYI : {} ", redisService.getMap(RedisMapKey.MAP_OF_RANDEVUDATA).size());
            return new ResponseEntity<>(randevuData, HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Error save file text : {}", e, e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<RandevuData> updateRandevu(RandevuData randevuData) {
        logger.info("Update Randevu : {}", randevuData.getRandevu());
        try {
            randevuData.getRandevu().setIdPatient(randevuData.getPatientInfo().getPatient().getIdPatient());
            randevuData.getRandevu().setIdPersonal(randevuData.getHekim().getPersonal().getIdPersonal());
            randevuData.getRandevu().setIdSigortaMuqavile(randevuData.getSigortaMuqavileData() != null ?
                    randevuData.getSigortaMuqavileData().getSigortaMuqavile().getIdSigortaMuqavile() : 0);
            randevuData.getRandevu().setIdXidmetler(randevuData.getXidmetler() != null ?
                    randevuData.getXidmetler().getIdXidmetler() : 0);
            randevuData.getRandevu().setIdYonlendiren(randevuData.getYonlendiren() != null ?
                    randevuData.getYonlendiren().getPersonal().getIdPersonal() : 0);
            randevuData.setRandevu(redisUtility.saveOrUpdateRandevu(randevuData.getRandevu()));

            redisService.add(randevuData.getRandevu().getIdRandevu(), randevuData, RedisMapKey.MAP_OF_RANDEVUDATA);
            return new ResponseEntity<>(randevuData, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error save file text : {}", e, e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
