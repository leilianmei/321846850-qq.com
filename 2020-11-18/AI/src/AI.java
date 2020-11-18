import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
    int x,y;
	int leftflag,rightflag,upflag,downflag;
	Image downImg,leftImg,rightImg,upImg,leftImg4,leftImg5,rightImg6,rightImg7,upImg8,upImg9,downImg10,downImg11,currentImg;
	public MainCanvas(){
	  try
	  {
		downImg=Image.createImage("/sayo10.png");
		leftImg=Image.createImage("/sayo12.png");
		upImg=Image.createImage("/sayo14.png");
		rightImg=Image.createImage("/sayo16.png");
		leftImg4=Image.createImage("/sayo02.png");
		leftImg5=Image.createImage("/sayo22.png");
		rightImg6=Image.createImage("/sayo06.png");
		rightImg7=Image.createImage("/sayo26.png");
		upImg8=Image.createImage("/sayo04.png");
		upImg9=Image.createImage("/sayo24.png");
		downImg10=Image.createImage("/sayo00.png");
		downImg11=Image.createImage("/sayo20.png");
		currentImg=downImg;
		x=120;
		y=100;
		leftflag=1;
		rightflag=1;
		upflag=1;
		downflag=1;
	  }
	  catch (IOException e)
	  {
		  e.printStackTrace();
	  }
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			currentImg=leftImg;
			x=x-1;
			if(leftflag==1){
				currentImg=leftImg4;
				leftflag++;
			}
			else if(leftflag==2){
				currentImg=leftImg5;
				leftflag--;
			}	
		}
	    if(action==RIGHT){
			currentImg=rightImg;
			x=x+1;
			if(rightflag==1){
				currentImg=rightImg6;
				rightflag++;
			}
			else if(rightflag==2){
				currentImg=rightImg7;
				rightflag=1;
			}	
		}
		if(action==UP){
			currentImg=upImg;
			y=y-1;
			if(upflag==1){
				currentImg=upImg8;
				upflag++;
			}
			else if(upflag==2){
				currentImg=upImg9;
				upflag=1;
			}	
		}
		if(action==DOWN){
			currentImg=downImg;
			y=y+1;
			if(downflag==1){
				currentImg=downImg10;
				downflag++;
			}
			else if(downflag==2){
				currentImg=downImg11;
				downflag=1;
			}	
			}	
			repaint();
	}
}