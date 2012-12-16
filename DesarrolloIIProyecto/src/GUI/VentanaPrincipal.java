package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class VentanaPrincipal extends JFrame implements ActionListener
{
	private JButton btCerrar, btInformacion, btBorrar, btBuscar, btReporte;
	private JTextField campoBusqueda, campoSegBusqueda;
	private JMenuBar barraPrincipal;	
	private JMenu menuRegistros, menuConsultas, menuOpciones, menuEdiciones;
	private JMenuItem itemSalir, itemBus, itemEmpleado, itemEstacion, itemProgramacion, itemRecarga, itemRuta;
	private JMenuItem itemSolicitud, itemTarjeta, itemPasajero, itemEdPasajero, itemEdEmpleado, itemEdBus, itemEdEstacion;
        private JMenuItem itemEdProgramacion, itemEdRecarga, itemEdRuta, itemEdTarjeta;
                
                
        private JPanel panelBotones;
	private ImageIcon imLogo;
	private JTable tablaConsultas;
	
	private JScrollPane scrollConsultas;
	private PanelCCAbonado panelCCAbonado;
/*	private PanelCCOperador panelCCOperador;
	private PanelEstadRobosPerdidasMes panelEstadisticas;
	private PanelClienteNuevoMes panelClienteNuevoMes;

*/
        public String seleccion;
	private boolean boolTabla;
        
	public VentanaPrincipal(String tipoUsuario)
	{
		super("Principal - " +tipoUsuario);
                
                
               
                itemSalir = new JMenuItem("Salir");
                
                //panelEstadisticas = new PanelEstadRobosPerdidasMes();
		panelCCAbonado =  new PanelCCAbonado();
		//panelCCOperador = new PanelCCOperador();
		//panelClienteNuevoMes = new PanelClienteNuevoMes();
		//panelEstadisticas.btConsultaTipo.addActionListener(this);
		//panelEstadisticas.btConsultaMes.addActionListener(this);
		//panelEstadisticas.btnCancelar_1.addActionListener(this);
		panelCCAbonado.btnAceptar.addActionListener(this);
		panelCCAbonado.btnCancelar.addActionListener(this);
		//panelCCOperador.btnAceptar.addActionListener(this);
		//panelCCOperador.btnCancelar.addActionListener(this);
		//panelClienteNuevoMes.btConsultaTipo.addActionListener(this);
		//panelClienteNuevoMes.btConsultaMes.addActionListener(this);
		//panelClienteNuevoMes.btnCancelar_1.addActionListener(this);
		seleccion = "";
		boolTabla = false;

		imLogo  = new ImageIcon("Imagenes/smalllogo.png");		
		JLabel lbLogo = new JLabel(imLogo);		

		setLayout(new BorderLayout());
		add(lbLogo, BorderLayout.NORTH);	

		//instanciar botones
		btInformacion = new JButton("Informacion");
		btBorrar = new JButton("Borrar");
		btCerrar = new JButton("Cerrar");	
		btBuscar = new JButton("Buscar");	
		btReporte = new JButton("Generar Reporte");

		//instanciar campos de busqueda
		campoBusqueda = new JTextField();
		campoSegBusqueda = new JTextField();

		//Creacion de la Barra de Menu		
		
                barraPrincipal = new JMenuBar();
		
                menuRegistros = new JMenu ("Registros");
		menuEdiciones = new JMenu ("Ver");
		menuConsultas = new JMenu ("Consultas");
		menuOpciones = new JMenu ("Opciones");		

		itemBus = new JMenuItem ("Bus");
                itemPasajero = new JMenuItem ("Pasajero");
		itemEmpleado = new JMenuItem ("Empleado");
		itemEstacion = new JMenuItem ("Estacion");
		itemProgramacion = new JMenuItem ("Programacion");
		itemRecarga = new JMenuItem ("Recarga");
                itemSolicitud = new JMenuItem ("Solicitud");
                itemTarjeta = new JMenuItem ("Tarjeta");
                itemRuta = new JMenuItem ("Ruta");
		
		itemEdPasajero = new JMenuItem("Pasajero");
                itemEdEmpleado = new JMenuItem("Empleados");
                itemEdBus = new JMenuItem("Bus") ;
                itemEdEstacion = new JMenuItem("Estacion");
                itemEdProgramacion = new JMenuItem("Programacion");
                itemEdRecarga = new JMenuItem("Recarga");
                itemEdRuta = new JMenuItem("Ruta");
                itemEdTarjeta = new JMenuItem("Tarjeta");

		
		btCerrar.addActionListener(this);
		btInformacion.addActionListener(this);
		btBorrar.addActionListener(this);
		btBuscar.addActionListener(this);

		itemEmpleado.addActionListener(this);
		itemPasajero.addActionListener(this);
		itemBus.addActionListener(this);
		itemProgramacion.addActionListener(this);
		itemRecarga.addActionListener(this);
		itemRuta.addActionListener(this);
		itemSolicitud.addActionListener(this);
		itemTarjeta.addActionListener(this);
		itemSalir.addActionListener(this);

        
		itemEdPasajero.addActionListener(this);		
		itemEdBus.addActionListener(this);
		itemEdEmpleado.addActionListener(this);
		itemEdEstacion.addActionListener(this);
		itemEdProgramacion.addActionListener(this);
		itemEdRecarga.addActionListener(this);
		itemEdRuta.addActionListener(this);
		itemEdTarjeta.addActionListener(this);

		

		menuRegistros.add(itemPasajero);
		menuRegistros.add(itemEmpleado);			
		menuRegistros.add(itemBus);
		menuRegistros.add(itemEstacion);
		menuRegistros.add(itemProgramacion);
		menuRegistros.add(itemRecarga);
		menuRegistros.add(itemRuta);
		menuRegistros.add(itemSolicitud);
		menuRegistros.add(itemTarjeta);


		menuEdiciones.add(itemEdPasajero);
		menuEdiciones.add(itemEdEmpleado);
		menuEdiciones.add(itemEdBus);
		menuEdiciones.add(itemEdEstacion);
		menuEdiciones.add(itemEdProgramacion);
		menuEdiciones.add(itemEdRuta);
		menuEdiciones.add(itemEdRecarga);
		menuEdiciones.add(itemEdTarjeta);


                menuOpciones.add(itemSalir);	

		barraPrincipal.add(menuRegistros);
		barraPrincipal.add(menuEdiciones);
		barraPrincipal.add(menuConsultas);
		barraPrincipal.add(menuOpciones);
                
                if("Pasajero".equals(tipoUsuario)){
                    
                    itemSalir.setEnabled(false);
                    itemBus.setEnabled(false);
                    itemEmpleado.setEnabled(false);
                    itemEstacion.setEnabled(false); 
                    itemProgramacion.setEnabled(false); 
                    itemRecarga.setEnabled(false); 
                    itemRuta.setEnabled(false);
                    itemSolicitud.setEnabled(false); 
                    itemTarjeta.setEnabled(false); 
                    itemPasajero.setEnabled(false);
                    
                    itemEdEmpleado.setEnabled(false);
                    itemEdBus.setEnabled(false); 
                    itemEdEstacion.setEnabled(false);
                    itemEdProgramacion.setEnabled(false);
                    itemEdRecarga.setEnabled(false); 
                    itemEdRuta.setEnabled(false); 
                    itemEdTarjeta.setEnabled(false);
                }
                
                setJMenuBar(barraPrincipal);
		setVisible(true);
		setSize(800,600);
		setResizable(false);
		setLocationRelativeTo(null);
		

	}

	public void actionPerformed(ActionEvent evento) 
	{
            
            if (evento.getSource() == btInformacion)
		
            {
                int nFila =tablaConsultas.getSelectedRow();
                //hacemos una condicion de que si la varialbe i es igual a - es que no se ha seleccionado ninguna fila,
			
                if(nFila == -1)
                {
                    JOptionPane.showMessageDialog(null,"Por favor seleccione una fila");
                }
                
                else//de lo contrario si se selecciono la fila
                {
                    String identificacion = (String) tablaConsultas.getValueAt(nFila,0);
                    
                    if(seleccion.equals("pasajero"))
                    {
                        //EdPasajero EC = new EditarCliente(identificacion,this);
                    }
                    if(seleccion.equals("empleado"))
                    {
                        //EditarEmpleado ED = new EditarEmpleado(identificacion,this);
                    }				
				if(seleccion.equals("bus"))
				{
					//EditarBus EO = new EditarOficina(identificacion,this);
				}				
				if(seleccion.equals("programacion"))
				{	
					//EditarProgramacion EEC = new EditarEquipoCelular(identificacion,this);
				}				
				if(seleccion.equals("recarga"))
				{
					//EditarRecarga EPP = new EditarPlanPostpago(identificacion,this);
				}				
				if(seleccion.equals("ruta"))
				{		
				}				
				if(seleccion.equals("solicitud"))
				{
					//String nom_pais = (String) tablaConsultas.getValueAt(nFila,1);
					//EditarOperadorFijo EOF = new EditarOperadorFijo(identificacion,nom_pais,this);
				}				
				if(seleccion.equals("tarjeta"))
				{	
					//String nom_pais = (String) tablaConsultas.getValueAt(nFila,1);
					//EditarOpMovilInternacional EOMI = new EditarOpMovilInternacional(identificacion, nom_pais,this);
				}				
								
			}
		}

		if (evento.getSource() == btBorrar)
		{
			int nFila =tablaConsultas.getSelectedRow();
			//hacemos una condicion de que si la varialbe i es igual a - es que no se ha seleccionado ninguna 
			//fila,
			if(nFila == -1)
			{
				JOptionPane.showMessageDialog(null,"Por favor seleccione una fila");
			}
			else//de lo contrario si se selecciono la fila
			{
				String identificacion = (String) tablaConsultas.getValueAt(nFila,0);

				if(seleccion.equals("cliente"))
				{
					//daocliente.borrarCliente(identificacion);
					removerContenidoVentana();
					mostrarTabla("cliente");
				}				
				if(seleccion.equals("empleado"))
				{
					//daoempleado.borrarEmpleado(identificacion);
					removerContenidoVentana();
					mostrarTabla("empleado");
				}				
				if(seleccion.equals("oficina"))
				{
					//daooficina.borrarOficina(identificacion);
					removerContenidoVentana();
					mostrarTabla("oficina");
				}				
				if(seleccion.equals("equipo"))
				{
					//daoequipo.borrarEquipo(identificacion);
					removerContenidoVentana();
					mostrarTabla("equipo");

				}				
				if(seleccion.equals("planpostpago"))
				{
					//daoplanpostpago.borrarPlanPostPago(identificacion);
					removerContenidoVentana();
					mostrarTabla("planpostpago");
				}				
				if(seleccion.equals("sppostpago"))
				{		
					removerContenidoVentana();
					mostrarTabla("sppostpago");					
				}				
				if(seleccion.equals("ofijo"))
				{
					String pais = (String) tablaConsultas.getValueAt(nFila,1);
					//daooperadorfijo.borrarOperadorFijo(identificacion, pais);
					removerContenidoVentana();
					mostrarTabla("ofijo");
				}				
				if(seleccion.equals("ominter"))
				{
					String pais = (String) tablaConsultas.getValueAt(nFila,1);
					//daoopmovilinter.borrarOMI(identificacion, pais);
					removerContenidoVentana();
					mostrarTabla("ominter");
				}				
				if(seleccion.equals("mlocal"))
				{
					String pais = (String) tablaConsultas.getValueAt(nFila,1);
					//daoopmovillocal.borrarOML(identificacion, pais);
					removerContenidoVentana();
					mostrarTabla("mlocal");
				}				
			}
		}

		if (evento.getSource() == btCerrar)
		{
			boolTabla = false;
			this.remove(scrollConsultas);
			this.remove(panelBotones);
			repaint();
		}

		if (evento.getSource() == btBuscar)
		{
			String busqueda = campoBusqueda.getText();
			boolean encontrado = false;

			for (int i = 0; i < tablaConsultas.getRowCount(); i++)
			{
				if (tablaConsultas.getValueAt(i, 0).equals(busqueda)) 
				{
					if(seleccion.equals("ofijo") || seleccion.equals("ominter"))
					{
						String segBusqueda = campoSegBusqueda.getText();
						if(tablaConsultas.getValueAt(i, 1).equals(segBusqueda))
						{
							tablaConsultas.changeSelection(i, 0, false, false);
							encontrado = true;
							campoBusqueda.setText("");
							campoSegBusqueda.setText("");
							break;
						}
					}	
					else
					{
						tablaConsultas.changeSelection(i, 0, false, false);
						encontrado = true;
						campoBusqueda.setText("");
						break;
					}

				}
			}

			if(encontrado == false)
				JOptionPane.showMessageDialog(null, "La busqueda no obtuvo resultados","ERROR", JOptionPane.ERROR_MESSAGE);	
		}	

			
		
		//EVENTOS REGISTROS
		if (evento.getSource() == itemPasajero)
		{
			//RegistrarPasajero RC = new RegistrarCliente(this);
		}
		if (evento.getSource() == itemEmpleado)
		{
			//RegistrarEmpleado ce = new RegistrarEmpleado(this); 
		}	
		if (evento.getSource() == itemBus)
		{
			//RegistroBus pp = new RegistroPlanPostpago(this);
		}	
		if (evento.getSource() == itemEstacion)
		{
			//RegistrarEstacion regObj = new RegistrarEquipoCelular(this);
		}
		if (evento.getSource() == itemProgramacion)
		{
			//RegistroProgramacion contratoObj = new RegistroContrato();
		}
		if (evento.getSource() == itemRecarga)
		{
			//RegistroRecarga RecargaObj = new RegistroContrato();
		}		
		if(evento.getSource() == itemRuta)
		{
			//RegistroRuta s = new RegistroRuta();
		}		
		if (evento.getSource() == itemSolicitud)
		{
			//RegistroSolicitud reg = new RegistroSolicitud();
		}
		if (evento.getSource() == itemTarjeta)
		{
			//RegistrarTarjeta tarjeta = new RegistrarTarjeta();
		}
		

		//EVENTOS INVENTARIO
		if (evento.getSource() == itemEdPasajero)
		{
			seleccion = "pasajero";
			mostrarTabla("pasajero");
		}
		if (evento.getSource() == itemEdEmpleado)
		{
			seleccion = "empleado";
			mostrarTabla("empleado");
		}
		if (evento.getSource() == itemEdPasajero)
		{
			seleccion = "pasajero";
			mostrarTabla("pasajero");			
		}
		if (evento.getSource() == itemEdProgramacion)
		{
			seleccion = "programacion";
			mostrarTabla("programacion");
		}
		if (evento.getSource() == itemEdRecarga)
		{
			seleccion = "recarga";
			mostrarTabla("recarga");
		}
		if (evento.getSource() == itemEdRuta)
		{
			seleccion = "ruta";
			mostrarTabla("ruta");
		}
		if (evento.getSource() == itemEdTarjeta)
		{
			seleccion = "tarjeta";
			mostrarTabla("tarjeta");
		}
                

		//EVENTOS CONSULTAS
		/*
                if (evento.getSource() == itemCClientesNuevos)
		{
			try 
			{
				this.remove(scrollConsultas);
				this.remove(panelBotones);
			}
			catch(Exception e){}			

			this.add(panelClienteNuevoMes);
			pack();
			setSize(800,600);
		}
		if (evento.getSource() == itemFranjasUsoRed)
		{

		}
		if (evento.getSource() == itemUsuariosPrepago)
		{
			mostrarConsultas("usuarios prepago");
		}
		if (evento.getSource() == itemPlanesEscogidos)
		{
			mostrarConsultas("planes mas escojidos");
		}
		if (evento.getSource() == itemUsuariosPostpago)
		{
			mostrarConsultas("usuarios postpago");
		}
		if (evento.getSource() == itemDatosYConsumo)
		{
			mostrarConsultas("datos y consumo");
		}
		if (evento.getSource() == itemOpRoaming)
		{
			mostrarConsultas("Operadores Roaming");
		}
		if (evento.getSource() == itemOpLocalMasUsado)
		{
			try 
			{
				this.remove(scrollConsultas);
				this.remove(panelBotones);
			}
			catch(Exception e){}			

			this.add(panelCCOperador);
			pack();
			setSize(800,600);
		}
		if (evento.getSource() == itemCorporativos)
		{
			mostrarConsultas("Planes Preferidos Por Usuarios Corporativos");
		}
		if (evento.getSource() == itemConsumoPorGenero)
		{
			mostrarConsultas("consumo genero");			
		}
		if (evento.getSource() == itemRobos)
		{
			try 
			{
				this.remove(scrollConsultas);
				this.remove(panelBotones);
			}
			catch(Exception e){}			

			this.add(panelEstadisticas);
			pack();
			setSize(800,600);
		}
		if (evento.getSource() == itemConsumoPorAbonado)
		{

			try 
			{
				this.remove(scrollConsultas);
				this.remove(panelBotones);
			}
			catch(Exception e){}			

			this.add(panelCCAbonado);
			pack();
			setSize(800,600);

		}
		if (evento.getSource() == itemEquipos)
		{
			mostrarConsultas("Equipos Mas Demandados");
		}
                * 
                */
                
		if (evento.getSource() == itemSalir)
		{
			System.exit(0);
		}
                
	}//FIN DEL MANEJADOR DE EVENTOS	

		
	////////////////////////////////////////////////////////////////////////////////////
	
	public void mostrarTabla(String opcion)
	{
		removerContenidoVentana();
		
		DefaultTableModel modeloConsultas = new DefaultTableModel();

		JLabel lbBusqueda = new JLabel();
		lbBusqueda.setHorizontalAlignment(4);

		JLabel lbSegBusqueda = new JLabel();
		lbSegBusqueda.setHorizontalAlignment(4);


		if(opcion == "empleado")
		{
			lbBusqueda.setText("Identificacion");
		}	

		if(opcion == "usuario")
		{		
			lbBusqueda.setText("Identificacion");
		}

		if(opcion == "bus")
		{
			lbBusqueda.setText("Placa");
		}

		if(opcion == "programacion")
		{	
			lbBusqueda.setText("Identificacion Conductor");
		}

		if(opcion == "recarga")
		{	
			lbBusqueda.setText("pin tarjeta");
		}

		if(opcion == "ruta")
                    lbBusqueda.setText("Nombe de la ruta");
		{		
			//modeloConsultas = daoservplanpostpago.g
		}

		if(opcion == "solicitud")
		{
			lbBusqueda.setText("# de Ticket");
		}

		if(opcion == "tarjeta")
		{
			lbBusqueda.setText("Pin");
			
		}

		

		if(opcion.equals("empleado"))
		{			
			JPanel panelA = new JPanel(new GridLayout(1,3,5,5));
			panelA.add(btInformacion);
			panelA.add(btBorrar);
			panelA.add(btCerrar);
			JPanel panelB = new JPanel(new GridLayout(1,5,5,5));
			panelB.add(lbBusqueda);
			panelB.add(campoBusqueda);
			panelB.add(lbSegBusqueda);
			panelB.add(campoSegBusqueda);
			panelB.add(btBuscar);

			panelBotones = new JPanel(new GridLayout(2,1,5,5));
			panelBotones.add(panelA);
			panelBotones.add(panelB);			
		}
		else
		{
			panelBotones = new JPanel(new GridLayout(2,3,5,5));
			panelBotones.add(btInformacion);
			panelBotones.add(btBorrar);
			panelBotones.add(btCerrar);
			panelBotones.add(lbBusqueda);
			panelBotones.add(campoBusqueda);
			panelBotones.add(btBuscar);
		}


		scrollConsultas = new JScrollPane();
		tablaConsultas = new JTable();
		tablaConsultas.setModel(modeloConsultas);
		scrollConsultas.setViewportView(tablaConsultas);
		//scrollConsultas.setPreferredSize(new Dimension(780, 420));
		
		boolTabla = true;
		this.add(scrollConsultas, BorderLayout.CENTER);
		this.add(panelBotones, BorderLayout.SOUTH);
		this.pack();
		this.setSize(800,600);


	}

	public void mostrarConsultasConCiudades(String ciudad)
	{
		try 
		{
			this.remove(scrollConsultas);
			this.remove(panelBotones);
		}
		catch(Exception e){}

		DefaultTableModel modeloConsultas = new DefaultTableModel();


		panelBotones = new JPanel(new GridLayout(1,2,5,5));
		panelBotones.add(btReporte);
		panelBotones.add(btCerrar);

		scrollConsultas = new JScrollPane();
		tablaConsultas = new JTable();
		tablaConsultas.setModel(modeloConsultas);
		scrollConsultas.setViewportView(tablaConsultas);
		
		boolTabla = true;
		this.add(scrollConsultas, BorderLayout.CENTER);
		this.add(panelBotones, BorderLayout.SOUTH);
		this.pack();
		this.setSize(800,600);

	}

	public void mostrarConsultasConFechas(String fechaI, String fechaF)
	{
		try 
		{
			this.remove(scrollConsultas);
			this.remove(panelBotones);
		}
		catch(Exception e){}
		DefaultTableModel modeloConsultas = new DefaultTableModel();


		panelBotones = new JPanel(new GridLayout(1,2,5,5));
		panelBotones.add(btReporte);
		panelBotones.add(btCerrar);

		scrollConsultas = new JScrollPane();
		tablaConsultas = new JTable();
		tablaConsultas.setModel(modeloConsultas);
		scrollConsultas.setViewportView(tablaConsultas);
		
		boolTabla = true;
		this.add(scrollConsultas, BorderLayout.CENTER);
		this.add(panelBotones, BorderLayout.SOUTH);
		this.pack();
		this.setSize(800,600);

	}

	public void mostrarConsultasConFechasRobo(String fechaI, String fechaF)
	{
		try 
		{
			this.remove(scrollConsultas);
			this.remove(panelBotones);
		}
		catch(Exception e){}

		DefaultTableModel modeloConsultas = new DefaultTableModel();

		panelBotones = new JPanel(new GridLayout(1,2,5,5));
		panelBotones.add(btReporte);
		panelBotones.add(btCerrar);

		scrollConsultas = new JScrollPane();
		tablaConsultas = new JTable();
		tablaConsultas.setModel(modeloConsultas);
		scrollConsultas.setViewportView(tablaConsultas);
		
		boolTabla = true;
		this.add(scrollConsultas, BorderLayout.CENTER);
		this.add(panelBotones, BorderLayout.SOUTH);
		this.pack();
		this.setSize(800,600);

	}



	public void mostrarConsultas(String opcion)
	{
		try 
		{
			this.remove(scrollConsultas);
			this.remove(panelBotones);
		}
		catch(Exception e){}

		DefaultTableModel modeloConsultas = new DefaultTableModel();

		if(opcion == "Postpago")
		{
		}
		if(opcion == "Prepago")
		{
		}
		if(opcion == "consumo genero")
		{
		}

		if(opcion == "por Llamadas")
		{
		}

		if(opcion == "por SMS")
		{
		}

		if(opcion == "por Internet")
		{
		}
		if(opcion == "Operadores Locales Mas Usados Llamadas")
		{
		}
		if(opcion == "Operadores Locales Mas Usados Sms")
		{
		}
		if(opcion == "Operadores Locales Mas Usados Datos")
		{
			System.out.println("aca todo bn");
		}

		if(opcion == "planes mas escojidos")
		{
		}
		if(opcion == "usuarios prepago")
		{
		}
		if(opcion == "usuarios postpago")
		{
		}
		if(opcion == "datos y consumo")
		{
			//modeloConsultas = daoconsultas.Usu
		}
		if(opcion == "Operadores Roaming")
		{
		}
		if(opcion == "Planes Preferidos Por Usuarios Corporativos")
		{
		}
		if(opcion == "Equipos Mas Demandados")
		{
		}

		panelBotones = new JPanel(new GridLayout(1,2,5,5));
		panelBotones.add(btReporte);
		panelBotones.add(btCerrar);

		scrollConsultas = new JScrollPane();
		tablaConsultas = new JTable();
		tablaConsultas.setModel(modeloConsultas);
		scrollConsultas.setViewportView(tablaConsultas);
		//scrollConsultas.setPreferredSize(new Dimension(780, 450));

		boolTabla = true;
		this.add(scrollConsultas, BorderLayout.CENTER);
		this.add(panelBotones, BorderLayout.SOUTH);
		this.pack();
		this.setSize(800,600);


	}

	public void removerContenidoVentana()
	{
		try 
		{
			this.remove(scrollConsultas);
			this.remove(panelBotones);
			repaint();
		}
		catch(Exception e){}
		boolTabla = false;
	}

	public boolean isMostrandoTabla()
	{
		return boolTabla;
	}

	public static void main(String[] args) 
	{
		VentanaPrincipal VP = new VentanaPrincipal("");
	}

}
