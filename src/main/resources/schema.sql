CREATE TABLE if not exists employees (
    employee_id uuid DEFAULT gen_random_uuid(),
    last_name character varying(20) NOT NULL,
    first_name character varying(10) NOT NULL
    -- title character varying(30),
    -- title_of_courtesy character varying(25),
    -- birth_date date,
    -- hire_date date,
    -- address character varying(60),
    -- city character varying(15),
    -- region character varying(15),
    -- postal_code character varying(10),
    -- country character varying(15),
    -- home_phone character varying(24),
    -- extension character varying(4),
    -- photo bytea,
    -- notes text,
    -- reports_to uuid,
    -- photo_path character varying(255)
);
