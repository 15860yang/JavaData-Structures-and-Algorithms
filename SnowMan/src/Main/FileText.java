package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileText {

    public static void main(String[] args) {
        new FileText().moveAndReNameFile("D://src//", "D://dest//");
    }

    public void moveAndReNameFile(String srcPath, String destPath) {
        int picIndex = 0;
        File srcDir = new File(srcPath);
        String[] fileNames = srcDir.list();
        for (int i = fileNames.length - 1; i >= 0; i--) {
            File file = new File(srcPath + "//" + fileNames[i]);
            if (file.isFile()) {
                copyFile(srcPath, fileNames[i], destPath, picIndex++ + fileNames[i].substring(fileNames[i].lastIndexOf('.')));
            } else {
                moveAndReNameFile(srcPath + "//" + fileNames[i], destPath + "//" + fileNames[i]);
            }
        }
    }

    public void copyFile(String SrcPath, String oldFileName, String destPath, String newFileName) {
        File srcFile = new File(SrcPath + "//" + oldFileName);
        File destFile = new File(destPath + "//" + newFileName);
        int len;
        byte[] buffer = new byte[1024 * 1024];
        InputStream in = null;
        OutputStream output = null;
        new File(destPath).mkdirs();
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
