import App.Alerter;
import in.FakeSource;
import org.junit.Before;
import org.junit.Test;
import out.FakeDestination;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlerterTest {
    public static final String EXPECTED_TEXT = "expectedText";
    public static final String FILENAME = "filename";
    Alerter alerter;
    FakeSource fakeSource;

    @Before
    public void setup(){
        alerter = new Alerter();
    }

    @Test
    public void canGetInput() throws IOException {
        setupFakeSource();
        List<String> expected = new ArrayList<String>();
        expected.add(EXPECTED_TEXT);
        assertEquals(expected, alerter.getInput());
    }

    private void setupFakeSource() {
        fakeSource = new FakeSource(FILENAME);
        alerter.setSource(fakeSource);
        fakeSource.setText(EXPECTED_TEXT);
    }

    @Test
    public void canSendOutput(){
        setupFakeDestination();
        String recipient = "someone";
        List<String> textList = new ArrayList<String>();
        assertTrue(alerter.send(recipient, textList));
    }

    private void setupFakeDestination() {
        alerter.setDestination(new FakeDestination());
    }
}
