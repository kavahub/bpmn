package cn.phecde.bpmn.activiti.categorize;

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
public class DiscardTextConnector implements Connector {

    @Override
    public IntegrationContext apply(IntegrationContext integrationContext) {
        String contentToDiscard = (String) integrationContext.getInBoundVariables().get("content");
        contentToDiscard += " :( ";
        integrationContext.addOutBoundVariable("content",
                contentToDiscard);
        log.info("Final Content: " + contentToDiscard);
        return integrationContext;
    }
    
}
