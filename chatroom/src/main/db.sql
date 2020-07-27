create database chatroom;

use chatroom;

drop table if exists user;
create table user (
--     自增的写法auto_increment
    userId int primary key auto_increment,
--     用户名登录时使用的名字，不可以重复的写法(相当于qq号)
    name varchar (50) unique ,

    password varchar (50),
--     登录完毕后界面上显示的昵称(昵称随便改)
    nickName varchar (50),
--     上次的登录退出时间，用来实现历史记录
    lastLogout datetime
);

drop table if exists channel;
create table channel(
    channelId int primary key auto_increment,
    channelName varchar (50)
);

drop table if exists message;
create table message(
    messageId int primary key auto_increment,
    --  谁发送的消息
    userId int,

    channel int,

    -- 消息正文
    content text,

    -- 消息的发送时间
    sendTime datetime
);