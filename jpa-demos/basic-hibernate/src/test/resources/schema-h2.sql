CREATE TABLE IF NOT EXISTS employee (
  id int(11) primary key,
  code varchar(45),
  pid varchar(45),
  name varchar(45),
  surname1 varchar(45),
  surname2 varchar(45),
  email varchar(255),
  phone varchar(15)
);

INSERT INTO employee (id, code, pid, name, surname1, surname2, email, phone) VALUES (1, 'a1', '11M', 'marta', 'soto', '', 'email@domain.com', 913333333);
INSERT INTO employee (id, code, pid, name, surname1, surname2, email, phone) VALUES (2, 'a2', '11M', 'james', 'bond', '', 'email@domain.com', 913333333);