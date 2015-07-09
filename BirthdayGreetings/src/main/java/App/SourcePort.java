package App;

import java.io.IOException;
import java.util.List;

public interface SourcePort {
    List<String> getText() throws IOException;
}
