package cn.phecde.bpmn.activiti.config;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.extern.slf4j.Slf4j;

/**
 * 自动配置
 *  
 * @author PinWei Wan
 */
@Slf4j
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

    @Bean
    public CommandLineRunner queryInfomation(final RepositoryService repositoryService,
                                  final TaskService taskService) {

        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                log.info(">>> Number of process definitions [{}]", repositoryService.createProcessDefinitionQuery().count());
                log.info(">>> Number of tasks [{}]", taskService.createTaskQuery().count());
            }
        };
    }
}
