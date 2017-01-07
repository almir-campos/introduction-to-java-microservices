package com.javasd.ijm.commons.deo.logger;

//Notice we're not using javax.persistence
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author AlmirCampos <ac@javasd.com>
 */
public class ExamLog implements Serializable
{
    public String id; //Notice this is a String, not a Long as we were using before
    public Long examId;
    public Date dateReceived; 
    public Date dataGraded;
    public Double grade;
    public Boolean deleted;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Long getExamId()
    {
        return examId;
    }

    public void setExamId(Long examId)
    {
        this.examId = examId;
    }

    public Date getDateReceived()
    {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived)
    {
        this.dateReceived = dateReceived;
    }

    public Date getDataGraded()
    {
        return dataGraded;
    }

    public void setDataGraded(Date dataGraded)
    {
        this.dataGraded = dataGraded;
    }

    public Double getGrade()
    {
        return grade;
    }

    public void setGrade(Double grade)
    {
        this.grade = grade;
    }

    public Boolean getDeleted()
    {
        return deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }
    
}
