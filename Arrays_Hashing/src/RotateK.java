import java.util.Arrays;

public class RotateK {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,7,8,9};
        int k = 4;
        int[] res= rotate(arr,k);
        Arrays.stream(res).forEach(System.out::print);
    }

    private static int[] rotate(int[] arr,int k) {
        int n = arr.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = arr[i];
        }
        return temp;
    }
}
