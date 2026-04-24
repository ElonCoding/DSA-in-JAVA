package Sem4.day4;

import java.util.ArrayList;
import java.util.List;

//write a java program to find all the subsets of a given set of arr [1,2,3]
public class subset2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        // Find and print the max value using Math.max
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        System.out.println("Max value: " + max);
        
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(arr, 0, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void generateSubsets(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Exclude the current element
        generateSubsets(arr, index + 1, current, result);

        // Include the current element
        current.add(arr[index]);
        generateSubsets(arr, index + 1, current, result);
        current.remove(current.size() - 1);
    }
}
