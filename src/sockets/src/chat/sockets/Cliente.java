package sockets.src.chat.sockets;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
        String nickUser = JOptionPane.showInputDialog("Usuario: ");
        LaminaMarcoCliente milamina = new LaminaMarcoCliente(nickUser);
        add(milamina);
        setVisible(true);

        addWindowListener(new StatusOnline(nickUser));
    }
}

// Eventos para la ventana
class StatusOnline extends WindowAdapter{
    private String nickUser;

    public StatusOnline(String nickUser){
        this.nickUser = nickUser;
    }
    // ONLINE
    public void windowOpened(WindowEvent e){
        try {
            Socket socket = new Socket("192.168.2.15", 3081);
            InfoChat datos = new InfoChat();
            datos.setUsuario(nickUser);
            datos.setMensaje(" online");
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(socket.getOutputStream());
            paqueteDatos.writeObject(datos);

            paqueteDatos.close();
            socket.close();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}

// Crear acciones en ventana
class LaminaMarcoCliente extends JPanel implements Runnable{
    private JTextField mensaje;
    private final JComboBox destinatario;
    private final JLabel usuario;
    private JButton boton;
    private JTextArea bandeja;

    public LaminaMarcoCliente(String nickUser){

        usuario = new JLabel();
        usuario.setText("Usuario: "+nickUser);
        add(usuario);

        JLabel texto = new JLabel("Online: ");
        add(texto);

        destinatario = new JComboBox();
        add(destinatario);

        bandeja = new JTextArea(12,20);
        add(bandeja);

        mensaje = new JTextField(20);
        add(mensaje);

        boton = new JButton("Enviar");
        SendText event = new SendText();
        boton.addActionListener(event);
        add(boton);

        Thread hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        try {
            ServerSocket servidorCliente = new ServerSocket(9090);
            Socket cliente;
            InfoChat paqueteRecibido;

            while(true){
                cliente = servidorCliente.accept();

                ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());

                paqueteRecibido = (InfoChat) flujoEntrada.readObject();
                if(!paqueteRecibido.getMensaje().equals(" online")){
                    bandeja.append("\n" + paqueteRecibido.getUsuario() + ": " + paqueteRecibido.getMensaje());
                }else{
                    ArrayList<String> ipsMenu = new ArrayList<>();
                    ipsMenu = paqueteRecibido.getIps();
                    destinatario.removeAllItems();

                    for(String z:ipsMenu){
                        destinatario.addItem(z);
                    }

                    bandeja.append("\n" + paqueteRecibido.getIps());
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    // funcion para el boton - SOCKET - Enviar mensaje
    private class SendText implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            bandeja.append("\n Yo: " + mensaje.getText());

            try {

                Socket socket = new Socket("192.168.2.15", 3081); // Socket

                InfoChat chatData = new InfoChat();
                chatData.setUsuario(usuario.getText());
                chatData.setDestinatario((String) destinatario.getSelectedItem());
                chatData.setMensaje(mensaje.getText());

                ObjectOutputStream flujoData = new ObjectOutputStream(socket.getOutputStream());
                flujoData.writeObject(chatData);
                flujoData.close();

                // PRUEBA ENVIO DE DATOS
                /*DataOutputStream flujoSalida = new DataOutputStream(socket.getOutputStream()); // Datos de salida
                flujoSalida.writeUTF(mensaje.getText()); // Capturar dato de salida
                flujoSalida.close();*/

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException(ex);
            }
        }
    }
}



class InfoChat implements Serializable {
    private String usuario, destinatario, mensaje;
    private ArrayList<String> ips;

    public ArrayList<String> getIps() {
        return ips;
    }
    public void setIps(ArrayList<String> ips) {
        this.ips = ips;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
