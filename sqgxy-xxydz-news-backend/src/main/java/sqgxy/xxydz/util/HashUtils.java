package sqgxy.xxydz.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author xmp
 * @date 2022-11-22 19:08
 * 工具类
 */
public class HashUtils {

    /**
     * 对密码进行MD5加密
     */
    public static String MD5(String username, String password) {
        SimpleHash simpleHash = new SimpleHash("MD5", password, ByteSource.Util.bytes(username), 1024);
        return simpleHash.toString();
    }
}
