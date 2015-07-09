package App;

import java.io.IOException;
import java.util.List;

public class Alerter {

    SourcePort source;
    DestinationPort destination;

    public void setDestination(DestinationPort destination) {
        this.destination = destination;
    }

    public void setSource(SourcePort source) {
        this.source = source;
    }

    public List<String> getInput() throws IOException {
        return source.getText();
    }

    public boolean send(String recipient, List<String> textList) {
        return destination.send(recipient, textList);
    }
}
