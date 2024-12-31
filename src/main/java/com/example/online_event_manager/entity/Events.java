package com.example.online_event_manager.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")

public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false,updatable = false)
    private int id;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Column(name = "location",nullable = false)
    private String location;

    @Column(name="event_date",nullable = false)
    private LocalDateTime eventDate;

    @Column(name="category",nullable = false,length = 100)
    private String category;

    public Events() {
    }

    public Events(String title, String description, String location, LocalDateTime eventDate, String category) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.eventDate = eventDate;
        this.category = category;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
