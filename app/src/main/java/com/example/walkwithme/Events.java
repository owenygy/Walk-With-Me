package com.example.walkwithme;

import java.util.Objects;

public class Events {
    public int eventID;
    public String eventName;
    public String eventDescription;
    public String eventStartDate;
    public String eventEndDate;
    public Float latitude;
    public Float longitude;
    public int maxParticipants;
    public int creationUserID;
    public Boolean eventActiveStatus;

    public Events (int eventID, String eventName, String eventDescription, String eventStartDate, String eventEndDate,
                   Float latitude, Float longitude, int maxParticipants, int creationUserID, Boolean eventActiveStatus) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.latitude = latitude;
        this.longitude = longitude;
        this.maxParticipants = maxParticipants;
        this.creationUserID = creationUserID;
        this.eventActiveStatus = eventActiveStatus;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public int getCreationUserID() {
        return creationUserID;
    }

    public void setCreationUserID(int creationUserID) {
        this.creationUserID = creationUserID;
    }

    public Boolean getEventActiveStatus() {
        return eventActiveStatus;
    }

    public void setEventActiveStatus(Boolean eventActiveStatus) {
        this.eventActiveStatus = eventActiveStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Events events = (Events) o;
        return eventID == events.eventID &&
                maxParticipants == events.maxParticipants &&
                creationUserID == events.creationUserID &&
                Objects.equals(eventName, events.eventName) &&
                Objects.equals(eventDescription, events.eventDescription) &&
                Objects.equals(eventStartDate, events.eventStartDate) &&
                Objects.equals(eventEndDate, events.eventEndDate) &&
                Objects.equals(latitude, events.latitude) &&
                Objects.equals(longitude, events.longitude) &&
                Objects.equals(eventActiveStatus, events.eventActiveStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventID, eventName, eventDescription, eventStartDate, eventEndDate, latitude, longitude, maxParticipants, creationUserID, eventActiveStatus);
    }
}
