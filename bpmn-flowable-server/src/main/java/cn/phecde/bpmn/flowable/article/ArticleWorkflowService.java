package cn.phecde.bpmn.flowable.article;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 流程服务
 * 
 * @author PinWei Wan
 */
@Service
public class ArticleWorkflowService {
    private final static String PROCESS_DEFINITION_KEY = "articleReview";

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    /**
     * 启动流程
     * 
     * @param article
     */
    @Transactional
    public void startProcess(Article article) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("author", article.getAuthor());
        variables.put("url", article.getUrl());
        runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY, variables);
    }

    /**
     * 我的任务
     * 
     * @param assignee
     * @return
     */
    @Transactional
    public List<Article> getTasks(String assignee) {
        List<Task> tasks = taskService.createTaskQuery()
                .processDefinitionKey(PROCESS_DEFINITION_KEY)
                .taskCandidateGroup(assignee)
                .list();

        List<Article> articles = tasks.stream()
                .map(task -> {
                    Map<String, Object> variables = taskService.getVariables(task.getId());
                    return new Article(
                            task.getId(), (String) variables.get("author"), (String) variables.get("url"));
                })
                .collect(Collectors.toList());
        return articles;
    }

    /**
     * 提交检查
     * @param approval
     */
    @Transactional
    public void submitReview(Approval approval) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("approved", approval.isStatus());
        taskService.complete(approval.getTaskId(), variables);
    }
}
