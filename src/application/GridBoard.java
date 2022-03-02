package application;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GridBoard extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GridBoard() {
		  
	      GridBagLayout gbl=new GridBagLayout();
	      setLayout(gbl);
	      this.setUp();
	}
	
	public void setUp() {
	      TileCell[] gridField = new TileCell[16];
	      GridBagConstraints basic = new GridBagConstraints();
	      basic.gridx=0;
	      basic.gridy=0;
	 
	      for(int i = 0; i<4; i++)
	      {
	    	  for(int j =0; j<4; j++) {
	    		  gridField[j]= new TileCell();
	    		  add(gridField[j],basic);
	    		  basic.gridx++;
	    	  }
	    	  basic.gridx = 0;
	    	  basic.gridy++;
	      }
	      return;
	}
	
}