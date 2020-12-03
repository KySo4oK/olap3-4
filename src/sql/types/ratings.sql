CREATE TABLE public.ratings
(
    rating_id text NOT NULL,
    imdb_rating text,
    kinopoisk_rating text,
    CONSTRAINT ratings_pkey PRIMARY KEY (rating_id)
)