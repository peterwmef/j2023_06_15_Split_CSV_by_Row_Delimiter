package util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SuppressWarnings("unused")
public class UFile { // class /////////////////////////////////////
// fields .......................................

public static void createFile(String filePath) throws IOException {
    Path fp = Paths.get(filePath);
    if (fp.getParent() != null) Files.createDirectories(fp.getParent());
    deleteFileOrDir(filePath);
    Files.createFile(fp);
}

public static void deleteFileOrDir(String dirPath) {
    try {
        File f = new File(dirPath);
        if (f.exists()) {
            if (f.isDirectory()) {
                FileUtils.deleteDirectory(new File(dirPath));
            } else {
                //noinspection ResultOfMethodCallIgnored
                f.delete();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

} // class /////////////////////////////////////
