package Sem4.day1;

public class min {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int sum = 0;
       
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(min);
        for (int i = 0; i < arr.length; i++) {
             sum += arr[i];
        }
        System.out.println(sum);
}
    }
