# Projeto de Software
## Folha de Pagamento

### Padrões de projeto usados:
#### Foram usados do GoF:
- Strategy
- Command

### Refatoramentos e Code Smells:

  - *Feature Envy*: Primeiramente, o pacote foi completamente reestruturado e foram criados diretórios diferentes para cada tipo de coisa a ser feita: agora a package fpg contém as pastas agenda, employees, main e payment, o que adequou melhor o nome de cada coisa e a função designada.
  - *Duplicated Code, Long Method, Type Checking, Large Class, Primitive Obsession*: Na Classe Main foi feita uma refatoração completa, onde em cada opção escolhida (dentro de cada if) contém agora apenas uma linha de chamada de método. E esses métodos são chamados de classes novas que representam a seleção usada: Para cada opção tem uma classe específica que contém os métodos necessários para a mesma. Foi criada dentro da Main a Classe show_employee_list, já que é preciso usar essa ideia em várias opções diferentes(pois várias precisam pedir o ID do funcionário). A Classe Main diminuiu de mais de 600 linhas para menos de 100(80+-). Com isso, códigos duplicados foram removidos, o uso de variáveis diminuiu consideravelmente e o número de erros também. A legibilidade melhorou significativamente.
  - *Feature Envy, Long Method, Duplicated Code, Primitive Obsession*: No lugar de manusear o calendário e criar as agendas dos funcionários em uma classe só (PaymentRoll), agora temos o diretório Agenda e o diretório Payment, onde na Classe Agenda temos uma Classe que armazena a instância do calendário e contém métodos para passar os dias, diferente do Projeto anterior que fazia tudo na mesma função, e ainda foi usado o padrão de projeto Strategy para criar as agendas de pagamento, e com isso foi resolvido o Code Smell de usar muitos IF.
  - *Feature Envy, Primitive Obsession, Long Method, Duplicated Code*: Na Classe Payment também foi usado Strategy e o objetivo desse conjunto de classes é calcular os pagamentos de cada tipo de funcionário(Horista, Salariado, etc), e com isso foram resolvidos muitos Smells, além de resolver o uso de muitos IFs também. O código antigo gerava muitos erros e usar Strategy parece ter sido uma boa escolha. O código também ficou mais legível(outro Smell resolvido).
  - *Long Parameter List, Primitive Obsession*: Na Classes dos Employees antiga continha vários atributos do tipo inteiros para guardar a data de pagamento e e data de cadastro, um Smell, que foi resolvido com a criação do conjunto de classes agenda. Assim, foram feitos pequenos ajustes nos Employees para manusear as novas classes de pagamento e agenda. Ademais, não houveram grandes mudanças. 
  - *Long Method, Primitive Obsession, Large Class, Duplicated Code*: No diretório Main, as classes obtidas do refatoramento também chamam muitos outros métodos e estes últimos também, o que resolveu boa parte dos Long Methods que o código antigo tinha. Além disso, na nova Classe MainSelector7(Rodar Folha para hoje), foi implementada a funcionalidade de escolher a quantidade dias que se deseja passar.
 - Também foi usado Command para implementar o Undo_Redo, onde os executes vêm das classes da Main(MainSelectorX).
 
