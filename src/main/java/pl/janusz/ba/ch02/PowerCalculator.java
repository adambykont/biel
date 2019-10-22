package pl.janusz.ba.ch02;

/**
 * Created by Janusz Kacki on 22/10/2019. Project; bielmarcus
 */
public class PowerCalculator {

    public int calculatePower(int base, int exponent) {

        int product = 1;
        for (int i = 0; i < exponent; i++) {
            product *= base;
        }

        return product;
    }
}
                                                            