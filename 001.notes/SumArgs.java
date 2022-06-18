public class SumArgs {
	public static void main(String[] args) {
		int N = args.length;
		int sum = 0;
		for (int i = 0; i<N; i += 1) {
			sum += Integer.parseInt(args[i]);
		}
		System.out.println(sum);
	}
}