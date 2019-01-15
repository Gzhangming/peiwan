package com.peiwan.Config.Shiro;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro的配置类
 * User: 张家明
 *
 * @author LiXuekai on 2019/1/13/12:24
 */
@Configuration
public class shiroConfig {
    /**
     * 创建ShiroFilterFactoryBeean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //1.设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以是实现权限相关的拦截器
         *    常用的过滤器：
         *    anon: 无需认证（登录） 可以访问
         *    authc:必须认证才可以访问
         *    user:如果使用rememberMe的功能可以直接访问
         *    perms:该资源必须得到资源权限才可以访问
         *    role:该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<String,String>();

         /* 需要放行的页面*/
        //测试的
        filterMap.put("/testThymeleaf","anon");
        filterMap.put("/tocheshi","anon");
        filterMap.put("/logins","anon");
        //主页面
        filterMap.put("/","anon");
        filterMap.put("/MyIndex","anon");
        filterMap.put("/toIndex","anon");
        //注册页面
        filterMap.put("/toRegister","anon");
        //登陆逻辑
        filterMap.put("/sqlLogin","anon");
        //2
        filterMap.put("/sqlLoginShiro","anon");
        //放行退出业务
        filterMap.put("/tologint","anon");
        //放行用户名的验证业务
        filterMap.put("/Yname","anon");
        //密码的验证业务
        filterMap.put("/Ypwd","anon");


//授权过滤器
        filterMap.put("/add","perms[user:add]");


       /* filterMap.put("/add","authc");
        filterMap.put("/update","authc");*/
       //可以简介化直接要根下的都要进行登录
        filterMap.put("/*","authc");

//        authc:必须认证（登录）才可以访问  这里拦截成功  但是
//        如果不设置默认会自动寻找Web工程根目录下的"/loginJC.jsp"页面
//        下面进行设设置
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
//      设置一个 未授权的提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/toAccredit");



        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);


        return shiroFilterFactoryBean;
    }


    /**
     * 创建DefaultWebSecusrityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        //注入记住我管理器;
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }




    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }


    /**
     * cookie对象;
     * @return
     */
    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(2592000);
        return simpleCookie;
    }
    /**
     * cookie管理对象;记住我功能
     * @return
     */
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }


}
