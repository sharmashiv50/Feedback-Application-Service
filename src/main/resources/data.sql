DROP TABLE IF EXISTS registration;
DROP TABLE IF EXISTS feedback;

CREATE TABLE registration (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  emp_id VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);

CREATE TABLE feedback (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  learner_name VARCHAR(250) NOT NULL,
  learner_emp_id VARCHAR(250) NOT NULL,
  course_name VARCHAR(250) NOT NULL,
  is_content_relevant VARCHAR(250) NOT NULL,
  is_relevant_content_hands_on VARCHAR(250) NOT NULL,
  proficiency_level VARCHAR(250) NOT NULL,
  rating_of_content VARCHAR(250) NOT NULL,
  rating_of_hands_on VARCHAR(250) NOT NULL,
  comments VARCHAR(1000) NOT NULL
);
 
INSERT INTO registration (name, emp_id, password) VALUES
  ('Mohit', '741258', 'Mohit@1'),
  ('Sachin', '1627135', 'Upadhyay1'),
  ('Rashmi', '789654', 'Rashmi@1');

INSERT INTO feedback (learner_name, learner_emp_id,course_name,is_content_relevant,is_relevant_content_hands_on,proficiency_level,rating_of_content,rating_of_hands_on,comments) VALUES
  ('Mohit',  '856257','Java 1','Yes','Yes','Medium','5','4','Very Interesting code 1'),
  ('Sachin', '856256','Java 3','Yes','Yes','Medium','5','4','Very Interesting code 3'),
  ('Rashmi', '856258','Java 4','Yes','Yes','Medium','5','4','Very Interesting code 4');