package out;

import App.DestinationPort;

import java.util.List;

public class FakeDestination implements DestinationPort {
    @Override
    public boolean send(String recipient, List<String> textList) {
        return true;
    }


}
