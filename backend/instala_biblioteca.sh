mvn install:install-file \
   -Dfile=./src/main/resources/simplesDB.jar \
   -DgroupId=simplesDB \
   -DartifactId=simplesDB \
   -Dversion=1.0 \
   -Dpackaging=jar \
   -DgeneratePom=true
