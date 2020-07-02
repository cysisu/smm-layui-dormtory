DROP DATABASE IF EXISTS hejianjie;
CREATE DATABASE hejianjie DEFAULT CHARACTER SET utf8;
USE hejianjie;
CREATE TABLE roomorder(
    orderid int(8) NOT NULL AUTO_INCREMENT,
    roomnumber char(6) NOT NULL,
    identityid char(18) NOT NULL,
    workid char(10),
    status char(10),
    intime datetime DEFAULT NULL,
    predicttime datetime DEFAULT NULL,
    days int(8),
    price int(8),
    totalMoney int(8),
    label  char(200),
    outtime datetime DEFAULT NULL,
    PRIMARY KEY (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `roomorder`(`orderid`,`roomnumber`,`identityid`,`workid`,`status`,`intime`,`predicttime`,`days`,`price`,`totalMoney`,`label`,`outtime`) values(00000001,'3-223','500231199706154789','10001','booked','2020-6-30 21:28','2020-6-30 12:00',1,80,null,null,'2020-6-30 9:23');

use hejianjie;
create table manager(
    nickName char (20) not null,
    password char(20) not null,
    primary key (nickName)
);
insert into manager (nickName,password) values ('201835010609','201835010609');

use hejianjie;
create table customer(
	identityId char(20) not null,
    name char(20),
    sex char(20),
    phone char(20),
    primary key (identityId)
);
insert into customer(identityId,name,sex,phone) values ('500231199706154789','何杰健','男','17776342344');