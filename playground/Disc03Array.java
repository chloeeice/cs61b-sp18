public class Disc03Array {

    /*exercise 2.1*/
    public static int[] insert(int[] arr, int item, int position) {
        int[] newArr = new int[arr.length + 1];

        //这一步漏了
        position = Math.min(arr.length, position);

        System.arraycopy(arr, 0, newArr, 0, position);
        newArr[position] = item;
        System.arraycopy(arr, position, newArr, position + 1, (arr.length - position));
        return newArr;
    }

    /*exercise 2.2: create a method to destructively reverse the items in arr.*/
    public static void reverse(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    /*sol: exercise 2.2- 省略了左右指针。*/
    public static void reverseSol(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int j = arr.length - i - 1;  /*即我的方法里的right*/
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    //TODO 02: exercise 2.3
    /*exercise 2.3: */
    public static int[] replicate(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        int[] newArr = new int[total];
        int i = 0;

        /*这里开始参考的答案写的*/
        for (int item: arr) {
            for (int count = 0; count < item; count++) {
                newArr[i] = item;
                i++;
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        A = insert(A, 20, 6);
        replicate(A);
    }
}
