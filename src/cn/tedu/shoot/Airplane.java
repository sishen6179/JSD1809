package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** 小敌机:是飞行物，也是分 */
public class Airplane extends FlyingObject implements Enemy {
	/*
	 * A:静态变量，静态块赋值-----------最好的
	 *   --第一次new对象(方法区分配images一份，静态块赋一次值)
	 *   --以后new对象----什么也不做了
	 * B:实例变量，构造中赋值
	 *   --第一次new对象(堆中分配images，构造中赋一次值)
	 *   --第二次new对象(堆中分配images，构造中赋一次值)
	 *   --第三次new对象(堆中分配images，构造中赋一次值)
	 * C:静态变量，构造中赋值
	 *   --第一次new对象(方法区分配images一份，构造中赋一次值)
	 *   --第二次new对象(构造中赋一次值)
	 *   --第三次new对象(构造中赋一次值)
	 */
	
	private static BufferedImage[] images; //图片
	static{
		images = new BufferedImage[5];
		for(int i=0;i<images.length;i++){
			images[i] = loadImage("airplane"+i+".png");
		}
	}
	
	private int speed; //移动速度
	/** 构造方法 */
	public Airplane(){
		super(49,36);
		speed = 2;
	}
	
	/** 重写step()移动 */
	public void step(){
		y+=speed; //y+(向下)
	}
	
	int index = 1; //死了时的起始下标
	/** 重写getImage()获取图片 */
	public BufferedImage getImage(){ //每10毫秒走一次
		if(isLife()){ //若为活着的，则返回images[0]
			return images[0];
		}else if(isDead()){ //若为死了的
			BufferedImage img = images[index++]; //images[1]到images[4]
			if(index==images.length){ //若到最后一张图片了
				state = REMOVE; //将对象状态修改为删除状态
			}
			return img;
		}
		return null; //REMOVE状态时，返回null
		/*
		 *                   index=1
		 * 10M img=images[1] index=2                  返回images[1]
		 * 20M img=images[2] index=3                  返回images[2]
		 * 30M img=images[3] index=4                  返回images[3]
		 * 40M img=images[4] index=5(REMOVE) 返回images[4]
		 * 50M 
		 */
	}
	
	/** 重写getScore()得分 */
	public int getScore(){
		return 1; //打掉小敌机，玩家得1分
	}
	
}

















