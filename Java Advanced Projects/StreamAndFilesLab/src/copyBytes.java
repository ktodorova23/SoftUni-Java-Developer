import java.io.*;

public class copyBytes {
    public static void main(String[] args) {
        String inputPath = "E:\\Java\\Docs for exercise\\Java Advanced\\Labs\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        String outputPath = "E:\\Java\\Docs for exercise\\Java Advanced\\Labs\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        FileInputStream fileReader = null;
        FileOutputStream fileWriter = null;

        try {
            fileReader = new FileInputStream(inputPath);
            fileWriter = new FileOutputStream(outputPath);

            int oneByte = fileReader.read();

            while (oneByte >= 0) {
                if (oneByte == ' ' || oneByte == '\n') {
                    fileWriter.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);

                    for (int i = 0; i < digits.length(); i++) {
                        fileWriter.write(digits.charAt(i));
                    }
                }

                oneByte = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
