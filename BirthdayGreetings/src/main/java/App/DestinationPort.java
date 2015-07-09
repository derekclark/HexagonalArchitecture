package App;

import java.util.List;

public interface DestinationPort {
    boolean send(String recipient, List<String> textList);
}
