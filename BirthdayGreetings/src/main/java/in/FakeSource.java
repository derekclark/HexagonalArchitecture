package in;

import App.SourcePort;

import java.util.ArrayList;
import java.util.List;

public class FakeSource implements SourcePort {
    String text, filename;

    public FakeSource(String filename){
        this.filename=filename;
    }

    @Override
    public List<String> getText() {
        List<String> list = new ArrayList<String>();
        list.add(text);
        return list;
    }

    public void setText(String text) {
        this.text = text;
    }
}
