
USE music;
drop table album;
drop table recordingGroup;
drop table recordingStudio;

CREATE TABLE recordingGroup(
    groupName   VARCHAR(30) NOT NULL,
    leadSinger  VARCHAR(20) NOT NULL,
    yearFormed  VARCHAR(20) NOT NULL,
    genre       VARCHAR(20) NOT NULL,
    CONSTRAINT pk_groupName PRIMARY KEY (groupName)
);


CREATE TABLE recordingStudio(
    sName 	VARCHAR(30) NOT NULL,
    sAddr 	VARCHAR(50) NOT NULL,
    sOwner	VARCHAR(20) NOT NULL,
    sPhone	VARCHAR(20) NOT NULL,
    CONSTRAINT pk_sName PRIMARY KEY (sName)
);


CREATE TABLE album(
    albumTitle  VARCHAR(30) NOT NULL,
    groupName 	VARCHAR(30) NOT NULL,
    studioName	VARCHAR(30) NOT NULL,
    dateR       VARCHAR(20) NOT NULL,
    aLength      VARCHAR(20) NOT NULL,
    numSongs    VARCHAR(20) NOT NULL,
    CONSTRAINT fk_groupName   FOREIGN KEY (groupName ) 
        REFERENCES recordingGroup (groupName),
    CONSTRAINT fk_studioName  FOREIGN KEY (studioName )
        REFERENCES  recordingStudio(sName),
    CONSTRAINT pk_ PRIMARY KEY (albumTitle, groupName)
);


insert into recordingGroup values('Metallica', 'James Hetfield', '1981', 'Rock');
insert into recordingGroup values('Green Day', 'Billie Joe', '1992', 'Rock');
insert into recordingGroup values('Red Hot Chilli Peppers', 'Anthony Kiedis', '1983', 'Rock');
insert into recordingGroup values('Smashing Punkins', 'Billy Corgan', '1995', 'Rock');
insert into recordingGroup values('Weezer', 'Rivers Cuomo', '1994', 'Rock');
insert into recordingGroup values('Korn', 'Jonathan Davis', '1993', 'Rock');
insert into recordingGroup values('Perl Jam', 'Eddie Vedder', '1990', 'Rock');
insert into recordingGroup values('Misfits', 'Glenn Danzig', '1977', 'Punk Rock');
insert into recordingGroup values('Blink-182', 'Mark Hoppus', '1992', 'Skate Punk');


insert into recordingStudio values('EastWest Studio', '7265 Santa Monica Blvd, Hollywood CA, 45124','Archer Val', '213-412-3323');
insert into recordingStudio values('Melly Studio', '265 Florence Blvd, Bell CA, 90210','Mel Holly', '310-393-2323');
insert into recordingStudio values('Gillian Studio', '578 Belmont Ave, Vermont CA, 94250','Art Leo', '530-987-2323');
insert into recordingStudio values('Kobe Arts', '592 Nance Blvd, Los Angeles CA, 90210','Holly Holms', '710-373-5323');
insert into recordingStudio values('Record Plant', '1032 N Sycamore Ave Los Angeles CA, 92343', 'Marcus Miller', '323-993-9300'); 
insert into recordingStudio values('Sunset Sound', '6650 Sunset Blvd Los Angeles CA, 98451', 'Bill Burr', '323-472-9962');
insert into recordingStudio values('Punk Records', '323 Rock Ave Seattle WA, 54513', 'Rocky Rocker', '667-661-5535');

insert into album values('Kerplunk', 'Green Day', 'Kobe Arts', 'January 17,1991', '33', '12');
insert into album values('Dookie', 'Green Day', 'Kobe Arts', 'February 01, 1994','45', '15');
insert into album values('Insomniac', 'Green Day', 'Gillian Studio', 'October 10, 1995', '43', '14');
insert into album values('Kill''Em All', 'Metallica', 'Melly Studio', 'July 25, 1983', '52', '10');
insert into album values('Californication', 'Red Hot Chilli Peppers', 'Record Plant', 'June 7, 1999', '53', '15');
insert into album values('Mellon Collie and the Infinite', 'Smashing Punkins', 'Sunset Sound', 'October 23, 1995', '74', '18');
insert into album values('Weezer', 'Weezer', 'EastWest Studio', 'May 10, 1994', '57', '10');
insert into album values('Follow the Leader', 'Korn', 'Punk Records', 'August 18, 1998', '65', '14');
insert into album values('Ten', 'Perl Jam', 'Sunset Sound', 'August 27, 1991', '62', '11');
insert into album values('Static Age', 'Misfits', 'Punk Records', 'February 27, 1996', '46', '14');
insert into album values('Dude Ranch', 'Blink-182', 'Punk Records', 'June 17, 1997', '53','16');














