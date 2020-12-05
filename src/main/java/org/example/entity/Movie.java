package org.example.entity;

import org.example.entity.enums.RatingType;

import java.util.Objects;

public class Movie {
    private String year;
    private String country;
    private String director;
    private String screenwriter;
    private String actors;
    private String urlLogo;
    private String title;
    private String linkMeta;
    private String genre;
    private Description description;
    private Metadata metadata;
    private RatingType rating;

    @Override
    public String toString() {
        return "Movie{" +
                "year='" + year + '\'' +
                ", country='" + country + '\'' +
                ", director='" + director + '\'' +
                ", screenwriter='" + screenwriter + '\'' +
                ", actors='" + actors + '\'' +
                ", urlLogo='" + urlLogo + '\'' +
                ", title='" + title + '\'' +
                ", linkMeta='" + linkMeta + '\'' +
                ", genre='" + genre + '\'' +
                ", description=" + description +
                ", metadata=" + metadata +
                ", rating=" + rating +
                '}';
    }

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

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinkMeta() {
        return linkMeta;
    }

    public void setLinkMeta(String linkMeta) {
        this.linkMeta = linkMeta;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public RatingType getRating() {
        return rating;
    }

    public void setRating(RatingType rating) {
        this.rating = rating;
    }

    public static final class MovieBuilder {
        private String year;
        private String country;
        private String director;
        private String screenwriter;
        private String actors;
        private String urlLogo;
        private String title;
        private String linkMeta;
        private String genre;
        private Description description;
        private Metadata metadata;
        private RatingType rating;

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

        public MovieBuilder urlLogo(String urlLogo) {
            this.urlLogo = urlLogo;
            return this;
        }

        public MovieBuilder title(String title) {
            this.title = title;
            return this;
        }

        public MovieBuilder linkMeta(String linkMeta) {
            this.linkMeta = linkMeta;
            return this;
        }

        public MovieBuilder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public MovieBuilder description(Description description) {
            this.description = description;
            return this;
        }

        public MovieBuilder metadata(Metadata metadata) {
            this.metadata = metadata;
            return this;
        }

        public MovieBuilder rating(RatingType rating) {
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
            movie.setUrlLogo(urlLogo);
            movie.setTitle(title);
            movie.setLinkMeta(linkMeta);
            movie.setGenre(genre);
            movie.setDescription(description);
            movie.setMetadata(metadata);
            movie.setRating(rating);
            return movie;
        }
    }
}
