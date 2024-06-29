# 账户
# ID
# Long
# String
# String
# 名称
# 类型
# 余额
# BigDecimal
# Long
# 货币
# 人民币余额
# BigDecimal

drop table if exists account;
create table account (
    id bigint unsigned not null auto_increment primary key,
    is_deleted tinyint(1) not null default 0,
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp,

    name varchar(255) not null default '',
    type varchar(255) not null default '',
    balance decimal(19, 2) not null default 0,
    currency_id bigint unsigned not null default 0,
    cny_balance decimal(19, 2) not null default 0
);
