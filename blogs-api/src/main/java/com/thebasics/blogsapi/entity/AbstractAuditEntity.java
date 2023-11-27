package com.thebasics.blogsapi.entity;

import jakarta.persistence.MappedSuperclass;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
@Setter
@Getter
public class AbstractAuditEntity {

    @CreationTimestamp
    private Instant createdTime;
    @UpdateTimestamp
    private Instant updatedTime;

    private String createdBy;
    private String updatedBy;
}
