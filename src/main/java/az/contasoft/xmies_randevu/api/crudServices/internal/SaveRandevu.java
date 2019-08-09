package az.contasoft.xmies_randevu.api.crudServices.internal;

import java.util.Date;

public class SaveRandevu {


    private String adi;
    private String soyAdi;
    private String ataAdi;
    private String telNomresi;
    private Date date;
    private long idPersonal;
    private int status;

    public SaveRandevu( String adi, String soyAdi,String ataAdi, String telNomresi, Date date, long idPersonal, int status) {
        this.adi = adi;
        this.soyAdi = soyAdi;
        this.ataAdi = ataAdi;
        this.telNomresi = telNomresi;
        this.date = date;
        this.idPersonal = idPersonal;
        this.status = status;
    }

    public SaveRandevu() {
    }

    @Override
    public String toString() {
        return "SaveRandevu{" +
                "adi='" + adi + '\'' +
                ", soyAdi='" + soyAdi + '\'' +
                ", ataAdi='" + ataAdi + '\'' +
                ", telNomresi='" + telNomresi + '\'' +
                ", date=" + date +
                ", idPersonal=" + idPersonal +
                ", status=" + status +
                '}';
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

    public Date getDate() {
        return date;
    }

    public String getAtaAdi() {
        return ataAdi;
    }

    public void setAtaAdi(String ataAdi) {
        this.ataAdi = ataAdi;
    }

    public void setDate(Date date) {
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
