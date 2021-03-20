package classes;

import exeptions.ExceptionAAA1;
import exeptions.ExceptionAAA2;
import exeptions.ExceptionAAA3;

public class AAA {

    public int intField;
    public  AAA(Integer parameter) throws ExceptionAAA1 {
        if (parameter == null) throw new ExceptionAAA1();
    }
    public void methode(int parameter) throws ExceptionAAA2, ExceptionAAA3 {

        if(parameter==0)
            throw new ExceptionAAA2();

        if (parameter<0)
            throw new ExceptionAAA3();
    }
}
