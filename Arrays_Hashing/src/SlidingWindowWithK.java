public class SlidingWindowWithK {
    public static void main(String[] args) {
        int k= 3;
        int[] arr={2,5,3,2,8,9,1,9,8,9,11,1};
        int res = slidingWindow(arr,k);
        System.out.println(res);
    }

    private static int slidingWindow(int[] arr, int k) {
        int highVal,lowIndex=0,temp=0;
        int highIndex;
        for (int i = 0; i < k; i++) {
                temp=temp+arr[i];
        }
        highVal=temp;
        for (int i = k; i < arr.length; i++) {
            temp=temp+arr[i]-arr[i-k];
            if (temp>highVal) {
                highVal = temp;
                lowIndex=i-k+1;
            }
        }
        highIndex=lowIndex+k-1;
        System.out.println("lowIndex : "+lowIndex+" highIndex : "+ highIndex);
        return highVal;
    }

}
