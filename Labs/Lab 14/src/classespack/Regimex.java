package classespack;

import  java.text.SimpleDateFormat;
import java.util.*;

public class Regimex {
    protected String R=null;
    Calendar C;
    protected  Date d=new Date();

    public Regimex(Calendar c){
        this.C=c;
    }

    public Regimex(){
        this.C=Calendar.getInstance();
    }

    public Integer GetHOUR(){
        return C.get(Calendar.HOUR_OF_DAY);
    }

    public Integer GetDayOfWeek(){
        int day= C.get(Calendar.DAY_OF_WEEK) - 1;
        if(day==0)
            return 7;
        return day;
    }

    public String AddDay()
    {
        C.add(Calendar.DAY_OF_YEAR,1);
        return new SimpleDateFormat("dd.MM.yyyy").format(C.getTime());
    }

    public String GetCurrentDate(){
        return new SimpleDateFormat("dd.MM.yyyy").format(C.getTime());
    }


}
