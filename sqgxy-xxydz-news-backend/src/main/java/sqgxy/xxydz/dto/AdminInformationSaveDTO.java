package sqgxy.xxydz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xmp
 * @date 2022-11-18 18:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInformationSaveDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
