CREATE TABLE public.movies
(
    title text COLLATE pg_catalog."default" NOT NULL,
    year text COLLATE pg_catalog."default",
    country text COLLATE pg_catalog."default",
    director text COLLATE pg_catalog."default",
    actors text COLLATE pg_catalog."default",
    genre text COLLATE pg_catalog."default",
    screenwriter text COLLATE pg_catalog."default",
    CONSTRAINT movies_pkey PRIMARY KEY (title)
)