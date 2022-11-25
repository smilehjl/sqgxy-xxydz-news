package sqgxy.xxydz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @author xmp
 * @date 2022-11-18 15:36
 *
 * 新闻主体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsAddDTO {

    private MultipartFile pictureFile;

    private String picturePath;

    private String title;

    private Date releaseTime;

    private String content;

    private Integer newsCategoryId;
}
