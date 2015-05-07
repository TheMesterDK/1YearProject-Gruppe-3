Create table cprnummer
(
Cprid int identity primary key,
Cprnummer char(10) unique not null,
)

Create table kunde
(
Navn varchar(100),
Adresse varchar(100),
Telefonnummer varchar(65),
Postnummer char(4),
Email varchar(100),
Kommentarer varchar(250),
Cprid int primary key,
Foreign key (cprid)
References cprnummer (cprid)
on update cascade
on delete cascade,
)

Create table sælger
(
Sælgerid int identity primary key,
navn varchar(100),
)

Create table bil
(
Chassisnummer varchar(100) primary key,
Registreringsnummerr varchar(10),
Pris double,
Model varchar(100),
Årgang char(4),
Bemærkninger varchar(250),
)

Create table finansieringsaftale
(
Aftaleid int identity primary key,
Beløb double,
Udbetaling double,
Rente double,
Afviklingsperiode int,
Oprettelsestidspunkt timestamp,
Sælgerid int,
Foreign key (sælgerid)
References sælger (sælgerid),
Chassisnummer varchar(100),
Foreign key (chassisnummer)
References bil (chassisnummer)
on update cascade
on delete cascade,
Cprid int,
Foreign key (cprid)
References cprnummer (cprid)
on update cascade
on delete cascade,

)