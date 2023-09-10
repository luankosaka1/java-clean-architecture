# Java e Clean Architecture

## Entities
Tem como diferenciar dois objetos através de um identificador único.

## Value Object
São considerados iguais, se todos os seus atributos tiverem valores iguais.
Não possui identificador único como Entities.

## Service
Pode ser utilizado tanto na camada de domínio quanto infraestrutura.

## Use Cases 
Os termos `Use Case`, `Application Service` e `Command Handler` são basicamente sinônimos e servem para fornecer pontos de entrada na sua aplicação, de forma independente dos mecanismos de entrega (Web, CLI, etc).