package com.vuphuong.truckapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "AuditLogs")
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "UserName",length = 100)
    private String userName;
    @Column(name = "Action")
    private String action;
    @Column(name = "Details")
    private String details;
    @Column(name = "IPAddress")
    private String ipAddress;
    @Column(name = "CreatAt")
    private LocalDateTime createAt =  LocalDateTime.now();

    public AuditLog() {
    }

    public AuditLog(Long id, String userName, String action, String details, String ipAddress, LocalDateTime createAt) {
        this.id = id;
        this.userName = userName;
        this.action = action;
        this.details = details;
        this.ipAddress = ipAddress;
        this.createAt = createAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "AuditLog{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", action='" + action + '\'' +
                ", details='" + details + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
