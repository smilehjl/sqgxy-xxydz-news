package sqgxy.xxydz.shiro;

import sqgxy.xxydz.dto.AdminInformationDTO;
import sqgxy.xxydz.dto.Principal;
import sqgxy.xxydz.service.AdminInformationService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author xmp
 * @date 2022-11-21 16:43
 */
@Component
public class MyRealm extends AuthorizingRealm {

    private final AdminInformationService adminInformationService;

    private final ModelMapper modelMapper;

    public MyRealm(AdminInformationService adminInformationService, ModelMapper modelMapper) {
        this.adminInformationService = adminInformationService;
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //使用MD5加密算法
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        //加密的次数
        hashedCredentialsMatcher.setHashIterations(1024);
        this.setCredentialsMatcher(hashedCredentialsMatcher);
        this.modelMapper = modelMapper;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //将AuthenticationToken强转为UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //获取客户端传来的username
        String username = usernamePasswordToken.getUsername();

        //通过username查找数据库里
        AdminInformationDTO adminInformation = adminInformationService.getAdminInformationByUsername(username);

        //如果User为null则用户不存在
        if(adminInformation == null){
            throw new UnknownAccountException();
        }

        Principal principal = modelMapper.map(adminInformation, Principal.class);

        /*
            登录输入用户名和密码，输入的密码会在shiro比较的时候通过MD5加密，
            然后再和SimpleAuthenticationInfo里传的数据库里的真实密码进行比较（且数据库里的真实密码是已经加密过的字符串）
         */
        //盐值：
        ByteSource byteSource = ByteSource.Util.bytes(username);
        //SimpleAuthenticationInfo(Object principal, Object hashedCredentials, ByteSource credentialsSalt, String realmName)
        return new SimpleAuthenticationInfo(principal, adminInformation.getPassword(), byteSource, getName());
    }
}
