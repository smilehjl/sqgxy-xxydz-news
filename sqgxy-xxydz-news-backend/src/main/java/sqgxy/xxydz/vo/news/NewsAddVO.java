package sqgxy.xxydz.vo.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author xmp
 * @date 2022-11-19 15:36
 * 新闻主体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsAddVO {

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseTime;

    private String content;

    private Integer newsCategoryId;
}
