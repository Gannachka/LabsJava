package main.java.person.student.aaa;

import main.java.person.student.Student;

import java.util.Date;


public class AAA implements Student {
    public int LimitUniversityLength=200;


    public String getSurname() {
        return surname;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String name;



    public String getFathername() {
        return fatherName;
    }


    public Date getBirthday() {
        return birthday;
    }


    public void setFathername(String fatherName) {
        this.fatherName=fatherName;
    }
    private String fatherName;


    public void setBirthday(int yyyy,int mm, int dd) {
        if (MinDateOfBird<yyyy) this.birthday = new Date (yyyy,mm,dd);
    }

    private Date birthday;


    public Date getFirstDate() {
        return firstDate ;
    }


    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    private Date firstDate;


    public String getUniversity() {
        return university;
    }


    public void setUniversity(String university) {
        this.university = university;
    }

    private String university;



}
