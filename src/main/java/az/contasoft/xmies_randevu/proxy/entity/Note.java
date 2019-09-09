package az.contasoft.xmies_randevu.proxy.entity;


import java.io.Serializable;
import java.time.LocalDateTime;

public class Note implements Serializable {

    private static final long serialVersionUID = 1L;

    private long idNote;
    private long idProtokol;
    private long idPersonal;
    private String text;
    private LocalDateTime enteredDate;
    private int isDelete;
    private int status;

    public Note() {
    }

    public Note(long idNote, long idProtokol, long idPersonal, String text, LocalDateTime enteredDate, int isDelete, int status) {
        this.idNote = idNote;
        this.idProtokol = idProtokol;
        this.idPersonal = idPersonal;
        this.text = text;
        this.enteredDate = enteredDate;
        this.isDelete = isDelete;
        this.status = status;
    }

    public long getIdNote() {
        return idNote;
    }

    public void setIdNote(long idNote) {
        this.idNote = idNote;
    }

    public long getIdProtokol() {
        return idProtokol;
    }

    public void setIdProtokol(long idProtokol) {
        this.idProtokol = idProtokol;
    }

    public long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(LocalDateTime enteredDate) {
        this.enteredDate = enteredDate;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Note{" +
                "idNote=" + idNote +
                ", idProtokol=" + idProtokol +
                ", idPersonal=" + idPersonal +
                ", text='" + text + '\'' +
                ", enteredDate=" + enteredDate +
                ", isDelete=" + isDelete +
                ", status=" + status +
                '}';
    }
}