package prac_9;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import prac_9.CSVWriter;

public class GestorArchivosG573 {
    public void writeIntoFile(List<String[]> data, String file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            writer.write(data.toString());
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }

    }

    public List<String[]> readFile(String file) throws IOException {
        List<String[]> datos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea = br.readLine();

            while (linea != null) {
                String[] campos = linea.split(",", -1);

                // Limpiar comillas si existen
                for (int i = 0; i < campos.length; i++) {
                    campos[i] = campos[i].trim();
                    if (campos[i].startsWith("\"") && campos[i].endsWith("\"")) {
                        campos[i] = campos[i].substring(1, campos[i].length() - 1);
                        campos[i] = campos[i].replace("\"\"", "\"");
                    }
                }

                datos.add(campos);
                linea = br.readLine();
            }
        } catch (IOException e) {
            throw new IOException("Error reading file: " + file, e);
        }

        return datos;
    }

    public void backup() throws IOException {
        try {
            List<String[]> datos = readFile("./prac_9/datos_2177573.txt");
            writeIntoFile(datos, "./prac_9/backup.dat");
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    public void main(String[] args) throws IOException {
        int opc;
        do {
            System.out.println("1. Escribir archivo\n2.Leer archivo\n3. Crear CSV\n4.Salir");
            Scanner sc = new Scanner(System.in);

            switch (opc = sc.nextInt()) {
                case 1:
                    System.out.println("Escriba los datos del estudiante: (Nombre,Matricula)");
                    String dato = sc.nextLine();
                case 2:

            }
        } while (opc != 4);
    }
}
