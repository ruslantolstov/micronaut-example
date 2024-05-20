CREATE TABLE IF NOT EXISTS "post" (
    id uuid DEFAULT uuid_generate_v4() NOT NULL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    user_id uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT now() NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT now() NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "user" (id)
    );
