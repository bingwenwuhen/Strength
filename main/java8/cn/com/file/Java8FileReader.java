package cn.com.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Administrator on 2016/8/5.
 */
public class Java8FileReader {
    public static void main(String[] args) throws IOException {
        //In java8 you can also use Streams to further optimize it
        Files.lines(Paths.get("f:/1.txt"), StandardCharsets.UTF_8)
                .forEach(System.out::println);
    }
}
