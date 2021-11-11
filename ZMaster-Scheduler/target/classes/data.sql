INSERT INTO BATCH_JOBS values (1,'Sample Job1','Incoming',5.3,'Not ReRan','Remote Location');
INSERT INTO BATCH_JOBS values (2,'Sample Job2','OutGoing',5.3,'ReRan','Came From MQ');
INSERT INTO BATCH_JOBS values (3,'Sample Job3','Incoming',5.2,'Not ReRan','Remote Location');
INSERT INTO BATCH_JOBS values (4,'Sample Job4','OutGoing',5.4,'ReRan','Came From MQ');



Hibernate: create table batch_history (id uuid not null, batch_window varchar(50), job_name varchar(50), job_status varchar(20), manual_trigger_details varchar(50), time_run timestamp, primary key (id))
Hibernate: create table batch_jobs (id uuid not null, directions varchar(30), file_location varchar(70), job_name varchar(30), rerun_details varchar(30), scheme_name varchar(30), spring_details varchar(20), primary key (id))
Hibernate: create table batch_schedule (id uuid not null, day_of_week date, job_name varchar(50), time_of_day timestamp, primary key (id))
Hibernate: create table schemes (id int4 not null, scheme_description varchar(70), scheme_name varchar(20), primary key (id))
Hibernate: alter table if exists schemes drop constraint if exists UK_r6evjvx00wdgo4n6nshogwd59

new
Hibernate: create table batch_jobs (id uuid not null, directions varchar(30), file_location varchar(70), job_name varchar(30), rerun_details varchar(30), scheme_name varchar(30), spring_details varchar(20), primary key (id))
Hibernate: create table batch_schedule (id int4 not null, cron_expression varchar(50), day_of_week timestamp, job_name varchar(50), time_of_day timestamp, primary key (id))
Hibernate: create sequence hibernate_sequence start 1 increment 1








