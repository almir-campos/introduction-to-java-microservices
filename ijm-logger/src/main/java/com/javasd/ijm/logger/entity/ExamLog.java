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
    @Id@Getter @Setter
    public String id; //Notice this is a String, not a Long as we were using before
    @Getter @Setter
    public Long examId;
    @Getter @Setter
    public Date dateReceived; 
    @Getter @Setter
    public Date dataGraded;
    @Getter @Setter
    public Date dataDeleted;
    @Getter @Setter
    public Double grade;
    @Getter @Setter
    public Boolean deleted;

//    public String getId()
//    {
//        return id;
//    }
//
//    public void setId(String id)
//    {
//        this.id = id;
//    }
//
//    public Long getExamId()
//    {
//        return examId;
//    }
//
//    public void setExamId(Long examId)
//    {
//        this.examId = examId;
//    }
//
//    public Date getDateReceived()
//    {
//        return dateReceived;
//    }
//
//    public void setDateReceived(Date dateReceived)
//    {
//        this.dateReceived = dateReceived;
//    }
//
//    public Date getDataGraded()
//    {
//        return dataGraded;
//    }
//
//    public Date getDataDeleted()
//    {
//        return dataDeleted;
//    }
//
//    public void setDataDeleted(Date dataDeleted)
//    {
//        this.dataDeleted = dataDeleted;
//    }
//
//    
//    public void setDataGraded(Date dataGraded)
//    {
//        this.dataGraded = dataGraded;
//    }
//
//    public Double getGrade()
//    {
//        return grade;
//    }
//
//    public void setGrade(Double grade)
//    {
//        this.grade = grade;
//    }
//
//    public Boolean getDeleted()
//    {
//        return deleted;
//    }
//
//    public void setDeleted(Boolean deleted)
//    {
//        this.deleted = deleted;
//    }
//    
}
