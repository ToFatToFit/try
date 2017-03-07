package edu.tsystems.test.DuplicateStarter;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DuplicateStarter {
    public static void main(String[] args) {
        Map<String, Integer> duplicates = new HashMap<String, Integer>();
        try {
            File file = new File(args[0]);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if (!duplicates.containsKey(line)) {
                    duplicates.put(line, 1);
                } else {
                    duplicates.put(line, duplicates.get(line) + 1);
                }
            }
            fileReader.close();

            try (Writer writer1 = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(args[1]), "utf-8"))) {
                for (Map.Entry<String, Integer> entry : duplicates.entrySet()) {
                    writer1.write(entry.getKey() + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (Writer writer2 = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(args[2]), "utf-8"))) {
                for (Map.Entry<String, Integer> entry : duplicates.entrySet()) {
                    if (entry.getValue() != 1) {
                        writer2.write(entry.getKey() + " - " + entry.getValue() + "\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
