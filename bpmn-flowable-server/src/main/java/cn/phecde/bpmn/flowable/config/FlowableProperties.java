package cn.phecde.bpmn.flowable.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * 属性配置
 *  
 * @author PinWei Wan
 */
@Data
@ConfigurationProperties("phecde.bpmn.flowable")
public class FlowableProperties {
}
