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
 * @date 2022-11-23 23:03
 * 领导联系方式
 */

@TableName("information")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Information {

    /**
     * 主键，自增
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 职责
     */
    private String duty;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    private Date createTime;

    private Date updateTime;

}
