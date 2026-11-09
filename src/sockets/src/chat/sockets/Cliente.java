package sockets.src.chat.sockets;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    public static void main(String[] args) {

        MarcoCliente marco = new MarcoCliente();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// Crear Ventana
class MarcoCliente extends JFrame{
    public MarcoCliente(){
        // Para crear el marco de la interfaz
        setBounds(600, 300, 280, 350);
        LaminaMarcoCliente milamina = new LaminaMarcoCliente();
        add(milamina);
        setVisible(true);
    }
}

// Crear acciones en ventana
class LaminaMarcoCliente extends JPanel{
    private JTextField campo1;
    private JButton boton;

    public LaminaMarcoCliente(){
        JLabel texto = new JLabel("Client Render");
        add(texto);
        campo1 = new JTextField(20);
        add(campo1);
        boton = new JButton("Enviar");
        SendText event = new SendText();
        boton.addActionListener(event);
        add(boton);
    }



    // funcion para el boton - SOCKET
    private class SendText implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Socket socket = new Socket("192.168.2.15", 3081); // Socket
                DataOutputStream flujoSalida = new DataOutputStream(socket.getOutputStream()); // Datos de salida

                flujoSalida.writeUTF(campo1.getText()); // Capturar dato de salida
                flujoSalida.close();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException(ex);
            }
        }
    }


}