# Relatorio — SimpleClientServer

## b) Executar somente `SimpleClientTest`

Nao ha servidor escutando `127.0.0.1:3334`. Na chamada `new Socket(...)`, o sistema operacional recusa a conexao e e lancada uma `ConnectException` (normalmente com a mensagem `Connection refused: connect`). O `catch` do cliente imprime `Falha na comunicacao: ...`. A janela para digitar mensagens nao e exibida, pois a conexao falha antes do laco de interface.

## c) Executar `SimpleServerTest`

O servidor cria um `ServerSocket` na porta 3334 e mostra `Servidor iniciado na porta 3334`. Em seguida, para em `servidor.accept()`: essa chamada e bloqueante e aguarda um cliente. Nenhuma mensagem adicional aparece ate que algum cliente se conecte. A aplicacao continua em execucao e a porta permanece reservada.

## d) Executar o servidor e depois um cliente

O cliente consegue estabelecer a conexao, imprime o endereco e a porta do servidor e abre uma caixa de dialogo para cada mensagem. Cada texto diferente de `sair` e impresso no console do cliente e enviado, terminado por quebra de linha, ao socket.

O `accept()` do servidor retorna, o IP do cliente (neste teste, `127.0.0.1`) e mostrado e o servidor passa a imprimir cada linha recebida. Ao digitar `sair`, essa palavra **nao** e enviada: o `if` impede seu envio. O cliente apenas exibe que se desconectou e o processo termina. Mesmo sem um `cliente.close()` explicito, a terminacao do processo fecha o socket; o servidor recebe fim de fluxo, sai de `hasNextLine()`, mostra `Servidor finalizado!` e fecha o `ServerSocket`.

## e) Duas instancias de `SimpleClientTest`

Com o primeiro cliente conectado, o servidor fica no laco que le exclusivamente o socket desse primeiro cliente. Ao iniciar o segundo cliente, a conexao TCP pode ser estabelecida e ele pode imprimir que conectou, pois o sistema mantem conexoes pendentes na fila do `ServerSocket`.

No entanto, o programa servidor possui somente **uma** chamada a `accept()`. Portanto, ele nunca aceita nem le o socket do segundo cliente enquanto o primeiro estiver conectado. As mensagens da segunda instancia podem ser exibidas em seu proprio console, mas nao sao exibidas pelo servidor. As mensagens digitadas na primeira instancia continuam sendo recebidas e exibidas pelo servidor. Isso demonstra que este codigo e monocliente, nao um servidor concorrente.

## f) Encerrar a segunda instancia e usar a primeira

Encerrar o segundo cliente nao altera o atendimento do primeiro: o servidor jamais tinha aceitado o segundo socket. Assim, as novas mensagens do primeiro cliente continuam aparecendo normalmente no console do servidor. Quando o primeiro cliente tambem encerrar, o servidor detectara o fim de fluxo e sera finalizado.

## g) Executar uma segunda instancia de `SimpleServerTest`

A primeira instancia ja reservou a porta local 3334. A segunda tenta criar outro `ServerSocket` na mesma combinacao de IP/porta e falha com `BindException` (tipicamente `Address already in use: bind`). O bloco `catch` escreve `Erro ao criar o servidor!` e a pilha de excecao. A primeira instancia continua executando normalmente.

## Observacao de projeto

Para aceitar mais de um cliente de verdade, o servidor precisaria chamar `accept()` repetidamente (normalmente em um laco) e tratar cada `Socket` em uma thread ou tarefa separada. O codigo atual tambem poderia fechar explicitamente o socket e o `PrintStream` do cliente com try-with-resources.
