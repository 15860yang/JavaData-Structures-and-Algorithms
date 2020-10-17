package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFileText {

    public static void main(String[] args) {
        new CopyFileText().reNameFile("D://src//", "png");
    }

    public void reNameFile(String filePath, String... suffixs) {
        int picIndex = 0;
        File srcDir = new File(filePath);
        String[] fileNames = srcDir.list();
        for (int i = fileNames.length - 1; i >= 0; i--) {
            File file = new File(filePath + "//" + fileNames[i]);
            if (file.isFile()) {
                for (String suffix : suffixs) {
                    if (fileNames[i].endsWith(suffix)) {
                        String oldFileName = filePath + "//" + fileNames[i];
                        File oldFile = new File(oldFileName);
                        String newFileName = filePath + "//" + picIndex++ + "." + suffix;
                        File newFile = new File(newFileName);
                        if (oldFile.exists() && oldFile.isFile()) {
                            oldFile.renameTo(newFile);
                        }
                        break;
                    }
                }
            } else {
                reNameFile(filePath + "//" + fileNames[i], suffixs);
            }
        }
    }

    public void copyFile(String SrcPath, String srcFileName, String destPath) {
        File srcFile = new File(SrcPath + "//" + srcFileName);
        File destFile = new File(destPath + "//" + srcFileName);
        int len;
        byte[] buffer = new byte[1024 * 1024];
        InputStream in = null;
        OutputStream output = null;
        try {
            in = new FileInputStream(srcFile);
            output = new FileOutputStream(destFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            while ((len = in.read(buffer)) != -1) {
                output.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeStream(in, output);
    }

    public void closeStream(InputStream in, OutputStream output) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (output != null) {
            try {
                output.flush();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
