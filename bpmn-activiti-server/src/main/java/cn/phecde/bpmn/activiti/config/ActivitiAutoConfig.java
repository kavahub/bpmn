package cn.phecde.bpmn.activiti.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.phecde.bpmn.activiti.service.CustomProcessEventListener;
import cn.phecde.bpmn.activiti.service.CustomTaskEventListener;

/**
 * 自动配置
 *  
 * @author PinWei Wan
 */
@Configuration
@EnableConfigurationProperties({ActivitiProperties.class})
public class ActivitiAutoConfig {
    
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return null;
            }
        };
    }

    @Bean
    @ConditionalOnProperty(prefix = "phecde.bpmn.activiti.log", name = "processEventEnabled", havingValue = "true")
    public CustomProcessEventListener customProcessEventListener() {
        return new CustomProcessEventListener();
    }

    @Bean
    @ConditionalOnProperty(prefix = "phecde.bpmn.activiti.log", name = "taskEventEnabled", havingValue = "true")
    public CustomTaskEventListener customTaskEventListener() {
        return new CustomTaskEventListener();
    }
}
