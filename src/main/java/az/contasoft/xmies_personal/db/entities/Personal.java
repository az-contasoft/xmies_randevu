package az.contasoft.xmies_personal.db.entities;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long idPersonal;
    private String personalName;
    private String personalSurName;
    private String personalMotherName;
    private String personalFatherName;
    private LocalDate personalBirthDate;
    private long personalGenderProperty;
    private long personalCitizenshipProperty; // milliyetibloo
    private long bloodType;
    private long personalMaritalStatusPro; // ishci ailə vəziyyəti
    private long personalEducationPro;  // ishci tehsili
    private long personalJobsProperty;
    private long personalDepartmentPro;  // ishchinin hekim ,professor olmagi
    private long personalMilitaryStatusPro;
    private long personalTitleProperty;
    private LocalDate startedDatePersonal;  //ishchinin ishe bashlama tarixi
    private LocalDate finishedDatePersonal;
    private String phone;
    private String mail;
    private String idAddress;
    private int isDeleted;

}



