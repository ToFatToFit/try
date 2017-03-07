package edu.tsystems.test.subcons;

import java.io.*;

/**
 * Created by Megmeehey on 04.03.2017.
 */
public class SubconsequencesStarter {
    public static void main(String[] args) {
        String[] first = new String[]{""}, second = new String[]{""};
        try {
            //File file = new File(args[0]);
            File file = new File(args[0]); // E:\\Java\\SubconsequencesStarter\\out\\production\\SubconsequencesStarter\\edu\\tsystems\\test\\subcons\\in.txt
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            try {
                first = bufferedReader.readLine().split(",");
                second = bufferedReader.readLine().split(",");
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileReader.close();
            System.out.println(isContains(first, second));

            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(args[1]), "utf-8"))) { // "E:\\Java\\SubconsequencesStarter\\out\\production\\SubconsequencesStarter\\edu\\tsystems\\test\\subcons\\out.txt"
                writer.write(isContains(first, second));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String isContains(String[] first, String[] second) {
        boolean found = true;
        int curChar = 0;
        for (String f : first) { // проходимся по всем элементам первого списка и ищем эквивалентные во втором
            boolean curFound = false; // изначально элемент не найден
            //for(String s : second) {
            while (curChar < second.length) { // начинаем искать с последнего просмотренного символа
                if (f.equals(second[curChar])) {
                    curFound = true; // выходим из цикла
                    curChar++;
                    break;
                } else {
                    curChar++;
                }
            }
            if (!curFound) { // если не найден
                found = false; // то не все элементы получаются вычеркиванием
                break;
            }
        }
        if (found) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
