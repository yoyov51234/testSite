package utils;

import java.io.File;

public class UploadFileHelper {

    // 默认上传目录（容器内路径）
    private static final String UPLOAD_DIR = System.getProperty("uploadDir", System.getProperty("user.dir")+"/src/test/resources/uploads");

    /**
     * 构造一个上传文件的完整路径（并校验存在）
     */
    public static String resolveUploadPath(String filename) {
        File file = new File(UPLOAD_DIR, filename);
        ;

        if (!file.exists()) {
            throw new RuntimeException("❌ Upload file not found: " + file.getAbsolutePath());
        }

        return file.getAbsolutePath();
    }
}
