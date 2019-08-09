package az.contasoft.xmies_randevu.api.searchServices;

import az.contasoft.xmies_randevu.api.searchServices.internalServices.SearchServices;
import az.contasoft.xmies_randevu.db.entity.Randevu;
import com.hazelcast.core.IMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/searchServices")
public class SearchController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final SearchServices searchServices;

    public SearchController(SearchServices searchServices) {
        this.searchServices = searchServices;
    }

    @GetMapping("/getRandevu/{idRandevu}")
    public ResponseEntity<Randevu> getByIdRandevu(@PathVariable("idRandevu") long idRandevu) {
        logger.info("xmies_randevu_idRandevu->search->request : {}", idRandevu);
        return searchServices.getByIdRandevu(idRandevu);
    }


    @GetMapping("/getAll")
    public ResponseEntity<IMap<Long, Randevu>> getAll() {
        logger.info("getAllRandevu ");
        return searchServices.getAll();
    }

    @GetMapping("/cache")
    public ResponseEntity<String> startCaching() {
        return searchServices.startCaching();
    }
}
