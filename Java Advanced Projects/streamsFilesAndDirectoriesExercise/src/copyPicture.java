import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class copyPicture {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("pic.jpg");

        byte[] buffer = fileInputStream.readAllBytes();

        FileOutputStream fileOutputStream = new FileOutputStream("pi-copy.jpg");

        fileOutputStream.write(buffer);
        fileOutputStream.close();
    }
}
