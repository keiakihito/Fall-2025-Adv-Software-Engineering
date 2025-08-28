// FilePropertiesクラスを実装してください。

package Adapter.Question.Q2.Properties;

import java.io.IOException;
import java.io.*;
import java.util.Properties;

public class FileProperties implements FileIO {

    private Properties properties;

    public FileProperties() {
        properties = new Properties();
    }

    @Override
    public void readFromFile(String filename) throws IOException {
        try (Reader reader = new FileReader(filename)) {
            properties.load(reader);
        }
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            properties.store(writer, "written by FileProperties");
        }
    }

    @Override
    public void setValue(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}

