import App.Alerter;
import App.SourcePort;
import in.FileAdapter;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileAdapterIntegrationTest {
    public static final String EXPECTED_TEXT = "expectedText";
    public static final String FILENAME = "test.txt";
    Alerter alerter;
    SourcePort source;

    @Before
    public void setup(){
        alerter = new Alerter();
        source = new FileAdapter(FILENAME);
        alerter.setSource(source);

        deleteFile(FILENAME);
    }

    private void deleteFile(String filename) {
        File file = new File(filename);
        file.delete();
    }

    @Test
    public void canGetInput() throws IOException {
        prepareInputFile();

        List<String> expected = new ArrayList<String>();
        expected.add(EXPECTED_TEXT);
        assertEquals(expected, alerter.getInput());
    }

    private void prepareInputFile() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(FILENAME);
        out.println(EXPECTED_TEXT);
        out.close();
    }

    @Test(expected=FileNotFoundException.class)
    public void exceptionWhenInputFileNotFound() throws IOException {
        alerter.getInput();
    }
}
