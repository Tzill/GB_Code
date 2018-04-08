import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;

public class MainClass {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        try {
            throw new MyException(1, 1);
        } catch (MyException e) {
            arr[e.getRow()][e.getCol()] = 10;
        }
        System.out.println(arr[1][1]);
    }

    private static void finallyEx() {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("1.txt");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // try-with-resources // Interface Closeable
        try (FileOutputStream fos = new FileOutputStream("2.txt")) {

        } catch (IOException e) {

        }
    }

    private static void reportMakerEx() {
        try {
            ReportMaker.savePDF("A", "A");
        } catch (IOException e) {
            // show alert
        }
    }

    private static void savePDF() throws IOException {
        FileOutputStream out = new FileOutputStream("1.txt");
        out.close();
    }

    private static void doSomethingEx() {
        try {
            doSomething();
        } catch (RuntimeException e) {
            System.out.println("main RE");
        }
    }

    private static void doSomething() {
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("/ 0 - not correct");
            throw e;
            // throw new RuntimeException("1");
        }

    }

    private static void srqtExcEx() {
        try {
            System.out.println(sqrt(-20));
        } catch (RuntimeException e) {
            System.out.println("Некорректные данные");
        }
    }

    private static int sqrt(int n) {
        if (n < 0) {
            throw new RuntimeException("Корень нельзя вычислить из отрицательного числа");
        }
        return n / 2;
    }


    private static void ExceptionEx3() {
        try {
            int a = 10 / 0;
            int[] arr = new int[2];
            arr[5] = 10;
        } catch (ArithmeticException e) {
            System.out.println("AE");
        } catch (RuntimeException e) {
            System.out.println("RE");
        }
    }

    private static void ExceptionEx2() {
        try {
            int a = 10 / 0;
            int[] arr = new int[5];
            arr[10] = 20;
            System.out.println(2);
        } catch (NullPointerException e) {
            System.out.println("NPE CATCHED");
        } catch (ArithmeticException e) {
            System.out.println("AE CATCHED");
        }
        System.out.println("END");
    }

    private static void ExceptionEx1() {
        int b = 0; // Вводит пользователь
        int a;
        try {
            a = 10 / b;
        } catch (ArithmeticException e) {
            a = 2;
        }
        System.out.println(a);
    }

    private static void NPEEx() {
        String str = null;
        try {
            str.contains("A");
        } catch (NullPointerException e) {
            str = "Java";
            System.out.println(str.concat("a"));
            System.out.println("Catched");
        }
    }

    private static void arithmeticExceptionEx() {
        // Здесь пользователь вводит число b
        int b = 0;
        int a = 10 / b;
    }

    private static void a1() {
        a2();
    }

    private static void a2() {
        a3();
    }

    private static void a3() {

        int a = 10 / 0;
    }
}
