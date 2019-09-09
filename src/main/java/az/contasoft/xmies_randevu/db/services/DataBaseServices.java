package az.contasoft.xmies_randevu.db.services;

import az.contasoft.xmies_randevu.db.entity.Randevu;
import az.contasoft.xmies_randevu.db.repo.RepoRandevu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataBaseServices {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final RepoRandevu repoRandevu;


    public DataBaseServices(RepoRandevu repoRandevu) {
        this.repoRandevu = repoRandevu;
    }

    public Randevu insertOrUpdate (Randevu randevu) throws Exception{
        logger.info("{}", "Randevu insert or update for getIdRandevu : "+randevu.getIdRandevu());
        Randevu randevuFromDB;
        if (randevu.getIdRandevu()>0){
            logger.info("{}", "Randevu found and trying to update");
            randevuFromDB = repoRandevu.findByIdRandevu(randevu.getIdRandevu());
            randevuFromDB.setIdRandevu(randevu.getIdRandevu());
            randevuFromDB.setAdi(randevu.getAdi());
            randevuFromDB.setSoyAdi(randevu.getSoyAdi());
            randevuFromDB.setAtaAdi(randevu.getAtaAdi());
            randevuFromDB.setTelNomresi(randevu.getTelNomresi());
            randevuFromDB.setDate(randevu.getDate());
            randevuFromDB.setIdPersonal(randevu.getIdPersonal());
            randevuFromDB.setStatus(randevu.getStatus());
            randevuFromDB.setIdNote(randevu.getIdNote());
            randevuFromDB.setIdPatient(randevu.getIdPatient());
            randevuFromDB.setIdXidmetler(randevu.getIdXidmetler());
            randevuFromDB.setIdYonlendiren(randevu.getIdYonlendiren());
            randevuFromDB.setIdSigortaMuqavile(randevu.getIdSigortaMuqavile());
        }else {
            logger.info("{}", "Trying to inser randevu");
            randevuFromDB = randevu;
        }
        randevuFromDB = repoRandevu.save(randevuFromDB);
        logger.info("successfully saved");
        return randevuFromDB;
    }

    public Randevu getRandevu(long idRandevu) {
        logger.info("{}","getting Randevu by idRandevu : " +idRandevu);
        return repoRandevu.findByIdRandevu(idRandevu);
    }

    public List<Randevu> getAll(){
        logger.info("{}", "getting all Randevu");
        return repoRandevu.findAll();
    }
}
