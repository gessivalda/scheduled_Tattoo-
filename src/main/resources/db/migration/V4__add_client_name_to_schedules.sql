ALTER TABLE tattoo_scheduled_dates ADD COLUMN client_name VARCHAR(150) NOT NULL DEFAULT '';
ALTER TABLE tattoo_scheduled_dates ALTER COLUMN client_name DROP DEFAULT;
