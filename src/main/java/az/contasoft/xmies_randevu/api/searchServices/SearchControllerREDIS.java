package az.contasoft.xmies_randevu.api.searchServices;

import az.contasoft.xmies_randevu.api.searchServices.internalServices.SearchServicesREDIS;
import az.contasoft.xmies_randevu.db.entity.Randevu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/searchServices/redis")
public class SearchControllerREDIS {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final SearchServicesREDIS searchServicesREDIS;

    public SearchControllerREDIS(SearchServicesREDIS searchServicesREDIS) {
        this.searchServicesREDIS = searchServicesREDIS;
    }


    @GetMapping("/getRandevu/{idRandevu}")
    public ResponseEntity<Randevu> getByIdRandevu(@PathVariable("idRandevu") long idRandevu) {
        logger.info("xmies_randevu_idRandevu->search->request : {}", idRandevu);
        return searchServicesREDIS.getByIdRandevu(idRandevu);
    }


    @GetMapping("/getAll")
    public ResponseEntity<Map<Long, Randevu>> getAll() {
        logger.info("getAllRandevu ");
        return searchServicesREDIS.getAll();
    }

    @GetMapping("/cache")
    public ResponseEntity<String> startCaching() {
        new Thread(() -> searchServicesREDIS.startCaching()).start();
        return new ResponseEntity<>("OK", HttpStatus.OK);

    }
}
