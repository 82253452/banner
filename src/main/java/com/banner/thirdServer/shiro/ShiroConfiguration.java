/*
package com.banner.thirdServer.security;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

*/
/**
 * Shiro 配置
 *
 * @author 单红宇(365384722)
 * @myblog http://blog.csdn.net/catoop/
 * @create 2016年1月13日
 *//*

@Configuration
public class ShiroConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);

    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return em;
    }

    */
/**
     * 注册DelegatingFilterProxy（Shiro）
     *
     * @param dispatcherServlet
     * @return * @author SHANHY
     * @create 2016年1月13日
     *//*

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter")); //  该值缺省为false,表示生命周期由SpringApplicationContext管理,设置为true则表示由ServletContainer管理
        filterRegistration.addInitParameter("targetFilterLifecycle", "true");
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("*/
/*");
        return filterRegistration;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(MyShiroRealm myShiroRealm) {
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        dwsm.setRealm(myShiroRealm); //      <!-- 用户授权/认证信息Cache, 采用EhCache 缓存 -->  dwsm.setCacheManager(getEhCacheManager()); return dwsm;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(MyShiroRealm myShiroRealm) {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(getDefaultWebSecurityManager(myShiroRealm));
        return new AuthorizationAttributeSourceAdvisor();
    }

    */
/**
     * 加载shiroFilter权限控制规则（从数据库读取然后配置）
     *
     * @author SHANHY
     * @create 2016年1月14日
     *//*

    private void loadShiroFilterChain(ShiroFilterFactoryBean shiroFilterFactoryBean, StudentService stuService, IScoreDao scoreDao) { /////////////////////// 下面这些规则配置最好配置到配置文件中 ///////////////////////
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>(); // authc：该过滤器下的页面必须验证后才能访问，它是Shiro内置的一个拦截器org.apache.shiro.web.filter.authc.FormAuthenticationFilter filterChainDefinitionMap.put("/user", "authc");// 这里为了测试，只限制/user，实际开发中请修改为具体拦截的请求规则 // anon：它对应的过滤器里面是空的,什么都没做 logger.info("##################从数据库读取权限规则，加载到shiroFilter中##################");
        filterChainDefinitionMap.put("/user/edit*/
/**", "authc,perms[user:edit]");// 这里为了测试，固定写死的值，也可以从数据库或其他配置中读取 filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("*/
/**", "anon");//anon 可以理解为不拦截 shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    }

    */
/**
     * ShiroFilter<br/>
     * 注意这里参数中的 StudentService 和 IScoreDao 只是一个例子，因为我们在这里可以用这样的方式获取到相关访问数据库的对象，
     * 然后读取数据库相关配置，配置到 shiroFilterFactoryBean 的访问规则中。实际项目中，请使用自己的Service来处理业务逻辑。
     *
     * @param myShiroRealm
     * @param stuService
     * @param scoreDao
     * @return * @author SHANHY
     * @create 2016年1月14日
     *//*

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(MyShiroRealm myShiroRealm, StudentService stuService, IScoreDao scoreDao) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager(myShiroRealm));// 必须设置SecurityManager
        shiroFilterFactoryBean.setLoginUrl("/login");// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setSuccessUrl("/user"); // 登录成功后要跳转的连接
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        loadShiroFilterChain(shiroFilterFactoryBean, stuService, scoreDao);
        return shiroFilterFactoryBean;
    }

}*/
