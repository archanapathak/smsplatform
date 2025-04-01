package com.smsApp.smsplatform.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;

@Entity
@Table(name = "send_msg")
@Valid
public class SendMsg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "mobile",nullable = false)
    @NotNull(message = "mobile number cannot be blank and be 10 digit long")
    @Min(10)
    private Long mobile;

    @Column(name="message",nullable = false)
    @NotBlank(message = "message  cannot be blank")
    @Size(max = 160,message = "message length should not exceed 16o character")
    private String message;
    @Column(name="status",nullable = false)
    private String status;
    @Column(name="received_ts",nullable = false)
    private Timestamp received_ts;
    @Column(name="sent_ts")
    private Timestamp sent_ts;
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "account_id")
    @Column(name="account_id")
    private int account_id;
    @Column(name="telco_response")
    private String telco_response;

    public SendMsg() {
    }

    public SendMsg(Long id, Long mobile, String message, String status, Timestamp received_ts, Timestamp sent_ts, int account_id, String telco_response) {
        this.id = id;
        this.mobile = mobile;
        this.message = message;
        this.status = status;
        this.received_ts = received_ts;
        this.sent_ts = sent_ts;
        this.account_id = account_id;
        this.telco_response = telco_response;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getReceived_ts() {
        return received_ts;
    }

    public void setReceived_ts(Timestamp received_ts) {
        this.received_ts = received_ts;
    }

    public Timestamp getSent_ts() {
        return sent_ts;
    }

    public void setSent_ts(Timestamp sent_ts) {
        this.sent_ts = sent_ts;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getTelco_response() {
        return telco_response;
    }

    public void setTelco_response(String telco_response) {
        this.telco_response = telco_response;
    }

    @Override
    public String toString() {
        return "SendMsg{" +
                "id=" + id +
                ", mobile=" + mobile +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", received_ts=" + received_ts +
                ", sent_ts=" + sent_ts +
                ", account_id=" + account_id +
                ", telco_response='" + telco_response + '\'' +
                '}';
    }
}
