CREATE TABLE public.metadata_types
(
    metadata_id text NOT NULL,
    metadata_type text COLLATE pg_catalog."default",
    CONSTRAINT metadata_pkey PRIMARY KEY (metadata_id)
)