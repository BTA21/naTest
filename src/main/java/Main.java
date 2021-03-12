import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) throws LineDataException {

//        int[][] input = {{1,2},{2,3},{3,4},{4,5},{5,6}};
//        int[][] input = {{1,2},{2,3},{3,4},{4,5},{5,6}, {1,2}};
        int[][] input = {{1,3},{2,2},{3,4},{4,6},{5,9},{7,7}};
//        int[][] input = {{1,3},{3,6}};
//        int[][] input = {{1,3},{1,3}};
//        int[][] input = {{1,3,1},{1,3}};

        LineUtil check1 = new LineUtil(input);

        System.out.println(check1.isStraightLine());



    }



}
