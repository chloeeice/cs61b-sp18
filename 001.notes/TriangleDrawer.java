
public class TriangleDrawer {
    public static void drawTriangle(int N) {
		int col = 0;
		int row = 0;
		while (row < N) {
			for (int i = 0; i<col; i++) {
				System.out.print('*');
			}
			System.out.println('*');
			col = col + 1;
			row = row + 1;
		}	
    }   
    public static void main(String[] args) {
    	drawTriangle(10);     
    }
}

