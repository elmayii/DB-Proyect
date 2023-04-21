--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: create_cdr(integer, text, text, integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.create_cdr(id integer, nombre text, nombre_presidente text, colegio_id integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    INSERT INTO cdr (id,nombre, nombre_presidente, colegio_id)
    VALUES (id,nombre, nombre_presidente, colegio_id);
END;$$;


ALTER FUNCTION public.create_cdr(id integer, nombre text, nombre_presidente text, colegio_id integer) OWNER TO postgres;

--
-- Name: create_circunscripcion(integer, text, integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.create_circunscripcion(id integer, nombre text, municipio_id integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    INSERT INTO circunscripcion (id,nombre, municipio_id)
    VALUES (id,nombre, municipio_id);
END;$$;


ALTER FUNCTION public.create_circunscripcion(id integer, nombre text, municipio_id integer) OWNER TO postgres;

--
-- Name: create_colegio(integer, text, text, integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.create_colegio(id integer, nombre text, direccion text, circunscripcion_id integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    INSERT INTO colegio (id,nombre, direccion, circunscripcion_id)
    VALUES (id,nombre, direccion, circunscripcion_id);
END;$$;


ALTER FUNCTION public.create_colegio(id integer, nombre text, direccion text, circunscripcion_id integer) OWNER TO postgres;

--
-- Name: create_elector(integer, text, text, date, text, integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.create_elector(id integer, nombre text, apellido text, fecha_nacimiento date, direccion_particular text, cdr_id integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    INSERT INTO elector (nombre, apellido, fecha_nacimiento, direccion_particular,cdr_id)
    VALUES (nombre, apellido, fecha_nacimiento, direccion_particular,cdr_id);
END;$$;


ALTER FUNCTION public.create_elector(id integer, nombre text, apellido text, fecha_nacimiento date, direccion_particular text, cdr_id integer) OWNER TO postgres;

--
-- Name: create_municipio(integer, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.create_municipio(id integer, nombre text) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    INSERT INTO municipio(id,nombre)
    VALUES (id,nombre);
END;$$;


ALTER FUNCTION public.create_municipio(id integer, nombre text) OWNER TO postgres;

--
-- Name: create_nominados(integer, text, text, date, text, integer, text, text, text, text, text, integer, integer, integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.create_nominados(id integer, nombre text, apellidos text, fecha_nacimiento date, direccion_particular text, edad integer, integracion_revolucionaria text, telefono text, ocupacion text, profesion text, datos_bibliograficos text, vuelta integer, votos integer, circunscripcion_id integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    INSERT INTO nominados (id,nombre, apellidos, fecha_nacimiento, direccion_particular, edad, integracion_revolucionaria, telefono, ocupacion,profesion,datos_bibliograficos,vuelta,votos,circunscripcion_id)
    VALUES (id,nombre, apellidos, fecha_nacimiento, direccion_particular, edad, integracion_revolucionaria, telefono, ocupacion,profesion,datos_bibliograficos,vuelta,votos,circunscripcion_id);
END;$$;


ALTER FUNCTION public.create_nominados(id integer, nombre text, apellidos text, fecha_nacimiento date, direccion_particular text, edad integer, integracion_revolucionaria text, telefono text, ocupacion text, profesion text, datos_bibliograficos text, vuelta integer, votos integer, circunscripcion_id integer) OWNER TO postgres;

--
-- Name: delete_cdr(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.delete_cdr(ide integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    DELETE FROM cdr WHERE id = ide;
END;$$;


ALTER FUNCTION public.delete_cdr(ide integer) OWNER TO postgres;

--
-- Name: delete_colegio(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.delete_colegio(ide integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    DELETE FROM colegio WHERE id = ide;
END;$$;


ALTER FUNCTION public.delete_colegio(ide integer) OWNER TO postgres;

--
-- Name: delete_cricunscripcion(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.delete_cricunscripcion(ide integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    DELETE FROM cricunscripcion WHERE id = ide;
END;$$;


ALTER FUNCTION public.delete_cricunscripcion(ide integer) OWNER TO postgres;

--
-- Name: delete_elector(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.delete_elector(ide integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    DELETE FROM elector WHERE id = ide;
END;$$;


ALTER FUNCTION public.delete_elector(ide integer) OWNER TO postgres;

--
-- Name: delete_municipio(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.delete_municipio(ide integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    DELETE FROM municipio WHERE id = ide;
END;$$;


ALTER FUNCTION public.delete_municipio(ide integer) OWNER TO postgres;

--
-- Name: delete_nominados(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.delete_nominados(ide integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    DELETE FROM nominados WHERE id = ide;
END;$$;


ALTER FUNCTION public.delete_nominados(ide integer) OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: cdr; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cdr (
    id integer NOT NULL,
    nombre character varying(30),
    nombre_presidente character varying(60),
    colegio_id integer
);


ALTER TABLE public.cdr OWNER TO postgres;

--
-- Name: getbyid_cdr(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.getbyid_cdr(ide integer) RETURNS public.cdr
    LANGUAGE plpgsql
    AS $$DECLARE
    cdr_data cdr%ROWTYPE;
BEGIN
    SELECT * INTO cdr_data FROM cdr WHERE id = ide;
    RETURN cdr_data;
END;$$;


ALTER FUNCTION public.getbyid_cdr(ide integer) OWNER TO postgres;

--
-- Name: circunscripcion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.circunscripcion (
    id integer NOT NULL,
    nombre character varying(255),
    municipio_id integer
);


ALTER TABLE public.circunscripcion OWNER TO postgres;

--
-- Name: getbyid_circunscripcion(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.getbyid_circunscripcion(ide integer) RETURNS public.circunscripcion
    LANGUAGE plpgsql
    AS $$DECLARE
    circunscripcion_data circunscripcion%ROWTYPE;
BEGIN
    SELECT * INTO circunscripcion_data FROM circunscripcion WHERE id = ide;
    RETURN circunscripcion_data;
END;$$;


ALTER FUNCTION public.getbyid_circunscripcion(ide integer) OWNER TO postgres;

--
-- Name: colegio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.colegio (
    id integer NOT NULL,
    nombre character varying(30),
    direccion character varying(50),
    circunscripcion_id integer NOT NULL
);


ALTER TABLE public.colegio OWNER TO postgres;

--
-- Name: getbyid_colegio(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.getbyid_colegio(ide integer) RETURNS public.colegio
    LANGUAGE plpgsql
    AS $$DECLARE
    colegio_data colegio%ROWTYPE;
BEGIN
    SELECT * INTO colegio_data FROM colegio WHERE id = ide;
    RETURN colegio_data;
END;$$;


ALTER FUNCTION public.getbyid_colegio(ide integer) OWNER TO postgres;

--
-- Name: elector; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.elector (
    id integer NOT NULL,
    nombre character varying(255),
    apellidos character varying,
    fecha_nacimiento date,
    direccion_particular character varying(50),
    cdr_id integer
);


ALTER TABLE public.elector OWNER TO postgres;

--
-- Name: getbyid_elector(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.getbyid_elector(ide integer) RETURNS public.elector
    LANGUAGE plpgsql
    AS $$DECLARE
    elector_data elector%ROWTYPE;
BEGIN
    SELECT * INTO elector_data FROM elector WHERE id = ide;
    RETURN elector_data;
END;$$;


ALTER FUNCTION public.getbyid_elector(ide integer) OWNER TO postgres;

--
-- Name: municipio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.municipio (
    id integer NOT NULL,
    nombre character varying(255)
);


ALTER TABLE public.municipio OWNER TO postgres;

--
-- Name: getbyid_municipio(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.getbyid_municipio(ide integer) RETURNS public.municipio
    LANGUAGE plpgsql
    AS $$DECLARE
    municipio_data municipio%ROWTYPE;
BEGIN
    SELECT * INTO municipio_data FROM municipio WHERE id = ide;
    RETURN municipio_data;
END;$$;


ALTER FUNCTION public.getbyid_municipio(ide integer) OWNER TO postgres;

--
-- Name: nominados; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nominados (
    id integer NOT NULL,
    nombre character varying(255),
    apellidos character varying,
    fecha_nacimiento date,
    direccion_particular character varying(50),
    edad integer,
    integracion_revolucionaria character varying(255),
    telefono character varying(11),
    ocupacion character varying(20),
    profesion character varying(20),
    datos_biograficos character varying(255),
    vuelta integer,
    votos integer,
    circunscripcion_id integer
);


ALTER TABLE public.nominados OWNER TO postgres;

--
-- Name: getbyid_nominados(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.getbyid_nominados(ide integer) RETURNS public.nominados
    LANGUAGE plpgsql
    AS $$DECLARE
    nominados_data nominados%ROWTYPE;
BEGIN
    SELECT * INTO nominados_data FROM nominados WHERE id = ide;
    RETURN nominados_data;
END;$$;


ALTER FUNCTION public.getbyid_nominados(ide integer) OWNER TO postgres;

--
-- Name: update_cdr(integer, text, text, integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.update_cdr(cdr_id integer, nuevo_nombre text, nuevo_nombre_presidente text, nuevo_colegio_id integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    UPDATE cdr SET 
    nombre = nuevo_nombre,
    id_colegio = nuevo_colegio_id,
    nombre_presidente = nuevo_nombre_presidente
    WHERE id = cdr_id;
END;$$;


ALTER FUNCTION public.update_cdr(cdr_id integer, nuevo_nombre text, nuevo_nombre_presidente text, nuevo_colegio_id integer) OWNER TO postgres;

--
-- Name: update_circunscripcion(text, integer, integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.update_circunscripcion(nuevo_nombre text, nuevo_municipio_id integer, ide integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    UPDATE circunscripcion SET 
    nombre = nuevo_nombre,
    municipio_id = nuevo_municipio_id
    WHERE id = ide;
END;$$;


ALTER FUNCTION public.update_circunscripcion(nuevo_nombre text, nuevo_municipio_id integer, ide integer) OWNER TO postgres;

--
-- Name: update_colegio(integer, text, text, integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.update_colegio(ide integer, nuevo_nombre text, nuevo_direccion text, nuevo_circunscripcion_id integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    UPDATE colegio SET 
    nombre = nuevo_nombre,
    direccion = nuevo_direccion,
    circunscripcion_id=nuevo_circunscripcion_id
    WHERE id = ide;
END;$$;


ALTER FUNCTION public.update_colegio(ide integer, nuevo_nombre text, nuevo_direccion text, nuevo_circunscripcion_id integer) OWNER TO postgres;

--
-- Name: update_elector(integer, text, text, date, text, integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.update_elector(ide integer, nuevo_nombre text, nuevo_apellidos text, nuevo_fecha_nacimiento date, nuevo_direccion_particular text, nuevo_cdr_id integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    UPDATE elector SET 
    nombre = nuevo_nombre,
    apellidos = nuevo_apellidos,
    fecha_nacimiento=nuevo_fecha_nacimiento,
    direccion_particular=nuevo_direccion_particular,
    cdr_id = nuevo_cdr_id
    WHERE id = ide;
END;$$;


ALTER FUNCTION public.update_elector(ide integer, nuevo_nombre text, nuevo_apellidos text, nuevo_fecha_nacimiento date, nuevo_direccion_particular text, nuevo_cdr_id integer) OWNER TO postgres;

--
-- Name: update_municipio(integer, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.update_municipio(ide integer, nuevo_nombre text) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    UPDATE municipio SET 
    nombre = nuevo_nombre
    WHERE id = ide;
END;$$;


ALTER FUNCTION public.update_municipio(ide integer, nuevo_nombre text) OWNER TO postgres;

--
-- Name: update_nominados(integer, text, text, date, integer, text, text, text, text, text, text, integer, integer, integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.update_nominados(ide integer, nuevo_nombre text, nuevo_apellidos text, nuevo_fecha_nacimiento date, nuevo_edad integer, nuevo_integracion_revolucionaria text, nuevo_telefono text, nuevo_ocupacion text, nuevo_profesion text, nuevo_datos_biograficos text, nuevo_direccion_particular text, nuevo_vuelta integer, nuevo_votos integer, nuevo_circunscripcion_id integer) RETURNS void
    LANGUAGE plpgsql
    AS $$BEGIN
    UPDATE nominados SET 
    nombre = nuevo_nombre,
    apellidos = nuevo_apellidos,
    fecha_nacimiento=nuevo_fecha_nacimiento,
    edad=nuevo_edad,
    integracion_revolucionaria=nuevo_integracion_revolucionaria,
    telefono=nuevo_telefono,
    ocupacion=nuevo_ocupacion,
    profesion=nuevo_profesion,
    datos_biograficos=nuevo_datos_biograficos,
    direccion_particular=nuevo_direccion_particular,
    vuelta=nuevo_vuelta,
    votos=nuevo_votos,
    circunscripcion_id=nuevo_circunscripcion_id,
    nombre_presidente = nuevo_nombre_presidente
    WHERE id = ide;
END;$$;


ALTER FUNCTION public.update_nominados(ide integer, nuevo_nombre text, nuevo_apellidos text, nuevo_fecha_nacimiento date, nuevo_edad integer, nuevo_integracion_revolucionaria text, nuevo_telefono text, nuevo_ocupacion text, nuevo_profesion text, nuevo_datos_biograficos text, nuevo_direccion_particular text, nuevo_vuelta integer, nuevo_votos integer, nuevo_circunscripcion_id integer) OWNER TO postgres;

--
-- Name: cdr_electores; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.cdr_electores AS
 SELECT cdr.id AS cdr_id,
    e.id,
    e.nombre,
    e.apellidos,
    e.fecha_nacimiento,
    e.direccion_particular
   FROM (public.cdr
     JOIN public.elector e ON ((cdr.id = e.cdr_id)))
  ORDER BY e.apellidos, e.nombre;


ALTER TABLE public.cdr_electores OWNER TO postgres;

--
-- Name: cdr_list; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.cdr_list AS
 SELECT m.nombre AS municipio,
    c.nombre AS circunscripcion,
    ce.nombre AS colegio_electoral,
    cdr.nombre AS cdr_nombre
   FROM (((public.municipio m
     JOIN public.circunscripcion c ON ((m.id = c.municipio_id)))
     JOIN public.colegio ce ON ((c.id = ce.circunscripcion_id)))
     JOIN public.cdr ON ((ce.id = cdr.colegio_id)));


ALTER TABLE public.cdr_list OWNER TO postgres;

--
-- Name: listado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.listado (
    elector_id integer NOT NULL,
    colegio_id integer NOT NULL,
    votado boolean,
    causa_no_voto character varying(255)
);


ALTER TABLE public.listado OWNER TO postgres;

--
-- Name: municipios; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.municipios AS
SELECT
    NULL::character varying(255) AS municipio,
    NULL::bigint AS cantidad_circunscripciones,
    NULL::bigint AS cantidad_colegios_electorales,
    NULL::bigint AS cantidad_cdrs,
    NULL::bigint AS cantidad_electores;


ALTER TABLE public.municipios OWNER TO postgres;

--
-- Name: municipios_nominados; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.municipios_nominados AS
SELECT
    NULL::character varying(255) AS nombre_municipio,
    NULL::bigint AS cantidad_nominados;


ALTER TABLE public.municipios_nominados OWNER TO postgres;

--
-- Name: nominado; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.nominado AS
 SELECT (((n.nombre)::text || ' '::text) || (n.apellidos)::text) AS nombre_completo,
    (date_part('year'::text, now()) - date_part('year'::text, n.fecha_nacimiento)) AS edad,
    n.integracion_revolucionaria,
    n.direccion_particular,
    n.telefono,
    n.ocupacion,
    n.profesion,
    n.datos_biograficos
   FROM public.nominados n
  ORDER BY (((n.nombre)::text || ' '::text) || (n.apellidos)::text);


ALTER TABLE public.nominado OWNER TO postgres;

--
-- Name: nominados_list; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.nominados_list AS
 SELECT m.nombre AS municipio,
    c.nombre AS circunscripcion,
    n.vuelta
   FROM ((public.municipio m
     JOIN public.circunscripcion c ON ((m.id = c.municipio_id)))
     JOIN public.nominados n ON ((c.id = n.circunscripcion_id)))
  GROUP BY m.nombre, c.nombre, n.vuelta;


ALTER TABLE public.nominados_list OWNER TO postgres;

--
-- Data for Name: cdr; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cdr (id, nombre, nombre_presidente, colegio_id) FROM stdin;
1	sss	cicicici	1
2	asdas	asdadsa	1
\.


--
-- Data for Name: circunscripcion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.circunscripcion (id, nombre, municipio_id) FROM stdin;
1	ddsda	1
2	ddsda	1
\.


--
-- Data for Name: colegio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.colegio (id, nombre, direccion, circunscripcion_id) FROM stdin;
1	ddsda	asfx	1
\.


--
-- Data for Name: elector; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.elector (id, nombre, apellidos, fecha_nacimiento, direccion_particular, cdr_id) FROM stdin;
1	asdfxz	adzzz	2000-03-03	asdz	1
\.


--
-- Data for Name: listado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.listado (elector_id, colegio_id, votado, causa_no_voto) FROM stdin;
\.


--
-- Data for Name: municipio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.municipio (id, nombre) FROM stdin;
1	fsadfd
2	fsadfd
3	fsadfd
4	fsadfd
\.


--
-- Data for Name: nominados; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.nominados (id, nombre, apellidos, fecha_nacimiento, direccion_particular, edad, integracion_revolucionaria, telefono, ocupacion, profesion, datos_biograficos, vuelta, votos, circunscripcion_id) FROM stdin;
1	asdfxz	adzzz	2000-03-16	aweruiwiwuidu ufhuewu eu9wfhe	0	adac	asdz	sdaz	asdxx	afaf dfs dwf 	2	2666	1
2	asdfxz	adzzz	2000-03-16	aweruiwiwuidu ufhuewu eu9wfhe	0	adac	asdz	sdaz	asdxx	afaf dfs dwf 	2	2666	1
\.


--
-- Name: cdr cdr_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cdr
    ADD CONSTRAINT cdr_pkey PRIMARY KEY (id);


--
-- Name: circunscripcion circunscripcion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.circunscripcion
    ADD CONSTRAINT circunscripcion_pkey PRIMARY KEY (id);


--
-- Name: colegio colegio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.colegio
    ADD CONSTRAINT colegio_pkey PRIMARY KEY (id);


--
-- Name: elector elector_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.elector
    ADD CONSTRAINT elector_pkey PRIMARY KEY (id);


--
-- Name: listado listado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.listado
    ADD CONSTRAINT listado_pkey PRIMARY KEY (elector_id, colegio_id);


--
-- Name: municipio municipio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.municipio
    ADD CONSTRAINT municipio_pkey PRIMARY KEY (id);


--
-- Name: nominados nominados_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nominados
    ADD CONSTRAINT nominados_pkey PRIMARY KEY (id);


--
-- Name: municipios _RETURN; Type: RULE; Schema: public; Owner: postgres
--

CREATE OR REPLACE VIEW public.municipios AS
 SELECT m.nombre AS municipio,
    count(DISTINCT c.id) AS cantidad_circunscripciones,
    count(DISTINCT ce.id) AS cantidad_colegios_electorales,
    count(DISTINCT cd.id) AS cantidad_cdrs,
    count(DISTINCT e.id) AS cantidad_electores
   FROM ((((public.municipio m
     LEFT JOIN public.circunscripcion c ON ((m.id = c.municipio_id)))
     LEFT JOIN public.colegio ce ON ((c.id = ce.circunscripcion_id)))
     LEFT JOIN public.cdr cd ON ((ce.id = cd.colegio_id)))
     LEFT JOIN public.elector e ON ((cd.id = e.cdr_id)))
  GROUP BY m.id;


--
-- Name: municipios_nominados _RETURN; Type: RULE; Schema: public; Owner: postgres
--

CREATE OR REPLACE VIEW public.municipios_nominados AS
 SELECT m.nombre AS nombre_municipio,
    count(*) AS cantidad_nominados
   FROM ((public.nominados n
     JOIN public.circunscripcion c ON ((n.circunscripcion_id = c.id)))
     JOIN public.municipio m ON ((c.municipio_id = m.id)))
  GROUP BY m.id
 HAVING (count(*) > 2)
  ORDER BY (count(*)) DESC
 LIMIT 5;


--
-- Name: cdr cdr_colegio_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cdr
    ADD CONSTRAINT cdr_colegio_id_fkey FOREIGN KEY (colegio_id) REFERENCES public.colegio(id);


--
-- Name: circunscripcion circunscripcion_municipio_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.circunscripcion
    ADD CONSTRAINT circunscripcion_municipio_id_fkey FOREIGN KEY (municipio_id) REFERENCES public.municipio(id);


--
-- Name: colegio colegio_circunscripcion_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.colegio
    ADD CONSTRAINT colegio_circunscripcion_id_fkey FOREIGN KEY (circunscripcion_id) REFERENCES public.circunscripcion(id);


--
-- Name: elector elector_cdr_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.elector
    ADD CONSTRAINT elector_cdr_id_fkey FOREIGN KEY (cdr_id) REFERENCES public.cdr(id);


--
-- Name: listado listado_colegio_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.listado
    ADD CONSTRAINT listado_colegio_id_fkey FOREIGN KEY (colegio_id) REFERENCES public.colegio(id);


--
-- Name: listado listado_elector_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.listado
    ADD CONSTRAINT listado_elector_id_fkey FOREIGN KEY (elector_id) REFERENCES public.elector(id);


--
-- Name: nominados nominados_circunscripcion_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nominados
    ADD CONSTRAINT nominados_circunscripcion_id_fkey FOREIGN KEY (circunscripcion_id) REFERENCES public.circunscripcion(id);


--
-- PostgreSQL database dump complete
--

