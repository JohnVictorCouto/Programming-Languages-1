# Relatorio — SimpleClientServer

## b) Executar somente `SimpleClientTest`

Ocorre uma exceção do tipo `java.net.ConnectException: Connection refused` no console do cliente. O código do cliente tenta criar uma instância do objeto `Socket` direcionada ao endereço local na porta `3305`. Como a aplicação do servidor ainda não foi executada, não existe nenhum processo a escutar essa porta no sistema operacional. Consequentemente, a tentativa de conexão TCP é imediatamente rejeitada.

## c) Executar `SimpleServerTest`

O servidor é iniciado com sucesso, exibe no console a mensagem "Servidor iniciado e escutando a porta 3334" e a sua execução fica bloqueada (em estado de espera). Ao iniciar o servidor, o método iniciaServidor() aloca o recurso ServerSocket na `porta` `3305`. Em seguida, a chamada do método `aguardaConexaoCliente()` aciona o método `servidor.accept()`. O método `accept()` possui comportamento bloqueante: a thread principal de execução fica suspensa até que um cliente estabeleça uma conexão Socket nessa porta.   

## d) Executar o servidor e depois um cliente

O cliente conecta-se com sucesso, envia mensagens que são impressas no servidor e retransmitidas de volta (eco) para o cliente. A conexão bidirecional via protocolo TCP é estabelecida entre as duas partes. O loop `while(entrada.hasNextLine())` no servidor recebe os dados transmitidos pelo cliente e responde imediatamente. Quando o cliente encerra a comunicação (fechando ou enviando o comando de saída), a conexão do cliente é fechada, fazendo com que o método `hasNextLine()` do servidor retorne false e permita o encerramento limpo do programa.

## e) Múltiplas Instâncias do Cliente com o Mesmo Servidor

O comportamento observado ocorre porque o servidor foi implementado utilizando uma arquitetura monothread, o que significa que seu fluxo de execução é estritamente sequencial e direto. Sem o suporte a múltiplas threads ou multiplexação de Entrada/Saída (como select ou poll), esse tipo de servidor fica totalmente bloqueado e dedicado a uma única conexão por vez, sendo incapaz de atender requisições simultâneas de forma paralela.
Quando a primeira instância do cliente se conecta, o servidor aceita a conexão e entra em um laço fechado de leitura e resposta. Durante esse período, todo o poder de processamento do servidor está voltado para interagir com esse primeiro cliente, permitindo que a troca de mensagens aconteça normalmente.
No momento em que a segunda instância do cliente é iniciada, ela até consegue estabelecer a conexão em nível de rede (ficando na fila do sistema operacional), mas as suas mensagens introduzidas na interface ficam retidas e não são ecoadas. Isso acontece porque o fluxo do servidor continua "preso" no laço de execução do primeiro cliente, impossibilitando-o de alcançar a linha de código que aceitaria e processaria a nova conexão.
Por fim, ao voltar a interagir com a primeira instância, o servidor continua a responder-lhe sem problemas. Como o canal de comunicação original nunca foi interrompido e o servidor permanece executando o laço sequencial dedicado a essa primeira conexão, ele processa e ecoa as mensagens instantaneamente, ignorando completamente qualquer outro cliente que esteja aguardando na fila.

## f) Encerrar a Segunda Instância e Continuar a Usar a Primeira

Após fechar a segunda instância do cliente, a primeira instância continua a comunicar com o servidor sem falhas.
 Como o servidor nunca chegou a aceitar ativamente o fluxo de dados da segunda instância (mantendo-a apenas na fila do sistema operacional), o encerramento do segundo cliente não afeta o Socket que está associado à primeira instância no loop principal do servidor.

## g) Tentativa de Execução de uma Segunda Instância do Servidor

A segunda instância do `SimpleServerTest.java` lança uma exceção `java.net.BindException: Address already in use: bind` e é interrompida imediatamente. Na arquitetura de redes TCP/IP, uma porta de comunicação (neste caso, a porta `3334`) só pode ser reservada e utilizada por um único processo ou serviço de cada vez num determinado endereço IP local. Como a primeira instância do servidor já se encontra a escutar a porta 3334 via `ServerSocket`, a tentativa de registrar um novo socket na mesma porta é bloqueada pelo sistema operacional.