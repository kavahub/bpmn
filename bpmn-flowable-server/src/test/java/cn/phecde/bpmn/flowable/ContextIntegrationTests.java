package cn.phecde.bpmn.flowable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 测试
 *  
 * @author PinWei Wan
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { BPMNFlowableApplication.class })
@TestProfiles
public class ContextIntegrationTests {
    @Test
    public void whenLoadApplication_thenSuccess() {
    }
}
