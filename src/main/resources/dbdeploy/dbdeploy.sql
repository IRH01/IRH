
-- START CHANGE SCRIPT #20141120174701: 20141120174701_new_change_script.sql

CREATE TABLE FOO (
FOO_ID INTEGER NOT NULL ,FOO_VALUE VARCHAR(30) ); 


INSERT INTO changelog (change_number, complete_dt, applied_by, description)
 VALUES (20141120174701, CURRENT_TIMESTAMP, USER(), '20141120174701_new_change_script.sql');

COMMIT;

-- END CHANGE SCRIPT #20141120174701: 20141120174701_new_change_script.sql


-- START CHANGE SCRIPT #20141120175749: 20141120175749_new_change_script.sql

DROP TABLE FOO;


INSERT INTO changelog (change_number, complete_dt, applied_by, description)
 VALUES (20141120175749, CURRENT_TIMESTAMP, USER(), '20141120175749_new_change_script.sql');

COMMIT;

-- END CHANGE SCRIPT #20141120175749: 20141120175749_new_change_script.sql


-- START CHANGE SCRIPT #20141121103648: 20141121103648_new_change_script.sql



INSERT INTO changelog (change_number, complete_dt, applied_by, description)
 VALUES (20141121103648, CURRENT_TIMESTAMP, USER(), '20141121103648_new_change_script.sql');

COMMIT;

-- END CHANGE SCRIPT #20141121103648: 20141121103648_new_change_script.sql

