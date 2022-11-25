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
 * @date 2022-11-22 19:03
 * 新闻类型（一级标题）
 */

@TableName("xdstar")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class XdStar {

    /**
     * 主键，自增
     */
    @TableId(type = IdType.INPUT)
    private Integer id;
    /**
     * 学号
     */
    private Integer xueno;

    /**
     * 姓名
     */
    private String name;

    /**
     * 星星名字
     */
    private String starname;

    /**
     * 事例
     */
    private String example;

    private Date createTime;

    private Date updateTime;

}
