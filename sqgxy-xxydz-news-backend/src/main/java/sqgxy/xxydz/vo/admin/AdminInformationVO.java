package sqgxy.xxydz.vo.admin;

import sqgxy.xxydz.enums.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xmp
 * @date 2022-11-23 16:22
 *
 * 管理员信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInformationVO {

    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 角色
     */
    private AdminRole role;
}
