package sqgxy.xxydz.controller;

import sqgxy.xxydz.module.HeaderImgUpload;
import sqgxy.xxydz.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author xmp
 * @date 2022-11-11 23:09
 * 上传图片操作
 */
@Slf4j
@Api(tags = "上传图片操作")
@RestController
public class OperationController {

    @ApiOperation(value = "单文件上传")
    @PostMapping("/uploading")
    public Result filesUpload(MultipartFile file) throws IOException {
        String s = HeaderImgUpload.headPortraitUpload(file);
        return new Result().ok().data(s);
    }

}
