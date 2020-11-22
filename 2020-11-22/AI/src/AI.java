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
	Image heroImg[][]=new Image[4][3];
	Image currentImg;

	public MainCanvas(){
	  try
	  {
		//i值含义：0：左，1：右，2：上，3：下
		for(int i=0;i<heroImg.length;i++){
			for(int j=0;j<heroImg[i].length;j++){
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			}
			}
		currentImg=heroImg[3][0];//游戏刚进入的时候，显示哪个hero的图片
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
			if(leftflag==1){
				currentImg=heroImg[0][1];
				leftflag++;
			}
			else if (leftflag==2)
			{ 
				currentImg=heroImg[0][2];
				leftflag=1;
			}
			x=x-1;
			repaint();
		}
	
    if(action==RIGHT){
			if(rightflag==1){
				currentImg=heroImg[1][1];
				rightflag++;
			}
			else if (rightflag==2)
			{ 
				currentImg=heroImg[1][2];
				rightflag=1;
			}
			x=x+1;
			repaint();
		}
	
		if(action==UP){

			if(upflag==1){
				currentImg=heroImg[2][1];
				upflag++;
			}
			else if (upflag==2)
			{ 
				currentImg=heroImg[2][2];
				upflag=1;
			}
			y=y-1;
			repaint();
		}
		
	if(action==DOWN){
		if(downflag==1){
				currentImg=heroImg[3][1];
				downflag++;
			}
			else if (downflag==2)
			{ 
				currentImg=heroImg[3][2];
				downflag=1;
			}
			y=y+1;
			repaint();
	}
	
	}
}