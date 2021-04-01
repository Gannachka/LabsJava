import classes.AAA;
import exeptions.ExceptionAAA1;
import exeptions.ExceptionAAA2;
import exeptions.ExceptionAAA3;

public class Main {

    public static void main(String[] args)  {

        try {
            AAA b = new AAA(null);
            AAA a = new AAA(5);
            a.methode(-8);

        }
        catch(ExceptionAAA1 e) {
            System.out.println("null");
        }
        catch(ExceptionAAA2 e) {
            System.out.println(e.toString());
        }
        catch(ExceptionAAA3 e) {
            System.out.println("Value < 0");
        }
        finally {

        }
    }
}
