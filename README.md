# SPRING CLOUD MICRO-SERVICES
<br>
<br>
<br>


Client-side service discovery allows services to find and communicate with each other without hard-coding hostname and port. The only ‘fixed point' in such an architecture consists of a service registry with which each service has to register.

A drawback is that all clients must implement a certain logic to interact with this fixed point. This assumes an additional network round trip before the actual request.

With Netflix Eureka each client can simultaneously act as a server, to replicate its status to a connected peer. In other words, a client retrieves a list of all connected peers of a service registry and makes all further requests to any other services through a load-balancing algorithm.

<br>
<br>

### TYPES OF MICRO-SERVICES 
<br>
<br>

We've implement the following types of microservices to achieve the goal:

- Service registry (Eureka Server) 
- REST service which registers itself at the registry (Eureka Client)
- Web application, which is consuming the REST service as a registry-aware client (Spring Cloud Netflix Feign Client)
- Spring cloud gateway that provides means for routing requests to different micro-services 

<br>
<br>

<img src="images/MICROSERVICES_ARCHITECHTURE.png" alt="Italian Trulli">
figure: Currency Exchange Micro-services
<br>
<br>
<br>

<img src="images/EUREKA_SERVER.png" alt="Italian Trulli">
figure: Eureka Server 
<br>
<br>
<br>


<img src="images/ZIPKIN_SERVER.png" alt="Italian Trulli">
figure: Zipkin Server 
<br>
<br>
<br>


<img src="images/RABBITMQ_1.png" alt="Italian Trulli">
<br>
<br>
<img src="images/RABBITMQ_2.png" alt="Italian Trulli">
<br>
<br>
figure: RABBITMQ Server 
<br>
<br>
<br>




CLINENT REQUESTS



a. API GATEWAY

    http://localhost:8765/currency-conversion/from/USD/to/BDT/quantity/100
    http://localhost:8765/currency-conversion-new/from/USD/to/BDT/quantity/100

    http://localhost:8765/currency-exchange/from/AUD/to/BDT


b. 
    http://localhost:8000/currency-exchange/from/AUD/to/BDT
    http://35.231.202.202:8000/currency-exchange-feign/from/AUD/to/INR

c.     
    http://localhost:8100/currency-conversion/from/USD/to/BDT/quantity/100
    
    http://35.196.139.219:8100/currency-conversion-feign/from/USD/to/INR/quantity/100
    http://35.196.139.219:8100/currency-conversion-feign/from/USD/to/INR/quantity/100


<br>
<br>
<br>

# DOCKER CONTAINERS EXECUTION

<br>
<br>

<br>
<br>

## RUN WITH THE COMMANDS 

<br>
<br>

The follwing commands with create the docker imaages and run all the required micro-services - 

<br>


    $ ./create_docker_images.sh
    $ docker-compose up



<br>
<br>
<br>

# CONTAINER ORCHESTRATION WITH KUBERNETES 
<br>
<br>
<br>

Typical features:

- Auto Scaling 
- service Discovery
- Load Balancer 
- Self Healing
- Zero Downtime Deployments 

<br>
<br>
<br>

### GOOGLE KUBERNETES ENGINE  (GKE)







<br>
<img src="images/CLUSTER_CREATION.png" alt="Italian Trulli">
figure: horizontal deployment architecture
<br>
<br>

<br>
<img src="images/SERVICES.png" alt="Italian Trulli">
figure: list of the services
<br>
<br>

<br>
<img src="images/CURRENCY_EXCHANGE.png" alt="Italian Trulli">
figure: Currency exchange service dashboard
<br>
<br>


<br>
<img src="images/CURRENCY_CONVERSION.png" alt="Italian Trulli">
figure: Currency conversion service dashboard
<br>
<br>
<br>



