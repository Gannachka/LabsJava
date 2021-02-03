package main.B1.B2.B3.B4;


import A1.FirstClassA1;

public class FirstClassB4 {
    public  int parameterB4;
    public FirstClassB4(int parameterB4){
        this.parameterB4=parameterB4;
    }
    public void printInformationAboutClass(){
        System.out.println(getClass().getName()+" "+this.parameterB4);
    }
    public static void main(String[] args) {
        FirstClassB4 firstClassB4=new FirstClassB4(54);
        firstClassB4.printInformationAboutClass();

        //Task6
        FirstClassA1 firstClassA1=new FirstClassA1(777);
        firstClassA1.printInformationAboutClass();


    }



}
