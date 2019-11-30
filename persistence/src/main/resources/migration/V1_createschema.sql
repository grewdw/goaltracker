CREATE SCHEMA goaltracker;

USE goaltracker;

CREATE TABLE activity (
  id bigint(20) auto_increment,
  name varchar(255),
  primary key (id));

CREATE TABLE activity_record (
  id bigint(20) auto_increment,
  end datetime,
  start datetime,
  activity_id bigint(20),
  primary key (id));

CREATE TABLE task(
  id bigint(20) auto_increment,
  name varchar(255),
  primary key (id));

CREATE TABLE task_record(
  id bigint(20) auto_increment,
  count int(11),
  time datetime,
  task_id bigint(20),
  primary key (id));

CREATE TABLE task_target(
  id bigint(20) auto_increment,
  count int(11),
  current bit(1),
  direction int(11),
  period int(11),
  task_id bigint(20),
  primary key (id));