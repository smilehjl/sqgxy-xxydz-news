package sqgxy.xxydz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import sqgxy.xxydz.enums.DisplayContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xmp
 * @date 2022-11-19 15:21
 * 新闻类别（二级标题）
 */

@TableName("news_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsCategory {

    /**
     * 主键自增
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 新闻类别名
     */
    private String name;

    /**
     * 所属的新闻类型id
     */
    private Integer newsTypeId;

    /**
     * 展示的类型
     */
    private DisplayContent displayContent;

    private Date createTime;

    private Date updateTime;
}
