CREATE TABLE public.movies2metadata
(
    movie_title text COLLATE pg_catalog."default" NOT NULL references movies(title),
    metadata_id text references metadata_types(metadata_id),
    metadata text,
    CONSTRAINT movies2metadata_pkey PRIMARY KEY (movie_title, metadata_id)
)