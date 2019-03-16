CREATE TABLE sites (
	site_id BIGSERIAL PRIMARY KEY
	, site_name VARCHAR(50) NOT NULL
	, db_name TEXT NOT NULL
	, db_url TEXT NOT NULL
	, db_user TEXT NOT NULL
	, db_password TEXT NOT NULL
	, version_no INTEGER NOT NULL
);

CREATE TABLE languages (
	language_id BIGSERIAL PRIMARY KEY
	, language_code TEXT NOT NULL
	, version_no INTEGER NOT NULL
);