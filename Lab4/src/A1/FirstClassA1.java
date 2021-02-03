package A1;

public class FirstClassA1 {

    public  int parameterA1;
    public FirstClassA1(int parameterA1){
        this.parameterA1=parameterA1;
    }
    public void printInformationAboutClass(){
        System.out.println(getClass().getName()+" "+this.parameterA1);
    }
     public static void main(String[] args) {
        FirstClassA1 firstClassA1=new FirstClassA1(54);
        firstClassA1.printInformationAboutClass();
    }

}
