package _2023_06_27.classwork;

public class Main {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};

        System.out.println(printArray((arr -> {
            int sum = 0;
            for (int i : arr) {
                sum += i;
            }
            return sum;
        }), ints));

        System.out.println(printArray(Main::printRef, ints));

    }

    public static int printArray(Printer printer, int[] arr) {
        return printer.print(arr);
    }

    public static int printRef(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}
