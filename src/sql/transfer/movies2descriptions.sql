CREATE TABLE public.movies2descriptions
(
    movie_title text COLLATE pg_catalog."default" NOT NULL,
    description_id text,
    CONSTRAINT movies2descriptions_pkey PRIMARY KEY (movie_title)
)