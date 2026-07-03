CREATE TABLE perk_categories (
    perk_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,

    PRIMARY KEY (perk_id, category_id),

    CONSTRAINT fk_perk_categories_perk
     FOREIGN KEY (perk_id)
         REFERENCES perks(id)
         ON DELETE CASCADE,

    CONSTRAINT fk_perk_categories_category
     FOREIGN KEY (category_id)
         REFERENCES categories(id)
         ON DELETE CASCADE
);