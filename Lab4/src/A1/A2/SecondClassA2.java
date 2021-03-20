package A1.A2;

public class SecondClassA2 {
    public  int parameterA2;
    public SecondClassA2(int parameterA2){
        this.parameterA2=parameterA2;
    }
    public void printInformationAboutClass(){
        System.out.println(getClass().getName()+this.parameterA2);
    }

}
