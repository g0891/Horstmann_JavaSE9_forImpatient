package ch02;
import com.opencsv.CSVReaderHeaderAware;

import java.io.FileReader;
import java.util.Map;

public class Ch02_13 {
    public static void main(String[] args) throws Exception {
        CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader("./.test/file.csv"));
        Map<String, String> values;
        while ((values = reader.readMap()) != null){
            System.out.println(values.get("name"));
        }

    }
}
