package cn.phecde.bpmn.activiti;

import static org.assertj.core.api.Assertions.assertThat;

import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 测试
 *  
 * @author PinWei Wan
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { BPMNActivitiApplication.class })
@TestProfiles
public class ProcessDefinitionTests {
    private static final String PROCESS_DEFINITION_KEY = "categorizeProcess";

    @Autowired
    private ProcessRuntime processRuntime;

    @Autowired
    private SecurityUtil securityUtil; 

    @Test
    public void givenKey_thenGetProcessDefinition_thenOk() {
        securityUtil.logInAs("system");

        ProcessDefinition processDefinition = processRuntime.processDefinition(PROCESS_DEFINITION_KEY);
        assertThat(processDefinition).isNotNull();
        assertThat(processDefinition.getKey()).isEqualTo(PROCESS_DEFINITION_KEY);
        assertThat(processDefinition.getAppVersion()).isNull();
    }
    
}
