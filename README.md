# Gym Project

O Gym Project é um projeto sobre um serviço de uma loja virtual feita para gerenciar pedidos de produtos esportivos e de academia. O projeto implementa requisições CRUD em suas chamadas de acesso, além de fazer o uso de Design Patterns para uma possível futura expansão, possibilitando a adição de novos setores, camadas e recursos.

## Diagrama de Classe

<img src="./assets/gym-project-class-diagram.png" alt="Class Diagram">

## Tecnologias

<img src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/java.png" alt="Java 17" width="80"/> <img src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/spring.png" alt="Spring" width="80"/> <img src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/spring_boot.png" alt="Spring Boot" width="80"/> <img src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/maven.png" alt="Maven" width="80"/> <img src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/hibernate.png" alt="Hbernate" width="80"/> <img src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/postgresql.png" alt="PostgreSQL" width="80"/>
  
## Ferramentas

<img src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/intellij.png" alt="IntelliJ" width="80"/> <img src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/postman.png" alt="Postman" width="80"/>

## Como Executar

1. Clone o repositório
```
git clone https://github.com/seu-usuario/gym-sports-api.git
```

2. Configure o banco de dados no application.properties
```
spring.application.name=gym
spring.profiles.active=test
```

3. Execute a aplicação:
```
mvn spring-boot:run
```

### Principais Endpoints

<table>
  <tr>
    <th>Método</th>
    <th>Endpoint</th>
    <th>Descrição</th>
  </tr>
  <tr>
    <td>POST</td>
    <td>/user</td>
    <td>Cria um novo usuário</td>
  </tr>
  <tr>
    <td>POST</td>
    <td>/brand</td>
    <td>Cria uma nova marca</td>
  </tr>
  <tr>
    <td>POST</td>
    <td>/sportproduct</td>
    <td>Cria um novo produto esportivo</td>
  </tr>
  <tr>
    <td>POST</td>
    <td>/gymproduct</td>
    <td>Cria um novo produto de academia</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/sportproduct</td>
    <td>Lista todos os produtos esportivo</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/gymproduct</td>
    <td>Lista todos os produtos de academia</td>
  </tr>
  <tr>
    <td>POST</td>
    <td>/sportorder</td>
    <td>Cria um novo pedido de produtos esportivos</td>
  </tr>
  <tr>
    <td>POST</td>
    <td>/gymorder</td>
    <td>Cria um novo pedido de produtos de academia</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/sportorder/{id}</td>
    <td>Lista um pedido de produtos espostivos pelo seu ID</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/gymorder/{id}</td>
    <td>Lista um pedido de produtos de academia pelo seu ID</td>
  </tr>
  <tr>
    <td>PUT</td>
    <td>/gymorder/{id}</td>
    <td>Atualiza um pedido de produtos de academia</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/gymorder/{id}/pay</td>
    <td>Efetua pagamento do pedido</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/gymorder/{id}/dispatch</td>
    <td>Despacha o pedido</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/gymorder/{id}/cancel</td>
    <td>Cancela o pedido</td>
  </tr>
  <tr>
    <td>DELETE</td>
    <td>/gymproduct/{id}</td>
    <td>Delete um produto de academia</td>
  </tr>
</table>

## Padrões de Design

Padrões de Design são conceitos reutilizaveis da Engenharia de Software, que possuem o objetivo de fornecer possíveis soluções para problemas em comum que podem surgir durante o desenvolvimento de um sistema de software. São práticas que permitem abstrair soluções de problemáticas encontradas em contextos similares de forma eficiente e flexível e, nesse caso, fazem parte de um conjunto de boas práticas que foram adotadas no sistema **gym-project** para garantir possibilidades de futuras extenções do mesmo, possibilitando uma melhoria contínua de forma rápida e adaptada para a situação.

### Strategy

O padrão de design Strategy se caracteriza como um padrão comportamental que permite definir uma família de algoritmos, encapsular cada um deles em classes separadas e torná-los intercambiáveis. Isso permite que o algoritmo varie independentemente dos clientes que o utilizam, seguindo o princípio do SOLID *Open/Closed*. Esse conceito separa a definição de um algoritmo da sua execução, permitindo que diferentes versões do algoritmo sejam selecionadas em tempo de execução e evitando condicionais complexos quando existem múltiplas variações de um comportamento.


### State

O State é um padrão de design comportamental que permite que um objeto altere seu comportamento quando seu estado interno muda. Ele encapsula diferentes comportamentos em estados separadas e delega a execução para o estado atual, seguindo o princípio de que um objeto deve parecer mudar de classe quando seu estado muda. Esse conceito permite que um objeto modifique suas ações dinamicamente conforme seu estado interno evolui, evitando condicionais complexos que verificam o estado atual do objeto e tornando as transições entre estados explícitas e organizadas.

<div align="center"><img src="./assets/State Diagram.png" alt="State Class Diagram" width="400"></div>

No software **gym-project**, esse conceito é aplicado de forma na qual os objetos instânciados da classe `ServiceOrder` possam alterar seu `State` em tempo de execução, variando entre `AwaitingPayment`, `Paid`, `Sent` e `Canceled` de acordo com as solicitações do usuário. Diferentes retornos são enviados de acordo com a requisição e o estdo atual do objeto.

```
AwaitingPaymentState - Estado inicial do pedido
PaidState - Pagamento do Pedido - /gymorder/{id}/pay
SentState - Envio do Pedido - /gymorder/{id}/dispatch
CanceledState - Cancelamento do Pedido - /gymorder/{id}/cancel
```

**1. AwaitingPayment**

Quando nesse estado, o pedido pode ser pago ou cancelado, porém retorna um erro caso ocorra a requisião de despacho.

```
@Override
public void successInPaying(ServiceOrder serviceOrder) {
  serviceOrder.setState(new PaidState());
}

@Override
public void dispatchOrder(ServiceOrder serviceOrder) {
  throw new IllegalOrderStateException("Operation not supported - Service Order not Paid");
}

@Override
public void cancelOrder(ServiceOrder serviceOrder) {
  serviceOrder.setState(new CanceledState());
}
```

**2. Paid**

Quando nesse estado, o pedido pode ser enviado ou cancelado, porém retorna um erro caso ocorra a requisião de pagamento.

```
@Override
public void successInPaying(ServiceOrder serviceOrder) {
  throw new IllegalOrderStateException("Operation not supported - Service already Paid");
}

@Override
public void dispatchOrder(ServiceOrder serviceOrder) {
  serviceOrder.setState(new SentState());
}

@Override
public void cancelOrder(ServiceOrder serviceOrder) {
  serviceOrder.setState(new CanceledState());
}
```

**3. Sent**

Quando nesse estado, as requisições de pagamento, despacho e cancelamento retornam um erro em todos os casos.

```
@Override
public void successInPaying(ServiceOrder serviceOrder) {
  throw new IllegalOrderStateException("Operation not supported - Service already Sent");
}

@Override
public void dispatchOrder(ServiceOrder serviceOrder) {
  throw new IllegalOrderStateException("Operation not supported - Service already Sent");
}

@Override
public void cancelOrder(ServiceOrder serviceOrder) {
  throw new IllegalOrderStateException("Operation not supported - Service already Sent");
}
```

**4. Canceled**

Quando nesse estado, as requisições de pagamento, despacho e cancelamento retornam um erro em todos os casos.

```
@Override
public void successInPaying(ServiceOrder serviceOrder) {
  throw new IllegalOrderStateException("Operation not supported - Service Order Canceled");
}

@Override
public void dispatchOrder(ServiceOrder serviceOrder) {
  throw new IllegalOrderStateException("Operation not supported - Service Order Canceled");
}

@Override
public void cancelOrder(ServiceOrder serviceOrder) {
  throw new IllegalOrderStateException("Operation not supported - Service Order Canceled");
}
```

## Contribuidores

* [José Pedro Vissoti](https://github.com/josevissoti)
* [Enzo Barbosa Dourado de Almeida](https://github.com/enzo-barbosa)
* [Marcelo Henrique Silva Ferreira](https://github.com/marcelohsf)
