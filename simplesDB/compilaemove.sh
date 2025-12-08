#!/bin/bash 
mvn package && mv ./target/simplesDB-1.0-SNAPSHOT.jar ./target/simplesDB.jar && mv -f ./target/simplesDB.jar ../backend/src/main/resources/
