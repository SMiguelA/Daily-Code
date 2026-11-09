package sockets.src.chat.sockets;
import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
            while(true){
                Socket socket = servidor.accept();

                // flujo de entrada
                DataInputStream flujoEntrada = new DataInputStream(socket.getInputStream());
                String mensaje = flujoEntrada.readUTF();

                // escribir en el area, ya capturamos la informacion
                areaTexto.append("\n"+mensaje);
                socket.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}