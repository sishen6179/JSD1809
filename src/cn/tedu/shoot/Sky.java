package cn.tedu.shoot;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
/** ���:�Ƿ����� */
public class Sky extends FlyingObject {
	private static BufferedImage image; //ͼƬ
	static{
		image = loadImage("background.png");
	}
	
	private int speed; //�ƶ��ٶ�
	private int y1; //�ڶ���ͼƬ��y����
	/** ���췽�� */
	public Sky(){
		super(World.WIDTH,World.HEIGHT,0,0);
		speed = 1;
		y1 = -World.HEIGHT;
	}
	
	/** ��дstep()�ƶ� */
	public void step(){
		y+=speed;  //y+(����)
		y1+=speed; //y1+(����)
		if(y>=World.HEIGHT){ //��y>=���ڵĸߣ���ζ�ŵ���������
			y=-World.HEIGHT; //���޸�y��ֵΪ���Ĵ��ڵĸ�
		}
		if(y1>=World.HEIGHT){ //��y1>=���ڵĸߣ���ζ�ŵ���������
			y1=-World.HEIGHT; //���޸�y1��ֵΪ���Ĵ��ڵĸ�
		}
	}
	
	/** ��дgetImage()��ȡͼƬ */
	public BufferedImage getImage(){
		return image; //ֱ�ӷ���image
	}
	
	/** ��дpaintObject()������ */
	public void paintObject(Graphics g){
		g.drawImage(this.getImage(),this.x,this.y,null);  //��һ��ͼ
		g.drawImage(this.getImage(),this.x,this.y1,null); //�ڶ���ͼ
	}
	
}












