/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileoperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author xperiaW
 */
public class ContentReader {

    public static String readFile(File file_path) {
        String records = "";
        try {

            java.io.FileReader fr = new java.io.FileReader(file_path);
            BufferedReader txtReader = new BufferedReader(fr);

            String line;

            while ((line = txtReader.readLine()) != null) {
                records = records + line + "\n";
            }
            txtReader.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return records;

    }

}
