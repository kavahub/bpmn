package cn.phecde.bpmn.flowable.article;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * 流程中的服务：发布文章
 *  
 * @author PinWei Wan
 */
public class PublishArticleService implements JavaDelegate {
    public void execute(DelegateExecution execution) {
        System.out.println("Publishing the approved article.");
    }
    
}
