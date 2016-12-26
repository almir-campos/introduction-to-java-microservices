/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.grader.service;

import com.javasd.ijm.commons.deo.qna.Answer;
import com.javasd.ijm.commons.deo.qna.Question;
import java.util.List;

/**
 *
 * @author acampos
 */
public class GradeCalculator
{
    private List<Question> answeredQuestions;
    private List<Question> originalQuestions;
    
    public GradeCalculator(){}
    
    public GradeCalculator( List<Question> answeredQuestions, List<Question> originalQuestions )
    {
        this.answeredQuestions = answeredQuestions;
        this.originalQuestions = originalQuestions;
        
        setCorrectAnswers();
    }
    
    private void setCorrectAnswers()
    {
        for ( Question answeredQuestion : answeredQuestions )
        {
            for ( Answer answer : answeredQuestion.getAnswers() )
            {
                answer.setCorrect( isCorrectAnswer( answeredQuestion, answer ) );
            }
        }
    }
    
    private boolean isCorrectAnswer(
            Question answeredQuestion,
            Answer questionAnswer )
    {
        for ( Question originalQuestion : originalQuestions )
        {
            if ( originalQuestion.getId().longValue() == answeredQuestion.getId().longValue() )
            {
                for ( Answer originalAnswer : originalQuestion.getAnswers() )
                {
                    if ( questionAnswer.getId().longValue() == originalAnswer.getId().longValue() )
                    {
                        return originalAnswer.isCorrect();
                    }
                }
            }
        }
        return false;
    }
    
    public double calcGrade()
    {
        int nQuestions = answeredQuestions.size();
        int correctQuestions = 0;
        
        for ( Question question : answeredQuestions )
        {
            for ( Answer answer : question.getAnswers() )
            {
                if ( answer.isChosen() && answer.isCorrect() )
                {
                    correctQuestions++;
                }
            }
        }
        
        double grade = correctQuestions * 100.0 / nQuestions;
        
        grade = Math.round( grade * 100.0 ) / 100.0;
        
        return grade;
    }
}
