package com.github.vlsidlyarevich.model;

public class Movie extends BaseEntity{
    private String name;
    private String image;
    private String duration;
    private String genre;
    private String story_line;
    private String language;
    private String imdb_key;
    private boolean isShowing;

    public Movie() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStory_line() {
        return story_line;
    }

    public void setStory_line(String story_line) {
        this.story_line = story_line;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getImdb_key() {
        return imdb_key;
    }

    public void setImdb_key(String imdb_key) {
        this.imdb_key = imdb_key;
    }

    public boolean isShowing() {
        return isShowing;
    }

    public void setShowing(boolean showing) {
        isShowing = showing;
    }
}
