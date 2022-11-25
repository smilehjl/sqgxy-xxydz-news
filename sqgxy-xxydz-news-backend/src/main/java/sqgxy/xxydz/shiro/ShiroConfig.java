package sqgxy.xxydz.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xmp
 * @date 2022-11-21 22:15
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 设置默认登录的 URL，身份认证失败会访问该 URL
        shiroFilterFactoryBean.setLoginUrl("/login");

        // 设置成功之后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/");

        // 设置未授权界面，权限认证失败会访问该 URL
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        // LinkedHashMap 是有序的，进行顺序拦截器配置
        Map<String, String> filterChainMap  = new LinkedHashMap<>();
        /*
               1). anon 可以被匿名访问
               2). authc 必须认证（登录）后才可以访问
               ......
        */
        filterChainMap.put("/**","anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(Realm singleRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(singleRealm);
        return securityManager;
    }
}
