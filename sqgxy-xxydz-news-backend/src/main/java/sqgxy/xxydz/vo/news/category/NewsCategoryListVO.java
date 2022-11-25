package sqgxy.xxydz.vo.news.category;

import sqgxy.xxydz.enums.DisplayContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xmp
 * @date 2022-11-19 14:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsCategoryListVO {

    private Integer id;

    private String name;

    private DisplayContent displayContent;
}
