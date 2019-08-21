package az.contasoft.xmies_randevu.api.crudServices.internal;

import java.time.LocalDateTime;

public class UpdateRandevu {
    private long idRandevu;
    private String adi;
    private String soyAdi;
    private String ataAdi;
    private String telNomresi;
    private LocalDateTime date;
    private long idPersonal;
    private int status;

    public UpdateRandevu(long idRandevu, String adi, String soyAdi,String ataAdi, String telNomresi, LocalDateTime date, long idPersonal, int status) {
        this.idRandevu = idRandevu;
        this.adi = adi;
        this.soyAdi = soyAdi;
        this.ataAdi = ataAdi;
        this.telNomresi = telNomresi;
        this.date = date;
        this.idPersonal = idPersonal;
        this.status = status;
    }

    public UpdateRandevu() {
    }

    @Override
    public String toString() {
        return "UpdateRandevu{" +
                "idRandevu=" + idRandevu +
                ", adi='" + adi + '\'' +
                ", soyAdi='" + soyAdi + '\'' +
                ", ataAdi='" + ataAdi + '\'' +
                ", telNomresi='" + telNomresi + '\'' +
                ", date=" + date +
                ", idPersonal=" + idPersonal +
                ", status=" + status +
                '}';
    }

    public long getIdRandevu() {
        return idRandevu;
    }

    public void setIdRandevu(long idRandevu) {
        this.idRandevu = idRandevu;
    }

    public String getAtaAdi() {
        return ataAdi;
    }

    public void setAtaAdi(String ataAdi) {
        this.ataAdi = ataAdi;
    }

    public String getAdi() {
        return adi;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
