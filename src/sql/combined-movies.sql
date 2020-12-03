CREATE TABLE public.combined_movies
(
    rating integer NOT NULL,
    movie text COLLATE pg_catalog."default",
    year_eng integer,
    country integer,
    rating_eng numeric,
    overview text COLLATE pg_catalog."default",
    director text COLLATE pg_catalog."default",
    screenwriter text COLLATE pg_catalog."default",
    actors text COLLATE pg_catalog."default",
    url_logo text COLLATE pg_catalog."default",
    rank integer,
    title text COLLATE pg_catalog."default",
    year_rus integer,
    linkmeta text COLLATE pg_catalog."default",
    rating_rus numeric,
    duration text COLLATE pg_catalog."default",
    genre text COLLATE pg_catalog."default",
    metadate text COLLATE pg_catalog."default",
    summarytext text COLLATE pg_catalog."default",
    creditsinfo text COLLATE pg_catalog."default",
    CONSTRAINT combined_movies_pkey PRIMARY KEY (rating)
)