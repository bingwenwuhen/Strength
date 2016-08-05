package cn.com.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Administrator on 2016/8/5.
 */
public class Java78FileReadingExample {
    public static void main(String[] args) throws IOException {
        //JAVA 7 Example - Uses Platform's default character encoding
        System.out.println(new String(Files.readAllBytes(Paths.get("f:/1.txt"))));
        //Java 8 Example - Uses UTF-8 character encoding
        List lines = Files.readAllLines(Paths.get("f:/1.txt"), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder(1024);
        for (Object line: lines) {
            sb.append(line);
        }
        String fromFile = sb.toString();
        System.out.println("===================================");
        System.out.println("String created by reading File in java");
        System.out.println(fromFile);
        System.out.println("+++++++++++++++++++++++++++++++++++");
    }
}
