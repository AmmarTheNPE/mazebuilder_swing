package application;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main 
{

  // Probably should declare any buttons here
  //public JButton lbutton, rbutton, mbutton;
  

  public static void main(String[] args)
  {
    // This is the play area
    // 
	  Main main= new Main();
    main.openGameWindow();
  
  }

public void openGameWindow() {
	// TODO Auto-generated method stub
GameWindow game = new GameWindow("Group C aMaze",Main.this);
    
    // have to override the default layout to reposition things!!!!!!!

    game.setSize(new Dimension(900, 1000));
    
    // So the debate here was, do I make the GameWindow object the game
    // or do I make main() the game, manipulating a window?
    // Should GameWindow methods know what they store?
    // Answer is, have the "game" do it.

    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    game.getContentPane().setBackground(Color.cyan);
    game.setUp();
    
    // May or may not need this
    
    game.setVisible(true);

    // You will HAVE to read some documentation and catch exceptions so get used
    // to it. 

    try {
      // The 4 that are installed on Linux here
      // May have to test on Windows boxes to see what is there.
      UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
      // This is the "Java" or CrossPlatform version and the default
      //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
      // Linux only
      //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
      // really old style Motif 
      //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
    } 
    catch (UnsupportedLookAndFeelException e) {
     // handle possible exception
    }
    catch (ClassNotFoundException e) {
     // handle possible exception
    }
    catch (InstantiationException e) {
     // handle possible exception
    }
    catch (IllegalAccessException e) {
     // handle possible exception
    }
}
  
};
