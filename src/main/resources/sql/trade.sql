# 交易
# ID
# Long
# Long
# Long
# 支出账户
# 转入账户
# 人民币金额
# 货币
# BigDecimal
# Long
# 汇率
# BigDecimal
# BigDecimal
# BigDecimal
# 转入货币金额
# 转出货币金额

drop table if exists trade;
create table trade (
    id bigint unsigned not null auto_increment primary key,
    is_deleted tinyint(1) not null default 0,
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp,

    from_account_id bigint unsigned not null default 0,
    to_account_id bigint unsigned not null default 0,
    cny_amount decimal(19, 2) not null default 0,
    from_currency_id bigint unsigned not null default 0,
    to_currency_id bigint unsigned not null default 0,
    from_amount decimal(19, 2) not null default 0,
    from_rate decimal(19, 2) not null default 0,
    to_amount decimal(19, 2) not null default 0,
    to_rate decimal(19, 2) not null default 0
);
