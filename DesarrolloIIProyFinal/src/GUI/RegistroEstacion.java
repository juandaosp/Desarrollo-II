/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.ControladorEstacion;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author Dash
 */
public class RegistroEstacion extends JFrame implements ActionListener
{
     private JButton btRegistrar, btCancelar, btLimpiar;
     private JTextField campoNombre,campoUbicacion,campoIdEmpleado;
     private JComboBox comboEstado;
     
     private  ControladorEstacion controladorEstacion = new ControladorEstacion();
             
   
    
    public RegistroEstacion() 
    {
        super("Registro Estacion");
        
        String[] listaEstado={"Activo","Inactivo"};
        
        
        btRegistrar= new JButton("Registrar");
        btCancelar= new JButton("Cancelar");
        btLimpiar = new JButton("Limpiar");
        
        //AGREGAR EVENTOS DE LOS BOTONES
        btRegistrar.addActionListener(this);
        btCancelar.addActionListener(this);
        btLimpiar.addActionListener(this);
        
        
        campoNombre = new JTextField(20);
        campoIdEmpleado=new JTextField(20);
        campoUbicacion = new JTextField(20);
        
        comboEstado = new JComboBox(listaEstado);
        
        ImageIcon imLogo  = new ImageIcon("C:\\Users\\Dash\\Desktop\\Desarrollo-II\\DesarrolloIIProyecto\\src\\GUI\\LogoProyecto.png");		
        JLabel lbLogo = new JLabel(imLogo);
        
        JPanel panelNorte = new JPanel();
        panelNorte.add(lbLogo);
        
        JPanel panelCentralFlow = new JPanel();
        panelCentralFlow.setLayout(new FlowLayout());
                
        JPanel panelCentral = new JPanel(new GridLayout(5,2,10,10));        
        panelCentral.add(new JLabel("Nombre"));
        panelCentral.add(campoNombre);
        panelCentral.add(new JLabel("Ubicacion"));
        panelCentral.add(campoUbicacion);
        panelCentral.add(new JLabel("Id Empleado"));
        panelCentral.add(campoIdEmpleado);
        panelCentral.add(new JLabel("Estado"));
        panelCentral.add(comboEstado);
        
        JPanel panelSur = new JPanel();
        panelSur.setLayout(new GridLayout(1,3,5,5));
        panelSur.add(btRegistrar);
        panelSur.add(btLimpiar); 
        panelSur.add(btCancelar);
        
        panelCentralFlow.add(panelCentral);
        
        add(panelNorte,BorderLayout.NORTH);
        add(panelCentralFlow);
        add(panelSur,BorderLayout.SOUTH);       
        
        
        
        setSize(500,350);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    
    public static  void main(String[] args)
    {
        RegistroEstacion registroEstacion =new RegistroEstacion();
        registroEstacion.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
               
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btRegistrar)
        {
            String nombre,ubicacion,idEmpleado,estado;
            nombre=campoNombre.getText();
            ubicacion=campoUbicacion.getText();
            idEmpleado=campoIdEmpleado.getText();
            estado=(String)comboEstado.getSelectedItem();
            
            try 
            {
                controladorEstacion.agregarEstacion(nombre, ubicacion, estado, idEmpleado);
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, "Error en el guardado por favor revise sus campos");
            }           
         
        }
        if (ae.getSource()==btLimpiar) 
        {
            campoNombre.setText("");
            campoUbicacion.setText("");
            campoIdEmpleado.setText("");
        }
        if (ae.getSource()==btCancelar) 
        {
            this.dispose();
        }
    }
}
