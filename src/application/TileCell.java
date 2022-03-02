package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;


public class TileCell extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String imageName;
	private BufferedImage image;
	private int angle=0;
	private Graphics2D g2d;

	private boolean rotating=false;



	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public void rotate(){
    	if(angle<5){
    	angle+=1;
    	}else{
    		angle=1;
    	}
    }
	// rotates and set Image for the tile
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        if (rotating) {
        	int w2 = getWidth() / 2;
            int h2 = getHeight() / 2;
            if(angle==1){

                g2d.rotate(Math.PI/2, w2, h2);
            }
            else if(angle==2){
            	g2d.rotate(Math.PI, w2, h2);
            }
            else if(angle==3){
            	g2d.rotate(-Math.PI/2, w2, h2);
            }
            else if(angle==4){
            	g2d.rotate(2*Math.PI, w2, h2);
            }

            rotating=false;
        }
        g.drawImage(image, 0, 0,getWidth(),getHeight(), this); // see javadoc for more info on the parameters            
    }
    
	public boolean isRotating() {
		return rotating;
	}

	public void setRotating(boolean rotating) {
		this.rotating = rotating;
	}

	public TileCell(String name) {
		imageName=name;
		   try {                
		          image = ImageIO.read(new File(imageName));
		       } catch (IOException ex) {
		            System.out.println(ex.toString());
		       }
	this.setBorder(BorderFactory.createLineBorder(Color.black));
	this.setPreferredSize(new Dimension(38,38));
	}
	public TileCell() {
		   
	this.setBorder(BorderFactory.createLineBorder(Color.black));
	this.setPreferredSize(new Dimension(38,38));
	}
	
	
}