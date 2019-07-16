-- Run this with psql
CREATE USER "perseo" WITH ENCRYPTED PASSWORD 'perseo';
ALTER ROLE "perseo" WITH createdb;

CREATE DATABASE perseo2
  WITH OWNER = perseo
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'es_PY.UTF-8'
       LC_CTYPE = 'es_PY.UTF-8'
       CONNECTION LIMIT = -1;
