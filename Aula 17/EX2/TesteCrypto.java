// Classe “TesteCrypto.java”
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
public class TesteCrypto
{  public static void main(String[] args) throws Exception
   {  
      String   sMsgPath = "mensagem.txt";
      Scanner leitor = new Scanner(new File(sMsgPath));
      StringBuilder conteudo = new StringBuilder();
      while (leitor.hasNextLine()) {
         conteudo.append(leitor.nextLine()).append("\n");
      }
      String sMsgClara = conteudo.toString().trim();
      String   sMsgCifrada = null;
      String   sMsgDecifrada = null;
      byte[]   bMsgClara = null;
      byte[]   bMsgCifrada = null;
      byte[]   bMsgDecifrada = null;
      PrintWriter arquivoCifrada = new PrintWriter("texto_crifrada.txt", "UTF-8");
      PrintWriter arquivoDecifrada = new PrintWriter("texto_decifrado.txt", "UTF-8");
      // Instancia objeto da classe Impressora
      Impressora prn = new Impressora();
      // Imprime marcador de bloco
      arquivoCifrada.println("---------------------------------------------------------------");
      // Imprime Texto
      arquivoCifrada.println(">>> Imprimindo mensagem original...");
      arquivoCifrada.println("");
      // Converte o texto String dado no equivalente byte[]
      bMsgClara = sMsgClara.getBytes("ISO-8859-1");
      // Imprime cabecalho da mensagem
      arquivoCifrada.println("Mensagem Clara (Hexadecimal):");
      // Imprime o texto original em Hexadecimal
      arquivoCifrada.print(prn.hexBytesToString(bMsgClara));
      arquivoCifrada.println("");
      // Imprime cabecalho da mensagem
      arquivoCifrada.println("Mensagem Clara (String):");
      // Imprime o texto original em String
      arquivoCifrada.println(sMsgClara);
      arquivoCifrada.println("");
      leitor.close();
      /*
       * Criptografia Dummy ------------------------------------------------------------
       */
      // Imprime Texto
      arquivoCifrada.println(">>> Cifrando com o algoritmo Dummy...");
      arquivoCifrada.println("");
      // Instancia um objeto da classe CryptoDummy
      CryptoDummy cdummy = new CryptoDummy();
      // Gera a chave criptografica Dummy simetrica e nome do arquivo onde sera armazenada
      cdummy.geraChave(new File ("chave.dummy"));
      // Gera a cifra Dummy da mensagem dada, com a chave Dummy simetrica dada
      cdummy.geraCifra(bMsgClara, new File ("chave.dummy"));
      // Recebe o texto cifrado
      bMsgCifrada = cdummy.getTextoCifrado();
      // Converte o texto byte[] no equivalente String
      sMsgCifrada = (new String (bMsgCifrada, "ISO-8859-1"));
      // Imprime cabecalho da mensagem
      arquivoCifrada.println("Mensagem Cifrada (Hexadecimal):");
      // Imprime o texto cifrado em Hexadecimal
      arquivoCifrada.print(prn.hexBytesToString(bMsgCifrada));
      arquivoCifrada.println("");
      // Imprime cabecalho da mensagem
      arquivoCifrada.println("Mensagem Cifrada (String):");
      // Imprime o texto cifrado em String
      arquivoCifrada.println(sMsgCifrada);
      arquivoCifrada.println("");
      // Imprime texto
      arquivoDecifrada.println(">>> Decifrando com o algoritmo Dummy...");
      arquivoDecifrada.println("");
      // Gera a decifra Dummy da mensagem dada, segundo a chave Dummy simetrica gerada
      cdummy.geraDecifra(bMsgCifrada, new File ("chave.dummy"));
      // recebe o texto decifrado
      bMsgDecifrada = cdummy.getTextoDecifrado();
      // Converte o texto byte[] no equivalente String
      sMsgDecifrada = (new String (bMsgDecifrada, "ISO-8859-1"));
      // Imprime cabeÃ§alho da mensagem
      arquivoDecifrada.println("Mensagem Decifrada (Hexadecimal):");
      // Imprime o texto decifrado em Hexadecimal
      arquivoDecifrada.print(prn.hexBytesToString(bMsgDecifrada));
      arquivoDecifrada.println();
      // Imprime cabecalho da mensagem
      arquivoDecifrada.println("Mensagem Decifrada (String):");
      // Imprime o texto decifrado em String
      arquivoDecifrada.println(sMsgDecifrada);
      arquivoDecifrada.println(""); 
      /*
       * Criptografia AES --------------------------------------------------------------
       */
      // Imprime Texto
      arquivoCifrada.println(">>> Cifrando com o algoritmo AES...");
      arquivoCifrada.println("");
      // Instancia um objeto da classe CryptoAES
      CryptoAES   caes = new CryptoAES();
      // Gera a Chave criptografica AES simetrica e o nome do arquivo onde será armazenada
      caes.geraChave(new File ("chave.simetrica"));
      // Gera a cifra AES da mensagem dada, com a chave simetrica dada
      caes.geraCifra(bMsgClara, new File ("chave.simetrica"));
      // Recebe o texto cifrado
      bMsgCifrada = caes.getTextoCifrado();
      // Converte o texto byte[] no equivalente String
      sMsgCifrada = (new String (bMsgCifrada, "ISO-8859-1"));
      // Imprime cabecalho da mensagem
      arquivoCifrada.println("Mensagem Cifrada (Hexadecimal):");
      // Imprime o texto cifrado em Hexadecimal
      arquivoCifrada.print(prn.hexBytesToString(bMsgCifrada));
      arquivoCifrada.println("");
      // Imprime cabecalho da mensagem
      arquivoCifrada.println("Mensagem Cifrada (String):");
      // Imprime o texto cifrado em String
      arquivoCifrada.println(sMsgCifrada);
      arquivoCifrada.println("");
      // Imprime texto
      arquivoDecifrada.println(">>> Decifrando com o algoritmo AES...");
      arquivoDecifrada.println("");
      // Gera a decifra AES da mensagem dada, segundo a chave simetrica gerada
      caes.geraDecifra(bMsgCifrada, new File ("chave.simetrica"));
      // recebe o texto decifrado
      bMsgDecifrada = caes.getTextoDecifrado();
      // Converte o texto byte[] no equivalente String
      sMsgDecifrada = (new String (bMsgDecifrada, "ISO-8859-1"));
      // Imprime cabecalho da mensagem
      arquivoDecifrada.println("Mensagem Decifrada (Hexadecimal):");
      // Imprime o texto decifrado em Hexadecimal
      arquivoDecifrada.print(prn.hexBytesToString(bMsgDecifrada));
      arquivoDecifrada.println();
      // Imprime cabecalho da mensagem
      arquivoDecifrada.println("Mensagem Decifrada (String):");
      // Imprime o texto decifrado em String
      arquivoDecifrada.println(sMsgDecifrada);
      arquivoDecifrada.println(""); 
      /*
       * Criptografia RSA --------------------------------------------------------------
       */
      // Imprime Texto
      arquivoCifrada.println(">>> Cifrando com o algoritmo RSA...");
      arquivoCifrada.println("");
      // Instancia um objeto da classe CryptoRSA
      CryptoRSA   crsa = new CryptoRSA();
      // Gera as Chaves criptografica RSA publica e privada e os arquivos onde armazenar
      crsa.geraParDeChaves(new File ("chave.publica"), new File ("chave.privada"));
      // Gera a cifra RSA da mensagem dada, segundo a chave publica gerada
      crsa.geraCifra(bMsgClara, new File ("chave.publica"));
      // Recebe o texto cifrado
      bMsgCifrada = crsa.getTextoCifrado();
      // Converte o texto byte[] no equivalente String
      sMsgCifrada = (new String (bMsgCifrada, "ISO-8859-1"));
      // Imprime cabecalho da mensagem
      arquivoCifrada.println("Mensagem Cifrada (Hexadecimal):");
      // Imprime o texto cifrado em Hexadecimal
      arquivoCifrada.print(prn.hexBytesToString(bMsgCifrada));
      arquivoCifrada.println("");
      // Imprime cabecalho da mensagem
      arquivoCifrada.println("Mensagem Cifrada (String):");
      // Imprime o texto cifrado em String
      arquivoCifrada.println(sMsgCifrada);
      arquivoCifrada.println("");
      // Imprime texto
      arquivoDecifrada.println(">>> Decifrando com o algoritmo RSA...");
      arquivoDecifrada.println("");
      // Gera a decifra RSA da mensagem dada, segundo a chave privada gerada
      crsa.geraDecifra(bMsgCifrada, new File ("chave.privada"));
      // recebe o texto decifrado
      bMsgDecifrada = crsa.getTextoDecifrado();
      // Converte o texto byte[] no equivalente String
      sMsgDecifrada = (new String (bMsgDecifrada, "ISO-8859-1"));
      // Imprime cabecalho da mensagem
      arquivoDecifrada.println("Mensagem Decifrada (Hexadecimal):");
      // Imprime o texto decifrado em Hexadecimal
      arquivoDecifrada.print(prn.hexBytesToString(bMsgDecifrada));
      arquivoDecifrada.println();
      // Imprime cabecalho da mensagem
      arquivoDecifrada.println("Mensagem Decifrada (String):");
      // Imprime o texto decifrado em String
      arquivoDecifrada.println(sMsgDecifrada);
      arquivoDecifrada.println("");
      arquivoCifrada.close();
      arquivoDecifrada.close();
   }
}

