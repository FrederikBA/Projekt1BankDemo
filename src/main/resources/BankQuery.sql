create database ebberoedbank;

drop table customers;
create table customers(
customerID int not null primary key auto_increment,
customerName varchar(255) not null
);

drop table accounts;
create table accounts(
accountID int not null primary key auto_increment,
balance int not null
);

drop table transactions;
create table transactions(
transactionID int not null primary key auto_increment,
amount int not null
);


/*INSERT STATEMENTS */
INSERT INTO customers(customerID,customerName) VALUES (?,?);

/*SELECT STATEMENTS */
SELECT * FROM customers;

