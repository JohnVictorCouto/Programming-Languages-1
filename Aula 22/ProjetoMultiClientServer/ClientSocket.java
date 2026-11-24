import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;
public class ClientSocket {
    private final Socket socket;
    private final BufferedReader entrada;
    private final PrintWriter saida;
    public ClientSocket(Socket socket) throws IOException {
        this.socket = socket;
        System.out.println("Cliente "+ socket.getRemoteSocketAddress() + " conectado.");
        entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        saida = new PrintWriter(socket.getOutputStream(), true);
    }
    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }
    public void close(){
        try{
            entrada.close();
            saida.close();
            socket.close();
        }
        catch (IOException ex){
            System.err.println("Erro ao fechar conexão com o cliente: " + ex.getMessage());
        }
    }
    public String getMessage() {
        try {
            return entrada.readLine();
        } catch (IOException ex) {
            System.err.println("Erro ao ler mensagem do cliente: " + ex.getMessage());
            return null;
        }
    }
    public boolean sendMsg(String msg) {
        saida.println(msg);
        return !saida.checkError();
    }
}
