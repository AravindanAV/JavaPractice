public class KadanesAlgo {

    //Largest Sum Contiguous Subarray (Kadane’s Algorithm)
    /*Given an array arr[] of size N. The task is to find the sum of
     the contiguous subarray within a arr[] with the largest sum.
    *   Input: arr = {-2,-3,4,-1,-2,1,5,-3}
        Output: 7
        Explanation: The subarray {4,-1, -2, 1, 5} has the largest sum 7.

        Input: arr = {2}
        Output: 2
        Explanation: The subarray {2} has the largest sum 1.*/
    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] arr) {
        int maxCurrent = arr[0];
        int maxGlobal = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (maxCurrent + arr[i] > arr[i]) {
                maxCurrent += arr[i];
            } else {
                maxCurrent = arr[i];
            }

            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }

        return maxGlobal;
    }

    private static void subArray(int[] arr) {
        int lowIndex = 0, highIndex = 0, high = arr[0], temp = 0;
        for (int i = 0; i < arr.length; i++) {
            lowIndex = i;
            for (int j = i; j < arr.length ; j++) {
                temp = temp+arr[j];
                if (temp>high){
                    highIndex = j;
                }
            }
        }
        System.out.println("Largest Sum Contiguous SubArray :"+lowIndex+"-"+highIndex);

    }
}
