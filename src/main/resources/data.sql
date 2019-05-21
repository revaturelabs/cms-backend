DROP TABLE IF EXISTS tag;



CREATE TABLE tag (

  name VARCHAR(250) PRIMARY KEY NOT NULL,

  contentId INT NOT NULL,

  belongTo VARCHAR(250) DEFAULT NULL

);



INSERT INTO tag (name, contentId, belongTo) VALUES

('Nate C', 'h2', 'Java, Spring Boot, Database'),

('Eli C', 'SQL', 'SQL, JDBC'),

('Kyle M', 'Angular', 'Angular, TypeScript, CSS');