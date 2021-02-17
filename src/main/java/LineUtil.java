import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Класс Утилиты, которая определяет принадлежность точек к одной прямой со свойствами
 * <b>k</b>, <b>b</b> и <b>coordinates</b>.
 * @autor Азамат Набиев
 * @version 1.1
 */
public class LineUtil {

    /** Поле коэффициента k */
    private double k;

    /** Поле коэффициента b */
    private double b;

    /** Поле массива координат одной прямой (предпологаемо) */
    private int[][] coordinates;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param coordinates - массив координат одной прямой (предпологаемо)
     * @see LineUtil#LineUtil(int[][])
     */
    LineUtil(int[][] coordinates) {
        this.coordinates = coordinates;

        try {
            double x0 = coordinates[0][0];
            double y0 = coordinates[0][1];
            double x1 = coordinates[1][0];
            double y1 = coordinates[1][1];
            double y = (y0-y1);
            double x = (x0-x1);
            if ((y > x && x > 0) || (y < x && x < 0)) {
                this.k = y / x;
            } else {
                this.k = x / y;
            }
            this.b = y0 - x0 * k;

        } catch (Exception ArrayIndexOutOfBoundsException) {
            System.out.println("Входной массив мал для условий задачи!");
        }

    }

    boolean checkLineCoordinates() {
        for(int i = 2; i < coordinates.length; i++) {
            double y = Array.getDouble(coordinates[i],1);
            double x = Array.getDouble(coordinates[i],0);
            if (y != (x * k + b)) {
                return false;
            }
            System.out.println(y + "=" + (x*k+b));

        }
        return true;
    }

    boolean getCheckCoord() {
        return this.checkLineCoordinates();
    }

    public boolean isStraightLine(int[][] coordinates) {

            for(int i = 0; i < coordinates.length; i++) {
                if(Array.getLength(coordinates[i]) != 2){
                    return false;
                } else {
                    for(int j = 0; j < coordinates.length; j++) {
                        for(int ij = 0; ij < coordinates.length; ij++) {
                            if(j!=ij){
                                if(Arrays.equals(coordinates[j],coordinates[ij])){
                                    return false;
                                }
                            } else {
                                continue;
                            }

                        }

                    }

                }
            }


        return getCheckCoord();
    }
}
