package com.company; // Тут должно быть edu.tsystems.test.calc, а класс должен зваться CalculatorStarter.
import java.io.*;
import java.math.BigDecimal;

import static com.company.ExpressionUtils.calculateExpression;

/**
 * Created by Megmeehey on 05.03.2017.
 *
 */
public class Main {
    public static void main(String[] args) {
        BigDecimal res = BigDecimal.ZERO;
        boolean isOk = true;
        try {
            OutputStream os = new FileOutputStream(args[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File file = new File(args[0]);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    res = calculateExpression(line);
                }
                catch (Exception e)
                {
                    System.out.println("ERROR");
                    isOk = false;
                }
                if (isOk) {
                    System.out.println(res);
                }
                isOk = true;
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}