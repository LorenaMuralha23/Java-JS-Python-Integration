package com.mycompany.testing;

public class BackMessage {
    private String from;
    private String status;

    public BackMessage() {
    }

    public BackMessage(String from, String status) {
        this.from = from;
        this.status = status;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
