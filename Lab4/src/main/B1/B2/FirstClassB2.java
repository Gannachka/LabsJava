package main.B1.B2;



public class FirstClassB2 {
    public  int parameterB2;
    public FirstClassB2(int parameterB2){
        this.parameterB2=parameterB2;
    }
    public void printInformationAboutClassB2(){
        System.out.println(getClass().getName()+" "+this.parameterB2);
    }
    public static void main(String[] args) {
        FirstClassB2 firstClassB2=new FirstClassB2(54);
        firstClassB2.printInformationAboutClassB2();
    }
}
