package cn.phecde.bpmn.flowable.article;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * 流程中的服务：发送邮件
 *  
 * @author PinWei Wan
 */
public class SendMailService implements JavaDelegate {
    public void execute(DelegateExecution execution) {
        System.out.println("Sending rejection mail to author.");
    }   
}
