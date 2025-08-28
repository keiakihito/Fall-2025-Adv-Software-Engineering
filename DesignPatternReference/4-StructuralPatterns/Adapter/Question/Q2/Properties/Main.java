package Adapter.Question.Q2.Properties;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileIO f = new FileProperties();
        try {
            f.readFromFile("src/Adapter/Question/Q2/Properties/file.txt");
            f.setValue("width", "1024");
            f.setValue("height", "512");
            f.setValue("depth", "32");
            f.writeToFile("src/Adapter/Question/Q2/Properties/newfile.txt");
            System.out.println("newfile.txt is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
