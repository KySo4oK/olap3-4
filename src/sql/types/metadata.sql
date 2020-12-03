CREATE TABLE public.metadata
(
    metadata_id text NOT NULL,
    imdb_metadata text COLLATE pg_catalog."default",
    kp_metadata text COLLATE pg_catalog."default",
    CONSTRAINT metadata_pkey PRIMARY KEY (metadata_id)
)