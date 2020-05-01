package principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;

public class Contenedor extends JPanel {
	
	public Contenedor() {
		
		setLayout(new BorderLayout());
		
		JPanel laminamenu=new JPanel();
		
		JMenuBar mibarra=new JMenuBar();
		
		//----------Crear los elementos del menú de la parte superior-----------
		fuente=new JMenu("Fuente");
		
		tamagno=new JMenu("Tamaño");
		
		// Aqui se crea los elementos para el menú Fuente
		configura_menu("Arial", "fuente", "Arial", 9, 10, "");
		
		configura_menu("Calibri", "fuente", "Calibri", 9, 10, "");
		
		configura_menu("Courier", "fuente", "Courier", 9, 10, "");
		
		configura_menu("Georgia", "fuente", "Georgia", 9, 10, "");
		
		configura_menu("Verdana", "fuente", "Verdana", 9, 10, "");
		
		// Aqui se crea los elementos para el menú Estilo
		configura_menu("Negrita", "estilo", "", Font.BOLD, 10, "src/imagenes/negrita.gif");
		
		configura_menu("Cursiva", "estilo", "", Font.ITALIC, 10, "src/imagenes/cursiva.gif");
		
		// Aqui se crea los elementos para el menú Tamaño
		
		ButtonGroup tamagno_letra=new ButtonGroup();
		
		JRadioButtonMenuItem doce=new JRadioButtonMenuItem("12");
		
		JRadioButtonMenuItem dieciseis=new JRadioButtonMenuItem("16");
		
		JRadioButtonMenuItem veinte=new JRadioButtonMenuItem("20");
		
		JRadioButtonMenuItem veinticuatro=new JRadioButtonMenuItem("24");
		
		tamagno_letra.add(doce);
		
		tamagno_letra.add(dieciseis);
		
		tamagno_letra.add(veinte);
		
		tamagno_letra.add(veinticuatro);
		
		doce.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 12));
		
		dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 16));
		
		veinte.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 20));
		
		veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 24));
		
		tamagno.add(doce);
		
		tamagno.add(dieciseis);
		
		tamagno.add(veinte);
		
		tamagno.add(veinticuatro);
		
		mibarra.add(fuente);
		
		mibarra.add(tamagno);
		
		laminamenu.add(mibarra);
		
		add(laminamenu, BorderLayout.NORTH);
		
		//--------------------------Crear el área de texto------------------------------
		miarea=new JTextPane();
		
		add(miarea, BorderLayout.CENTER);
		
		
		//----------Crear los elementos del menú ubicado en la parte izquierda----------
		
		barra=new JToolBar();
		
		configura_barra("src/imagenes/negrita.gif").addActionListener(new StyledEditorKit.BoldAction());
		
		configura_barra("src/imagenes/cursiva.gif").addActionListener(new StyledEditorKit.ItalicAction());
		
		configura_barra("src/imagenes/subrayado.gif").addActionListener(new StyledEditorKit.UnderlineAction());
		
		barra.addSeparator();
		
		configura_barra("src/imagenes/azul.gif").addActionListener(new StyledEditorKit.ForegroundAction("Pone_azul", Color.BLUE));
		
		configura_barra("src/imagenes/rojo.gif").addActionListener(new StyledEditorKit.ForegroundAction("Pone_rojo", Color.RED));
		
		configura_barra("src/imagenes/amarillo.gif").addActionListener(new StyledEditorKit.ForegroundAction("Pone_amarillo", Color.YELLOW));
		
		barra.addSeparator();
		
		configura_barra("src/imagenes/izquierda.gif").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
		
		configura_barra("src/imagenes/centrado.gif").addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
		
		configura_barra("src/imagenes/derecha.gif").addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
		
		configura_barra("src/imagenes/justificado.gif").addActionListener(new StyledEditorKit.AlignmentAction("Justificada", 3));
		
		barra.setOrientation(1);
		
		add(barra, BorderLayout.WEST);
		
	}
	
	// Método para colocar una imagen a los botones
	public JButton configura_barra(String ruta) {
		
		JButton boton=new JButton(new ImageIcon(ruta));
		
		barra.add(boton);
		
		return boton;
		
	}
	
	// Método para añadir una imagen a los botones y asignarle sus correspondientes acciones
	public void configura_menu(String rotulo, String menu, String tipo_letra, int estilos, int tam, String ruta_icono) {
		
		JMenuItem elem_menu=new JMenuItem(rotulo, new ImageIcon(ruta_icono));
		
		if(menu=="fuente") {
			
			fuente.add(elem_menu);
			
			if(tipo_letra=="Arial") {
				
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Arial"));
				
			}else if(tipo_letra=="Calibri") {
				
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Calibri"));
				
			}else if(tipo_letra=="Courier") {
				
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Courier"));
				
			}else if(tipo_letra=="Georgia") {
				
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Georgia"));
				
			}else if(tipo_letra=="Verdana") {
				
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Verdana"));
				
			}
			
		}else if(menu=="tamaño") {
			
			tamagno.add(elem_menu);
			
			elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", tam));
			
		}
		
	}
	
	private JTextPane miarea;
	
	private JMenu fuente, tamagno;
	
	private Font letras;
	
	private JButton negritaBarra, cursivaBarra, subraBarra, azulBarra, rojoBarra, amarilloBarra, a_izquierda, a_centrado, a_derecha, a_justificado;
	
	private JToolBar barra;

}
