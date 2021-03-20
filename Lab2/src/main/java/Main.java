package main.java;

public class Main {


	public static void main(String[] args) {
		first();
		System.out.println(" ");
		second();
		System.out.println(" ");
		third();
		System.out.println(" ");
		forth();
		System.out.println(" ");
		fifth();
		System.out.println(" ");
		Student.Count(9);

	}
		public static void first(){
			int[] x = new int[10];
			for (int i = 0; i < x.length; i++) {
				x[i] = i;
				System.out.println(x[i]);
			}
		}
		public static void second() {
			int xx[][] = new int[5][5];
			for (int i = 0; i < xx.length; i++) {
				System.out.println(" ");
				for (int j = 0; j < xx.length; j++) {
					xx[i][j] = i + j;
					System.out.print(xx[i][j]);
				}
			}
		}
		public static void third() {
		byte num=88;
		System.out.println(num<<=2);
		System.out.println(num^=2);
		System.out.println(num&2);
		System.out.println(~num);
		}

		public static void forth() {
			int rand = (int) (Math.random() * 20);
			boolean result;
			if (rand>=2 && rand<18 || rand==0) {
				result = rand > 15 ? true : false;
				System.out.println(result);
			}
	    }
	    public static void fifth(){
			int a = 64;
			do {
				a--;
				switch (a) {
					case 31:
						System.out.println(a);
						a = 0;
						break;
				}
			} while (a > 1);

		}
	}
	class Student{
	public static int countOfStudents =23 ;
	public static void Count(int numberOfNewStudents){
		System.out.println(countOfStudents+=numberOfNewStudents);
	}
}



