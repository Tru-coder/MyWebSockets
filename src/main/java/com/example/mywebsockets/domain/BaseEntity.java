package com.example.mywebsockets.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(nullable = false, updatable = false, name = "id")
    private Long id;

    @Column(nullable = false, updatable = false, name = "uuid")
    private UUID uuid;

    @Column(name = "created_at", updatable = false, nullable = false)
    Instant createdAt;

    @Column(name = "updated_at")
    Instant updatedAt;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @Column(name = "is_updated", nullable = false)
    private Boolean isUpdated;

    @PrePersist
    private void initialize(){
        isDeleted = false;
        isUpdated = false;
        uuid = UUID.randomUUID();
        createdAt = Instant.now();
    }

    @PreUpdate
    private void onUpdate(){
        isUpdated = true;
        updatedAt = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;
        BaseEntity that = (BaseEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BaseEntity {" +
                "id = " + id +
                "}";
    }
}