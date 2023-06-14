package csv;

import util.U;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

public class MyCsvReader { // class /////////////////////////////////////
    final private String csvFilePath;
//    final private String eolChar;

@SuppressWarnings("unused")
public MyCsvReader(String csvFilePath, String eolChar) {
    this.csvFilePath = csvFilePath;
//    this.eolChar = eolChar;
}

@SuppressWarnings("UnnecessaryContinue")
public void readAndPrint() throws Exception {
    BufferedReader reader = new BufferedReader(new FileReader(csvFilePath, StandardCharsets.UTF_8));
    while (true) {
        int c = reader.read();
        if (c == -1) break;
        if (c == 13) {
            continue;
        } else if (c == 10) {
            U.print("___EOL___");
            continue;
        } else {
            U.printInline(c + "[" + (char)c + "]");
        }



    }


}

} // class /////////////////////////////////////
