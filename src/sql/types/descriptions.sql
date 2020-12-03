CREATE TABLE public.descriptions
(
    description_id text NOT NULL,
    description_rus text COLLATE pg_catalog."default",
    description_eng text COLLATE pg_catalog."default",
    CONSTRAINT descriptions_pkey PRIMARY KEY (description_id)
)