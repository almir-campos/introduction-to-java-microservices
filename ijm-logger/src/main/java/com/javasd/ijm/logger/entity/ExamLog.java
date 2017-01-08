package com.javasd.ijm.logger.entity;

//Notice we're not using javax.persistence
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author AlmirCampos <ac@javasd.com>
 */
@Document( collection = "exam_log")
public class ExamLog implements Serializable
{
    @Id @Getter @Setter
    public String id; //Notice this is a String, not a Long as we were using before
    @Getter @Setter
    public Long examId;
    @Getter @Setter
    public Date dateReceived; 
    @Getter @Setter
    public Date dataGraded;
    @Getter @Setter
    public Date dateDeleted;
    @Getter @Setter
    public Double grade;
    @Getter @Setter
    public Boolean deleted;

}
