package sqgxy.xxydz.util;

import sqgxy.xxydz.dto.Principal;
import org.apache.shiro.SecurityUtils;

/**
 * @author xmp
 * @date 2022-11-21 0:42
 * Shiro
 */
public class ShiroUtils {

    public static Principal getPrincipal() {
        return (Principal) SecurityUtils.getSubject().getPrincipal();
    }
}
