CREATE SEQUENCE guestbook_id_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 999999
START 1
CACHE 1;

CREATE TABLE guestbook (
    id integer NOT NULL DEFAULT NEXTVAL('guestbook_id_seq'::regclass),
    name character varying(25),
    comment character varying(100)
);