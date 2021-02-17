create database ebberoedbank;

drop table customers;
create table customers(
customerID int not null primary key auto_increment,
customerName varchar(255) not null,
customerEmail varchar(255) not null
);

drop table accounts;
create table accounts(
accountID int not null primary key auto_increment,
balance int not null
);

drop table transactions;
create table transactions(
transactionID int not null primary key auto_increment,
customerID int,
amount int not null,
transactionTime varchar(255) not null
);

/*INSERT STATEMENTS */
INSERT INTO customers(customerID,customerName,customerEmail) VALUES (?,?,?);
INSERT INTO transactions(transactionID,customerID,amount) VALUES (?,?,?);

/*SELECT STATEMENTS */
SELECT * FROM customers;
SELECT * FROM accounts;
SELECT * FROM transactions;
SELECT t.transactionID, t.customerID, c.customerName, c.customerEmail, t.amount
FROM transactions t, customers c
WHERE c.customerID = t.customerID;


