package sqgxy.xxydz.vo.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xmp
 * @date 2022-11-19 14:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagingQueryListByNewsCategoryIdVO {

    private Integer newsCategoryId;

    /**
     * 当前页
     */
    private Integer current;

    /**
     * 大小
     */
    private Integer size;
}
