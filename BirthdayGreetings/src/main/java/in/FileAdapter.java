package in;

import App.SourcePort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAdapter implements SourcePort {
    File file;
    BufferedReader reader = null;

    public FileAdapter(String filename){
        file = new File(filename);
    }

    @Override
    public List<String> getText() throws IOException {
        List<String> fileContent = new ArrayList<String>();

        reader = new BufferedReader(new FileReader(file));
        String text = null;

        while ((text = reader.readLine()) != null){
            fileContent.add(text);
        }

        if (reader != null){
            reader.close();
        }

        return fileContent;
    }
}
