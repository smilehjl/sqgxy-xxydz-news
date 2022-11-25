package sqgxy.xxydz.permission;

/**
 * @author xmp
 * @date 2022-01-24 0:38
 */

public class PermissionException extends RuntimeException {

    public PermissionException() {
        super("权限不足");
    }
}
