/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.ControladorEmpleados;
import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author Dash
 */
public class RegistroEmpleado extends JFrame implements ActionListener
{
        private JButton btRegistrar, btCancelar, btLimpiar;
	private JComboBox comboGenero, comboEstadoCivil, comboTContrato, comboCargo, comboTipoID;
	private JTextField campoIdentificacion, campoNombre; 
	private VentanaPrincipal ventanaP;
        private JPasswordField campoContrasena;
	private JTextField campoFNDia, campoFNMes, campoFNAno,campoFIDia, campoFIMes, campoFIAno, campoEps, campoSalario,campoLicencia,campoLogin;
        
        ControladorEmpleados controladorEmpleados;
        
    public RegistroEmpleado()  
    {
                super("Registro Empleado");
                
                controladorEmpleados = new ControladorEmpleados();

		JLabel lbIdentificacion = new JLabel ("Identificacion");
		JLabel lbNombre = new JLabel ("Nombre");
		JLabel lbGenero = new JLabel ("Genero");
		JLabel lbEstadoCivil = new JLabel ("Estado Civil");
		JLabel lbFechaNacimiento = new JLabel ("Fecha de Nacimiento (DD-MM-AAAA)");
		JLabel lbFechaIngreso = new JLabel ("Fecha de Ingreso (DD-MM-AAAA)");
		JLabel lbTContrato = new JLabel ("Tipo de Contrato");		
		JLabel lbCargo = new JLabel ("Cargo");
		JLabel lbCodOfi = new JLabel("EPS");
		JLabel lbTipoID = new JLabel("Tipo de Identificacion");
		JLabel lbCiudad = new JLabel("Ciudad");

		String [] listaGeneros = {"Masculino", "Femenino"};	
		String [] listaEstadoC = {"Soltero(a)", "Casado(a)", "Viudo(a)", "Divorciado(a)", "Union Libre"};
		String [] listaTContrato = {"Termino Indefinido", "Temporal", "Prestacion de Servicios"};
		String [] listaCargo = {"Aux de Serv", "Director Oper", "Director de Estac.", "Atencion al Cliente", "Gerente"};
		String [] listaTipoID = {"Cedula Extranjeria", "Cedula Ciudadania", "Pasaporte", "Tarjeta de identidad"};
                //para seleccionar cargos como un string: (String) cbCargo.getSelectedItem();

		comboGenero = new JComboBox(listaGeneros);		
		comboEstadoCivil = new JComboBox(listaEstadoC);
		comboTContrato = new JComboBox(listaTContrato);
		comboCargo = new JComboBox(listaCargo);
		comboTipoID = new JComboBox(listaTipoID);
                

		campoIdentificacion = new JTextField();
		campoNombre = new JTextField();
		campoEps = new JTextField();
		campoSalario = new JTextField();
                campoLicencia= new JTextField();
                campoLogin = new JTextField();

		campoFNDia = new JTextField();
		campoFNMes = new JTextField();
		campoFNAno = new JTextField();

		campoFIDia = new JTextField();
		campoFIMes = new JTextField();
		campoFIAno = new JTextField();

                campoContrasena = new JPasswordField();
                
		btRegistrar = new JButton("Registrar");
		btCancelar = new JButton("Cancelar");
		btLimpiar = new JButton("Limpiar");

		//AGREGAR EVENTOS DE LOS BOTONES
		btRegistrar.addActionListener(this);
		btCancelar.addActionListener(this);
		btLimpiar.addActionListener(this);

		JPanel panelFNacimiento = new JPanel(new GridLayout(1,3,5,5));
		panelFNacimiento.add(campoFNAno); 
		panelFNacimiento.add(campoFNMes); 
		panelFNacimiento.add(campoFNDia); 

		JPanel panelFIngreso = new JPanel(new GridLayout(1,3,5,5));
		panelFIngreso.add(campoFIAno); 
		panelFIngreso.add(campoFIMes); 
		panelFIngreso.add(campoFIDia); 

		JPanel panelCentral = new JPanel(new GridLayout(12,2,5,5));
		panelCentral.add(lbIdentificacion); 
		panelCentral.add(campoIdentificacion);
		panelCentral.add(lbNombre); 
		panelCentral.add(campoNombre);
                panelCentral.add(new JLabel("Login"));
                panelCentral.add(campoLogin);
                panelCentral.add(new JLabel("Password"));
                panelCentral.add(campoContrasena);
                panelCentral.add(lbCodOfi);
		panelCentral.add(campoEps);
                panelCentral.add(lbCiudad);
		panelCentral.add(campoSalario);
                panelCentral.add(new JLabel("Licencia"));
                panelCentral.add(campoLicencia);
		panelCentral.add(new JLabel("Genero"));		
		panelCentral.add(comboGenero);		
		panelCentral.add(lbEstadoCivil);
		panelCentral.add(comboEstadoCivil);
		panelCentral.add(lbFechaNacimiento);
		panelCentral.add(panelFNacimiento);
		panelCentral.add(lbCargo);
		panelCentral.add(comboCargo);

		JPanel b = new JPanel();
		b.setLayout(new GridLayout(1,3,5,5));
		b.add(btRegistrar);
		b.add(btLimpiar); 
		b.add(btCancelar);

		ImageIcon imLogo = new ImageIcon(getClass().getResource("/images/smalllogo.png"));		
		JLabel lbLogo = new JLabel(imLogo);		

		setLayout(new BorderLayout(5,5));
		add(lbLogo, BorderLayout.NORTH);
		add(panelCentral, BorderLayout.CENTER);
		add(b, BorderLayout.SOUTH);

		setSize(430,500);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
    
    }
    

    public void actionPerformed(ActionEvent ev) 
	{
            if(ev.getSource()==btRegistrar)
            {
                
                try{
                String login,contrasena,eps,ano,dia,mes,licencia,id,nombre,salario,cargo,estado,estadocivil,contrato;
                String genero;
                
                id=campoIdentificacion.getText();
                login= campoLogin.getText();
                contrasena=campoContrasena.getText();
                eps=campoEps.getText();
                ano=campoFNAno.getText();
                dia=campoFNDia.getText();
                mes=campoFNMes.getText();
                licencia=campoLicencia.getText();
                nombre=campoNombre.getText();
                salario=campoSalario.getText();
                cargo=(String)comboCargo.getSelectedItem();
                estadocivil=(String)comboEstadoCivil.getSelectedItem();
                genero=(String)comboGenero.getSelectedItem();
                char genero_formateado = genero.charAt(0);
                
                
                controladorEmpleados.insertarEmpleado(id, nombre, login, contrasena, eps, salario, licencia, genero_formateado, estadocivil,dia+"-"+mes+"-"+ano , cargo);
                
                campoIdentificacion.setText("");
                campoLogin.setText("");
                campoContrasena.setText("");
                campoEps.setText("");
                campoFNAno.setText("");
                campoFNDia.setText("");
                campoFNMes.setText("");
                campoLicencia.setText("");
                campoNombre.setText("");
                campoSalario.setText("");
                } 
                catch(Exception e)
                
                {
                
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    
                }
            }
            if(ev.getSource()==btLimpiar)
            {
                campoIdentificacion.setText("");
                campoLogin.setText("");
                campoContrasena.setText("");
                campoEps.setText("");
                campoFNAno.setText("");
                campoFNDia.setText("");
                campoFNMes.setText("");
                campoLicencia.setText("");
                campoNombre.setText("");
                campoSalario.setText("");
            }
            if(ev.getSource()==btCancelar)
            {
                this.dispose();
            }
	}	
 
}
