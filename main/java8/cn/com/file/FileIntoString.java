package cn.com.file;

import java.io.IOException;

import static java.lang.System.out;
import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

/**
 * Created by Administrator on 2016/8/5.
 */
public class FileIntoString {

    public static void main(String[] args) throws IOException {
        out.println(new String(readAllBytes(get("f:/1.txt"))));
    }

}
