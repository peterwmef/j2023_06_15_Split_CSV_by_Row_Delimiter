package csv;

import util.U;

import java.io.*;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class MyCsvReader { // class /////////////////////////////////////
    final private String csvFilePath;
    final private String resultFilePath;
    final private String eolChar;
    final private int    maxByteCount;
          private int    currByteCount;

public MyCsvReader(String csvFilePath, String eolChar, int maxByteCount, String resultFilePath) {
    this.csvFilePath    = csvFilePath;
    this.eolChar        = eolChar;
    this.maxByteCount   = maxByteCount;
    this.currByteCount  = 0;
    this.resultFilePath = resultFilePath;
}

public void readAndPrint() throws Exception {

    InputStream is1 = new FileInputStream(csvFilePath); // InputStream is used to read binary data, while Reader is used to read text data, precisely Unicode characters.
                                                        // InputStream.read() returns -1, or 0-255.  Nothing else. (Don't worry about 2's complements)
    BufferedInputStream bis = new BufferedInputStream(is1);
    StringBuilder s = new StringBuilder();


    try (FileOutputStream output = new FileOutputStream(resultFilePath, true)) { // Writers write characters, while OutputStreams write bytes

        while (true) {
            int b;
            if (   currByteCount++ > maxByteCount || (b = bis.read()) == -1   )  break;
            switch(b) {
                case 10: U.print("___EOL___"); // LF
                case 13: continue; // CR - eol is "CR-LF" or "LF"
                default:
                    U.printInline(b + "[" + (char)b + "]");
                    //                output.write(c); // String.format(""0x%04X "", c)
            }

        }

    }


}

} // class /////////////////////////////////////
