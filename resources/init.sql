CREATE TABLE clients (
    id VARCHAR(40) PRIMARY KEY NOT NULL,
    name VARCHAR(30) NOT NULL,
    address VARCHAR(80) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    is_professional BOOLEAN NOT NULL
);

CREATE TYPE project_status AS ENUM ('CANCELLED', 'ONGOING', 'COMPLETED');

CREATE TABLE projects (
    id VARCHAR(40) PRIMARY KEY NOT NULL,
    title VARCHAR(50) NOT NULL,
    margin DOUBLE PRECISION,
    status project_status NOT NULL,
    client_id VARCHAR(40) NOT NULL,
    CONSTRAINT fk_customer FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE invoices (
    id VARCHAR(40) PRIMARY KEY NOT NULL,
    overall_cost DOUBLE PRECISION NOT NULL,
    issued_at DATE NOT NULL,
    validated_at DATE NOT NULL,
    project_id VARCHAR(40) NOT NULL,
    CONSTRAINT fk_project FOREIGN KEY (project_id) REFERENCES projects(id)
);

CREATE TABLE components (
    id VARCHAR(40) PRIMARY KEY NOT NULL,
    name VARCHAR(30) NOT NULL,
    vat DOUBLE PRECISION NOT NULL,
    project_id VARCHAR(40) NOT NULL
);

CREATE TABLE materials (
    PRIMARY KEY (id),
    price DOUBLE PRECISION NOT NULL,
    quantity INTEGER NOT NULL,
    transportation_cost DOUBLE PRECISION NOT NULL,
    quality_coeffecient DOUBLE PRECISION NOT NULL,
    CONSTRAINT fk_project FOREIGN KEY (project_id) REFERENCES projects(id)
) INHERITS (components);

CREATE TABLE workforce (
   PRIMARY KEY (id),
    hourly_rate DOUBLE PRECISION NOT NULL,
    work_hours DOUBLE PRECISION NOT NULL,
   CONSTRAINT fk_project FOREIGN KEY (project_id) REFERENCES projects(id)
) INHERITS (components);