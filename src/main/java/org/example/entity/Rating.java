package org.example.entity;

import org.example.entity.enums.RatingType;

public class Rating {
    private String ratingName;
    private RatingType ratingType;

    public String getRatingName() {
        return ratingName;
    }

    public void setRatingName(String ratingName) {
        this.ratingName = ratingName;
    }

    public RatingType getRatingType() {
        return ratingType;
    }

    public void setRatingType(RatingType ratingType) {
        this.ratingType = ratingType;
    }

    public static final class RatingBuilder {
        private String ratingName;
        private RatingType ratingType;

        private RatingBuilder() {
        }

        public static RatingBuilder aRating() {
            return new RatingBuilder();
        }

        public RatingBuilder ratingName(String ratingName) {
            this.ratingName = ratingName;
            return this;
        }

        public RatingBuilder ratingType(RatingType ratingType) {
            this.ratingType = ratingType;
            return this;
        }

        public Rating build() {
            Rating rating = new Rating();
            rating.ratingName = this.ratingName;
            rating.ratingType = this.ratingType;
            return rating;
        }
    }
}
