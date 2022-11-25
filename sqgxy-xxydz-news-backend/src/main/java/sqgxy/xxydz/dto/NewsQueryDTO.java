package sqgxy.xxydz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xmp
 * @date 2022-11-18 15:36
 *
 * 查询新闻主体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsQueryDTO {

    private Integer id;

    private String title;

    private Date releaseTime;

    private Integer hits;

    private String content;
}
