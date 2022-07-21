package cn.phecde.bpmn.activiti.config;

import org.activiti.api.model.shared.event.RuntimeEvent;
import org.activiti.api.task.runtime.events.TaskActivatedEvent;
import org.activiti.api.task.runtime.events.TaskAssignedEvent;
import org.activiti.api.task.runtime.events.TaskCancelledEvent;
import org.activiti.api.task.runtime.events.TaskCompletedEvent;
import org.activiti.api.task.runtime.events.TaskCreatedEvent;
import org.activiti.api.task.runtime.events.TaskSuspendedEvent;
import org.activiti.api.task.runtime.events.listener.TaskEventListener;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义任务事件监听
 * 
 * @author PinWei Wan
 */
@Slf4j
@SuppressWarnings({ "rawtypes" })
public class CustomTaskEventListener implements TaskEventListener {
    @Override
    public void onEvent(RuntimeEvent event) {

        if (event instanceof TaskActivatedEvent)
            log.info(">>> Task ACTIVATED event [{}]", event.toString());
        else if (event instanceof TaskAssignedEvent) {
            log.info(">>> Task ASSIGNED event [{}]", event.toString());
        } else if (event instanceof TaskCancelledEvent)
            log.info(">>> Task CANCELLED event [{}]", event.toString());
        else if (event instanceof TaskCompletedEvent)
            log.info(">>> Task COMPLETED event [{}]", event.toString());
        else if (event instanceof TaskCreatedEvent)
            log.info(">>> Task CREATED event [{}]", event.toString());
        else if (event instanceof TaskSuspendedEvent)
            log.info(">>> Task SUSPENDED event [{}]", event.toString());
        else
            log.info(">>> Task UNKNOW event [{}]", event.toString());

    }
}
