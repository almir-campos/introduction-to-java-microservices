package com.javasd.ijm.commons.deo.logger;

//Notice we're not using javax.persistence
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author AlmirCampos <ac@javasd.com>
 */
public class ExamLog implements Serializable
{

    @Getter
    @Setter
    public String id; //Notice this is a String, not a Long as we were using before
    public Long examId;
    @Getter
    @Setter
    public Date dateReceived;
    @Getter
    @Setter
    public Date dataGraded;
    @Getter
    @Setter
    public Double grade;
    @Getter
    @Setter
    public Boolean deleted;

}
