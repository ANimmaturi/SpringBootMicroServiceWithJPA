package com.example.ec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Tour implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String title;

    @Column(length = 200)
    private String description;

    @Column(length = 2000)
    private String blurd;

    @Column
    private Integer price;

    @Column
    private String duration;

    @Column(length = 2000)
    private String bullets;

    @Column
    private String keywords;

    @ManyToOne
    private TourPackage tourPackage;

    @Column
    private Region region;

    @Column
    private Difficulty difficulty;

    public Tour(String title, String description, String blurd, Integer price, String duration,
            String bullets, String keywords, TourPackage tourPackage, Region region,
            Difficulty difficulty) {
        this.title = title;
        this.description = description;
        this.blurd = blurd;
        this.price = price;
        this.duration = duration;
        this.bullets = bullets;
        this.keywords = keywords;
        this.tourPackage = tourPackage;
        this.region = region;
        this.difficulty = difficulty;
    }

    protected  Tour() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getBlurd() {
        return blurd;
    }

    public void setBlurd(String blurd) {
        this.blurd = blurd;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBullets() {
        return bullets;
    }

    public void setBullets(String bullets) {
        this.bullets = bullets;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public TourPackage getTourPackage() {
        return tourPackage;
    }

    public void setTourPackage(TourPackage tourPackage) {
        this.tourPackage = tourPackage;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Tour tour = (Tour) o;
        return Objects.equals(id, tour.id) &&
                Objects.equals(title, tour.title) &&
                Objects.equals(description, tour.description) &&
                Objects.equals(blurd, tour.blurd) &&
                Objects.equals(price, tour.price) &&
                Objects.equals(duration, tour.duration) &&
                Objects.equals(bullets, tour.bullets) &&
                Objects.equals(keywords, tour.keywords) &&
                Objects.equals(tourPackage, tour.tourPackage) &&
                region == tour.region &&
                difficulty == tour.difficulty;
    }

    @Override
    public int hashCode() {
        return Objects
                .hash(id, title, description, blurd, price, duration, bullets, keywords, tourPackage, region,
                        difficulty);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", blurd='" + blurd + '\'' +
                ", price=" + price +
                ", duration='" + duration + '\'' +
                ", bullets='" + bullets + '\'' +
                ", keywords='" + keywords + '\'' +
                ", tourPackage=" + tourPackage +
                ", region=" + region +
                ", difficulty=" + difficulty +
                '}';
    }
}
