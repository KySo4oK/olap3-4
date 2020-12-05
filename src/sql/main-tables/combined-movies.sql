CREATE TABLE public.combined_movies
(
    rating text NOT NULL,
    movie text COLLATE pg_catalog."default",
    year_eng text,
    country text,
    rating_eng text,
    overview text COLLATE pg_catalog."default",
    director text COLLATE pg_catalog."default",
    screenwriter text COLLATE pg_catalog."default",
    actors text COLLATE pg_catalog."default",
    url_logo text COLLATE pg_catalog."default",
    rank text,
    title text COLLATE pg_catalog."default",
    year_rus text,
    linkmeta text COLLATE pg_catalog."default",
    rating_rus text,
    duration text COLLATE pg_catalog."default",
    genre text COLLATE pg_catalog."default",
    metadate text COLLATE pg_catalog."default",
    summarytext text COLLATE pg_catalog."default",
    CONSTRAINT combined_movies_pkey PRIMARY KEY (rating)
)