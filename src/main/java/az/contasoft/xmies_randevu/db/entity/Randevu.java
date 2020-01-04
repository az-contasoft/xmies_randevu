package az.contasoft.xmies_randevu.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity

@Table(name = "randevu")
@Data
public class Randevu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRandevu", nullable = false, unique = true)
    private long idRandevu;
    private String telNomresi;
    private LocalDateTime date;
    private String note;
    private long idSigortaMuqavile;
    private long idYonlendiren;
    private long idPersonal;
    private long idPatient;
    private long idXidmetler;
    private long status;

    //    private String adi;
//    private String soyAdi;
//    private String ataAdi;


}
