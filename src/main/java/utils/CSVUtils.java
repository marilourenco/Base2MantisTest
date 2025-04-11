package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static Object[][] readCSV(String path) {
        List<Object[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(CSVUtils.class.getResourceAsStream(path)))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) { // Pula o header
                    firstLine = false;
                    continue;
                }
                String[] fields = line.split(",");
                data.add(fields);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data.toArray(new Object[0][]);
    }
}
