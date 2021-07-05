package model;

import java.sql.Date;

public class CommentModel {
    private int id;
    private int wsrefId;
    private String sessionId;
    private Date stamp;
    private String comtext;

    public CommentModel(int id, int wsrefId, String sessionId, Date stamp, String comtext) {
        this.id = id;
        this.wsrefId = wsrefId;
        this.sessionId = sessionId;
        this.stamp = stamp;
        this.comtext = comtext;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWsrefId() {
        return wsrefId;
    }

    public void setWsrefId(int wsrefId) {
        this.wsrefId = wsrefId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getStamp() {
        return stamp;
    }

    public void setStamp(Date stamp) {
        this.stamp = stamp;
    }

    public String getComtext() {
        return comtext;
    }

    public void setComtext(String comtext) {
        this.comtext = comtext;
    }
}
