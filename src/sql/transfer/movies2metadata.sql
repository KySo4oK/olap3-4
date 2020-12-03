CREATE TABLE public.movies2metadata
(
    movie_title text COLLATE pg_catalog."default" NOT NULL,
    metadata_id text,
    CONSTRAINT movies2metadata_pkey PRIMARY KEY (movie_title)
)