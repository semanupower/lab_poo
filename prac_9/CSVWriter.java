package prac_9;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVWriter {
    public static String escapeCSV(String input) {
        if (input.isEmpty()) {
            return input;
        }
        if (input.contains(",") || input.contains("\"")) {
            return "\""+ input.replace("\"", "\"\"") +"\"";
        }
        return input;
    }

    public static void writeCSV(List<String[]> datos) throws FileNotFoundException {
        try(PrintWriter writer = new PrintWriter("log_Garcia.csv")) {
            for (String[] dato : datos) {
                String renglon = Arrays.stream(dato).map(CSVWriter::escapeCSV).collect(Collectors.joining(","));
                writer.println(renglon);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
