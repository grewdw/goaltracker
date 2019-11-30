CREATE SCHEMA goaltracker;

CREATE TABLE activity (
  id bigint(20),
  name varchar(255));

CREATE TABLE activity_record (
  id bigint(20),
  end datetime,
  start datetime,
  activity_id bigint(20));

CREATE TABLE task(
  id bigint(20),
  name varchar(255));

CREATE TABLE task_record(
  id bigint(20),
  count int(11),
  time datetime,
  task_id bigint(20));

CREATE TABLE task_target(
  id bigint(20),
  count int(11)
  current bit(1)
  direction int(11)
  period int(11)
  task_id bigint(20));

CREATE TABLE hibernate_sequence(
  next_val bigint(20))
