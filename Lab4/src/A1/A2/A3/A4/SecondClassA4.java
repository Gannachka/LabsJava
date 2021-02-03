package A1.A2.A3.A4;

import A1.A2.FirstClassA2;
import A1.A2.SecondClassA2;

public class SecondClassA4 {
    public  int parameterA4;
    public SecondClassA4(int parameterA4){
        this.parameterA4=parameterA4;
    }
    public void printInformationAboutClass(){
        System.out.println(getClass().getName()+this.parameterA4);

    }
    public static void main(String[] args) {
        SecondClassA4 secondClassA4=new SecondClassA4(154);
        secondClassA4.printInformationAboutClass();

    }

}
