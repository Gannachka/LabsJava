public class Main {

    public static void main(String[] args) {
        CCC objectWithoutParameters= new CCC();
        CCC objectWithParameters = new CCC(10,9);
        System.out.println("Sum "+ objectWithParameters.sum());
        System.out.println("Ssub = "+ objectWithoutParameters.ssub(11,8));
        DDD objectWithParametersAndSuper=new DDD(25,10);
        System.out.println(objectWithParameters.sum());
        System.out.println(objectWithParametersAndSuper.calc());

    }
}
class CCC{
    public int x;
    private final int y;

    public int getY() {
        return y;
    }

    public CCC( ){
        x=0;
        y=0;
    }
    public CCC(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int sum(){
        return x+y;
    }
    public int ssub(int x,int y){
            return x-y;

    }
}
class DDD extends CCC{
  public  int x ;
  private final int y;

  public DDD(){
      super();
      this.x=1;
      this.y=1;
  }
  public DDD(int x, int y){
      super(x,y);
      this.x=x;
      this.y=y;
  }
  @Override
  public int sum(){
      int summ=super.sum();
      return this.x+this.y+summ;
  }
  public int calc(){
      return this.x*this.y + super.x* super.getY();
  }
}
