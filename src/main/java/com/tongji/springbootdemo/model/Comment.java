package com.tongji.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Integer commentId;
    private Integer blogId;
    private String content;
    private Integer senderId;
    private Timestamp date;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Timestamp getDate() {
        return date;
    }

    public String getFormattedTime() {
        long interval = System.currentTimeMillis() - date.getTime();
        StringBuilder sb = new StringBuilder();
        if(interval < 1000 * 60){
            sb.append("just now");
        }
        else if (interval < 1000 * 3600) {
            sb.append(interval / 60).append(" minutes ago");
        }
        else if (interval < 1000 * 3600 * 24) {
            sb.append(interval / 3600).append(" hours ago");
        }
        else{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH mm");
            sb.append(dateFormat.format(date));
        }
        return sb.toString();
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
