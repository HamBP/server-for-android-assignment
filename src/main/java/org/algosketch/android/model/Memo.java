package org.algosketch.android.model;

public class Memo {
    static public String BEFORE = "BEFORE";
    static public String PROGRESS = "PROGRESS";
    static public String DONE = "DONE";

    String content;
    String status;
    Long id;

    public Memo(String content, String status) {
        this.content = content;
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
