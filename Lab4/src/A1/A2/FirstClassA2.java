package A1.A2;

import main.B1.B2.*;

public class FirstClassA2 extends FirstClassB2 {
    public  int parameterA2;

    public FirstClassA2(int parameterA2){
        super(parameterA2);
        this.parameterA2=parameterA2;
    }
    public void printInformationAboutClass(){
        super.printInformationAboutClassB2();
        System.out.println(this.getClass().getName()+" "+this.parameterA2);
    }

    public static void main(String[] args) {

        FirstClassA2 firstClassA2=new FirstClassA2(154);
        firstClassA2.printInformationAboutClass();

    }
}
