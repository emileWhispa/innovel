# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cashin (
  id                        bigint auto_increment not null,
  fromu                     varchar(255),
  amount                    integer,
  motif                     varchar(255),
  receipt                   varchar(255),
  doneby_id                 bigint,
  date                      varchar(255),
  delete_status             varchar(255),
  constraint pk_cashin primary key (id))
;

create table cashout (
  id                        bigint auto_increment not null,
  sendto                    varchar(255),
  amount                    integer,
  motif                     varchar(255),
  upload                    varchar(255),
  doneby_id                 bigint,
  date                      varchar(255),
  delete_status             varchar(255),
  constraint pk_cashout primary key (id))
;

create table covered (
  id                        bigint auto_increment not null,
  amount                    integer,
  debt_id                   bigint,
  date                      varchar(255),
  delete_status             varchar(255),
  constraint pk_covered primary key (id))
;

create table debts (
  id                        bigint auto_increment not null,
  fromu                     varchar(255),
  amount                    integer,
  motif                     varchar(255),
  doneby_id                 bigint,
  date                      varchar(255),
  delete_status             varchar(255),
  constraint pk_debts primary key (id))
;

create table department (
  id                        bigint auto_increment not null,
  department_name           varchar(255),
  department_details        varchar(255),
  department_logo           varchar(255),
  delete_status             varchar(255),
  constraint pk_department primary key (id))
;

create table details (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  delete_status             varchar(255),
  content                   varchar(255),
  project_id                bigint,
  constraint pk_details primary key (id))
;

create table forums (
  id                        bigint auto_increment not null,
  forum_name                varchar(255),
  admin_id                  bigint,
  time                      varchar(255),
  delete_status             varchar(255),
  constraint pk_forums primary key (id))
;

create table members (
  id                        bigint auto_increment not null,
  member_id                 bigint,
  forum_id                  bigint,
  date                      varchar(255),
  delete_status             varchar(255),
  constraint pk_members primary key (id))
;

create table messages (
  id                        bigint auto_increment not null,
  message                   varchar(255),
  delete_status             varchar(255),
  status                    varchar(255),
  sendto_id                 bigint,
  fromu_id                  bigint,
  type                      varchar(255),
  constraint pk_messages primary key (id))
;

create table owned (
  id                        bigint auto_increment not null,
  delete_status             varchar(255),
  owner_id                  bigint,
  project_id                bigint,
  constraint pk_owned primary key (id))
;

create table payed (
  id                        bigint auto_increment not null,
  amount                    integer,
  sent_id                   bigint,
  date                      varchar(255),
  delete_status             varchar(255),
  constraint pk_payed primary key (id))
;

create table projects (
  id                        bigint auto_increment not null,
  project_name              varchar(255),
  developer_id              bigint,
  project_link              varchar(255),
  project_logo              varchar(255),
  delete_status             varchar(255),
  done                      integer,
  depart_id                 bigint,
  constraint pk_projects primary key (id))
;

create table sent_debts (
  id                        bigint auto_increment not null,
  sendto                    varchar(255),
  amount                    integer,
  motif                     varchar(255),
  doneby_id                 bigint,
  date                      varchar(255),
  delete_status             varchar(255),
  constraint pk_sent_debts primary key (id))
;

create table subtasks (
  id                        bigint auto_increment not null,
  sub_name                  varchar(255),
  sub_detail                varchar(255),
  complete                  integer,
  delete_status             varchar(255),
  task_id                   bigint,
  constraint pk_subtasks primary key (id))
;

create table tasks (
  id                        bigint auto_increment not null,
  task_name                 varchar(255),
  complete                  integer,
  owner_id                  bigint,
  proj_id                   bigint,
  delete_status             varchar(255),
  constraint pk_tasks primary key (id))
;

create table users (
  id                        bigint auto_increment not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  role                      varchar(255),
  phone                     varchar(255),
  dob                       varchar(255),
  age                       varchar(255),
  email                     varchar(255),
  photo                     varchar(255),
  username                  varchar(255),
  password                  varchar(255),
  delete_status             tinyint(1) default 0,
  delete_reason             varchar(255),
  done_by                   varchar(255),
  constraint pk_users primary key (id))
;

alter table cashin add constraint fk_cashin_doneby_1 foreign key (doneby_id) references users (id) on delete restrict on update restrict;
create index ix_cashin_doneby_1 on cashin (doneby_id);
alter table cashout add constraint fk_cashout_doneby_2 foreign key (doneby_id) references users (id) on delete restrict on update restrict;
create index ix_cashout_doneby_2 on cashout (doneby_id);
alter table covered add constraint fk_covered_debt_3 foreign key (debt_id) references debts (id) on delete restrict on update restrict;
create index ix_covered_debt_3 on covered (debt_id);
alter table debts add constraint fk_debts_doneby_4 foreign key (doneby_id) references users (id) on delete restrict on update restrict;
create index ix_debts_doneby_4 on debts (doneby_id);
alter table details add constraint fk_details_project_5 foreign key (project_id) references projects (id) on delete restrict on update restrict;
create index ix_details_project_5 on details (project_id);
alter table forums add constraint fk_forums_admin_6 foreign key (admin_id) references users (id) on delete restrict on update restrict;
create index ix_forums_admin_6 on forums (admin_id);
alter table members add constraint fk_members_member_7 foreign key (member_id) references users (id) on delete restrict on update restrict;
create index ix_members_member_7 on members (member_id);
alter table members add constraint fk_members_forum_8 foreign key (forum_id) references forums (id) on delete restrict on update restrict;
create index ix_members_forum_8 on members (forum_id);
alter table messages add constraint fk_messages_sendto_9 foreign key (sendto_id) references users (id) on delete restrict on update restrict;
create index ix_messages_sendto_9 on messages (sendto_id);
alter table messages add constraint fk_messages_fromu_10 foreign key (fromu_id) references users (id) on delete restrict on update restrict;
create index ix_messages_fromu_10 on messages (fromu_id);
alter table owned add constraint fk_owned_owner_11 foreign key (owner_id) references users (id) on delete restrict on update restrict;
create index ix_owned_owner_11 on owned (owner_id);
alter table owned add constraint fk_owned_project_12 foreign key (project_id) references projects (id) on delete restrict on update restrict;
create index ix_owned_project_12 on owned (project_id);
alter table payed add constraint fk_payed_sent_13 foreign key (sent_id) references sent_debts (id) on delete restrict on update restrict;
create index ix_payed_sent_13 on payed (sent_id);
alter table projects add constraint fk_projects_developer_14 foreign key (developer_id) references users (id) on delete restrict on update restrict;
create index ix_projects_developer_14 on projects (developer_id);
alter table projects add constraint fk_projects_depart_15 foreign key (depart_id) references department (id) on delete restrict on update restrict;
create index ix_projects_depart_15 on projects (depart_id);
alter table sent_debts add constraint fk_sent_debts_doneby_16 foreign key (doneby_id) references users (id) on delete restrict on update restrict;
create index ix_sent_debts_doneby_16 on sent_debts (doneby_id);
alter table subtasks add constraint fk_subtasks_task_17 foreign key (task_id) references tasks (id) on delete restrict on update restrict;
create index ix_subtasks_task_17 on subtasks (task_id);
alter table tasks add constraint fk_tasks_owner_18 foreign key (owner_id) references users (id) on delete restrict on update restrict;
create index ix_tasks_owner_18 on tasks (owner_id);
alter table tasks add constraint fk_tasks_proj_19 foreign key (proj_id) references projects (id) on delete restrict on update restrict;
create index ix_tasks_proj_19 on tasks (proj_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table cashin;

drop table cashout;

drop table covered;

drop table debts;

drop table department;

drop table details;

drop table forums;

drop table members;

drop table messages;

drop table owned;

drop table payed;

drop table projects;

drop table sent_debts;

drop table subtasks;

drop table tasks;

drop table users;

SET FOREIGN_KEY_CHECKS=1;

