package A1.A2.A3.A4;

import A1.A2.FirstClassA2;

public class FirstClassA4 {
    public  int parameterA4;
    public FirstClassA4(int parameterA4){
        this.parameterA4=parameterA4;
    }
    public void printInformationAboutClass(){
        System.out.println(getClass().getName()+this.parameterA4);
    }
    public static void main(String[] args) {
        FirstClassA4 firstClassA4=new FirstClassA4(154);
        firstClassA4.printInformationAboutClass();

    }
}
