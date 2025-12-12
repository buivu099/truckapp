package com.vuphuong.truckapp.service;

import com.vuphuong.truckapp.entity.AuditLog;
import com.vuphuong.truckapp.repository.AuditLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogService {
    private final AuditLogRepository auditLogRepository;

    public AuditLogService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public void logAction(String userName, String action, String details, String ipAddress) {
        AuditLog auditLog = new AuditLog();
        auditLog.setUserName(userName);
        auditLog.setAction(action);
        auditLog.setDetails(details);
        auditLog.setIpAddress(ipAddress);
        auditLogRepository.save(auditLog);
    }

    public List<AuditLog> findAllLog() {
        return  auditLogRepository.findAll();
    }
}
