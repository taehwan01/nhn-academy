import java.io.*;

public class FileDetails {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE: java FileDetails FileName");
            return;
        }
        String fileName = args[0];

        // read the file that passed from parameter of main method
        File file = new File(fileName);
        try (FileInputStream stream = new FileInputStream(file)) {
            char[] content = new char[(int) file.length()];
            for (int i = 0; i < content.length; i++) {
                content[i] = (char) stream.read();
                // System.out.print(content[i]);
            }
            summarize(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void summarize(char[] content) {
        int vowels = 0, consonates = 0, lines = 0;

        for (char letter : content) {
            if (Character.isLetter(letter)) {
                if ("AEIOUaeiou".indexOf(letter) != -1) {
                    vowels++;
                } else {
                    consonates++;
                }
            } else if (letter == '\n') {
                lines++;
            }
        }

        System.out.println("총 문자 수: " + content.length);
        System.out.println("모음 수: " + vowels);
        System.out.println("자음 수: " + consonates);
        System.out.println("줄 수: " + lines);
    }
}