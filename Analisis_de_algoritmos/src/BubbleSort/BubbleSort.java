package BubbleSort;

public class BubbleSort {
    private int[] array;
    public static void main(String[] args) {
        // DubbleSort
        int[] array = generateReversedArray(5000);
        BubbleSort bubbleSort = new BubbleSort(array);

        // Test1
        System.out.println(bubbleSort);
        System.out.println("______________________________");

        long startTime = System.nanoTime();
        bubbleSort.sort();
        long endTime = System.nanoTime();

        System.out.println(bubbleSort);
        System.out.println("Tiempo de ejecución: " + (endTime - startTime) + " nanosegundos");
    }

    public BubbleSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    
    public static int[] generateReversedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i; // Array invertido para representar el peor caso
        }
        return array;
    }
}

