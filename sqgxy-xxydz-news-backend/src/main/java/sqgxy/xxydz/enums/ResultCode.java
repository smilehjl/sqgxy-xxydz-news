package sqgxy.xxydz.enums;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xmp
 * @date 2022-11-19 17:28
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ResultCode {

    OK(200, true, "ok"),
    FAIL(500, false, "fail"),
    NOTFOUND(404, false, "not found"),
    PERMISSION(401, false, "insufficient permissions");

    private Integer code;

    private Boolean success;

    private String msg;
}
