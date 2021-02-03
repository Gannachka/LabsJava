package main.java.person.student.aaa;

import main.java.person.student.Student;

import java.util.Date;


public class AAA implements Student {
    public int LimitUniversityLength=200;

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }
    private String surname;

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    private String name;


    @Override
    public String getFathername() {
        return fatherName;
    }

    @Override
    public Date getBirthday() {
        return birthday;
    }

    @Override
    public void setFathername(String fatherName) {
        this.fatherName=fatherName;
    }
    private String fatherName;


    public void setBirthday(int yyyy,int mm, int dd) {
        if (MinDateOfBird<yyyy) this.birthday = new Date (yyyy,mm,dd);
    }

    private Date birthday;

    @Override
    public Date getFirstDate() {
        return firstDate ;
    }

    @Override
    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    private Date firstDate;

    @Override
    public String getUniversity() {
        return university;
    }

    @Override
    public void setUniversity(String university) {
        this.university = university;
    }

    private String university;



}
