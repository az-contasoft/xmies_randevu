package az.contasoft.xmies_randevu.db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity

@Table(name = "randevu")
    public class Randevu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRandevu", nullable = false, unique = true)

    private long idRandevu;
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

    public Randevu(String adi, String soyAdi, String ataAdi, String telNomresi, LocalDateTime date, String note, long idSigortaMuqavile, long idYonlendiren, long idPersonal, long idPatient, long idXidmetler, long status) {
        this.adi = adi;
        this.soyAdi = soyAdi;
        this.ataAdi = ataAdi;
        this.telNomresi = telNomresi;
        this.date = date;
        this.note = note;
        this.idSigortaMuqavile = idSigortaMuqavile;
        this.idYonlendiren = idYonlendiren;
        this.idPersonal = idPersonal;
        this.idPatient = idPatient;
        this.idXidmetler = idXidmetler;
        this.status = status;
    }

    public Randevu() {
    }

    @Override
    public String toString() {
        return "Randevu{" +
                "idRandevu=" + idRandevu +
                ", adi='" + adi + '\'' +
                ", soyAdi='" + soyAdi + '\'' +
                ", ataAdi='" + ataAdi + '\'' +
                ", telNomresi='" + telNomresi + '\'' +
                ", date=" + date +
                ", idNote=" + note +
                ", idSigortaMuqavile=" + idSigortaMuqavile +
                ", idYonlendiren=" + idYonlendiren +
                ", idPersonal=" + idPersonal +
                ", idPatient=" + idPatient +
                ", idXidmetler=" + idXidmetler +
                ", status=" + status +
                '}';
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getIdSigortaMuqavile() {
        return idSigortaMuqavile;
    }

    public long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(long idPatient) {
        this.idPatient = idPatient;
    }

    public long getIdXidmetler() {
        return idXidmetler;
    }

    public void setIdXidmetler(long idXidmetler) {
        this.idXidmetler = idXidmetler;
    }

    public void setIdSigortaMuqavile(long idSigortaMuqavile) {
        this.idSigortaMuqavile = idSigortaMuqavile;
    }

    public long getIdYonlendiren() {
        return idYonlendiren;
    }

    public void setIdYonlendiren(long idYonlendiren) {
        this.idYonlendiren = idYonlendiren;
    }

    public long getIdRandevu() {
        return idRandevu;
    }

    public void setIdRandevu(long idRandevu) {
        this.idRandevu = idRandevu;
    }

    public String getAdi() {
        return adi;
    }

    public String getAtaAdi() {
        return ataAdi;
    }

    public void setAtaAdi(String ataAdi) {
        this.ataAdi = ataAdi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyAdi() {
        return soyAdi;
    }

    public void setSoyAdi(String soyAdi) {
        this.soyAdi = soyAdi;
    }

    public String getTelNomresi() {
        return telNomresi;
    }

    public void setTelNomresi(String telNomresi) {
        this.telNomresi = telNomresi;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }
}
