package BubbleSort;

public class BubbleSort {
    private int[] array;
    public static void main(String[] args) {
        // DubbleSort
        int[] array = new int[] { 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36,
                35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10,
                9, 8, 7, 6, 5, 4, 3, 2, 1 };
        BubbleSort bubbleSort = new BubbleSort(array);

        // Test1
        System.out.println(bubbleSort);
        System.out.println("______________________________");

        long startTime = System.nanoTime();
        bubbleSort.sort();
        long endTime = System.nanoTime();

        System.out.println(bubbleSort);
        System.out.println((endTime - startTime) + "ns");
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
}

