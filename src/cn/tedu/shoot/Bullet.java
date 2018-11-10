package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** 子弹:是飞行物 */
public class Bullet extends FlyingObject {
	private static BufferedImage image; //图片
	static{
		image = loadImage("bullet.png");
	}
	
	private int speed; //移动速度
	/** 构造方法 */
	public Bullet(int x,int y){
		super(8,14,x,y);
		speed = 3;
	}
	
	/** 重写step()移动 */
	public void step(){
		y-=speed; //y-(向上)
	}
	
	/** 重写getImage()获取图片 */
	public BufferedImage getImage(){
		if(isLife()){ //若为活着的，则返回图片
			return image;
		}else if(isDead()){ //若为死了的，则将状态修改为REMOVE
			state = REMOVE;
		}
		return null; //死了的和删除的时，返回null
	}
	
	/** 重写outOfBounds()检测是否越界 */
	public boolean outOfBounds(){
		return this.y<=-this.height; //子弹的y<=负的子弹的高，即为越界了
	}
	
}
















