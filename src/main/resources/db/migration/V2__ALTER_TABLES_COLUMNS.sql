ALTER TABLE messages
DROP
CONSTRAINT fk432uswp9w9t9x6vpgkxk7llf;

ALTER TABLE messages
    ADD chat_id UUID;

ALTER TABLE messages
    ALTER COLUMN chat_id SET NOT NULL;

ALTER TABLE users
    ADD password VARCHAR(255);

ALTER TABLE users
    ALTER COLUMN password SET NOT NULL;

ALTER TABLE chats
    ADD CONSTRAINT uc_chats_persona UNIQUE (persona_id);

ALTER TABLE messages
    ADD CONSTRAINT FK_MESSAGES_ON_CHAT FOREIGN KEY (chat_id) REFERENCES chats (id);

ALTER TABLE messages
DROP
COLUMN user_id;

CREATE SEQUENCE IF NOT EXISTS messages_id_seq;
ALTER TABLE messages
    ALTER COLUMN id SET NOT NULL;
ALTER TABLE messages
    ALTER COLUMN id SET DEFAULT nextval('messages_id_seq');

ALTER SEQUENCE messages_id_seq OWNED BY messages.id;