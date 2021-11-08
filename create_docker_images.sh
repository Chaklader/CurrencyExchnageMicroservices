#!/bin/sh



start=`date +%s`

cd CurrencyExchangeService		
mvn spring-boot:build-image -DskipTests
echo "api-gateway docker image is created ..."
cd ..

sleep 5

cd CurrencyConversionService	
mvn spring-boot:build-image -DskipTests
echo "api-gateway docker image is created ..."
cd ..

sleep 5

cd ApiGateway			
mvn spring-boot:build-image -DskipTests
echo "api-gateway docker image is created ..."
cd ..

sleep 5

cd NamingServer			
mvn spring-boot:build-image -DskipTests
echo "api-gateway docker image is created ..."
cd ..

sleep 5

cd SpringCloudConfigServer		
mvn spring-boot:build-image -DskipTests
echo "api-gateway docker image is created ..."
cd ..

sleep 5


end=`date +%s`
runtime=$((end-start))

echo "ALL the required docker images for the micro-service architecture is created and total time consumed " $runtime "sec"
