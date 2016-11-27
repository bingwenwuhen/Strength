package cn.com.builtin.serialize;

import java.io.*;

/**
 * Created by xiaxuan on 16/11/24.
 */
public class NativeSerializeTools {

    /**
     * 序列化
     * @param filePath  序列化的路径
     * @param s         序列化的对象
     */
    public static void write(String filePath, Object s) throws IOException {
        if (filePath == null || filePath.length() == 0) {
            throw new RuntimeException("请传入序列化路径");
        }

        if (s == null) {
            throw new RuntimeException("请传入序列化对象");
        }

        File f = new File(filePath);
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(s);
            System.out.println("finish.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (oos != null) {
                oos.close();
            }
            if (fos != null){
                fos.close();
            }
            System.out.println("close the resource.");
        }
    }

    /**
     * 反序列化
     * @param filePath  反序列化的路径
     * @return          反序列化的对象
     */
    public static Object read(String filePath) throws IOException {
        if (filePath == null || filePath.length() == 0) {
            throw new RuntimeException("请传入反序列化路径");
        }

        File file = new File(filePath);

        ObjectInputStream ois = null;
        FileInputStream fis = null;
        Object o = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            o = ois.readObject();
            System.out.println("finish.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (ois != null) {
                ois.close();
            }
            if (fis != null) {
                fis.close();
            }
            System.out.println("close the resource.");
        }
        return o;
    }
}
