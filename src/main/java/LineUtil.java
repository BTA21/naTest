import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

        //Устанавливаем ограничение на размер массива, минимум 2 точки.
        try {
            double x0 = coordinates[0][0];
            double y0 = coordinates[0][1];
            double x1 = coordinates[1][0];
            double y1 = coordinates[1][1];
            double y = (y0-y1);
            double x = (x0-x1);
            //Вычисляем коэффициенты k и b.
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

    /**
     * Функция определения принадлежности точки к прямой.
     * @return возвращает true или false в зависимости от результата вычисления.
     */
    private boolean checkLineCoordinates() {
        for(int i = 2; i < coordinates.length; i++) {
            double y = Array.getDouble(coordinates[i],1);
            double x = Array.getDouble(coordinates[i],0);
            if (y != (x * k + b)) {
                return false;
            }
            //Для самопроверки
            System.out.println(y + "=" + (x*k+b));

        }
        return true;
    }

    /**
     * Функция с предварительными условиями вызывающая метод определения
     * принадлежности точки к прямой {@link LineUtil#checkLineCoordinates}.
     * @return возвращает true или false в зависимости от результата вычисления.
     */
    public boolean isStraightLine() throws LineDataException {

        Set dataPointSet = new HashSet();
            for(int i = 0; i < this.coordinates.length; i++) {
                //Массив с точкой должен содержать 2 координаты: x и y.
                if(Array.getLength(this.coordinates[i]) != 2) throw new LineDataException("Точка " + (i+1) + " имеет" +
                        ", больше двух координат!");
                //Массив с точками не должен сожержать одинаковых точек(используем хэш-сет)
                System.out.println(Arrays.toString(this.coordinates[i]));
                if(!dataPointSet.add(Arrays.toString(this.coordinates[i]))) throw new LineDataException("Прямая линия" +
                        " не может пересекать одну точку более одного раза!");
                else {
                    continue;
                }






            }
        return this.checkLineCoordinates();
    }
}
