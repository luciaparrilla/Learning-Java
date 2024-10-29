package com.campusdual.iofiles;

import com.campusdual.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Writer {
    public static void main(String[] args) {
        Path filePath = Paths.get(Route.PATH_NAME);
        //File exampleFile = filePath.toFile();
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath.toFile()))) {
            //pw.println("Hola. Este es como almaceno una cadena.");
            for(int i = 0; i < 10; i++){
                int random = Utils.getRandomNumberInRange(1,100);
                pw.println(random);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
