package converter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.codec.binary.Base64;

public class Converter {//program begins

    public static void main(String[] args) {

        File file = new File("Image\\Image1.png");

        try {
            FileInputStream image = new FileInputStream(file);
            byte imageData[] = new byte[(int) file.length()];
            image.read(imageData);

            String imageString = encodeImage(imageData);
            writeToTxt(imageString);
            System.out.println(imageString);

            System.out.println(" Successfull");

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static String encodeImage(byte[] imageByteArray) {
        return Base64.encodeBase64URLSafeString(imageByteArray);
    }

    public static void writeToTxt(String x64Image) {

        try {
            FileWriter outFile = new FileWriter(new File("Result\\x64Image.txt"));
            PrintWriter pWriter = new PrintWriter(outFile);
            pWriter.print(x64Image);
            pWriter.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}//programın ends
