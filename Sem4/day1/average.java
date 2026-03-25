package Sem4.day1;

public class average {
    public static void main(String[]args){
        int[]arr ={1,2,3,4,5,6,7,8,9,10};
        int average = 0;
        for (int i = 0; i < arr.length; i++) {
            average += arr[i];
        }
        System.out.println(average/arr.length);
    }

    
}
