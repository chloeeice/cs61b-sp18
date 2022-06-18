
public class MaxVal {
   public static int max(int[] m) {
      int res = 0;
      for (int n=0; n<m.length; n++) {
         if (res < m[n]) {
            res = m[n];
         } 
      } 
      return res;   
   }
   public static void main(String[] args) {
      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};  
      System.out.println(max(numbers));    
   }
}

