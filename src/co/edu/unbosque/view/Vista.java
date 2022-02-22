package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import co.edu.unbosque.controller.Controller;

public class Vista extends JFrame{
private Panelvista  panel;

	public Vista(Controller control) {
		
		setSize(500,400);
		setResizable(false);
		setTitle("Taller 1");
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	    setLayout(new BorderLayout());
	    panel = new Panelvista(control);
	    add(panel,BorderLayout.CENTER);
	    
	}
	public Panelvista getPanel() {
		return panel;
	}
	public void setPanel(Panelvista panel) {
		this.panel = panel;
	}
	
}
