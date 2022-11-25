package sqgxy.xxydz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xmp
 * @date 2022-11-19 15:24
 * 新闻类型（一级标题）
 */

@TableName("news_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsType {

    /**
     * 主键，自增
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 新闻类型名
     */
    private String name;

    private Date createTime;

    private Date updateTime;
}
