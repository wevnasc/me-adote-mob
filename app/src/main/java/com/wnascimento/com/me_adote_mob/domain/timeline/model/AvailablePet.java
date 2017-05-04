package com.wnascimento.com.me_adote_mob.domain.timeline.model;

public class AvailablePet {

    private final String id;
    private final String name;
    private final String image;
    private final String notes;
    private final Long createdAt;

    public AvailablePet(String id, String name, String image, String notes, Long createdAt) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.notes = notes;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getNotes() {
        return notes;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AvailablePet that = (AvailablePet) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }
}
