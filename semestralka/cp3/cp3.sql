/*DROP TABLE IF EXISTS Library;*/

CREATE TABLE Library(
    name VARCHAR(180) NOT NULL PRIMARY KEY,
    capacity INTEGER
);

CREATE TABLE AddressLibrary(
    library VARCHAR(180) REFERENCES Library(name) ON UPDATE CASCADE ON DELETE CASCADE,
    street VARCHAR(100) NOT NULL,
    postalCode CHAR(6),
    PRIMARY KEY(library, street, postalCode)
);

CREATE TABLE Book(
    number INTEGER PRIMARY KEY,
    state VARCHAR(60) NOT NULL,
    category VARCHAR(80) NOT NULL,
    title VARCHAR(180) NOT NULL
);

CREATE TABLE Has(
    library VARCHAR(180) PRIMARY KEY REFERENCES Library(name) ON UPDATE CASCADE ON DELETE CASCADE,
    book INTEGER PRIMARY KEY REFERENCES Book(number) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Publisher(
    publicationID INTEGER NOT NULL PRIMARY KEY,
    yearOfPublication VARCHAR(10) NOT NULL,
    publishes VARCHAR(180) NOT NULL REFERENCES Book(number) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Reader(
    ID INTEGER PRIMARY KEY,
    name VARCHAR(180) NOT NULL,
    mail VARHCAR(50),
    address VARCHAR(100) NOT NULL,
    numberOfBooksAvailabel INTEGER NOT NULL,

    PRIMARY KEY(name, mail, address)
);

CREATE TABLE Student(
    ID INTEGER NOT NULL PRIMARY KEY REFERENCES Reader(ID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Teacher(
    ID INTEGER NOT NULL PRIMARY KEY REFERENCES Reader(ID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE NameReader(
    reader INTEGER NOT NULL REFERENCES Reader(ID) ON UPDATE CASCADE ON DELETE CASCADE,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100) NOT NULL,
    PRIMARY KEY(reader, firstName, lastName)
);

CREATE TABLE AddressUser(
    reader INTEGER NOT NULL REFERENCES Reader(ID) ON UPDATE CASCADE ON DELETE CASCADE,
    street VARCHAR(100) NOT NULL,
    postalCode VARCHAR(6) NOT NULL,

    PRIMARY KEY(reader, street, postalCode)
);

CREATE TABLE Penalty(
    reader INTEGER NOT NULL PRIMARY KEY REFERENCES Reader(ID) ON UPDATE CASCADE ON DELETE CASCADE,
    penalize INTEGER REFERENCES Reader(ID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Staff(
    ID INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    reader INTEGER NOT NULL REFERENCES Reader(ID) ON UPDATE CASCADE ON DELETE CASCADE,
    book INTEGER REFERENCES Book(ID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Reservation(
    numberOfReservation INTEGER PRIMARY KEY,
    reserveDate VARCHAR(10),
    returnDate VARCHAR(10)
);

CREATE TABLE Reserve(
    reader INTEGER NOT NULL REFERENCES Reader(ID) ON UPDATE CASCADE ON DELETE CASCADE,
    book INTEGER NOT NULL REFERENCES Book(ID) ON UPDATE CASCADE ON DELETE CASCADE,
    resevation INTEGER NOT NULL REFERENCES Reservation(numberOfReservation) ON UPDATE CASCADE ON DELETE CASCADE

    PRIMARY KEY(reader, book, reservation)
);