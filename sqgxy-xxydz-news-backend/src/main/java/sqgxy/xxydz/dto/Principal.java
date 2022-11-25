package sqgxy.xxydz.dto;

import sqgxy.xxydz.enums.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xmp
 * @date 2022-11-24 0:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Principal {

    /**
     * 用户名
     */
    private String username;

    /**
     * 角色
     */
    private AdminRole role;
}
