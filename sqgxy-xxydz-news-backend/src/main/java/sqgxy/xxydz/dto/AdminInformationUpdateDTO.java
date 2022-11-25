package sqgxy.xxydz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xmp
 * @date 2022-11-18 16:22
 *
 * 管理员修改密码
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInformationUpdateDTO {

    private String username;

    /**
     * 密码
     */
    private String password;
}
