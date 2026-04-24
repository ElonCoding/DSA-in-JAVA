package Sem4.day4;

import java.util.ArrayList;
import java.util.List;

//write a java program to find all the subsets of a given set of arr [1,2,3]
public class subset {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
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
