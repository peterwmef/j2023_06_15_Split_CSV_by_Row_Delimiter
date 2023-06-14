package csv;
import util.U;
import util.UFile;
import java.io.*;

@SuppressWarnings({"FieldCanBeLocal", "unused", "UnnecessaryLocalVariable"})
public class MyCsvReader { // class /////////////////////////////////////
    final private boolean printToFile = false;

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
    UFile.deleteFileOrDir(resultFilePath);     //    UFile.createFile     (resultFilePath);
    BufferedInputStream bis = getBufferedInputStream();

    try (FileOutputStream fos = new FileOutputStream(resultFilePath, true)) { // Writers write characters, while OutputStreams write bytes

        while (true) {
            int b = bis.read();
            if (currByteCount++ > maxByteCount || b == -1) break; // eol is "CR-LF" or "LF"
            passChar(fos, b);
        }

    }


}

private BufferedInputStream getBufferedInputStream() throws FileNotFoundException {
    InputStream is1 = new FileInputStream(csvFilePath); // InputStream is used to read binary data, while Reader is used to read text data, precisely Unicode characters.
                                                        // InputStream.read() returns -1, or 0-255.  Nothing else. (Don't worry about 2's complements)
    BufferedInputStream bis = new BufferedInputStream(is1);
    return bis;
}

private void passChar(FileOutputStream fos, int b) throws Exception {
    switch(b) {
        case 10: // LF
            printInlineByte('\n', fos); // LF
        case 13: // CR
            return;
        default:
            printInlineByte(b, fos);
    }
}

public void printInlineByte(int b, FileOutputStream fos) throws Exception {
    if (printToFile) {
        fos.write( (char) b); // String.format(""0x%04X "", c)
    } else {
        U.printInline("[" + b + "]" + (char)b );
    }
}


} // class /////////////////////////////////////
