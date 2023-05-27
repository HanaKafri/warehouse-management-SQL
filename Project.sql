create database Project;
use Project;

create table company(
CoID int primary key auto_increment, 
Coname varchar(32),
country varchar(32),
city varchar(32),
address text,
Ccontact_person text,
email text,
phone_number text);

create table shipping_company(
SID int primary key auto_increment,
SCname varchar(32),
country varchar(32),
phone_number text,
email text,
SCcontact_person text);

create table Customer(
CuID int primary key auto_increment,
Cname varchar(32),
phone_number text,
Address text,
CuType varchar(32),
FirstSaleDate date);

create table health_permit (
HID int primary key,
date_of_issue date,
expire_date date);

create table measurement_unit (
MuID int primary key auto_increment,
Mname varchar (10));

create table packaging_type (
PaID int primary key auto_increment,
Pname varchar (10));

create table brand (
BID int primary key auto_increment,
CoID int not null,
Bname varchar(32),
foreign key (CoID) references company (CoID));

create table Batch(
Baid varChar(20) primary key,
CoID int not null,
SID int not null,
size int,
customer_broker text,
arrival_date date,
foreign key (CoID) references company (CoID),
foreign key (SID) references shipping_company (SID));

create table product (
PrID int primary key auto_increment,
Pname varchar (32),
Brid int,
barcode text,
description varchar (32),
size int,
MuID int not null,
PaID int not null,
HID int not null,
number_of_units int,
HS_code text,
custom_tax_tariff text,
foreign key (Brid) references  brand (Bid),
foreign key (MuID) references  measurement_unit (MuID),
foreign key (PaID) references packaging_type (PaID),
foreign key (HID) references health_permit (HID));

create table sales(
billID int primary key,
CuID int,
prID int,
number_of_units_soled int,
CarType varchar (32),
saleDate date,
foreign key (CuID) references  Customer (CuID),
foreign key (prID) references  product (PrID));

create table batch_content(
baid varchar(20),
prID int,
number_of_units int,
production_date date,
expiry_date date,
primary key(baid, prID),
foreign key (prID) references  product (PrID),
foreign key (baid) references  Batch (Baid));

select p.Pname, b.baid, c.Coname,
				b.arrival_date, bc.number_of_units, bc.production_date, bc.expiry_date,
				p.barcode, p.description, p.size, p.HS_code, p.custom_tax_tariff,
				m.Mname, pa.Pname, h.date_of_issue, h.expire_date
				from batch_content bc, Batch b, company c, shipping_company s,
				product p, measurement_unit m, packaging_type pa, health_permit h where bc.baid = b.Baid
				and bc.prID = p.PrID and p.MuID = m.MuID and p.PaID = pa.PaID
				and p.HID = h.HID and b.CoID = c.CoID and b.SID = s.SID;