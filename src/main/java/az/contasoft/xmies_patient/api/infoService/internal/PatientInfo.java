package az.contasoft.xmies_patient.api.infoService.internal;

import az.contasoft.xmies_patient.db.entity.Patient;
import az.contasoft.xmies_properties.db.entity.Properties;
import lombok.Data;

import java.io.Serializable;

@Data
public class PatientInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Patient patient;
    private Properties patientGenderProperty;    //cinsiyyeti
    private Properties patientTypeProperty;   //xeste tipi
    private Properties patientCitizenshipProperty;   //vetendashligi
    private Properties patientIdTypeProperty;      //kimlik tipi


    public String getDetail() {
        return (patient.getBarcode() !=null ?  patient.getBarcode() : "")
                .concat(" ")
                .concat(patient.getPatientPinCode() != null ? patient.getPatientPinCode() : "")
                .concat(" ")
                .concat(patient.getPatientName() !=null ? patient.getPatientName() : "")
                .concat(" ")
                .concat(patient.getPatientSurname() != null ? patient.getPatientSurname() : "")
                .concat(" ")
                .concat(patient.getPatientFatherName() != null ? patient.getPatientFatherName() : "")
                .concat(" ")
                .concat(patient.getPatientMobilePhoneNumber() != null ? patient.getPatientMobilePhoneNumber() : "");
    }
}
