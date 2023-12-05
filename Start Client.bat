@ECHO OFF
TITLE Clue Game Client
ECHO Starting the Client...
java -cp .;mysql-connector-java-5.1.40-bin.jar;ocsf.jar client.ClientGUI
PAUSE