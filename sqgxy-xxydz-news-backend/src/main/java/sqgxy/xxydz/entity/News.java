package sqgxy.xxydz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xmp
 * @date 2022-11-19 15:19
 * 新闻主体
 */

@TableName("news")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {

    /**
     * 主键自增
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 展示图片路径
     */
    private String picturePath;

    /**
     * 标题
     */
    private String title;

    /**
     * 发布时间
     */
    private Date releaseTime;

    /**
     * 点击率
     */
    private Integer hits;

    /**
     * 内容
     */
    private String content;

    /**
     * 文章所属类别id
     */
    private Integer newsCategoryId;

    private Date createTime;

    private Date updateTime;
}
