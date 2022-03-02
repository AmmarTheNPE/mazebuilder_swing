package application;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.HashSet;

/**
 *
 * This is the actual "game". May/will have to make some major changes.

 * This is just a "hollow" shell.
 *
 * When you get done, I should see the buttons at the top in the "play" area
 * (NOT a pull-down menu). The only one that should do anything is Quit.
 *
 * Should also see something that shows where the 4x4 board and the "spare"
 * tiles will be when we get them stuffed in.
 *
 * This version uses a GridBagLayout manager. I STRONGLY suggest that you use
 * SOME layout manager, and even though this one is not the easiest, it is VERY
 * flexible. Refer to
 *
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/layoutlist.html
 *
 * for an explaination of the various layout managers. And really read it and
 * try them out. Write some of you OWN code and play with them. It is the only
 * way to really learn programming. 
 */
//package game;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GameWindow extends JFrame implements ActionListener
  {
    /**
     * because it is a serializable object, need this or javac
     * complains <b>a lot</b>
     */
	GridBoard gridBoard;
	SideBar sideBarL;
	SideBar sideBarR;
	Menu menu;
	
	TileCell[] tiles = new TileCell[16];
    int tileCount=0;
	HashSet<String> set= new HashSet<>();
    public static final long serialVersionUID=1;
    JButton resetB, newGameB, quitB;
	private Main main;
    /*
     * Here I declare some variables that used "throughout" the game 
     */
    
    /**
     * Constructor sets the window name using super(), changes the layout,
     * which you really need to read up on, and maybe you can see why I chose
     * this one.
     *
     * @param s The name of the window
     * @param main 
     */

    public GameWindow(String s, Main main)
    {
      super(s);
      GridBagLayout gbl=new GridBagLayout();
      setLayout(gbl);
      resetB = new JButton("Reset");
      newGameB = new JButton("New Game");
      quitB = new JButton("Quit");
      this.main=main;
      
    }

    /**
     * For the buttons
     * @param e is the ActionEvent
     * 
     * BTW can ask the event for the name of the object generating event.
     * The odd syntax for non-java people is that "exit" for instance is
     * converted to a String object, then that object's equals() method is
     * called.
     *
     * Your code MUST not print out anything to console when you submit it.
     */

    public void actionPerformed(ActionEvent e) {
      if("Quit".equals(e.getActionCommand()))
        System.exit(0);
      //
      if("Reset".equals(e.getActionCommand())){
    	  resetGame();
      }
      if("New Game".equals(e.getActionCommand()))
    	resetGame();
      }
    
    public void resetGame(){
    	removeAll();
        dispose();
    	  repaint();
    	  main.openGameWindow();
    	  revalidate();
    	  repaint();
    }
    /**
     *  Establishes the inital board
     */

    public void setUp()
    {
      //actually create the array for elements, make sure it is big enough
      
      
      // Need to play around with the dimensions and the gridx/y values
      // These constraints are going to be added to the pieces/parts I 
      // stuff into the "GridBag".
      // YOU CAN USE any type of constraints you like. Just make it work.
     
      
      setUpSidebars();

   	 GridBagConstraints basic = new GridBagConstraints();
  
      basic.gridx=1;
      basic.gridy=0;
      menu = new Menu();
      add(menu,basic);
      this.addButtons();
     
      return;
    }
    //this method sets Left and Right SideBars
    public void setUpSidebars(){
    	 GridBagConstraints basic = new GridBagConstraints();
         basic.weightx= 1;
         basic.weighty=1;
         basic.gridx= 0;
         basic.gridy=1;
       
         sideBarL = new SideBar(7,this);
         add(sideBarL,basic);
         basic.gridy = 1;
         basic.gridx = 1;
         //Here I should create 16 elements to put into my gameBoard
         gridBoard = new GridBoard();
         add(gridBoard,basic);
         basic.gridx=2;
         basic.gridy=1;
         basic.gridwidth = 1;
         basic.gridheight = 1;
         sideBarR = new SideBar(15,this);
         add(sideBarR,basic);
         
    }
    /**
     * Used by setUp() to configure the buttons on a button bar and
     * add it to the gameBoard
     */

    public void addButtons()
    {
      GridBagConstraints basic2 = new GridBagConstraints();
      basic2.ipadx = 15;
      basic2.ipady = 15;
      basic2.insets = new Insets(0,5,0,5);
      basic2.gridx=0;
      basic2.gridy=0;
      menu.add(resetB,basic2);
      basic2.gridx=1;
      menu.add(newGameB,basic2);
      basic2.gridx=2;
      menu.add(quitB,basic2);
      newGameB.addActionListener(this);
      resetB.addActionListener(this);
      quitB.addActionListener(this);
    }
    //this method puts the dragged tiles on front
    public void addTiles(TileCell tile){
    	if(set.add(tile.getImageName())){
    	tiles[tileCount++] = tile;
        add(tile);
        setComponentZOrder(tile,0);
        }else{
        	System.out.println("exists");
        }
    }
  };