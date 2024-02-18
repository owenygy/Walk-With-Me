package com.example.walkwithme;

import java.util.Date;

/**
 * Event Class: storing event object
 */

public class Event {
    int eventID;
    int image;
    String title;
    String description;
    String startTime;
    String endTime;
    double latitude;
    double longitude;
    int maxParticipant;
    int creationUserID;
    boolean eventActiveStatus;

    public Event(int eventID, int image, String title, String description, String startTime, String endTime, double latitude, double longitude, int maxParticipant, int creationUserID, boolean eventActiveStatus) {
        this.eventID = eventID;
        this.image = image;
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.maxParticipant = maxParticipant;
        this.creationUserID = creationUserID;
        this.eventActiveStatus = eventActiveStatus;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getMaxParticipant() {
        return maxParticipant;
    }

    public void setMaxParticipant(int maxParticipant) {
        this.maxParticipant = maxParticipant;
    }

    public int getCreationUserID() {
        return creationUserID;
    }

    public void setCreationUserID(int creationUserID) {
        this.creationUserID = creationUserID;
    }

    public boolean isEventActiveStatus() {
        return eventActiveStatus;
    }

    public void setEventActiveStatus(boolean eventActiveStatus) {
        this.eventActiveStatus = eventActiveStatus;
    }
}