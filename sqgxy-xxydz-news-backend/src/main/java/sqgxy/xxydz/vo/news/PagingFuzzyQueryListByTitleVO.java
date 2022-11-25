package sqgxy.xxydz.vo.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xmp
 * @date 2022-11-21 14:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagingFuzzyQueryListByTitleVO {

    /**
     * 标题
     */
    private String title;

    /**
     * 当前页
     */
    private Integer current;

    /**
     * 大小
     */
    private Integer size;
}
