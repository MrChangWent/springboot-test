package learning.day05;

public class ArrayLearn {
    public static void main(String[] args) {

        int count = 0;

        int[][] arr = new int[][]{{3, 5, 8}, {12, 9}, {7, 0, 6, 4}};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                count += arr[i][j];
                System.out.println(count);
            }
        }

        System.out.println("sum = " +  count);
    }
}
