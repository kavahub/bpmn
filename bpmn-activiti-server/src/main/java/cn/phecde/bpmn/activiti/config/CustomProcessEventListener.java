package cn.phecde.bpmn.activiti.config;

import org.activiti.api.model.shared.event.RuntimeEvent;
import org.activiti.api.model.shared.event.VariableCreatedEvent;
import org.activiti.api.process.model.events.SequenceFlowEvent;
import org.activiti.api.process.runtime.events.ProcessCancelledEvent;
import org.activiti.api.process.runtime.events.ProcessCompletedEvent;
import org.activiti.api.process.runtime.events.ProcessCreatedEvent;
import org.activiti.api.process.runtime.events.ProcessResumedEvent;
import org.activiti.api.process.runtime.events.ProcessStartedEvent;
import org.activiti.api.process.runtime.events.ProcessSuspendedEvent;
import org.activiti.api.process.runtime.events.listener.ProcessRuntimeEventListener;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义流程事件监听
 * 
 * @author PinWei Wan
 */
@Slf4j
@SuppressWarnings({"rawtypes"})
public class CustomProcessEventListener implements ProcessRuntimeEventListener {
    public CustomProcessEventListener() {
    }

    @Override
    public void onEvent(RuntimeEvent event) {

        if (event instanceof ProcessStartedEvent)
            log.info(">>> Process STARTED event [{}]", event.toString());
        else if (event instanceof ProcessCompletedEvent)
            log.info(">>> Process COMPLETED event [{}]", event.toString());
        else if (event instanceof ProcessCancelledEvent)
            log.info(">>> Process CANCELLED event [{}]", event.toString());
        else if (event instanceof ProcessSuspendedEvent)
            log.info(">>> Process SUSPENDED event [{}]", event.toString());
        else if (event instanceof ProcessResumedEvent)
            log.info(">>> Process RESUMED event [{}]", event.toString());
        else if (event instanceof ProcessCreatedEvent)
            log.info(">>> Process CREATED event [{}]", event.toString());
        else if (event instanceof SequenceFlowEvent)
            log.info(">>> Process SEQUENCE FLOW event [{}]", event.toString());
        else if (event instanceof VariableCreatedEvent)
            log.info(">>> Process VARIABLE CREATED event [{}]", event.toString());
        else
            log.info(">>> Process UNKNOW event [{}]", event.toString());

    }

}
