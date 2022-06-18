/**public class Test{
	public static void main(String[] args){
		System.out.println(5 + "10");
	}
}
*/

public class LargerDemo {
	/** return the larger of x and y.*/
	public static int larger(int x, int y){
		if (x > y){
			return x;
		}
		return y;
	}
	public static void main(String[] args){
		System.out.println(larger(-5,10));

	}
}

