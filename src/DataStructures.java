import java.util.Arrays;

public class DataStructures {

    public static void main(String[] args) {
        int[] numbers = new int[]{23, 43, 65, 56, 71};
        System.out.println("Before sorting -> " + Arrays.toString(numbers));

        selectionSort(numbers);

        System.out.println("After sorting -> " + Arrays.toString(numbers));
    }

    private static void selectionSort(int[] ints){
         int minValue, minIndex;

        for (int i = 0; i < ints.length; i++) {
            minValue = ints[i];
            minIndex = i;
            for (int j = i + 1; j < ints.length; j++) {
                if(ints[j] > minValue){
                    minValue = ints[j];
                    minIndex = j;
                }
            }
            ints[minIndex] = ints[i];
            ints[i] = minValue;
        }

//        Arrays.stream(ints).forEach(System.out::println);
    }
}
