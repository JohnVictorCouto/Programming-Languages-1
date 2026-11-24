# Relatório — Aula 22: Threads e Java Sockets

## 1. Expressões lambda — Exemplos 1, 2 e 3

O arquivo `Lambda.java` contém uma interface funcional `Operacao` e os três usos pedidos. No primeiro, a lambda `(a, b) -> a + b` implementa a operação de soma; para os argumentos 5 e 3, o resultado é 8. No segundo, um `Comparator<String>` compara duas strings lexicograficamente; comparar “maçã” com “banana” retorna valor positivo, pois “maçã” vem depois de “banana” nessa ordenação. No terceiro, um stream filtra a lista de 1 a 10 e produz `[2, 4, 6, 8, 10]`.

As lambdas reduzem o código necessário para instanciar interfaces funcionais, mantendo explícito o comportamento fornecido ao método abstrato.

## 2. Funções anônimas — Exemplos 4 e 5

`ExemploFuncaoAnonima.java` implementa `Operacao` por meio de uma classe anônima e calcula `5 + 3 = 8`. `Lambda.java` mostra a versão concisa da mesma operação com lambda. Ambas produzem o mesmo resultado; a classe anônima explicita a implementação do método `executar`, enquanto a expressão lambda é apropriada porque a interface possui um único método abstrato.

## 3. Threads — Exemplos 6 a 11

Os arquivos fornecidos demonstram as duas formas centrais de execução comparadas no material. `SimpleThreadExample.java` executa o processamento na própria thread principal, apesar do nome da classe: chama `run()` diretamente, portanto não cria uma thread concorrente. `MultipleThreadExample.java` cria threads de trabalho com `start()`, dividindo o processamento configurado entre elas.

Na execução concorrente, mensagens podem aparecer intercaladas, porque cada thread avança independentemente. A duração total não é necessariamente o tempo de uma única thread dividido pelo número de threads: há custos de criação de threads, escalonamento, troca de contexto e contenção pelos núcleos. O ganho depende do processador e da carga. Para medir corretamente o tempo total do trabalho, a thread principal deve aguardar as threads de trabalho (por exemplo, com `join()`); no fonte fornecido, o cronômetro da thread principal termina logo após iniciar as threads e, assim, não mede a conclusão de todo o processamento.

Os fontes configuram até um bilhão de iterações. Por esse custo, não foi executada a carga integral como teste automatizado; os códigos foram compilados. Para testes rápidos, reduza temporariamente `TOTAL_NUMEROS` e restaure o valor antes da entrega.

## 4. Efeito de aumentar N em `MultipleThreadExample`

Aumentar `N` cria mais threads e reparte o volume de trabalho entre elas (com divisão inteira). Inicialmente, isso pode melhorar o aproveitamento de processadores com vários núcleos. Depois de certo ponto, o ganho diminui ou pode virar perda: a máquina tem número finito de núcleos, e muitas threads aumentam escalonamento, trocas de contexto, consumo de memória (incluindo pilhas), pressão sobre o sistema operacional e competição por CPU.

Há, portanto, um limite pragmático, não um número universal: depende dos recursos e da natureza da tarefa. O sistema operacional e a JVM também impõem limites de recursos e podem impedir a criação de novas threads. No código atual, há ainda dois cuidados: `N` deve ser positivo (zero causa divisão por zero; valor negativo não tem sentido) e, se `N` não dividir exatamente o total, a divisão inteira descarta o resto e o número de iterações executado fica menor que o total configurado. Recomenda-se validar `N` e distribuir também o resto. No meu caso, o máximo são 8 threads.

## 5. Cliente-servidor com sockets — Exemplos 12, 13 e 14

Os exemplos de comunicação cliente-servidor estabelecem uma conexão TCP entre um servidor que aguarda conexões e um cliente que envia mensagens. No projeto fornecido, `Server.java` cria um `ServerSocket` na porta 3305; para cada conexão aceita, instancia `ClientSocket` e cria uma thread que lê as mensagens daquele cliente. `Client.java` conecta a `127.0.0.1:3305`, envia cada linha digitada e encerra o envio quando recebe `sair`. O servidor registra as mensagens recebidas no console e fecha o socket do cliente ao fim da sessão.

O fluxo depende da ordem: se o cliente for iniciado antes do servidor estar escutando na porta, a conexão não é estabelecida e o cliente informa erro. Com o servidor em execução, clientes conectados podem enviar mensagens sem bloquear o atendimento de novas conexões, porque cada sessão é processada em uma thread própria.

## 6. Aumento da quantidade de clientes

Com mais clientes, o servidor fornecido aceita as conexões sequencialmente e cria uma thread para cada conexão; cada thread permanece ocupada lendo daquele cliente. Assim, várias sessões podem ser atendidas ao mesmo tempo, mas o consumo de recursos também cresce. O desempenho é limitado por CPU, memória, descritores de arquivo/sockets, capacidade de rede, limites do sistema operacional/JVM e fila de conexões pendentes do `ServerSocket`.

O fonte não define um limite explícito de clientes nem usa um pool de threads. Isso não significa que aceite clientes ilimitados: na prática, há limites de recursos e a criação de threads pode falhar quando estes se esgotam. Uma implementação de produção deveria limitar concorrência (por exemplo, executor com pool), tratar erros de aceitação e oferecer encerramento controlado. A porta e o endereço também precisam estar disponíveis e acessíveis na rede.

## 7. Projeto `ProjetoMultiClientServer`

- **a–c. Cliente sem servidor:** iniciar `Client.java` antes de `Server.java` gera falha de conexão, pois não há processo escutando na porta 3305. Ao iniciar `Server.java`, ele abre a porta, imprime que está aguardando conexões e fica bloqueado em `accept()`, pronto para aceitar clientes.
- **d. Primeiro cliente e saída:** quando o primeiro cliente conecta, o servidor registra a conexão e inicia uma thread para a sessão. As mensagens digitadas aparecem no console do servidor. Ao enviar `sair`, o cliente deixa o laço e a thread do servidor termina a leitura e fecha os recursos do cliente; o servidor principal continua aceitando outras conexões.
- **e–h. Clientes simultâneos:** enquanto um cliente permanece conectado, os próximos também conseguem conectar. Cada conexão tem sua própria thread; mensagens de clientes diferentes podem intercalar no console do servidor, mas cada linha indica o endereço remoto da origem. O servidor não retransmite as mensagens aos demais clientes: apenas as imprime localmente. As mensagens digitadas em um cliente não aparecem nos consoles dos outros.
- **i. Encerramento dos três clientes:** enviar `sair` em cada cliente encerra apenas aquela conexão/sessão. Depois da saída do último cliente, o servidor continua ativo e volta a aguardar conexões, pois o laço de aceitação é infinito.
- **j. Segunda instância do servidor:** não consegue abrir a mesma porta 3305 enquanto a primeira instância a mantém ocupada; ocorre erro de vinculação da porta (normalmente `Address already in use`). É preciso parar a primeira instância ou configurar outra porta.

## Desafio 1 — Servidor termina após a desconexão do último cliente

Implementado em `Desafio1/Server2.java`, `Desafio1/ClientSocket2.java` e `Desafio1/Client2.java`. O servidor mantém uma contagem de conexões ativas. Cada conexão é tratada por uma thread; ao receber `sair`, EOF ou uma falha de leitura, a sessão é fechada e a contagem é decrementada. Quando já houve ao menos uma conexão e a contagem chega a zero, o servidor fecha o `ServerSocket`. Isso desbloqueia o `accept()` e encerra o processo, atendendo ao requisito do desafio. A porta escolhida é 3306 para coexistir com o exemplo original.

## Desafio 2 — Comunicação bidirecional

Implementado em `Desafio2/ServerBidirectional.java`, `Desafio2/ClientSocketBidirectional.java` e `Desafio2/ClientBidirectional.java`. O cliente envia mensagens e possui uma thread leitora dedicada às respostas, permitindo enviar e receber sem que a leitura do console bloqueie a recepção. O servidor exibe cada mensagem recebida e devolve `Servidor recebeu: <mensagem>` ao cliente; assim, a informação pode ser conferida nos dois consoles. A palavra `sair` também recebe confirmação antes do encerramento da sessão. A porta escolhida é 3307.
