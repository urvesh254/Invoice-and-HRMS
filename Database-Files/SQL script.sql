-- Use project database.
USE invoice_and_hrms;

-- Drop All Old tables
DROP TABLE IF EXISTS bill;
DROP TABLE IF EXISTS bill_detail;
DROP TABLE IF EXISTS currency;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS expenses;
DROP TABLE IF EXISTS invalid_tokens;
DROP TABLE IF EXISTS invoice;
DROP TABLE IF EXISTS milestone;
DROP TABLE IF EXISTS milestone_module;
DROP TABLE IF EXISTS options;
DROP TABLE IF EXISTS permission;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS project_employee;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS role_permissions;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS vendor;

-- Create all the tables
CREATE TABLE bill (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  purchase_date DATE NOT NULL,
  status VARCHAR(255) NOT NULL,
  taxes DOUBLE PRECISION NOT NULL,
  vendor_id BIGINT NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE bill_detail (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  gst DOUBLE PRECISION NOT NULL,
  price DOUBLE PRECISION NOT NULL,
  quantity INTEGER NOT NULL,
  remark VARCHAR(255) NOT NULL,
  sub_total DOUBLE PRECISION NOT NULL,
  total_total DOUBLE PRECISION NOT NULL,
  bill_id BIGINT NOT NULL,
  expense_id BIGINT NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE bill_payment (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_by VARCHAR(255),
    created_dt DATETIME,
    modified_by VARCHAR(255),
    modified_dt DATETIME,
    amount DOUBLE PRECISION NOT NULL,
    bill_date DATE NOT NULL,
    description VARCHAR(255) NOT NULL,
    payment_mode VARCHAR(255) NOT NULL,
    bill_id BIGINT NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=MYISAM;

CREATE TABLE currency (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  country_name VARCHAR(255) NOT NULL,
  currency_name VARCHAR(255) NOT NULL,
  currency_symbol VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE customer (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  area VARCHAR(255) NOT NULL,
  country_name VARCHAR(255) NOT NULL,
  customer_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  number VARCHAR(255) NOT NULL,
  status VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE department (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  department_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE employee (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  address VARCHAR(255) NOT NULL,
  dob DATE,
  email VARCHAR(255) NOT NULL,
  emp_name VARCHAR(255) NOT NULL,
  joining_date DATE,
  number VARCHAR(255) NOT NULL,
  department_id BIGINT NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE expenses (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  expense_name VARCHAR(255) NOT NULL,
  status VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE `invalid_tokens` (
    id BIGINT NOT NULL AUTO_INCREMENT,
    token VARCHAR(255) NOT NULL,
    valid_till DATE NOT NULL,
    created_by VARCHAR(255),
    created_dt DATETIME,
    modified_by VARCHAR(255),
    modified_dt DATETIME,
    PRIMARY KEY (`id`)
)  ENGINE=MYISAM;

CREATE TABLE invoice (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  invoice_date DATE NOT NULL,
  invoice_no VARCHAR(255) NOT NULL,
  remark VARCHAR(255) NOT NULL,
  taxes DOUBLE PRECISION NOT NULL,
  total DOUBLE PRECISION NOT NULL,
  currency_id BIGINT NOT NULL,
  customer_id BIGINT NOT NULL,
  project_id BIGINT NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE invoice_detail (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  gst DOUBLE PRECISION NOT NULL,
  remark VARCHAR(255) NOT NULL,
  service_price DOUBLE PRECISION NOT NULL,
  service_quantity INTEGER NOT NULL,
  sub_total DOUBLE PRECISION NOT NULL,
  total_total DOUBLE PRECISION NOT NULL,
  invoice_id BIGINT NOT NULL,
  service_id BIGINT NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE invoice_payment (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  amount DOUBLE PRECISION NOT NULL,
  description VARCHAR(255) NOT NULL,
  payment_date DATE NOT NULL,
  payment_mode VARCHAR(255) NOT NULL,
  invoice_id BIGINT NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE milestone (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  budget DOUBLE PRECISION NOT NULL,
  deadline DATE NOT NULL,
  description VARCHAR(255) NOT NULL,
  status VARCHAR(255) NOT NULL,
  project_id BIGINT NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE milestone_module (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  deadline DATE NOT NULL,
  description VARCHAR(255) NOT NULL,
  status VARCHAR(255) NOT NULL,
  milestone_id BIGINT NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE options (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  key_ VARCHAR(255) NOT NULL,
  value_ VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE password_reset (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  token VARCHAR(255) NOT NULL,
  user_id BIGINT NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE permission (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  permission_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE project (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  description VARCHAR(255) NOT NULL,
  end_date DATE,
  project_name VARCHAR(255) NOT NULL,
  start_date DATE NOT NULL,
  status VARCHAR(255) NOT NULL,
  total_budget DOUBLE PRECISION NOT NULL,
  customer_id BIGINT NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE project_employee (
  projects_id BIGINT NOT NULL, employee_id BIGINT NOT NULL
) ENGINE = MYISAM;

CREATE TABLE role (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  role_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE role_permission (
  role_id BIGINT NOT NULL, permission_id BIGINT NOT NULL
) ENGINE = MYISAM;

CREATE TABLE service (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  hsn VARCHAR(255) NOT NULL,
  service_name VARCHAR(255) NOT NULL,
  status VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE user (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  email VARCHAR(255) NOT NULL,
  email_verified_at DATETIME,
  number VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  remember_token VARCHAR(255),
  user_name VARCHAR(255) NOT NULL,
  role_id BIGINT NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;

CREATE TABLE vendor (
  id BIGINT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(255),
  created_dt DATETIME,
  modified_by VARCHAR(255),
  modified_dt DATETIME,
  area VARCHAR(255) NOT NULL,
  country_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  number VARCHAR(255) NOT NULL,
  status VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  vendor_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MYISAM;


-- Update all foreign key constraint
ALTER TABLE department ADD CONSTRAINT UK_f5np34wnxt905fwmrs6133l28 UNIQUE (department_name);
ALTER TABLE permission ADD CONSTRAINT UK_l3pmqryh8vgle52647itattb9 UNIQUE (permission_name);
ALTER TABLE role ADD CONSTRAINT UK_iubw515ff0ugtm28p8g3myt0h UNIQUE (role_name);
-- ALTER TABLE role_permission ADD CONSTRAINT UK_fn4pldu982p9u158rpk6nho5k UNIQUE (permission_id);
ALTER TABLE user ADD CONSTRAINT UK_ob8kqyqqgmefl0aco34akdtpe UNIQUE (email);
ALTER TABLE bill ADD CONSTRAINT FKtp30esvi211s1lq78v4afj8cv FOREIGN KEY (vendor_id) REFERENCES vendor (id);
ALTER TABLE bill_detail ADD CONSTRAINT FKeolgwyayei3o80bb7rj7t207q FOREIGN KEY (bill_id) REFERENCES bill (id);
ALTER TABLE bill_detail ADD CONSTRAINT FKr4ra0te72j3r42w9gb0agbij0 FOREIGN KEY (expense_id) REFERENCES expenses (id);
ALTER TABLE bill_payment ADD CONSTRAINT FKjnqsfr0b9lukfdd6577vtngd5 FOREIGN KEY (bill_id) REFERENCES bill (id);
ALTER TABLE employee ADD CONSTRAINT FKbejtwvg9bxus2mffsm3swj3u9 FOREIGN KEY (department_id) REFERENCES department (id);
ALTER TABLE invoice ADD CONSTRAINT FKo0bwsmaaqrq6i9flisausgjb3 FOREIGN KEY (currency_id) REFERENCES currency (id);
ALTER TABLE invoice ADD CONSTRAINT FK5e32ukwo9uknwhylogvta4po6 FOREIGN KEY (customer_id) REFERENCES customer (id);
ALTER TABLE invoice ADD CONSTRAINT FKbty42xpdayvff0ytnonrd2ouv FOREIGN KEY (project_id) REFERENCES project (id);
ALTER TABLE invoice_detail ADD CONSTRAINT FKit1rbx4thcr6gx6bm3gxub3y4 FOREIGN KEY (invoice_id) REFERENCES invoice (id);
ALTER TABLE invoice_detail ADD CONSTRAINT FK5or4ncnbrkg5o8xl4e2uf9rs2 FOREIGN KEY (service_id) REFERENCES service (id);
ALTER TABLE invoice_payment ADD CONSTRAINT FKkopeu965ps1ljahtib8n8nub2 FOREIGN KEY (invoice_id) REFERENCES invoice (id);
ALTER TABLE milestone ADD CONSTRAINT FKc3o4jxeki21gqbpy8ejyxtnus FOREIGN KEY (project_id) REFERENCES project (id);
ALTER TABLE milestone_module ADD CONSTRAINT FKs3oiw74u90iwcd1h2nuoslv8m FOREIGN KEY (milestone_id) REFERENCES milestone (id);
ALTER TABLE password_reset ADD CONSTRAINT FK3rcc5avyc21uriav34cjrqc91 FOREIGN KEY (user_id) REFERENCES user (id);
ALTER TABLE project ADD CONSTRAINT FKj948tru2ilgqxfxsppp9mom5j FOREIGN KEY (customer_id) REFERENCES customer (id);
ALTER TABLE project_employee ADD CONSTRAINT FKn5yqs0xm3rmsg62n84ccyk4k0 FOREIGN KEY (employee_id) REFERENCES employee (id);
ALTER TABLE project_employee ADD CONSTRAINT FKo8tuufttvxdkddrgq026nvhte FOREIGN KEY (projects_id) REFERENCES project (id);
ALTER TABLE role_permission ADD CONSTRAINT FKf8yllw1ecvwqy3ehyxawqa1qp FOREIGN KEY (permission_id) REFERENCES permission (id);
ALTER TABLE role_permission ADD CONSTRAINT FKa6jx8n8xkesmjmv6jqug6bg68 FOREIGN KEY (role_id) REFERENCES role (id);
ALTER TABLE user ADD CONSTRAINT FKn82ha3ccdebhokx3a8fgdqeyy FOREIGN KEY (role_id) REFERENCES role (id);



-- SQL Stored Procedure for deleting old invalid tokens.
CREATE DEFINER=`ihs_dev`@`localhost` PROCEDURE `delete_old_invalid_tokes`()
BEGIN
SET SQL_SAFE_UPDATES = 0;
Delete from invalid_tokens where valid_till < NOW();
SET SQL_SAFE_UPDATES = 1;
END