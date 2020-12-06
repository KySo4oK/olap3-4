CREATE TABLE public.movies2ratings
(
    movie_title text COLLATE pg_catalog."default" NOT NULL references movies(title),
    rating_id text references rating_types(rating_id),
    rating text,
    CONSTRAINT movies2ratings_pkey PRIMARY KEY (movie_title, rating_id)
)