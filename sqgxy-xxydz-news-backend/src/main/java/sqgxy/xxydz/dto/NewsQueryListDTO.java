package sqgxy.xxydz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xmp
 * @date 2022-11-18 15:36
 *
 * 查询新闻列表时返回的实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsQueryListDTO {

    private String picturePath;

    private Integer id;

    private String title;

    private Date releaseTime;
}
