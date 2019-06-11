package com.fullstack.restfulwebservices.domain;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private Boolean completed;

    private Calendar date;

    private Long uid;

    public Todo() {
    }

    public Todo(String description, Boolean completed, Calendar date, Long uid) {
        this.description = description;
        this.completed = completed;
        this.date = date;
        this.uid = uid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Todo{" +
            "id=" + id +
            ", description='" + description + '\'' +
            ", completed=" + completed +
            ", date=" + date +
            '}';
    }
}
