package com.atos.examplanner.planner.model;

/**
 * Created by andrewpatterson on 16/06/2014.
 */
public class Exam {

    private String examName;
    private String teacherName;
    private String examDate;
    private String revisionTimeWanted;
    private String revisionTimeCurrently;
    private String desiredMark;
    private String examWorth;

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

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
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

    public String getDesiredMark() {
        return desiredMark;
    }

    public void setDesiredMark(String desiredMark) {
        this.desiredMark = desiredMark;
    }

    public String getExamWorth() {
        return examWorth;
    }

    public void setExamWorth(String examWorth) {
        this.examWorth = examWorth;
    }
}
