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
public class TagTextConnector implements Connector {

    @Override
    public IntegrationContext apply(IntegrationContext integrationContext) {
        String contentToTag = (String) integrationContext.getInBoundVariables().get("content");
        contentToTag += " :) ";
        integrationContext.addOutBoundVariable("content",
                contentToTag);
        log.info("Final Content: " + contentToTag);
        return integrationContext;
    }
    
}
