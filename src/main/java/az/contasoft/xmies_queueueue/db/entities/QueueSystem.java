package az.contasoft.xmies_queueueue.db.entities;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class QueueSystem implements Serializable {

    private static final long serialVersionUID = 1L;

    private long idQueueSystem;//idnovbe sistemi
    private LocalDateTime enteredDate;
    private long idProtokol;
    private long idDepartment;
    private long idPersonal;
    private long queueNo;//sira nomresi//
    private int status;//properties

}