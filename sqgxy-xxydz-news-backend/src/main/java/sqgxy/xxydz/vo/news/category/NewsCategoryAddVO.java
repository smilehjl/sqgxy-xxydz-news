package sqgxy.xxydz.vo.news.category;

import sqgxy.xxydz.enums.DisplayContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xmp
 * @date 2022-11-19 13:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsCategoryAddVO {

    private String name;

    private Integer newsTypeId;

    private DisplayContent displayContent;
}
