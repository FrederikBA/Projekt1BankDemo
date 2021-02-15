create database ebberoedbank;

create table customers(
customerID int not null primary key auto_increment,
customerName varchar(255) not null
);


/*INSERT STATEMENTS */
INSERT INTO customers(customerID,customerName) VALUES (?,?);

/*SELECT STATEMENTS */
SELECT * FROM customers;

