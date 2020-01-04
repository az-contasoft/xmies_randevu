package az.contasoft.xmies_personal_data.entities;

import az.contasoft.xmies_personal.db.entities.Personal;
import az.contasoft.xmies_properties.db.entity.Properties;
import az.contasoft.xmies_queueueue.db.entities.QueueSystem;
import lombok.Data;

import java.io.Serializable;

@Data
public class PersonalData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Personal personal;
    private Properties department;
    private Properties job;
    private QueueSystem queueSystem;
    private Properties gender;
    private Properties bloodType;
    private Properties citizenship;
    private Properties maritalStatus;
    private Properties education;
    private Properties military;
    private Properties title;

//    public PersonalData() {
//    }
//
//    public PersonalData(Personal personal, Properties department, Properties job, QueueSystem queueSystem, Properties gender, Properties bloodType, Properties citizenship, Properties maritalStatus, Properties education, Properties military, Properties title) {
//        this.personal = personal;
//        this.department = department;
//        this.job = job;
//        this.queueSystem = queueSystem;
//        this.gender = gender;
//        this.bloodType = bloodType;
//        this.citizenship = citizenship;
//        this.maritalStatus = maritalStatus;
//        this.education = education;
//        this.military = military;
//        this.title = title;
//    }

    public String getFullData(){
        return personal.getPersonalName()
                .concat(" ")
                .concat(personal.getPersonalSurName())
                .concat(" ")
                .concat(personal.getPersonalFatherName())
                .concat(" ")
                .concat(department!=null?department.getValue():"")
                .concat(" ")
                .concat(job!=null?job.getValue():"")
                .concat(" ")
                .concat(queueSystem!=null?queueSystem.getQueueNo()+"":"");
    }

//    @Override
//    public String toString() {
//        return "PersonalData{" +
//                "personal=" + personal +
//                ", department=" + department +
//                ", job=" + job +
//                ", queueSystem=" + queueSystem +
//                ", gender=" + gender +
//                ", bloodType=" + bloodType +
//                ", citizenship=" + citizenship +
//                ", maritalStatus=" + maritalStatus +
//                ", education=" + education +
//                ", military=" + military +
//                ", title=" + title +
//                '}';
//    }
//
//    public Personal getPersonal() {
//        return personal;
//    }
//
//    public void setPersonal(Personal personal) {
//        this.personal = personal;
//    }
//
//    public Properties getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Properties department) {
//        this.department = department;
//    }
//
//    public Properties getJob() {
//        return job;
//    }
//
//    public void setJob(Properties job) {
//        this.job = job;
//    }
//
//    public QueueSystem getQueueSystem() {
//        return queueSystem;
//    }
//
//    public void setQueueSystem(QueueSystem queueSystem) {
//        this.queueSystem = queueSystem;
//    }
//
//    public Properties getGender() {
//        return gender;
//    }
//
//    public void setGender(Properties gender) {
//        this.gender = gender;
//    }
//
//    public Properties getBloodType() {
//        return bloodType;
//    }
//
//    public void setBloodType(Properties bloodType) {
//        this.bloodType = bloodType;
//    }
//
//    public Properties getCitizenship() {
//        return citizenship;
//    }
//
//    public void setCitizenship(Properties citizenship) {
//        this.citizenship = citizenship;
//    }
//
//    public Properties getMaritalStatus() {
//        return maritalStatus;
//    }
//
//    public void setMaritalStatus(Properties maritalStatus) {
//        this.maritalStatus = maritalStatus;
//    }
//
//    public Properties getEducation() {
//        return education;
//    }
//
//    public void setEducation(Properties education) {
//        this.education = education;
//    }
//
//    public Properties getMilitary() {
//        return military;
//    }
//
//    public void setMilitary(Properties military) {
//        this.military = military;
//    }
//
//    public Properties getTitle() {
//        return title;
//    }
//
//    public void setTitle(Properties title) {
//        this.title = title;
//    }
}
