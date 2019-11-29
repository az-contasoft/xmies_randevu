package az.contasoft.xmies_randevu.api.crudServices;

import az.contasoft.xmies_randevu.api.crudServices.internal.SaveRandevu;
import az.contasoft.xmies_randevu.api.crudServices.internal.UpdateRandevu;
import az.contasoft.xmies_randevu.api.crudServices.internalServices.CrudServices;
import az.contasoft.xmies_randevu.db.entity.Randevu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("crudServices")
public class CrudController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CrudServices crudServices;

    public CrudController (CrudServices crudServices) {
        this.crudServices = crudServices;
    }


    @PostMapping("/add")
    public ResponseEntity<Randevu> saveRandevu(@RequestBody SaveRandevu saveRandevu){
        logger.info("xmies_randevu->add->request : {}" +saveRandevu.toString());
        return crudServices.saveRandevu(saveRandevu);
    }

    @PostMapping("/update")
    public ResponseEntity<Randevu> updateRandevu(@RequestBody UpdateRandevu updateRandevu){
        logger.info("xmies_randevu->update->request : {}"+ updateRandevu.toString());
        return  crudServices.updateRandevu(updateRandevu);
    }
}
