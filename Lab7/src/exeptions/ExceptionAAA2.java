package exeptions;

public class ExceptionAAA2 extends Exception {

//
//    public String getMessage(){
//        return this.getMessage();
//    }

    @Override
    public String toString(){
        return "Значение равно 0";
    }

    public void printStackTrace(){
        this.printStackTrace();
    }
}
