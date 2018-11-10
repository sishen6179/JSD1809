package cn.tedu.shoot;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
/** 天空:是飞行物 */
public class Sky extends FlyingObject {
	private static BufferedImage image; //图片
	static{
		image = loadImage("background.png");
	}
	
	private int speed; //移动速度
	private int y1; //第二张图片的y坐标
	/** 构造方法 */
	public Sky(){
		super(World.WIDTH,World.HEIGHT,0,0);
		speed = 1;
		y1 = -World.HEIGHT;
	}
	
	/** 重写step()移动 */
	public void step(){
		y+=speed;  //y+(向下)
		y1+=speed; //y1+(向下)
		if(y>=World.HEIGHT){ //若y>=窗口的高，意味着到最下面了
			y=-World.HEIGHT; //则修改y的值为负的窗口的高
		}
		if(y1>=World.HEIGHT){ //若y1>=窗口的高，意味着到最下面了
			y1=-World.HEIGHT; //则修改y1的值为负的窗口的高
		}
	}
	
	/** 重写getImage()获取图片 */
	public BufferedImage getImage(){
		return image; //直接返回image
	}
	
	/** 重写paintObject()画对象 */
	public void paintObject(Graphics g){
		g.drawImage(this.getImage(),this.x,this.y,null);  //第一张图
		g.drawImage(this.getImage(),this.x,this.y1,null); //第二张图
	}
	
}












