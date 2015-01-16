/*==============================================================*/
/* table: system_param                                          */
/*==============================================================*/
--drop table system_param;

create table system_param  (
   id                   varchar(32)                     not null,
   name                 varchar(50)                     not null,
   key                  varchar(50)                     not null,
   value                varchar(200)                    not null,
   readonly             varchar(1)                      not null,
   description          varchar(200),
   primary key (id)
);

comment on column system_param.key is '代码';

comment on column system_param.value is '值';

comment on column system_param.readonly is '只读';

comment on column system_param.description is '描述';

/*==============================================================*/
/* table: call_option                                           */
/*==============================================================*/
--drop table call_option;

create table call_option  (
   id                   varchar(32)                     not null,
   name                 varchar(100)                    not null,
   sort                 int(2),
   path                 varchar(200),
   username             varchar(50),
   password             varchar(50),
   description          varchar(2000),
   primary key (id)
);

comment on column call_option.sort is '顺序';

comment on column call_option.path is '路径';

comment on column call_option.username is '用户名';

comment on column call_option.password is '密码';

comment on column call_option.description is '描述';

/*==============================================================*/
/* table: call_option_detail                                    */
/*==============================================================*/
--drop table call_option_detail;

create table call_option_detail  (
   id                   varchar(32)                     not null,
   option_id            varchar(32)                     not null,
   type                 varchar(20)                     not null,
   x_coords             int(5)                          not null,
   y_coords             int(5)                          not null,
   primary key (id)
);

comment on column call_option_detail.option_id is 'FK';

comment on column call_option_detail.type is '类型';

comment on column call_option_detail.x_coords is 'x坐标';

comment on column call_option_detail.y_coords is 'y坐标';


/*==============================================================*/
/* table: call_total                                           */
/*==============================================================*/
--drop table call_total;

create table call_total  (
   id                   varchar(32)                     not null,
   mobile               varchar(25)                     not null,
   cur_date             varchar(8)                      not null,
   count                int(4)                          not null,
   primary key (id)
);

comment on column call_total.mobile is '号码';

comment on column call_total.cur_date is '日期';

comment on column call_total.count is '次数';

/*==============================================================*/
/* table: call_detail                                           */
/*==============================================================*/
--drop table call_detail;

create table call_detail  (
   id                   varchar(32)                     not null,
   mobile               varchar(25)                     not null,
   cur_date             varchar(8)                      not null,
   cur_time             time                            not null,
   description          varchar(50),
   primary key (id)
);

comment on column call_detail.mobile is '号码';

comment on column call_detail.cur_date is '日期';

comment on column call_detail.cur_time is '时间';

comment on column call_detail.description is '描述';

/*==============================================================*/
/* insert                                                       */
/*==============================================================*/
insert into call_option( id, name, sort, description ) values( 'bd2ba7c0b0fb4548b448089d7e848adb', '微微（uwewe）', 1, '同个号码未接通上限15次' );

insert into call_option_detail( id, option_id, type, x_coords, y_coords ) values( '8402023ffcf24934a7fa6abc2d78f53d', 'bd2ba7c0b0fb4548b448089d7e848adb', 'CALL_TAB', 684, 218 );

insert into call_option_detail( id, option_id, type, x_coords, y_coords ) values( '1244e779796b4ccea09824da4bd31d96', 'bd2ba7c0b0fb4548b448089d7e848adb', 'INPUT_BOX', 684, 388 );

insert into call_option_detail( id, option_id, type, x_coords, y_coords ) values( '50e264f2dcec4f6d96eaee858687bead', 'bd2ba7c0b0fb4548b448089d7e848adb', 'CALL_BUTTON', 684, 600 );

insert into call_option_detail( id, option_id, type, x_coords, y_coords ) values( '30453b87de964424b5894e57060944ff', 'bd2ba7c0b0fb4548b448089d7e848adb', 'HANGUP_BUTTON', 508, 110 );


insert into call_option( id, name, sort, description ) values( '0f0e5d021fde4d49aea78c03999fbd9f', 'YMCALL网络电话（ymcall）', 1, '无上限, 余额0.30' );

insert into call_option_detail( id, option_id, type, x_coords, y_coords ) values( '0dcd575892d247e3af267da0e3072a04', '0f0e5d021fde4d49aea78c03999fbd9f', 'CALL_TAB', 670, 200 );

insert into call_option_detail( id, option_id, type, x_coords, y_coords ) values( 'e644d57efe3c48d593647aa129d822f0', '0f0e5d021fde4d49aea78c03999fbd9f', 'INPUT_BOX', 670, 350 );

insert into call_option_detail( id, option_id, type, x_coords, y_coords ) values( '73f906c184b24d88907f668a199d690a', '0f0e5d021fde4d49aea78c03999fbd9f', 'CALL_BUTTON', 620, 550 );

insert into call_option_detail( id, option_id, type, x_coords, y_coords ) values( 'bfb27c023eb648eb9b495f5422370ec5', '0f0e5d021fde4d49aea78c03999fbd9f', 'HANGUP_BUTTON', 730, 550 );


insert into call_option( id, name, sort, description ) values( '9435895ed8164b0bb6a62558d83e6ba2', 'SKY网络电话（sky）', 1, '无上限, 余额0.60' );

insert into call_option_detail( id, option_id, type, x_coords, y_coords ) values( '82ef58be8ac943d1a8ca3d8d65793ff3', '9435895ed8164b0bb6a62558d83e6ba2', 'CALL_TAB', 600, 210 );

insert into call_option_detail( id, option_id, type, x_coords, y_coords ) values( '27c684314336484cbb12f892de31f0f7', '9435895ed8164b0bb6a62558d83e6ba2', 'INPUT_BOX', 660, 370 );

insert into call_option_detail( id, option_id, type, x_coords, y_coords ) values( '151acce7587a4fd78424809a723206e6', '9435895ed8164b0bb6a62558d83e6ba2', 'CALL_BUTTON', 600, 520 );

insert into call_option_detail( id, option_id, type, x_coords, y_coords ) values( '13cdd4b7a8f44a09860dd0be1397927a', '9435895ed8164b0bb6a62558d83e6ba2', 'HANGUP_BUTTON', 730, 520 );