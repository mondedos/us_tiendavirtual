@echo off
mvn -o install:install-file -DgroupId=mfis.tiendavirtual -DartifactId=negocio -Dversion=0.3.0 -Dpackaging=jar -Dfile=NegocioEJB-0.3.0.jar
