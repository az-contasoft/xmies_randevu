package az.contasoft.xmies_randevu.api.crudServices.internal;

import lombok.Data;

import java.time.LocalDateTime;
@Deprecated
@Data
public class SaveRandevu {

    private String adi;
    private String soyAdi;
    private String ataAdi;
    private String telNomresi;
    private LocalDateTime date;
    private String note;
    private long idSigortaMuqavile;
    private long idYonlendiren;
    private long idPersonal;
    private long idPatient;
    private long idXidmetler;
    private long status;

}
