package cn.tedu.shoot;
import java.util.Random;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics;
/** ������ */
public abstract class FlyingObject {
	public static final int LIFE = 0;   //���ŵ�
	public static final int DEAD = 1;   //���˵�
	public static final int REMOVE = 2; //ɾ����
	protected int state = LIFE; //��ǰ״̬(Ĭ��Ϊ���ŵ�)
	
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	/** ר�Ÿ�С�л�����л���С�۷��ṩ�� */
	public FlyingObject(int width,int height){
		this.width = width;
		this.height = height;
		Random rand = new Random();
		x = rand.nextInt(World.WIDTH-this.width); //x:0��(���ڿ�-���˵Ŀ�)֮��������
		y = -this.height; //y:���ĵ��˵ĸ�
	}
	/** ר�Ÿ�Ӣ�ۻ�����ա��ӵ��ṩ�� */
	public FlyingObject(int width,int height,int x,int y){
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	
	/** �������ƶ� */
	public abstract void step();
	
	/** ��ȡͼƬ */
	public static BufferedImage loadImage(String fileName){
		try{
			BufferedImage img = ImageIO.read(FlyingObject.class.getResource(fileName)); //��ͬ���ж�ȡͼƬ
			return img;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/** ��ȡ�����ͼƬ */
	public abstract BufferedImage getImage();

	/** �ж��Ƿ��ǻ��ŵ� */
	public boolean isLife(){
		return state==LIFE;
	}
	/** �ж��Ƿ������˵� */
	public boolean isDead(){
		return state==DEAD;
	}
	/** �ж��Ƿ���ɾ���� */
	public boolean isRemove(){
		return state==REMOVE;
	}
	
	/** ������ g:���� */
	public void paintObject(Graphics g){
		g.drawImage(this.getImage(),this.x,this.y,null);
	}
	
	/** �������Ƿ�Խ�� */
	public boolean outOfBounds(){
		return this.y>=World.HEIGHT; //���˵�y>=���ڵĸߣ���ΪԽ����
	}
	
	/** ��ײ���   this:����   other:�ӵ���Ӣ�ۻ� */
	public boolean hit(FlyingObject other){
		int x1 = this.x-other.width;  //x1:���˵�x-�ӵ��Ŀ�
		int x2 = this.x+this.width;   //x2:���˵�x+���˵Ŀ�
		int y1 = this.y-other.height; //y1:���˵�y-�ӵ��ĸ�
		int y2 = this.y+this.height;  //y2:���˵�y+���˵ĸ�
		int x = other.x;              //x:�ӵ���x
		int y = other.y;              //y:�ӵ���y
		
		return x>=x1 && x<=x2 
			   && 
			   y>=y1 && y<=y2; //x��x1��x2֮�䣬���ң�y��y1��y2֮�䣬����ײ����
	}
	
	/** ������ȥ�� */
	public void goDead(){
		state = DEAD; //������״̬�޸�ΪDEAD
	}
	
}






















