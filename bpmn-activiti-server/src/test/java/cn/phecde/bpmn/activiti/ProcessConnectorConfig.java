package cn.phecde.bpmn.activiti;

import java.util.Map;

import org.activiti.api.process.runtime.connector.Connector;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试
 *  
 * @author PinWei Wan
 */
@TestConfiguration
@Slf4j
public class ProcessConnectorConfig {
    @Bean
        public Connector processTextConnector() {
            return integrationContext -> {
                Map<String, Object> inBoundVariables = integrationContext.getInBoundVariables();
                String contentToProcess = (String) inBoundVariables.get("content");
                // Logic Here to decide if content is approved or not
                if (contentToProcess.contains("activiti")) {
                    log.info("> Approving content: " + contentToProcess);
                    integrationContext.addOutBoundVariable("approved",
                            true);
                } else {
                    log.info("> Discarding content: " + contentToProcess);
                    integrationContext.addOutBoundVariable("approved",
                            false);
                }
                return integrationContext;
            };
        }

        @Bean
        public Connector tagTextConnector() {
            return integrationContext -> {
                String contentToTag = (String) integrationContext.getInBoundVariables().get("content");
                contentToTag += " :) ";
                integrationContext.addOutBoundVariable("content",
                        contentToTag);
                log.info("Final Content: " + contentToTag);
                return integrationContext;
            };
        }

        @Bean
        public Connector discardTextConnector() {
            return integrationContext -> {
                String contentToDiscard = (String) integrationContext.getInBoundVariables().get("content");
                contentToDiscard += " :( ";
                integrationContext.addOutBoundVariable("content",
                        contentToDiscard);
                log.info("Final Content: " + contentToDiscard);
                return integrationContext;
            };
        }
}
