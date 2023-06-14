package main;
import csv.MyCsvReader;

public class Main { // class ///////////////////////////////////////

public static void main(String[] args) throws Exception {
    System.out.println("===== usage: java -jar jarFileName.jar csvFilePath EOL_Char[CR_LF|LF] ");
//    BufferedReader reader = new BufferedReader(new FileReader(args[0], StandardCharsets.UTF_8));
//    int c = reader.read();
    MyCsvReader myCsvReader = new MyCsvReader(args[0], args[1]);
    myCsvReader.readAndPrint();

}

} // class /////////////////////////////////////////////////////