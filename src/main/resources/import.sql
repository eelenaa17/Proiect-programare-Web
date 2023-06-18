insert into utilizator (first_name,last_name,cnp,phone) values ( 'Ionut', 'Pop', 1850517140, 471234567);
insert into utilizator (first_name,last_name,cnp,phone) values ( 'Florin', 'Mihai', 1950517140, 471234567);

insert into autor (nume,prenume) values ('Eminescu','Mihai');
insert into autor (nume,prenume) values ('Sadoveanu','Mihail');

insert into categorie (descriere) values ('Poezii');
insert into categorie (descriere)  values ('Povesti');

insert into book (idau, book_name, year,idca) values (1,'Fat-Frumos din lacrima',1870,2);
insert into book (idau, book_name, year,idca) values (1,'Legenda Luceafarului',2008,1);
insert into book (idau, book_name, year,idca) values (1,'Poezie',2014,1);

insert into book (idau, book_name, year,idca) values (2,'Dumbrava minunata',2013,2);
insert into book (idau, book_name, year,idca) values (2,'Baltagul',2013,2);
insert into book (idau, book_name, year,idca) values (2,'Fratii Jderi',2014,2);

INSERT INTO rezervari (datastart, datastop, idc, idu) VALUES (current_date, date_add(current_date, interval 1 DAY), 1, 1);

insert into lectura (denumire, perioada, idc, idu,datasala) values ('Sala 1',3,1,1,current_date);