CREATE TABLE todoes.users (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  password varchar(255) NOT NULL,
  enabled bit(1) NOT NULL,
  PRIMARY KEY (id)
)

CREATE TABLE todoes.roles (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  PRIMARY KEY (id)
)

CREATE TABLE todoes.user_role (
  id bigint NOT NULL AUTO_INCREMENT,
  user_id bigint NOT NULL,
  role_id bigint NOT NULL,
  PRIMARY KEY (id)
)

CREATE TABLE todoes.notes_list (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  date date NOT NULL,
  user_id bigint NOT NULL,
  PRIMARY KEY (id)
)

CREATE TABLE todoes.notes_group (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  date datetime NOT NULL,
  note_list_id bigint NOT NULL,
  PRIMARY KEY (id)
)

CREATE TABLE todoes.notes (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  text text NOT NULL,
  date datetime NOT NULL,
  complete bit(1) NOT NULL,
  group_id bigint NOT NULL,
  PRIMARY KEY (id)
)


ALTER TABLE todoes.user_role
ADD CONSTRAINT FK_user_role_role_id FOREIGN KEY (role_id)
REFERENCES todoes.roles (id);

ALTER TABLE todoes.user_role
ADD CONSTRAINT FK_user_role_user_id FOREIGN KEY (user_id)
REFERENCES todoes.users (id);

ALTER TABLE todoes.notes_list
ADD CONSTRAINT FK_notes_list_user_id FOREIGN KEY (user_id)
REFERENCES todoes.users (id);

ALTER TABLE todoes.notes_group
ADD CONSTRAINT FK_notes_group_note_list_id FOREIGN KEY (note_list_id)
REFERENCES todoes.notes_list (id);

ALTER TABLE todoes.notes
ADD CONSTRAINT FK_notes_group_id FOREIGN KEY (group_id)
REFERENCES todoes.notes_group (id);