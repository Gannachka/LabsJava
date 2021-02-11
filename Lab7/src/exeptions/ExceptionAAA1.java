package exeptions;

public class ExceptionAAA1 extends Exception{

    public String getMessage(){
        return "Конструктор не может принимать null";
    }

    public String toString(){
        return this.toString();
    }

    public void printStackTrace(){
        this.printStackTrace();
    }

}
