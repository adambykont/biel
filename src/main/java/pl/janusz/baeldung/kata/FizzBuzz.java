package pl.janusz.baeldung.kata;

/**
 * Created by Janusz Kacki on 21/10/2019. Project; bielmarcus
 */
public class FizzBuzz {

    public static final int FIZZ_BUZZ = 15;
    public static final int FIZZ = 3;
    public static final int BUZZ = 5;

    public static String fizzBuzz(int arg) {

        if (arg % FIZZ_BUZZ == 0) {
            return "fizz-buzz";
        }

        if (arg % FIZZ == 0) {
            return "fizz";
        }

        if (arg % BUZZ == 0) {
            return "buzz";
        }

        return String.valueOf(arg);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            int a = i + 1;
            System.out.printf("%d -> %s%n", a, fizzBuzz(a));
        }
    }
}
