package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SqlFileReader {

    public static String read(String path){

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            StringBuilder sql = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty() || line.startsWith("--")) continue;
                sql.append(line).append("\n");
            }

            return sql.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
