package application;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SideBar extends JPanel{

	/**
	 * 
	 */
	public int labelStart;
	private GameWindow gameWindow;
	private static final long serialVersionUID = 1L;

	public SideBar(int labelStart, GameWindow gameWindow) {
		  this.gameWindow=gameWindow;
	      GridBagLayout gbl=new GridBagLayout();
	      setLayout(gbl);
	      this.labelStart = labelStart;
	      this.setUp();
	}
	
	public void setUp() {
		 TileCell[] sideBar = new TileCell[8];
	      GridBagConstraints basic = new GridBagConstraints();
	      basic.gridx=0;
	      basic.gridy=0;
	      basic.insets = new Insets (5,0,5,0);
	     
	      for(int i =7; i>=0; i--)
	      {
	    	  sideBar[i]= new TileCell(String.valueOf(labelStart)+".jpg");
//	    	  setLabel(String.valueOf(labelStart),sideBar[i]);
	    	  labelStart--;
	    	  TileCell tile=sideBar[i];
	    	  tile.setBounds(20, 20, 38, 38); 
	    	  //double clicking mouse rotates tile
	    	  tile.addMouseListener(new MouseAdapter(){
	    		    @Override
	    		    public void mouseClicked(MouseEvent e){
	    		        if(e.getClickCount()>=2){
	    		            // your code here
	    		        	tile.setRotating(true);
	    		        	tile.rotate();
	    		        	tile.repaint();
	    		        	
	    		        }
	    		    }
	    		});
	    	  // adding listener for dragging tile
	    	  tile.addMouseMotionListener(
	    			  new MouseAdapter(){
	    				  	int count=0;
	    		            public void mouseDragged(MouseEvent E)
	    		            {
//	    		            	System.out.println("dragged");
	    		               int X=E.getX()+tile.getX();
	    		               
	    		               int Y=E.getY()+tile.getY();
	    		               tile.setBounds(X,Y,38,38);
//	    		             if(count==0){
	    		               //the dragged tile is set on front in gamewindow
	    		               gameWindow.addTiles(tile);
	    		               count++;
//	    		             }
	    		             }
	    		        });
	    	  add(sideBar[i],basic);
	    	  basic.gridx=0;
	    	  basic.gridy++;
	      }
	      
	      return;
	}
	
	public void setLabel(String name, JPanel panel) {
		
		System.out.println(name);
		JLabel label = new JLabel(name, JLabel.CENTER);

	    panel.add(label);
	    return;
	}
	
}