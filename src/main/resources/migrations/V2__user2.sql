CREATE TABLE IF NOT EXISTS "user2" (
    id uuid DEFAULT uuid_generate_v4() NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT now() NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT now() NOT NULL
    );
INSERT INTO "user2" (name, email) VALUES ('Alice', 'alice@mail.com');
