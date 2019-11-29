package az.contasoft.xmies_randevu.api.searchServices.internalServices;

import az.contasoft.xmies_randevu.api.searchServices.internal.RequestText;
import az.contasoft.xmies_randevu.db.entity.Randevu;
import az.contasoft.xmies_randevu.util.HazelCastUtility;
import com.hazelcast.core.IMap;
import net.bytebuddy.matcher.InheritedAnnotationMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SearchServices {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final HazelCastUtility hazelCastUtility;

    public SearchServices(HazelCastUtility hazelCastUtility) {
        this.hazelCastUtility = hazelCastUtility;
    }

    public ResponseEntity<Randevu> getByIdRandevu(long idRandevu) {
        try {
            Randevu randevu = hazelCastUtility.getRandevuByIdRandevu(idRandevu);
            if (randevu == null) {
                logger.info("NOT_FOUND searchIdRandevu response : {}", randevu);
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                logger.info("FOUND searchIdRandevu response  : {}", randevu);
                return new ResponseEntity<>(randevu, HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.error("Error get idRandevu by idRandevu  : {} ", e, e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<Map<Long, Randevu>> getAll() {

        try {
            IMap<Long, Randevu> randevuIMap = hazelCastUtility.getMapOfRandevu();
            if (randevuIMap == null || randevuIMap.isEmpty()) {
                logger.info("getAll response : {}", randevuIMap.size());
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                logger.info("return map of randevu getAllAsMap");
                return new ResponseEntity<>(randevuIMap, HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.error("Error getAll as map : {} and e.getMessage() : {}", e, e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    public ResponseEntity<List<Randevu>> getRandevuByName(RequestText requestText){
//        Map<Long, Randevu> map = hazelCastUtility.getMapOfRandevu();
//        String[] enteredTextMas = requestText.getEnteredText().split(" ");
//
//        for (String enteredTextmas : enteredTextMas) {
//            Map<Long, Randevu> yeniMap = new HashMap<>();
//            for (Randevu randevu : map.values()) {
//
//            }
//        }
//
//
//    }



    public ResponseEntity<String> startCaching() {
        hazelCastUtility.startCaching();
        return new ResponseEntity<>("Cached", HttpStatus.OK);
    }
}
