@echo off
mvn install:install-file -DgroupId=mfis.tiendavirtual -DartifactId=negocio -Dversion=0.1.0 -Dpackaging=jar -Dfile=NegocioEJB.jar
