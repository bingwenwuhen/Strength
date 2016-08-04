package cn.com.asm;

import org.objectweb.asm.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Administrator on 2016/8/3.
 */
public class Test_08 {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("e:/workspace/Strength/main/asm/cn/com/asm/Test.class");
        ClassReader reader = new ClassReader(fis);
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        reader.accept(new MyClassVisivator(cw), 0);
        writeToFile(cw.toByteArray(), "e:/workspace/Strength/main/asm/cn/com/asm/Test.class");
    }

    static void writeToFile(byte[] bytes, String fileName) {
        try {
            (new File(fileName)).createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyClassVisivator extends ClassAdapter {

        ClassVisitor mCv;

        public MyClassVisivator(ClassVisitor classVisitor) {
            super(classVisitor);
            mCv = classVisitor;
        }

        @Override
        public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
            MethodVisitor mv = super.visitMethod(i, s, s1, s2, strings);
            if ("main".equals("name")) {
                MyMethodVisitor mmv = new MyMethodVisitor(mv);
                return mmv;
            }
            return mv;
        }

        @Override
        public void visitEnd() {
            MethodVisitor mv = super.visitMethod(Opcodes.ACC_STATIC, "test03", "()V", null, null);
            if (mv != null) {
                mv.visitCode();
                mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream");
                mv.visitLdcInsn("Hello in Test03!");
                mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
                mv.visitInsn(Opcodes.RETURN);
                mv.visitMaxs(0, 0);
                mv.visitEnd();
            }
        }
    }

    static class MyMethodVisitor extends MethodAdapter {

        MethodVisitor mMv;

        public MyMethodVisitor(MethodVisitor methodVisitor) {
            super(methodVisitor);
            mMv = methodVisitor;
        }

        @Override
        public void visitInsn(int i) {
            if (i == Opcodes.RETURN) {
                System.out.println("Debug");
                mv.visitMethodInsn(Opcodes.INVOKESTATIC, "Test", "test03", "()V");
            }
            super.visitInsn(i);
        }

        @Override
        public void visitEnd() {
            super.visitEnd();
        }
    }

}
