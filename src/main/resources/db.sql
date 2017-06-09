CREATE TABLE types (
	id SERIAL PRIMARY KEY,
	name VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE articles (
	id SERIAL PRIMARY KEY,
	name VARCHAR(100) NOT NULL UNIQUE,
	type_id INTEGER REFERENCES types(id) ON DELETE CASCADE
);

CREATE TABLE article_link (
	article1_id integer not null references articles(id) on delete cascade,
	article2_id integer not null references articles(id) on delete cascade,
	PRIMARY KEY (article1_id, article2_id)
);

INSERT INTO types(id, name)
VALUES
(1,	'Новости'),
(2,	'События'),
(3,	'Спецакции'),
(4,	'Официальный текст'),
(5,	'Английский текст');

INSERT INTO articles(id, name, type_id)
VALUES
(1,	'Новость 1', 1),
(2,	'Новость 2', 1),
(3,	'Спецакция 1', 3),
(4,	'Новость 3', 1),
(5,	'Новость 4', 1),
(6,	'Спецакция 2', 3),
(7,	'Новость 5', 1),
(8,	'Официальный текст к новости 2', 4),
(9,	'Официальный текст к новости 4', 4),
(10, 'Английский текст к новости 2', 5),
(11, 'Английский текст к новости 3', 5);

INSERT INTO article_link(article1_id, article2_id)
VALUES
(2,8),
(5,9),
(2,10),
(4,11);