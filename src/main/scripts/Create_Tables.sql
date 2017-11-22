CREATE TABLE IF NOT EXISTS Person (
  nConst      VARCHAR(16) NOT NULL,
  primaryName VARCHAR(96) NULL,
  birthYear   INT         NULL,
  deathYear   INT         NULL,
  PRIMARY KEY (nConst),
  INDEX nConst_idx (nConst ASC)
);

CREATE TABLE IF NOT EXISTS Production (
  tConst        VARCHAR(16) NOT NULL,
  titleType     VARCHAR(24) NOT NULL,
  primaryTitle  VARCHAR(64) NULL,
  originalTitle VARCHAR(64) NULL,
  adult         TINYINT(1)  NULL,
  startYear     INT         NULL,
  endYear       INT         NULL,
  runtime       FLOAT       NULL,
  PRIMARY KEY (tConst),
  INDEX tConst_idx (tConst ASC)
);

CREATE TABLE IF NOT EXISTS Episode (
  tConst        VARCHAR(16) NOT NULL,
  parentTConst  VARCHAR(16) NOT NULL,
  seasonNumber  INT         NULL,
  episodeNumber INT         NULL,
  PRIMARY KEY (tConst),
  INDEX tConst_idx (parentTConst ASC),
  CONSTRAINT EpisodeFK1 FOREIGN KEY (tConst)
  REFERENCES Production (tConst)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT EpisodeFK2 FOREIGN KEY (parentTConst)
  REFERENCES Production (tConst)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
);


CREATE TABLE IF NOT EXISTS Known_For (
  nConst VARCHAR(16) NOT NULL,
  tConst VARCHAR(16) NOT NULL,
  PRIMARY KEY (nConst, tConst),
  INDEX nConst_idx (nConst ASC),
  CONSTRAINT Known_ForFK1 FOREIGN KEY (nConst)
  REFERENCES Person (nConst)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT Known_ForFK2 FOREIGN KEY (tConst)
  REFERENCES Production (tConst)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS Acts_In (
  nConst VARCHAR(16) NOT NULL,
  tConst VARCHAR(16) NOT NULL,
  PRIMARY KEY (nConst, tConst),
  INDEX tConst_idx (tConst ASC),
  CONSTRAINT Acts_InFK1 FOREIGN KEY (nConst)
  REFERENCES Person (nConst)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT Acts_InFK2 FOREIGN KEY (tConst)
  REFERENCES Production (tConst)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS Directs (
  nConst VARCHAR(16) NOT NULL,
  tConst VARCHAR(16) NOT NULL,
  PRIMARY KEY (nConst, tConst),
  INDEX tConst_idx (tConst ASC),
  CONSTRAINT DirectsFK1 FOREIGN KEY (nConst)
  REFERENCES Person (nConst)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT tConstDirectsFK FOREIGN KEY (tConst)
  REFERENCES Production (tConst)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS Writes (
  nConst VARCHAR(16) NOT NULL,
  tConst VARCHAR(16) NOT NULL,
  PRIMARY KEY (nConst, tConst),
  INDEX tConst_idx (tConst ASC),
  CONSTRAINT WritesFK1 FOREIGN KEY (nConst)
  REFERENCES Person (nConst)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT WritesFK2 FOREIGN KEY (tConst)
  REFERENCES Production (tConst)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS Primary_Profession (
  nConst     VARCHAR(16) NOT NULL,
  profession VARCHAR(32) NOT NULL,
  PRIMARY KEY (nConst, profession),
  INDEX nConst_idx (nConst ASC),
  CONSTRAINT Primary_ProfessionFK1 FOREIGN KEY (nConst)
  REFERENCES Person (nConst)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS Genre (
  tConst VARCHAR(16) NOT NULL,
  genre  VARCHAR(16) NOT NULL,
  PRIMARY KEY (tConst, genre),
  INDEX tConst_idx (tConst ASC),
  CONSTRAINT GenreFK1 FOREIGN KEY (tConst)
  REFERENCES Production (tConst)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS Ratings (
  tConst        VARCHAR(16) NOT NULL,
  averageRating FLOAT       NULL,
  numVotes      INT         NULL,
  PRIMARY KEY (tConst),
  INDEX tConst_idx (tConst ASC),
  CONSTRAINT RatingsFK1 FOREIGN KEY (tConst)
  REFERENCES Production (tConst)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS Finances (
  tConst  VARCHAR(16) NOT NULL,
  budget  FLOAT       NULL,
  revenue FLOAT       NULL,
  PRIMARY KEY (tConst),
  INDEX tConst_idx (tConst ASC),
  CONSTRAINT FinancesFK1 FOREIGN KEY (tConst)
  REFERENCES Production (tConst)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

SELECT COUNT(*) FROM Production;
SELECT COUNT(*) FROM Person;
SELECT COUNT(*) FROM Episode;
SELECT COUNT(*) FROM Known_For;
SELECT COUNT(*) FROM Acts_In;
SELECT COUNT(*) FROM Directs;
SELECT COUNT(*) FROM Writes;
SELECT COUNT(*) FROM Primary_Profession;
SELECT COUNT(*) FROM Genre;
SELECT COUNT(*) FROM Ratings;
SELECT COUNT(*) FROM Finances;