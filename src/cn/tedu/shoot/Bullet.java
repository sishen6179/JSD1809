package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** �ӵ�:�Ƿ����� */
public class Bullet extends FlyingObject {
	private static BufferedImage image; //ͼƬ
	static{
		image = loadImage("bullet.png");
	}
	
	private int speed; //�ƶ��ٶ�
	/** ���췽�� */
	public Bullet(int x,int y){
		super(8,14,x,y);
		speed = 3;
	}
	
	/** ��дstep()�ƶ� */
	public void step(){
		y-=speed; //y-(����)
	}
	
	/** ��дgetImage()��ȡͼƬ */
	public BufferedImage getImage(){
		if(isLife()){ //��Ϊ���ŵģ��򷵻�ͼƬ
			return image;
		}else if(isDead()){ //��Ϊ���˵ģ���״̬�޸�ΪREMOVE
			state = REMOVE;
		}
		return null; //���˵ĺ�ɾ����ʱ������null
	}
	
	/** ��дoutOfBounds()����Ƿ�Խ�� */
	public boolean outOfBounds(){
		return this.y<=-this.height; //�ӵ���y<=�����ӵ��ĸߣ���ΪԽ����
	}
	
}
















