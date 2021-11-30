package com.example.Entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Base {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    public Base(Long id) {
        this.id = id;
    }

    public Base() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
