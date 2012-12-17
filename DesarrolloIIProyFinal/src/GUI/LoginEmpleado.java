/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.ControladorEmpleados;
import Logica.Empleado;
import Logica.Usuario;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author RICURA FOODS
 */
public class LoginEmpleado extends JFrame implements ActionListener{
    
    private JButton IniSesionPasajero, IniCancelar ;
    private JTextField campoLogin, campoPass;
    private JLabel labLogin, labPass;
    private JPanel panelPrincipal, panelBotones;
    private ControladorEmpleados  CE = new ControladorEmpleados();
    
    
    public LoginEmpleado(){
        
        super("SSTM - Login");
        
        IniSesionPasajero= new JButton("Iniciar Sesion"); 
        IniCancelar= new JButton("Cancelar");
        
        ImageIcon imLogo = new ImageIcon(getClass().getResource("/images/smalllogo.png"));
        
        JLabel lbLogo = new JLabel(imLogo);
        
        setLayout(new BorderLayout(5 , 5));
        
         
        labLogin = new JLabel ("Login");
        campoLogin = new JTextField(10);
        
        labPass = new JLabel("Password");
        campoPass = new JTextField(10);
        
        JPanel pAux = new JPanel(new FlowLayout());
        panelPrincipal = new JPanel(new GridLayout(2,2,10,10));
        
        panelPrincipal.add(labLogin);
        panelPrincipal.add(campoLogin);
        panelPrincipal.add(labPass);
        panelPrincipal.add(campoPass);
       
        pAux.add(panelPrincipal);
        panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        
      
       IniSesionPasajero= new JButton("Iniciar Sesion"); 
       IniCancelar= new JButton("Cancelar");
       
       panelBotones.add(IniSesionPasajero);
       panelBotones.add(IniCancelar);
       
       add(lbLogo, BorderLayout.NORTH);
       add(pAux, BorderLayout.CENTER);
       add(panelBotones, BorderLayout.SOUTH);
       
       IniSesionPasajero.addActionListener(this);
       
       setVisible(true);
       setSize(400,300);
       setResizable(false);
    
    }    public void actionPerformed(ActionEvent evento) 
	{
             String id = campoLogin.getText();
             String Password = campoPass.getText();
            
            
                 
                 Empleado employee = CE.consultarEmpleado(id, Password);
                 
                 System.out.println(employee.getId());
                 
                 if (id.equals(employee.getId())&& Password.equals(employee.getContrasena())){
                     
                     VentanaPrincipal VP = new VentanaPrincipal(employee.getCargo());
                 
                 }else
                 
                 {
                 
                     JOptionPane.showMessageDialog(null,"El empleado con identificacion: "+ id + " y Password: " 
                             + Password + " No Existe","Error", JOptionPane.ERROR_MESSAGE);
                 }
        
        }
    
    public static void main(String a[]){
        
        LoginEmpleado l = new LoginEmpleado();
    }
}
