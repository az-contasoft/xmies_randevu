package az.contasoft.xmies_randevu.api.crudServices;

import az.contasoft.xmies_randevu.api.crudServices.internal.UpdateRandevu;
import az.contasoft.xmies_randevu.api.crudServices.internalServices.CrudServicesREDIS;
import az.contasoft.xmies_randevu.db.entity.Randevu;
import az.contasoft.xmies_randevu_data.api.searchServices.internal.RandevuData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("crudServices/redis")
public class CrudControllerREDIS {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CrudServicesREDIS crudServicesREDIS;

    public CrudControllerREDIS(CrudServicesREDIS crudServicesREDIS) {
        this.crudServicesREDIS = crudServicesREDIS;
    }


    @PostMapping("/add")
    public ResponseEntity<RandevuData> saveRandevu(@RequestBody RandevuData saveRandevu){
        logger.info("xmies_randevu->add->request RANDEVU : {}" +saveRandevu.getRandevu().toString());
        return crudServicesREDIS.saveRandevu(saveRandevu);
    }

    @PostMapping("/update")
    public ResponseEntity<RandevuData> updateRandevu(@RequestBody RandevuData updateRandevu){
        logger.info("xmies_randevu->update->request RANDEVU : {}"+ updateRandevu.getRandevu().toString());
        return  crudServicesREDIS.updateRandevu(updateRandevu);
    }
}
