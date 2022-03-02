package application;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Color;



public class Menu extends JPanel{

	private static final long serialVersionUID = 1L;

	public Menu() {
		
	      GridBagLayout gbl=new GridBagLayout();
	      setLayout(gbl);
	      this.setOpaque(false);
	      this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	      this.setPreferredSize(new Dimension(400,100));
	}

}