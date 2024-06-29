-- 汇率表
-- ID
-- Long
-- String
-- 货币
-- 汇率
-- BigDecimal
drop table if exists currency;
create table currency (
    id bigint unsigned not null auto_increment primary key,
    is_deleted tinyint(1) not null default 0,
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp,
    name varchar(255) not null default '',
    rate decimal(19, 2) not null default 0
);


