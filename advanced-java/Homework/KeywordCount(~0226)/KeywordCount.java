import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KeywordCount {
    static String[] keywords = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
            "const", "continue", "default", "do", "double", "else", "enum", "extends", "false", "final", "finally",
            "float", "for", "If", "goto", "Implements", "Import", "Instanceof", "Int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp",
            "super", "switch", "synchronize", "this", "throw", "throws", "transient", "true", "try", "void", "volatile",
            "while" };
    static int[] keywordCount = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // 검사할 파일이 하나도 입력되지 않았을 경우 종료
        if (args.length < 1) {
            System.out.println(
                    "사용법\n하나의 파일만 검토할 때: java KeywordCount Hello.java\n2개 이상의 파일만 검토할 때: java KeywordCount file1.java file2.java");
            return;
        }

        for (String fileName : args) {
            readFile(fileName);
            printKeywordCount(fileName);
            Arrays.fill(keywordCount, 0); // keywordCount 초기화
        }
    }

    // 파일을 읽어 키워드 개수 저장
    static void readFile(String fileName) throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(fileName);
        try (BufferedReader br = new BufferedReader(fileReader)) {
            String line;

            // 마지막 줄까지 반복
            while ((line = br.readLine()) != null) {
                StringTokenizer words = new StringTokenizer(line, " "); // 각 줄을 토큰화

                while (words.hasMoreTokens()) { // 단어 토큰이 남아있을 때까지 반복
                    String word = words.nextToken();
                    checkKeyword(word); // 해당 단어가 키워드인지 판별
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 파일별로 키워드 개수 출력
    static void printKeywordCount(String fileName) {
        System.out.println("File Name: " + fileName);
        System.out.println("Keyword Counts: ");
        for (int i = 0; i < keywords.length; i++) {
            if (keywordCount[i] != 0) {
                System.out.println(keywords[i] + ": " + keywordCount[i]);
            }
        }
        System.out.println();
    }

    // 해당 단어가 키워드인지 판별하고 해당 키워드에 대한 개수 1만큼 증가
    static void checkKeyword(String word) {
        for (int i = 0; i < keywords.length; i++) {
            String keyword = keywords[i];
            if (keyword.equals(word)) {
                keywordCount[i]++;
            }
        }
    }
}
