package com.mikehenry.multipledatasources.common;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class AbstractAuditableEntity implements Serializable {

    @Column(name = "dateCreated", updatable = false)
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column(name = "dateModified")
    @LastModifiedBy
    private LocalDateTime dateModified;
}
