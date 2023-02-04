## spring-cloud-stream example
#
#  http > nameSupplier > nameToPerson > log
#
#  http endpoint accept string and publish it to nameSupplier *supplier*, which put it in `name.to.person.topic` destination.
#
#  An nameToPerson *function*, read the string from the `name.to.person.topic` destination and convert it into person with 
#  upper case name and put it in `log.topic` destination.
#
#  A log *consumer* reads the person object from `log.topic` destination and log it to stdout.
#
## Run Sample : 
#
#  - Run docker
#
#    docker compose up -d 
#
#  - Run App
#   
#   ./mvnw clean install  -DskipTests
#
## Test Sample
#
#   $ curl  -H "Content-Type: application/json" localhost:8080/persons/<some name> -w '\n' 
#
#   $ curl  -H "Content-Type: application/json" localhost:8080/persons/farhad -w '\n' 
#
#
#   $ curl  -H "Content-Type: application/json" localhost:8080/persons/Farhad%20Rasouli -w '\n' 
#


