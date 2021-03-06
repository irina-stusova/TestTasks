package com.penske.lessons.lesson10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileProperties {
    public Properties readPropFile() {
        Properties properties = new Properties();
        try {
            String fileName = "src\\main\\java\\com\\penske\\lessons\\lesson10\\example.properties";
            File file = new File(fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public List<String> readFileAsList() {
        List<String> list = new ArrayList<>();
        File file = new File("src\\main\\java\\com\\penske\\lessons\\lesson10\\example.properties");
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeToFile(List<String> list) {
        FileWriter fileWriter = null;
        File file = new File("src\\main\\java\\com\\penske\\lessons\\lesson10\\example1.txt");
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter = new FileWriter(file);
            for (String line : list) {
                fileWriter.append(line);
                fileWriter.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
