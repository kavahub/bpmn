package cn.phecde.bpmn.activiti.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * 属性配置
 *  
 * @author PinWei Wan
 */
@Data
@ConfigurationProperties("phecde.bpmn.activiti")
public class ActivitiProperties {
    private Log log = new Log();

    @Data
    public static class Log {
        private boolean taskEventEnabled = false;
        private boolean processEventEnabled = false;
    }  
}
