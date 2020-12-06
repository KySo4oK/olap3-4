package org.example;

import org.example.entity.Description;
import org.example.entity.Metadata;
import org.example.entity.Movie;
import org.example.entity.Rating;
import org.example.entity.enums.DescriptionType;
import org.example.entity.enums.MetadataType;
import org.example.entity.enums.RatingType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MovieMapper {
    public Movie extractFromResultSet(ResultSet rs) throws SQLException {
        return Movie.MovieBuilder.aMovie()
                .actors(rs.getString("actors"))
                .country(rs.getString("country"))
                .description(getDescriptions(rs))
                .genre(rs.getString("genre"))
                .rating(getRatings(rs))
                .director(rs.getString("director"))
                .metadata(getMetadata(rs))
                .title(rs.getString("title"))
                .screenwriter(rs.getString("screenwriter"))
                .year(rs.getString("year_eng"))
                .build();
    }

    private List<Metadata> getMetadata(ResultSet rs) throws SQLException {
        Metadata metadataRus = Metadata.MetadataBuilder.aMetadata()
                .metadataName(rs.getString("url_logo"))
                .metadataType(MetadataType.RUS_METADATA)
                .build();
        Metadata metadataEng = Metadata.MetadataBuilder.aMetadata()
                .metadataName(rs.getString("linkmeta"))
                .metadataType(MetadataType.ENG_METADATA)
                .build();
        return List.of(metadataEng, metadataRus);
    }

    private List<Rating> getRatings(ResultSet rs) throws SQLException {
        Rating rating = Rating.RatingBuilder.aRating()
                .ratingName(rs.getString("rating"))
                .ratingType(RatingType.ENG_RATING)
                .build();
        Rating rank = Rating.RatingBuilder.aRating()
                .ratingName(rs.getString("rank"))
                .ratingType(RatingType.RUS_RATING)
                .build();
        return List.of(rank, rating);
    }

    private List<Description> getDescriptions(ResultSet rs) throws SQLException {
        Description overview = Description.DescriptionBuilder.aDescription()
                .descriptionName(rs.getString("overview"))
                .descriptionType(DescriptionType.ENG_DESC)
                .build();
        Description summary = Description.DescriptionBuilder.aDescription()
                .descriptionName(rs.getString("summarytext"))
                .descriptionType(DescriptionType.RUS_DESC)
                .build();
        return List.of(overview, summary);
    }
}
