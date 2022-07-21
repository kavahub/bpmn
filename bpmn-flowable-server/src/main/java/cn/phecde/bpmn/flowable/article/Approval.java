package cn.phecde.bpmn.flowable.article;

import lombok.Data;

/**
 * 网关对象
 * 
 * @author PinWei Wan
 */
@Data
public class Approval {
    /** 任务ID */
    private String taskId;
    /** 是否同意 */
    private boolean status;
}
