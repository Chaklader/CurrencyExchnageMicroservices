#!/bin/sh


cd CurrencyExchangeService		
mvn spring-boot:build-image -DskipTests
echo "api-gateway docker image is created ..."
cd ..

cd CurrencyConversionService	
mvn spring-boot:build-image -DskipTests
echo "api-gateway docker image is created ..."
cd ..

cd ApiGateway			
mvn spring-boot:build-image -DskipTests
echo "api-gateway docker image is created ..."
cd ..

cd NamingServer			
mvn spring-boot:build-image -DskipTests
echo "api-gateway docker image is created ..."
cd ..

cd SpringCloudConfigServer		
mvn spring-boot:build-image -DskipTests
echo "api-gateway docker image is created ..."
cd ..


echo "ALL the required docker images for the micro-service architecture is created ..."
