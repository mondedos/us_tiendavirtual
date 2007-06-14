@echo off
mvn install:install-file -DgroupId=jboss -DartifactId=jbossall-client -Dversion=4.2.0 -Dpackaging=jar -Dfile=jbossall-client.jar
