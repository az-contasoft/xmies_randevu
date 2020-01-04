package az.contasoft.xmies_properties.db.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Properties implements Serializable {

    private static final long serialVersionUID = 1L;

    private long idProperties;
    private String value;
    private long parentId;
    private int isDelete;
    private String proKey;
}
