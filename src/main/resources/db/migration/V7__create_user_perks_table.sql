CREATE TABLE user_perks (
     user_id BIGINT NOT NULL,
     perk_id BIGINT NOT NULL,

     PRIMARY KEY (user_id, perk_id),

     CONSTRAINT fk_user_perk_user
         FOREIGN KEY (user_id)
             REFERENCES users(id)
             ON DELETE CASCADE,

     CONSTRAINT fk_user_perks_perk
         FOREIGN KEY (perk_id)
             REFERENCES perks(id)
             ON DELETE CASCADE
);