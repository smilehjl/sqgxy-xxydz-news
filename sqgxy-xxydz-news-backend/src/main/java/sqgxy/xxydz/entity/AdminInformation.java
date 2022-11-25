package sqgxy.xxydz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import sqgxy.xxydz.enums.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xmp
 * @date 2022-11-19 15:17
 * 管理员信息表
 */

@TableName("admin_information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInformation {

    /**
     * 主键自增
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色
     */
    private AdminRole role;

    private Date createTime;

    private Date updateTime;
}
