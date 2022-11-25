package sqgxy.xxydz.config;

import sqgxy.xxydz.exception.HintException;
import sqgxy.xxydz.permission.PermissionException;
import sqgxy.xxydz.vo.Result;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author xmp
 * @date 2022-11-19 15:07
 * 异常处理
 */
@RestControllerAdvice
public class ZeusExceptionHandler {

    @ExceptionHandler(value = HintException.class)
    public Result hintExceptionHandler(HintException e) {
        return new Result().fail(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result exception(Exception e) {
        return new Result().fail(e.getMessage());
    }

    @ExceptionHandler(value = {UnknownAccountException.class, IncorrectCredentialsException.class})
    public Result UnknownAccountException(Exception e) {
        return new Result().fail("用户名或密码错误");
    }

    @ExceptionHandler(value = PermissionException.class)
    public Result PermissionException(Exception e) {
        return new Result().insufficientPermissions(e.getMessage());
    }

}
