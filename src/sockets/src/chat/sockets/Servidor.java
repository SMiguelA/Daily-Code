package sockets.src.chat.sockets;
import sockets.src.chat.sockets.InfoChat;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
    public static void main(String[] args) {

        MarcoServidor marco = new MarcoServidor();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// Crear Ventana
class MarcoServidor extends JFrame implements Runnable{
    private final JTextArea areaTexto;
    public MarcoServidor(){
        // Para crear el marco de la interfaz
        setBounds(600, 300, 280, 350);
        JPanel lamina = new JPanel();
        lamina.setLayout(new BorderLayout());
        areaTexto = new JTextArea();
        lamina.add(areaTexto, BorderLayout.CENTER);
        add(lamina);
        setVisible(true);

        // un hilo para ejecutar una funcion en segundo plano
        // en este caso la funcion run();
        Thread hilo = new Thread(this);
        hilo.start();
    }


    @Override
    public void run() {
        try {
            // ponemos a la escucha al servidor
            ServerSocket servidor = new ServerSocket(3081);

            String usuario, destinatario, mensaje;
            InfoChat chatDataRecibido;
            ArrayList<String> listaIp = new ArrayList<>();

            while(true){
                Socket socketRecibir = servidor.accept();

                ObjectInputStream flujoEntrada = new ObjectInputStream(socketRecibir.getInputStream());
                chatDataRecibido = (InfoChat) flujoEntrada.readObject();

                usuario = chatDataRecibido.getUsuario();
                destinatario = chatDataRecibido.getDestinatario();
                mensaje = chatDataRecibido.getMensaje();

                if(!mensaje.equals(" online")){
                    areaTexto.append("\n" + usuario + ": " + mensaje + " to " + destinatario);

                    Socket socketEnviar = new Socket(destinatario, 9090);
                    ObjectOutputStream chatDataEnvio = new ObjectOutputStream(socketEnviar.getOutputStream());

                    chatDataEnvio.writeObject(chatDataRecibido);
                    chatDataEnvio.close();

                    socketEnviar.close();
                    socketRecibir.close();
                }else{
                    // PARA DETECTAR EL ONLINE DE UN USER //
                    InetAddress ipAddressCliente = socketRecibir.getInetAddress();
                    String ip = ipAddressCliente.getHostAddress();
                    listaIp.add(ip);
                    chatDataRecibido.setIps(listaIp);

                    for(String eachIp: listaIp){
                        Socket socketEnviar = new Socket(eachIp, 9090);
                        ObjectOutputStream chatDataEnvio = new ObjectOutputStream(socketEnviar.getOutputStream());

                        chatDataEnvio.writeObject(chatDataRecibido);
                        chatDataEnvio.close();

                        socketEnviar.close();
                        socketRecibir.close();
                    }
                    //----------------------------------//
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}