package az.contasoft.xmies_personal.db.entities;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by heisenberg on 10/25/19.
 */
public class PersonalRelatives implements Serializable{




    private long idPersonalRelatives;
    private String ad;
    private String soyad;
    private String pincode;
    private String anaAdi;
    private String ataAdi;
    private LocalDate dogumTarixi;
    private long idProperties;//yaxinligi
    private long idPersonal;

    public PersonalRelatives() {
    }

    @Override
    public String toString() {
        return "PersonalRelatives{" +
                "idPersonalRelatives=" + idPersonalRelatives +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", pincode='" + pincode + '\'' +
                ", anaAdi='" + anaAdi + '\'' +
                ", ataAdi='" + ataAdi + '\'' +
                ", dogumTarixi=" + dogumTarixi +
                ", idProperties=" + idProperties +
                ", idPersonal=" + idPersonal +
                '}';
    }

    public PersonalRelatives(String ad, String soyad, String pincode, String anaAdi, String ataAdi, LocalDate dogumTarixi, long idProperties, long idPersonal) {
        this.ad = ad;
        this.soyad = soyad;
        this.pincode = pincode;
        this.anaAdi = anaAdi;
        this.ataAdi = ataAdi;
        this.dogumTarixi = dogumTarixi;
        this.idProperties = idProperties;
        this.idPersonal = idPersonal;
    }

    public long getIdPersonalRelatives() {
        return idPersonalRelatives;
    }

    public void setIdPersonalRelatives(long idPersonalRelatives) {
        this.idPersonalRelatives = idPersonalRelatives;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getAnaAdi() {
        return anaAdi;
    }

    public void setAnaAdi(String anaAdi) {
        this.anaAdi = anaAdi;
    }

    public String getAtaAdi() {
        return ataAdi;
    }

    public void setAtaAdi(String ataAdi) {
        this.ataAdi = ataAdi;
    }

    public LocalDate getDogumTarixi() {
        return dogumTarixi;
    }

    public void setDogumTarixi(LocalDate dogumTarixi) {
        this.dogumTarixi = dogumTarixi;
    }

    public long getIdProperties() {
        return idProperties;
    }

    public void setIdProperties(long idProperties) {
        this.idProperties = idProperties;
    }

    public long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(long idPersonal) {
        this.idPersonal = idPersonal;
    }
}
