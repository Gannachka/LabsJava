package main.java.person.student;
import main.java.person.Person;

import java.util.Date;

public interface Student extends Person {

    void setFirstDate(Date d);  // установить дату поступления в вуз

    Date getFirstDate();        //  получить дату поступления в вуз

    void setUniversity(String u); // установить имя вуза

    String getUniversity();

    int LimitUniversityLength = 0;
}
