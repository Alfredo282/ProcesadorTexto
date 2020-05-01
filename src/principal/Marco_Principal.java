package principal;

import javax.swing.JFrame;

public class Marco_Principal extends JFrame{
	
	public Marco_Principal() {
		
		setBounds(500, 200, 550, 470);
		
		Contenedor c=new Contenedor();
		
		add(c);
		
		setVisible(true);
		
	}

}
