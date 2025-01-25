package utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static Object[] getCSVData() throws IOException {
        String filePath = "./src/test/resources/data.csv";
        FileReader reader = new FileReader(filePath);
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

        List<Object> data = new ArrayList<>();
        for(CSVRecord csvRecord : csvParser){
            String itemName = csvRecord.get("series");
            data.add(itemName);
        }

        return data.toArray(new Object[0]);
    }

    public static String decimalFormat(double value){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(value);
    }

//    public static void main(String[] args) throws IOException {
//        Object[] series = getCSVData();
//        for(Object item : series){
//            System.out.println(item.toString());
//        }
//    }
}
