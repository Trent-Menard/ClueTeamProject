
CREATE TABLE ClueAccounts (
    ID INT AUTO_INCREMENT,
    username VARCHAR(25),
    password VARBINARY(16),
    PRIMARY KEY(ID),
    UNIQUE KEY username_unique (username)
);