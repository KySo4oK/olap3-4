CREATE TABLE public.movies2ratings
(
    movie_title text COLLATE pg_catalog."default" NOT NULL,
    rating_id text,
    CONSTRAINT movies2ratings_pkey PRIMARY KEY (movie_title)
)