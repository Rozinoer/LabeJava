import java.util.Random;

public class MAin {

    public static void main(String[] args) {

        long start;
        long end;
        Random rn = new Random();
        int[] array = new int[199997];
        int semi = array.length / 2;
        int[] part1 = new int[semi];
        int[] part2;
        part2 = new int[semi + 1];
        System.out.println("Firstable");
        for (int i = 0; i < array.length; i++) {
            array[i] = rn.nextInt(10);
            if (i < semi) {
                part1[i] = array[i];
            }
            if (i >= semi) {
                part2[i - semi] = array[i];
            }
            if (i!=array.length-1)
            System.out.print(array[i] + " "); else System.out.println(array[array.length-1]);

        }
        System.out.println("------------------------------------");


        try {
            start = System.currentTimeMillis();
            shell(array);
            System.out.println("After Shell Sort");
            for (int i = 0; i < array.length; i++) {
                if (i!=array.length-1)
                System.out.print(array[i] + " "); else System.out.println(array[array.length - 1]);
            }
            System.out.println("------------------------------------");
            end = System.currentTimeMillis();
            System.out.println("Single-threaded Shell sorting.\nTime: " + (end - start) + "ms. Array length is " +
                    array.length + "\n");

            start = System.currentTimeMillis();
            MultiThreadingShellSort mss = new MultiThreadingShellSort(part1, part2);
            mss.getThr().join();
            array = mss.getArray();
            end = System.currentTimeMillis();
            System.out.println("Multithreaded Shell sorting.\nTime: " + (end - start) + "ms. Array length is " +
                    array.length);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void shell(int[] array) {
        int length = array.length;
        int semi = length / 2;
        while (semi > 0) {
            for (int i = 0; i < length - semi; i++) {
                int j = i;
                while ((j >= 0) && array[j] > array[j + semi]) {
                    int temp = array[j];
                    array[j] = array[j + semi];
                    array[j + semi] = temp;
                    j--;
                }
            }
            semi /= 2;
        }
    }

}