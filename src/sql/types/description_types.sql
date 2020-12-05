CREATE TABLE public.description_types
(
    description_id text NOT NULL,
    description_type text COLLATE pg_catalog."default",
    CONSTRAINT descriptions_pkey PRIMARY KEY (description_id)
)