import main.java.person.student.aaa.*;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        AAA aaa=new AAA();
        aaa.setName("Hanna");
        aaa.setSurname("Miklyaeva");
        aaa.setFathername("Sergeevna");
        aaa.setBirthday(2000,11,29);
        aaa.setFirstDate(new Date (2018,8,1));
        aaa.setUniversity("Belarusian State Technological University");
        System.out.println(aaa.getName()+" "+aaa.getSurname()+" "+aaa.getFathername());
        System.out.println("Birthday: "+ aaa.getBirthday().getDate()+"."+aaa.getBirthday().getMonth()+"."+aaa.getBirthday().getYear());
        System.out.println("University Admission: "+ aaa.getFirstDate().getDate()+".0"+aaa.getFirstDate().getMonth()+"."+aaa.getFirstDate().getYear());
        System.out.println(aaa.getUniversity());

    }
}
