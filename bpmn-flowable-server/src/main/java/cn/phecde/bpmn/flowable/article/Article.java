package cn.phecde.bpmn.flowable.article;

import lombok.Data;

/**
 * 文章流程对象
 *  
 * @author PinWei Wan
 */
@Data
public class Article {
    /** 任务ID */
    private String taskId;
    /** 作者 */
    private String author;
    /** 文章路径 */
    private String url;
    
    public Article() {
    }

    public Article(String taskId, String author, String url) {
        this.taskId = taskId;
        this.author = author;
        this.url = url;
    }

    
}
