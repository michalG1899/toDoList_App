create table todos (
    id int unsigned primary key auto_increment,
    text varchar(100) not null,
    done bit
);

insert into todos (text, done) values ('Done todo', 1);
insert into todos (text, done) values ('UnDone todo', 0);
-- id:1, text: 'mock 1', done: true