create table Member
(
    id int auto_increment,
    email varchar(20) not null,
    nickname varchar(20) not null,
    birthday date not null,
    createdAt datetime not null,
    constraint member_id_uindex
        primary key (id)
);

create table MemberNicknameHistory
(
    id int auto_increment,
    memberId int not null,
    nickname varchar(20) not null,
    createdAt datetime not null,
    constraint memberNicknameHistory_id_uindex
        primary key (id)
);

create table Follow
(
    id int auto_increment,
    fromMemberId int not null,
    toMemberId int not null,
    createdAt datetime not null,
    constraint Follow_id_uindex
        primary key (id)
);

create unique index Follow_fromMemberId_toMemberId_uindex
    on Follow (fromMemberId, toMemberId);


create table POST
(
    id int auto_increment,
    memberId int not null,
    contents varchar(100) not null,
    createdDate date not null,
    createdAt datetime not null,
    constraint POST_id_uindex
        primary key (id)
);

create index POST__index_member_id
    on POST (memberId);

create index POST__index_created_date
    on POST (createdDate);

create index POST__index_member_id_created_date
    on POST (memberId, createdDate);

explain select createdDate, memberId, count(id)
from post use index (POST__index_created_date)
where memberId = 3 and
    createdDate between '1990-01-01' and '2023-01-01';
# group by createdDate, memberId

select memberId, count(id)
from post
group by memberId;

select createdDate, count(id)
from post
group by createdDate
order by 2 desc;

select count(distinct  (createdDate))
from post;

select *
from post
where memberId = 1
order by createdDate desc
limit 2
offset 4;


select *
from POSTwhere memberId=4 and id > 1000;




