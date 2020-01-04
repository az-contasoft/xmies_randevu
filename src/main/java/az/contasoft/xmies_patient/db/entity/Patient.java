package az.contasoft.xmies_patient.db.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    private long idPatient;
    private String patientNo;
    private String patientName;
    private String patientSurname;
    private String patientFatherName;
    private LocalDate patientBirthDate;   //tevelludu
    private long patientGenderProperty;    //cinsiyyeti
    private long patientTypeProperty;   //xeste tipi
    private long patientCitizenshipProperty;   //vetendashligi
    private long patientIdTypeProperty;      //kimlik tipi
    private String patientPinCode;   //fin
    private String idPatientBirthPlace;  //doguldugu yer  //TODO idbirthPlace etmeliyik?//id adress for flanshey
    private String patientMotherName;
    private String patientMotherSurname; //TODO ana soyad neye lazim?
    private String patientCurrentAddress;  //faktiki adresi
    private String patientRegistrationAddress;  //qeydiyyatd adresi
    private String barcode;
    //AEDRFTGYUİI
    private String patientHomePhoneNumber; //ev teli
    private String patientMobilePhoneNumber; //mobil teli
    private String patientEmail;
    private int isDelete;
    private long idPersonalDeletedBy;
}
