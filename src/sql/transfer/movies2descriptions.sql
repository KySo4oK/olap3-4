CREATE TABLE public.movies2descriptions
(
    movie_title text COLLATE pg_catalog."default" NOT NULL references movies(title),
    description_id text references description_types(description_id),
    description text,
    CONSTRAINT movies2descriptions_pkey PRIMARY KEY (movie_title, description_id)
)