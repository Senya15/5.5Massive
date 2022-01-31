import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.RoundingMode.*;

public class Main {
    static final int PATIENT_VALUE = 30;
    static final int MIN_TEMP = 32;
    static final int MAX_TEMP = 40;
    static final float MIN_TEMP_HEALTHY = 36.2f;
    static final float MAX_TEMP_HEALTHY = 36.9f;

    public static void main(String[] args) {
        float[] temperature = new float[PATIENT_VALUE];

        float averageTemp = 0f;
        float sumTemp = 0f;
        int counter = 0;

        System.out.print("Температура пациентов: ");
        for (int i = 0; i < temperature.length; i++) {
            temperature[i] = (float) (MIN_TEMP + (MAX_TEMP - MIN_TEMP) * Math.random());
            BigDecimal bd = BigDecimal.valueOf(temperature[i]);
            temperature[i] = bd.setScale(1, HALF_UP).floatValue();
            sumTemp += temperature[i];
            System.out.print(temperature[i] + " ");

            if (temperature[i] <= 36.9f && temperature[i] >= 36.2f) {
                counter++;
            }
        }
        averageTemp = sumTemp / PATIENT_VALUE;
//        BigDecimal bdAverageTemp = new BigDecimal(averageTemp);
//        bdAverageTemp = bdAverageTemp.setScale(1, HALF_UP);
        System.out.println("\nСредняя температура: " + averageTemp);
        System.out.println("Количество здоровых пациентов: " + counter);
    }
}


