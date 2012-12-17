
package GUI;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controladores.ControladorBus;
import DAO.exceptions.PreexistingEntityException;
import Logica.Bus;
import java.util.logging.Level;
import java.util.logging.Logger;


public class IngresarBus extends JFrame implements ActionListener{
    
    private JButton guardarBus,limpiarCampos, cancelar;
    private JLabel matricula,estado, ano, fabricante, capacidad, cilindraje, chasis, tipoBus;
    private JComboBox comboEstado, comboTipoBus;
    private JTextField textMatricula, textAno, textFabricante, textCapacidad, textCilindraje, textChasis;
    private JPanel panelFormulario, panelBotones;
    
    ControladorBus controlador = new ControladorBus();
    
    public IngresarBus()
    {
    
        super("Agregar Bus");
        
        matricula = new JLabel("Matricula");
        estado = new JLabel("Estado");
        ano = new JLabel("Año");
        fabricante = new JLabel("Fabricante");
        capacidad = new JLabel("Capacidad");
        cilindraje = new JLabel("Cilindraje");
        chasis = new JLabel("Chasis");
        tipoBus = new JLabel("Tipo");
        
        textMatricula = new JTextField(); 
        comboEstado = new JComboBox();
        comboEstado.addItem("Activo");
        comboEstado.addItem("Inactivo");
        
        comboTipoBus = new JComboBox();
        comboTipoBus.addItem("Troncal");
        comboTipoBus.addItem("Pretroncal");
        comboTipoBus.addItem("Alimentador");
        textAno = new JTextField(); 
        textFabricante = new JTextField(); 
        textCapacidad = new JTextField(); 
        textCilindraje = new JTextField(); 
        textChasis = new JTextField();
        
        
        guardarBus = new JButton("Guardar");
        limpiarCampos = new JButton("Limpiar Campos");
        cancelar = new JButton("Cancelar");
        
        ImageIcon imLogo = new ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Desarrollo-II\\DesarrolloIIProyFinal\\src\\images\\smalllogo.png");
        JLabel lbLogo = new JLabel(imLogo);
        
        panelFormulario = new JPanel(new GridLayout(8,2,2,2));
        panelFormulario.add(matricula);
        panelFormulario.add(textMatricula);
        panelFormulario.add(estado);
        panelFormulario.add(comboEstado);
        panelFormulario.add(ano);
        panelFormulario.add(textAno);
        panelFormulario.add(fabricante);
        panelFormulario.add(textFabricante);
        panelFormulario.add(capacidad);
        panelFormulario.add(textCapacidad);
        panelFormulario.add(cilindraje);
        panelFormulario.add(textCilindraje);
        panelFormulario.add(chasis);
        panelFormulario.add(textChasis);
        panelFormulario.add(tipoBus);
        panelFormulario.add(comboTipoBus);
        
        panelBotones = new JPanel(new GridLayout(1,3,2,2));
        panelBotones.add(guardarBus);
        panelBotones.add(limpiarCampos);
        panelBotones.add(cancelar);
        
        guardarBus.addActionListener(this);
        
        add(lbLogo,BorderLayout.NORTH);
        add(panelFormulario,BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        
        setVisible(true);
       setSize(400,480);
       setResizable(false);
        
    }
    
    public static void main(String args[])
    {
    IngresarBus ing = new IngresarBus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == "Guardar")
        {
            try {
                controlador.agregarBus(textMatricula.getText(), (String)comboEstado.getSelectedItem(), textAno.getText(), textFabricante.getText(), textCapacidad.getText(), textCilindraje.getText(), textChasis.getText(),(String) comboTipoBus.getSelectedItem());
            } catch (PreexistingEntityException ex) {
                Logger.getLogger(IngresarBus.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(IngresarBus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
