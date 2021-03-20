import A1.*;

import A1.A2.*;
import A1.A2.A3.A4.*;


public class Main {

    public static void main(String[] args) {

        FirstClassA1 firstClassA1 =new FirstClassA1(111);
        firstClassA1.printInformationAboutClass();

        FirstClassA2 firstClassA2 =new FirstClassA2(111);
        firstClassA2.printInformationAboutClass();

        SecondClassA2 secondClassA2=new SecondClassA2(333);
        secondClassA2.printInformationAboutClass();

        FirstClassA4 firstClassA4=new FirstClassA4(222);
        firstClassA4.printInformationAboutClass();

    }

}

