package cn.phecde.bpmn.flowable.config;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * 自动配置
 *  
 * @author PinWei Wan
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({FlowableProperties.class})
public class FlowableAutoConfig {
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
