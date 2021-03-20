package main.java.person.student.aaa;
import main.java.person.Person;
import main.java.person.student.Student;
import java.util.Date;

public class AAA implements Student, Person {
    public int LimitUniversityLength=200;
    private String surname;
    private String name;
    private String fatherName;
    private Date birthday;
    private Date firstDate;
    private String university;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathername() {
        return fatherName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setFathername(String fatherName) {
        this.fatherName=fatherName;
    }

    public void setBirthday(int yyyy,int mm, int dd) {
        if (MinDateOfBird<yyyy) this.birthday = new Date (yyyy,mm,dd);
    }

    public Date getFirstDate() {
        return firstDate ;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
