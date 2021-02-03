package main.java.person;

import java.util.Date;

public interface Person {
    public int MinDateOfBird = 1900;
    public void setSurname (String surname);
    public void setName (String name);
    public void setFathername(String fatherName);
    public void setBirthday(int yyyy, int mm, int dd);
    public String getSurname();
    public String getName();
    public String getFathername();
    public Date getBirthday();
}
