package sqgxy.xxydz.module;

import sqgxy.xxydz.exception.HintException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author xmp
 * 用于照片上传,处理静态文件不用重启且被访问
 */

@Slf4j
public class HeaderImgUpload {

    //静态资源路径
    private static final String FILE_PATH_PREFIX = "static/images";

    private static final String FILE_PATH_PREFIX_READ = "images";

    //文件路径后缀
    private static final String FILE_PATH_SUFFIX = ".png";

    // 默认的图片后缀
    private static final List<String> FILE_TYPE = Arrays.asList("image/jpeg", "image/png");

    public static String headPortraitUpload(MultipartFile file) throws IOException, HintException {

        System.out.println(file.getContentType());
        if (!FILE_TYPE.contains(file.getContentType())) {
            throw new HintException("上传的文件类型只能是:" + FILE_TYPE.toString());
        }

        String path = System.getProperty("user.dir");
        File upload = new File(path, FILE_PATH_PREFIX);

        log.info("目录upload: " + upload.toString());
        if (!upload.exists()) {
            log.info("目录不存在，开始创建: " + upload.toString());
            if (!upload.mkdirs()) {
                throw new HintException("文件上传失败");
            }
        }

        File file1;
        UUID fileName = UUID.randomUUID();
        if (!file.isEmpty()) {
            log.info("开始保存");
            //保存到文件服务器
            file1 = new File(upload, fileName + FILE_PATH_SUFFIX);
            file.transferTo(file1);
        } else {
            throw new NullPointerException("文件不能为空");
        }
        return FILE_PATH_PREFIX_READ + File.separator + fileName + FILE_PATH_SUFFIX;
    }

}
