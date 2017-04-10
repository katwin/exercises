package net.oswin.exercises;

/**
 * Массивы
 */
public class Arrays {
    public static void main(String[] args) {
        int[] abyte = {1,2,3};
        abyte = new int[]{4,5,6};

        boolean[] abool = {true, false, true, true, false};

        abyte = new int[]{10,9,8,7,6,5,4,3,2,0};
        abyte[9] = 1;
        System.out.println(abyte[9]);
        System.out.println(abyte[8]);
        //System.out.println(abyte[10]); IndexOfBoundException

        //увеличение размерности массива
        int[] abyte2 = new int[abyte.length+1];
        System.out.println(abyte2[10]);
        for (int i = 0; i < abyte.length; i++) {
            abyte2[i] = abyte[i];
        }
        System.out.println(abyte2[9]);

        abyte2 = java.util.Arrays.copyOf(abyte, 11);
        System.out.println(abyte2[9]);

        java.util.Arrays.sort(abyte);
        System.out.println(abyte[9]);

        System.out.println(abyte[java.util.Arrays.binarySearch(abyte, 7)]);

        String[] astr = new String[] {"1", "2", "3"};
        Integer[] aint = new Integer[] {1, 2, 3};

        int[][] matrix = new int[2][2];
        matrix[0][0] = 1;
        int[][][] cube = new int[2][2][2];
        cube[0][0][0] = 1;

        for (Integer i : java.util.Arrays.asList(aint)) {
            System.out.println(i);
        }
        for (Integer i : java.util.Arrays.asList(1,2,3,4)) {
            System.out.println(i);
        }
    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }
}
