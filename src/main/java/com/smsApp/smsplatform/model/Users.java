package com.smsApp.smsplatform.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int account_id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

//    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private SendMsg sendmsg;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id" ,referencedColumnName = "account_id")
    private SendMsg sendmsg;

    public Users() {
    }

    public Users(int account_id, String username, String password, SendMsg sendmsg) {
        this.account_id = account_id;
        this.username = username;
        this.password = password;
        this.sendmsg = sendmsg;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SendMsg getSendmsg() {
        return sendmsg;
    }

    public void setSendmsg(SendMsg sendmsg) {
        this.sendmsg = sendmsg;
    }

    @Override
    public String toString() {
        return "Users{" +
                "account_id=" + account_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sendmsg=" + sendmsg +
                '}';
    }
}
