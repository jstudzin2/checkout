# Checkout library

## Introduction ##

## Prerequisites ##

- `maven`
- `jdk 8`
- `IDE`

## Build ##

To build the project you need to have maven and JDK 1.8 configured on your local environment.

### Build tasks ###

- Run `mvn test` to run unit tests && generate test reports
- Run `mvn package` to generate jar library which could be used by other modules

## Start in IDE ##

- Extract provided file to your workspace directory
- Select File\New\Project from existing sources
- Import project as a maven project

## How to use ##

- Main class of this library is `Checkout.java `
- It needs to be fed by proper discount strategy which implements
PromotionRule interface.
- Adding items to the basket could be done by calling method `scan`
- To get result you need to call 'total' method. It returns total amount which 
needs to be paid the customer including the discount

## Start the application ##

Application is provided as a library which cannot be started standalone.

## Docker support ##

No docker
