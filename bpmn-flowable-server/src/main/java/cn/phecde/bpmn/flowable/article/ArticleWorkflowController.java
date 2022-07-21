package cn.phecde.bpmn.flowable.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 流程接口
 * 
 * @author PinWei Wan
 */
@RestController
public class ArticleWorkflowController {
    @Autowired
    private ArticleWorkflowService service;

    /**
     * 提交流程
     * 
     * @param article
     */
    @PostMapping("/submit")
    public void submit(@RequestBody Article article) {
        service.startProcess(article);
    }

    /**
     * 我的任务
     * 
     * @param assignee
     * @return
     */
    @GetMapping("/tasks")
    public List<Article> getTasks(@RequestParam String assignee) {
        return service.getTasks(assignee);
    }

    /**
     * 检查文章
     * @param approval
     */
    @PostMapping("/review")
    public void review(@RequestBody Approval approval) {
        service.submitReview(approval);
    }
}
