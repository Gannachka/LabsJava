package main.B1;



public class FirstClassB1 {
    public  int parameterB1;
    public FirstClassB1(int parameterB1){
        this.parameterB1=parameterB1;
    }
    public void printInformationAboutClass(){
        System.out.println(getClass().getName()+" "+this.parameterB1);
    }
    public static void main(String[] args) {
        FirstClassB1 firstClassB1=new FirstClassB1(54);
        firstClassB1.printInformationAboutClass();
    }
}
