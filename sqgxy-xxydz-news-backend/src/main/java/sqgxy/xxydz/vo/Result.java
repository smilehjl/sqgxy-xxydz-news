package sqgxy.xxydz.vo;

import sqgxy.xxydz.enums.ResultCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xmp
 * @date 2022-11-19 12:21
 * 封装接口返回数据的统一结构
 */

@Data
public class Result implements Serializable {

    private Integer code;

    private boolean success;

    private String msg;

    private Object data;

    private String cookie;

    public Result() {
    }

    public Result ok() {
        return field(this, ResultCode.OK);
    }

    public Result fail() {
        return field(this, ResultCode.FAIL);
    }

    public Result fail(String msg) {
        Result fail = fail();
        fail.setMsg(msg);
        return fail;
    }

    public Result insufficientPermissions() {
        return field(this, ResultCode.PERMISSION);
    }

    public Result insufficientPermissions(String msg) {
        Result insufficientPermissions = insufficientPermissions();
        insufficientPermissions.setMsg(msg);
        return insufficientPermissions;
    }

    public Result notFound() {
        return field(this, ResultCode.NOTFOUND);
    }

    // 链式编程
    public Result data(Object data) {
        this.data = data;
        return this;
    }

    public Result cookie(String cookie) {
        this.cookie = cookie;
        return this;
    }

    private Result field(Result result, ResultCode code) {
        result.setCode(code.getCode());
        result.setSuccess(code.getSuccess());
        result.setMsg(code.getMsg());
        return result;
    }
}
