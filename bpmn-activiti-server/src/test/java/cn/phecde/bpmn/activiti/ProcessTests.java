package cn.phecde.bpmn.activiti;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试
 * 
 * @author PinWei Wan
 */
@SpringBootTest(classes = { BPMNActivitiApplication.class })
@TestProfiles
@Slf4j
public class ProcessTests {
    private static final String PROCESS_DEFINITION_KEY = "categorizeProcess";

    @Autowired
    private ProcessRuntime processRuntime;

    @Autowired
    private SecurityUtil securityUtil;

    @Test
    public void runCategorizeContentProcess() {
        securityUtil.logInAs("system");

        String content = pickRandomString();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

        log.info("> Processing content: " + content + " at " + formatter.format(new Date()));

        ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder
                .start()
                .withProcessDefinitionKey(PROCESS_DEFINITION_KEY)
                .withName("Processing Content: " + content)
                .withVariable("content", content)
                .build());
        log.info("> Created Process Instance: " + processInstance);

    }

    private String pickRandomString() {
        String[] texts = { "hello from london", "Hi there from activiti!", "all good news over here.",
                "I've tweeted about activiti today.",
                "other boring projects.", "activiti cloud - Cloud Native Java BPM" };
        return texts[new Random().nextInt(texts.length)];
    }
}
