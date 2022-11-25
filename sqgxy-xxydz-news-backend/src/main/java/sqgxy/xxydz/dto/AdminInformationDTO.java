package sqgxy.xxydz.dto;

import sqgxy.xxydz.enums.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xmp
 * @date 2022-11-18 16:22
 * 管理员信息表
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInformationDTO {

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
}
