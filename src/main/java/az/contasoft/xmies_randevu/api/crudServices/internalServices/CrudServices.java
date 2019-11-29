package az.contasoft.xmies_randevu.api.crudServices.internalServices;

import az.contasoft.xmies_randevu.api.crudServices.internal.SaveRandevu;
import az.contasoft.xmies_randevu.api.crudServices.internal.UpdateRandevu;
import az.contasoft.xmies_randevu.db.entity.Randevu;
import az.contasoft.xmies_randevu.proxy.NoteProxy;
import az.contasoft.xmies_randevu.proxy.entity.Note;
import az.contasoft.xmies_randevu.util.HazelCastUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CrudServices {
    private final NoteProxy noteProxy;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final HazelCastUtility hazelCastUtility;

    public CrudServices(NoteProxy noteProxy, HazelCastUtility hazelCastUtility) {
        this.noteProxy = noteProxy;
        this.hazelCastUtility = hazelCastUtility;
    }

    public ResponseEntity<Randevu> saveRandevu(SaveRandevu saveRandevu) {
        try {
            Randevu randevu = new Randevu();
            logger.info("saveRandevu response : {}", saveRandevu.toString());
            randevu.setAdi(saveRandevu.getAdi());
            randevu.setSoyAdi(saveRandevu.getSoyAdi());
            randevu.setAtaAdi(saveRandevu.getAtaAdi());
            randevu.setTelNomresi(saveRandevu.getTelNomresi());
            randevu.setDate(saveRandevu.getDate());
            randevu.setIdPersonal(saveRandevu.getIdPersonal());
            randevu.setStatus(50);
            randevu.setIdYonlendiren(saveRandevu.getIdYonlendiren());
            randevu.setIdSigortaMuqavile(saveRandevu.getIdSigortaMuqavile());
            randevu.setIdXidmetler(saveRandevu.getIdXidmetler());
            randevu.setIdPatient(saveRandevu.getIdPatient());
            randevu.setNote(saveRandevu.getNote());
            randevu = hazelCastUtility.saveOrUpdateRandevu(randevu);
            return new ResponseEntity<>(randevu, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error save file text : {}", e, e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<Randevu> updateRandevu(UpdateRandevu updateRandevu) {
        try {
            Randevu randevu = hazelCastUtility.getRandevuByIdRandevu(updateRandevu.getIdRandevu());
            logger.info("saveRandevu response : {}", updateRandevu.toString());
            randevu.setIdRandevu(updateRandevu.getIdRandevu());
            randevu.setAdi(updateRandevu.getAdi());
            randevu.setSoyAdi(updateRandevu.getSoyAdi());
            randevu.setAtaAdi(updateRandevu.getAtaAdi());
            randevu.setTelNomresi(updateRandevu.getTelNomresi());
            randevu.setDate(updateRandevu.getDate());
            randevu.setIdSigortaMuqavile(updateRandevu.getIdSigortaMuqavile());
            randevu.setIdYonlendiren(updateRandevu.getIdYonlendiren());
            randevu.setNote(updateRandevu.getNote());
            randevu.setIdPersonal(updateRandevu.getIdPersonal());
            randevu.setStatus(updateRandevu.getStatus());
            randevu.setIdPatient(updateRandevu.getIdPatient());
            randevu.setIdXidmetler(updateRandevu.getIdXidmetler());
            randevu = hazelCastUtility.saveOrUpdateRandevu(randevu);
            return new ResponseEntity<>(randevu, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error save file text : {}", e, e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
