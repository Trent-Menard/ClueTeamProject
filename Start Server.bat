@ECHO OFF
TITLE Clue Game Server
ECHO Starting the Server...
java -cp .;mysql-connector-java-5.1.40-bin.jar;ocsf.jar server.ServerGUI
PAUSE