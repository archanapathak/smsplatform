package com.smsApp.smsplatform.model;

public class CustomerMsgDetails {
    String ack_id;
    int account_id;
    Long mobile;
    String message;

    public CustomerMsgDetails() {
    }

    public CustomerMsgDetails(String ack_id, int account_id, Long mobile, String message) {
        this.ack_id = ack_id;
        this.account_id = account_id;
        this.mobile = mobile;
        this.message = message;
    }

    public String getAck_id() {
        return ack_id;
    }

    public void setAck_id(String ack_id) {
        this.ack_id = ack_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CustomerMsgDetails{" +
                "ack_id='" + ack_id + '\'' +
                ", account_id=" + account_id +
                ", mobile=" + mobile +
                ", message='" + message + '\'' +
                '}';
    }
}
