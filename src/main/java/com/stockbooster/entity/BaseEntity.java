package com.stockbooster.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "created_at",updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by", nullable = false)
    private String updatedBy;

    @Column(name = "is_deleted")
    private Boolean isDeleted=false;

    private String getLoginUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (authentication == null) ? "anonymousUser" : authentication.getName();
    }


    @PrePersist
    protected void onPrePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
        this.createdBy = getLoginUser();
        this.updatedBy = getLoginUser();
    }

    @PreUpdate
    protected void onPreUpdate() {
        this.updatedAt = LocalDateTime.now();
        this.updatedBy = getLoginUser();
    }
}
