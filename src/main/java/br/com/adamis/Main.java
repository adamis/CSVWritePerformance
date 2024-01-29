package br.com.adamis;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void writeCSV(String filePath, List<String[]> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                StringBuilder line = new StringBuilder();
                for (int i = 0; i < row.length; i++) {
                    if (i > 0) {
                        line.append(",");
                    }
                    line.append(escapeSpecialCharacters(row[i]));
                }
                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String escapeSpecialCharacters(String field) {
        // Adicione lógica de escape de caracteres especiais, se necessário
        // Por exemplo, pode ser necessário lidar com vírgulas, aspas, etc.
        return field;
    }

    public static void main(String[] args) {
        // Exemplo de uso
        String filePath = "c:/temp/arquivo.csv";
        List<String[]> data = new ArrayList<String[]>();
        
        for (int i = 0; i < 200000; i++) {		
	        data.add(new String[]{"Nome" , "Idade", "Cidade"        ,"Nome", "Idade", "Cidade","Nome", "Idade", "Cidade","Nome", "Idade", "Cidade","Nome", "Idade", "Cidade","Nome", "Idade", "Cidade"});
	        data.add(new String[]{"João" , "25"   , "São Paulo"     ,"João", "25", "São Paulo","João", "25", "São Paulo","João", "25", "São Paulo","João", "25", "São Paulo","João", "25", "São Paulo","João", "25", "São Paulo"});
	        data.add(new String[]{"Maria", "30"   , "Rio de Janeiro","Maria", "30", "Rio de Janeiro","Maria", "30", "Rio de Janeiro","Maria", "30", "Rio de Janeiro","Maria", "30", "Rio de Janeiro","Maria", "30", "Rio de Janeiro",});
        }
        
        System.err.println("escrevendo1: "+data.size());
        writeCSV(filePath, data);
        
        for (int i = 0; i < 200000; i++) {		
	        data.add(new String[]{"asdasdasdas" , "asdasdasdas", "asdasdasdas" });
        }
        
        System.err.println("escrevendo2: "+data.size());
        writeCSV(filePath, data);
        
    }
}
