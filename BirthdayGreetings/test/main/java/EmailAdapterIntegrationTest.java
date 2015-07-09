import App.Alerter;
import org.junit.Test;
import App.DestinationPort;
import out.EmailAdapter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class EmailAdapterIntegrationTest {

    @Test
    public void canSend(){
        DestinationPort destination = new EmailAdapter();
        Alerter alerter = new Alerter();
        alerter.setDestination(destination);
        List<String> text = new ArrayList<String>();
        text.add("some text");
        assertTrue(alerter.send("someone", text));
    }
}
