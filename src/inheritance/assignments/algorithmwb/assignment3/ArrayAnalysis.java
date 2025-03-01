package inheritance.assignments.algorithmwb.assignment3;

import java.util.Arrays;

public class ArrayAnalysis {

    public static int searchForValue(int[] array, int targetNumber) throws Exception {
        for(int i = 0; i < array.length; i++){
            if(array[i] == targetNumber){
                return i;
            }
        }
        throw new Exception("Element not found");
    }
}
