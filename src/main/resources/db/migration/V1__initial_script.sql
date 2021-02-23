
CREATE TABLE ecommerce.product (
	id uuid NOT NULL,
	created_by uuid NULL,
	created_on timestamp NULL,
	updated_by uuid NULL,
	updated_on timestamp NULL,
	category varchar(255) NULL,
	description varchar NULL,
	"name" varchar(500) NULL,
	CONSTRAINT product_pkey PRIMARY KEY (id)
);

CREATE TABLE ecommerce."user" (
	id uuid NOT NULL,
	created_by uuid NULL,
	created_on timestamp NULL,
	updated_by uuid NULL,
	updated_on timestamp NULL,
	username varchar(255) NULL,
	CONSTRAINT user_pkey PRIMARY KEY (id)
);

CREATE TABLE ecommerce.review (
	id uuid NOT NULL,
	created_by uuid NULL,
	created_on timestamp NULL,
	updated_by uuid NULL,
	updated_on timestamp NULL,
	value int4 NOT NULL,
	CONSTRAINT review_pkey PRIMARY KEY (id)
);

CREATE TABLE ecommerce.product_image (
	id uuid NOT NULL,
	created_by uuid NULL,
	created_on timestamp NULL,
	updated_by uuid NULL,
	updated_on timestamp NULL,
	original varchar(255) NULL,
	product_id uuid NULL,
	url varchar(255) NULL,
	"large" varchar(255) NULL,
	medium varchar(255) NULL,
	CONSTRAINT product_image_pkey PRIMARY KEY (id)
);

CREATE TABLE ecommerce.product_plan (
	id uuid NOT NULL,
	created_by uuid NULL,
	created_on timestamp NULL,
	updated_by uuid NULL,
	updated_on timestamp NULL,
	delivery_time varchar(255) NULL,
	description varchar NULL,
	plan varchar(255) NULL,
	price int4 NULL,
	product_id uuid NULL,
	CONSTRAINT product_plan_pkey PRIMARY KEY (id)
);

CREATE TABLE ecommerce.product_tags (
	product_id uuid NOT NULL,
	tags varchar(255) NULL
);

ALTER TABLE ecommerce.product_tags ADD CONSTRAINT fk_tags_product_id FOREIGN KEY (product_id) REFERENCES ecommerce.product(id);
