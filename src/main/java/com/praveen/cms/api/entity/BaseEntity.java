package com.praveen.cms.api.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Column(name = "id", nullable = false, updatable = false,insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "created", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "updated", nullable = true, updatable = true)
    private Date updated ;

    @Column(name = "created_by", updatable = false)
    @CreatedBy
    private String createdBy = "system";

    @Column(name = "updated_by")
    @LastModifiedBy
    private String updatedBy = "system";

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
