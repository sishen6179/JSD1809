package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** 大敌机:是飞行物，也是分 */
public class BigAirplane extends FlyingObject implements Enemy{
	private static BufferedImage[] images; //图片
	static{
		images = new BufferedImage[5];
		for(int i=0;i<images.length;i++){
			images[i] = loadImage("bigplane"+i+".png");
		}
	}
	
	private int speed; //移动速度
	/** 构造方法 */
	public BigAirplane(){
		super(69,99);
		speed = 2;
	}
	
	/** 重写step()移动 */
	public void step(){
		y+=speed; //y+(向下)
	}
	
	int index = 1;
	/** 重写getImage()获取图片 */
	public BufferedImage getImage(){ //每10毫秒走一次
		if(isLife()){
			return images[0];
		}else if(isDead()){
			BufferedImage img = images[index++];
			if(index==images.length){
				state = REMOVE;
			}
			return img;
		}
		return null;
	}
	
	/** 重写getScore()得分 */
	public int getScore(){
		return 3; //打掉大敌机，得3分
	}
	
}














