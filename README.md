    SPRING CLOUD MICRO-SERVICES



    http://localhost:8000/currency-exchange/from/AUD/to/BDT
    http://localhost:8100/currency-conversion/from/USD/to/BDT/quantity/100


    API GATEWAY

        http://localhost:8765/currency-conversion/from/USD/to/BDT/quantity/100
        http://localhost:8765/currency-conversion-new/from/USD/to/BDT/quantity/100

        http://localhost:8765/currency-exchange/from/AUD/to/BDT




docker run -p 9411:9411 openzipkin/zipkin:2.23


spring-boot:build-image -DskipTests
