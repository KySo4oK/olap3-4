package org.example.entity;

import java.util.List;
import java.util.Objects;

public class Movie {
    private String year;
    private String country;
    private String director;
    private String screenwriter;
    private String actors;
    private String title;
    private String genre;
    private List<Description> description;
    private List<Metadata> metadata;
    private List<Rating> rating;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScreenwriter() {
        return screenwriter;
    }

    public void setScreenwriter(String screenwriter) {
        this.screenwriter = screenwriter;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Description> getDescription() {
        return description;
    }

    public void setDescription(List<Description> description) {
        this.description = description;
    }

    public List<Metadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Metadata> metadata) {
        this.metadata = metadata;
    }

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(List<Rating> rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "year='" + year + '\'' +
                ", country='" + country + '\'' +
                ", director='" + director + '\'' +
                ", screenwriter='" + screenwriter + '\'' +
                ", actors='" + actors + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", description=" + description +
                ", metadata=" + metadata +
                ", rating=" + rating +
                '}';
    }

    public static final class MovieBuilder {
        private String year;
        private String country;
        private String director;
        private String screenwriter;
        private String actors;
        private String title;
        private String genre;
        private List<Description> description;
        private List<Metadata> metadata;
        private List<Rating> rating;

        private MovieBuilder() {
        }

        public static MovieBuilder aMovie() {
            return new MovieBuilder();
        }

        public MovieBuilder year(String year) {
            this.year = year;
            return this;
        }

        public MovieBuilder country(String country) {
            this.country = country;
            return this;
        }

        public MovieBuilder director(String director) {
            this.director = director;
            return this;
        }

        public MovieBuilder screenwriter(String screenwriter) {
            this.screenwriter = screenwriter;
            return this;
        }

        public MovieBuilder actors(String actors) {
            this.actors = actors;
            return this;
        }

        public MovieBuilder title(String title) {
            this.title = title;
            return this;
        }

        public MovieBuilder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public MovieBuilder description(List<Description> description) {
            this.description = description;
            return this;
        }

        public MovieBuilder metadata(List<Metadata> metadata) {
            this.metadata = metadata;
            return this;
        }

        public MovieBuilder rating(List<Rating> rating) {
            this.rating = rating;
            return this;
        }

        public Movie build() {
            Movie movie = new Movie();
            movie.setYear(year);
            movie.setCountry(country);
            movie.setDirector(director);
            movie.setScreenwriter(screenwriter);
            movie.setActors(actors);
            movie.setTitle(title);
            movie.setGenre(genre);
            movie.setDescription(description);
            movie.setMetadata(metadata);
            movie.setRating(rating);
            return movie;
        }
    }
}
