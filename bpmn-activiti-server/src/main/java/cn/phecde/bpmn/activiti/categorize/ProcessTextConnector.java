package cn.phecde.bpmn.activiti.categorize;

import java.util.Map;

import org.activiti.api.process.model.IntegrationContext;
import org.activiti.api.process.runtime.connector.Connector;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 流程节点处理
 *  
 * @author PinWei Wan
 */
@Component
@Slf4j
public class ProcessTextConnector implements Connector {

    @Override
    public IntegrationContext apply(IntegrationContext integrationContext) {
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
    }
    
}
