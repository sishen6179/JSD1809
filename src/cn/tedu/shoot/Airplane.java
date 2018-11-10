package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** С�л�:�Ƿ����Ҳ�Ƿ� */
public class Airplane extends FlyingObject implements Enemy {
	/*
	 * A:��̬��������̬�鸳ֵ-----------��õ�
	 *   --��һ��new����(����������imagesһ�ݣ���̬�鸳һ��ֵ)
	 *   --�Ժ�new����----ʲôҲ������
	 * B:ʵ�������������и�ֵ
	 *   --��һ��new����(���з���images�������и�һ��ֵ)
	 *   --�ڶ���new����(���з���images�������и�һ��ֵ)
	 *   --������new����(���з���images�������и�һ��ֵ)
	 * C:��̬�����������и�ֵ
	 *   --��һ��new����(����������imagesһ�ݣ������и�һ��ֵ)
	 *   --�ڶ���new����(�����и�һ��ֵ)
	 *   --������new����(�����и�һ��ֵ)
	 */
	
	private static BufferedImage[] images; //ͼƬ
	static{
		images = new BufferedImage[5];
		for(int i=0;i<images.length;i++){
			images[i] = loadImage("airplane"+i+".png");
		}
	}
	
	private int speed; //�ƶ��ٶ�
	/** ���췽�� */
	public Airplane(){
		super(49,36);
		speed = 2;
	}
	
	/** ��дstep()�ƶ� */
	public void step(){
		y+=speed; //y+(����)
	}
	
	int index = 1; //����ʱ����ʼ�±�
	/** ��дgetImage()��ȡͼƬ */
	public BufferedImage getImage(){ //ÿ10������һ��
		if(isLife()){ //��Ϊ���ŵģ��򷵻�images[0]
			return images[0];
		}else if(isDead()){ //��Ϊ���˵�
			BufferedImage img = images[index++]; //images[1]��images[4]
			if(index==images.length){ //�������һ��ͼƬ��
				state = REMOVE; //������״̬�޸�Ϊɾ��״̬
			}
			return img;
		}
		return null; //REMOVE״̬ʱ������null
		/*
		 *                   index=1
		 * 10M img=images[1] index=2                  ����images[1]
		 * 20M img=images[2] index=3                  ����images[2]
		 * 30M img=images[3] index=4                  ����images[3]
		 * 40M img=images[4] index=5(REMOVE) ����images[4]
		 * 50M 
		 */
	}
	
	/** ��дgetScore()�÷� */
	public int getScore(){
		return 1; //���С�л�����ҵ�1��
	}
	
}

















