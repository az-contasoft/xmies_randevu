package az.contasoft.xmies_randevu_data.api.searchServices.internal;


import az.contasoft.xmies_patient.api.infoService.internal.PatientInfo;
import az.contasoft.xmies_personal_data.entities.PersonalData;
import az.contasoft.xmies_properties.db.entity.Properties;
import az.contasoft.xmies_randevu.db.entity.Randevu;
import az.contasoft.xmies_sigorta_muqavile_data.api.searchServices.internal.SigortaMuqavileData;
import az.contasoft.xmies_xidmetler.db.entity.Xidmetler;
import lombok.Data;

import java.io.Serializable;
@Data
public class RandevuData implements Serializable {

    private static final long serialVersionUID = 1L;
    private Randevu randevu;
    private PersonalData hekim;
    private PersonalData yonlendiren;
    private Properties properties;
    private Xidmetler xidmetler;
    private SigortaMuqavileData sigortaMuqavileData;
    private PatientInfo patientInfo;



}
