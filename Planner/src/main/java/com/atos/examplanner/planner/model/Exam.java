package com.atos.examplanner.planner.model;

import java.util.Date;

/**
 * Created by andrewpatterson on 16/06/2014.
 */
public class Exam {

    private String examName;
    private String teacherName;
    private Date examDate;
    private String revisionTimeWanted;
    private String revisionTimeCurrently;
    private int desiredMark;
    private int examPercentage;

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public String getRevisionTimeWanted() {
        return revisionTimeWanted;
    }

    public void setRevisionTimeWanted(String revisionTimeWanted) {
        this.revisionTimeWanted = revisionTimeWanted;
    }

    public String getRevisionTimeCurrently() {
        return revisionTimeCurrently;
    }

    public void setRevisionTimeCurrently(String revisionTimeCurrently) {
        this.revisionTimeCurrently = revisionTimeCurrently;
    }

    public int getDesiredMark() {
        return desiredMark;
    }

    public void setDesiredMark(int desiredMark) {
        this.desiredMark = desiredMark;
    }

    public int getExamPercentage() {
        return examPercentage;
    }

    public void setExamPercentage(int examPercentage) {
        this.examPercentage = examPercentage;
    }
}
