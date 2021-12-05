# Working multiple-dataSources and liquibase

## Multiple DataSources

The application shows how to configure 2 or more datasources with their separate entities \
The application use 2 mysql dbs, customer and payment each with their own tables. 

Go to 
1. CustomerDatasourceConfiguration and
2. PaymentDatasourceConfiguration

to view the datasource configuration setup

## Liquibase

Liquibase is an open-source database-independent library for tracking, managing and applying database schema changes

The application uses liquibase to manage database changes. 

NB:/ You will have to manually create the customer and payment dbs. 
