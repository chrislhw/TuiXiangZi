package game;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//�̳�Frame��
public class MainFrame extends Frame implements KeyListener{
	//���췽��
	public MainFrame(){
		//�����ӵķ���
		cageInit();
		//������ķ���
		wolfInit();
		//�����ӵķ���
		sheepInit();
		//���ϰ��ķ���
		treeInit();
		//���������ķ���
		backgroundInit();
		//���ô���
		setMainFrameUI();
		//�������ƣ�����û��Ƿ����˼���
		this.addKeyListener(this);
	}	
	//����һ��JLabel���
	JLabel[][] sheeps = new JLabel[12][16];
	//���ö�ά������г������ݵ�ģ�⣬����1�����ϰ���0����յ�
	int[][] datas = {
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1},
		{1,1,1,1,0,1,1,1,0,0,0,1,1,1,1,1},
		{1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1},
		{1,1,1,0,0,0,1,0,0,0,1,1,1,1,1,1},
		{1,1,1,1,0,0,1,0,0,0,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
	};
	//��������λ��
	int wx ;
	//���������λ��
	int wy ;
	//�Ƶ�Ŀ������ӵ���Ŀ
	int num = 0;
	//���ӵ�����
	int total = 4;
	
	//�ϰ��ĳ�ʼ��
	private void treeInit(){
		//����ͼƬ
		Icon ic = new ImageIcon("��.png");
		//������ά����
		for(int i = 0;i<datas.length;i++){
			for(int j = 0;j<datas[i].length;j++){
				//�������Ԫ�ص�ֵ��1�����ϰ�
				if(datas[i][j] == 1){
					JLabel lab_tree = new JLabel(ic);
					//3.�����ϰ��Ĵ�С��λ��
					lab_tree.setBounds(12+50*j,36+50*i,50,50);                           
					//4.���ϰ���ӵ�������
					this.add(lab_tree);
				}
			}
		}
	}
	//Ŀ�꣨���ӣ��ĳ�ʼ��
	private void cageInit() {
		//����ͼƬ
		Icon i = new ImageIcon("����.png");
		JLabel lab_cage1 = new JLabel(i);
		//���ô�С��λ��
		lab_cage1.setBounds(212, 386, 50, 50);
		//��ӽ�����
		this.add(lab_cage1);
		//��Ŀ���Ӧλ���ϵ�����Ϊ8��ʹ������8�������д���Ŀ�꣨���ӣ�
		datas[7][4] = 8;
		//�ڶ������ӵ�����ͬ��
		JLabel lab_cage2 = new JLabel(i);
		lab_cage2.setBounds(262, 386, 50, 50);
		this.add(lab_cage2);
		datas[7][5] = 8;
		JLabel lab_cage3 = new JLabel(i);
		lab_cage3.setBounds(212, 436, 50, 50);
		this.add(lab_cage3);
		datas[8][4] = 8;
		JLabel lab_cage4 = new JLabel(i);
		lab_cage4.setBounds(262, 436, 50, 50);
		this.add(lab_cage4);
		datas[8][5] = 8;
	}
	//���ӣ��򣩵ĳ�ʼ��
	private void sheepInit(){
		//����ͼƬ
		Icon i = new ImageIcon("δץ��.gif");
		JLabel lab_sheep1 = new JLabel(i);
		//�������ӵĴ�С��λ��
		lab_sheep1.setBounds(12+4*50, 36+5*50, 50, 50);
		//��������ӵ�������
		this.add(lab_sheep1);
		//�����Ӷ�Ӧλ���ϵ����ݸ�Ϊ4��ʹ4�������д�������
		datas[5][4] = 4;
		sheeps[5][4] = lab_sheep1;
	//�����ڶ�ֻ�򣬷������һֻ��һ��
		JLabel lab_sheep2 = new JLabel(i);
		lab_sheep2.setBounds(312, 336, 50, 50);	
		this.add(lab_sheep2);
		datas[6][6] = 4;
		sheeps[6][6] = lab_sheep2;
		//����ֻ�������ͬ��
		JLabel lab_sheep3 = new JLabel(i);
		lab_sheep3.setBounds(462, 336, 50, 50);	
		this.add(lab_sheep3);
		datas[6][9] = 4;
		sheeps[6][9] = lab_sheep3;
		JLabel lab_sheep4 = new JLabel(i);
		lab_sheep4.setBounds(412, 386, 50, 50);	
		this.add(lab_sheep4);
		datas[7][8] = 4;
		sheeps[7][8] = lab_sheep4;
	}	
	//����ĳ�ʼ��
	private void wolfInit() {
		//����ĳ�ʼλ�ã���45�У�47�У�
		wx = 4 ;
		wy = 6 ;
		//���������ͼƬ
		Icon i = new ImageIcon("����.png");
		lab_wolf = new JLabel(i);
		//��������Ĵ�С��λ��
		lab_wolf.setBounds(12 + wx*50, 36 + wy*50, 50, 50);
		//��������ӵ���������
		this.add(lab_wolf);
	}
	JLabel lab_wolf;
	//������ʼ��
	private void backgroundInit() {
		//����ͼƬ
		Icon i = new ImageIcon("����.png");
		JLabel lab_bg = new JLabel(i);
		//���ñ�����λ�úʹ�С
		lab_bg.setBounds(12, 36, 800, 600);
		//��������ӵ���������
		this.add(lab_bg);
	}
	//�������������
	private void setMainFrameUI(){
		//���ô���Ĳ���ģʽΪ���ɲ���
		this.setLayout(null);
		//���ô��ڵı���
		this.setTitle("ϲ�������̫�ǰ������� ");
		//���ô����Ƿ�ɵ��ڴ�С
		this.setResizable(true);
		//���ô��ڵ�λ��
		this.setLocation(110, 30);
		//���ô��ڳߴ�
		this.setSize(826,650);
		//���ô����Ƿ���ʾ
		this.setVisible(true);
	}
	//ʤ���ж�
	private void victory(){
		//����Ƶ�Ŀ������ӵ���Ŀ����������sum==total������49,50�У������ж�Ϊʤ������Ϸ����
		if(num == total){
			System.out.println("ʤ��");
		}
		/*
			��ÿһ�����ȫ����Ƴ����������ǰ���һ����������ʮ�������
				-----����	��ľ
				-----����	����		��ľ
				-----����	����		����
				-----����	����		Ŀ������
				-----����	Ŀ������		��ľ
				-----����	Ŀ������		����
				-----����	Ŀ������		Ŀ������
				�����κ�����
				-----����	�յ�
				-----����	��Ŀ��
				������	��ͼƬ	����ʾλ��
				-----����	����		�յ�
				������	��ͼƬ	����ʾλ��	����λ��		��JLabel		4-0	0-4
				-----����	����		��Ŀ��
				������	��ͼƬ	����ʾλ��	����λ��		��JLabel		4-0	8-12  num++;
				-----����	Ŀ������		�յ�
				������	��ͼƬ	����ʾλ��	����λ��		��JLabel		12-8	0-4   num--;
				-----����	Ŀ������		��Ŀ��
				������	��ͼƬ	����ʾλ��	����λ��		��JLabel		12-8	8-12

		 */
	}
	public void keyReleased(KeyEvent e) {
		//���ü�����ֵ�������������ֵ����
		//����37�滻������38�滻������39�滻������40�滻
		int key = e.getKeyCode();
		if(key == 37){
			//�����������ƶ�
			if(datas[wy][wx-1] == 0){
				wx = wx-1;
				int x =(int)lab_wolf.getLocation().getX();
				int y =(int)lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x-50, y);
				Icon i = new ImageIcon("����.png");
				lab_wolf.setIcon(i);
				return;
			}
			
			if(datas[wy][wx-1] == 1){
				return;
			}
			if(datas[wy][wx-1] == 4 && datas[wy][wx-2] == 1){
				return;
			}
			if(datas[wy][wx-1] == 4 && datas[wy][wx-2] == 4){
				return;
			}
			if(datas[wy][wx-1] == 4 && datas[wy][wx-2] == 12){
				return;
			}
			if(datas[wy][wx-1] == 12 && datas[wy][wx-2] == 1){
				return;
			}
			if(datas[wy][wx-1] == 12 && datas[wy][wx-2] == 4){
				return;
			}
			if(datas[wy][wx-1] == 12 && datas[wy][wx-2] == 12){
				return;
			}
			if(datas[wy][wx-1] == 8){
				wx = wx-1;
				int x =(int)lab_wolf.getLocation().getX();
				int y =(int)lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x-50, y);
				Icon i = new ImageIcon("����.png");
				lab_wolf.setIcon(i);
				return;
			}
			if(datas[wy][wx-1] == 4 && datas[wy][wx-2] == 0){
				datas[wy][wx-1] = 0;
				datas[wy][wx-2] = 4;
			}

			if(datas[wy][wx-1] == 4 && datas[wy][wx-2] == 8){
				datas[wy][wx-1] = 0;
				datas[wy][wx-2] = 12;
				num++;
			}
			if(datas[wy][wx-1] == 12 && datas[wy][wx-2] == 0){
				datas[wy][wx-1] = 8;
				datas[wy][wx-2] = 4;
				num--;
			}
			if(datas[wy][wx-1] == 12 && datas[wy][wx-2] == 8){
				datas[wy][wx-1] = 8;
				datas[wy][wx-2] = 12;
			}
			sheeps[wy][wx-1].setLocation(12+wx*50-100,36+wy*50);
			sheeps[wy][wx-2] = sheeps[wy][wx-1];
			sheeps[wy][wx-1] = null;
			wx = wx-1;
			int x =(int)lab_wolf.getLocation().getX();
			int y =(int)lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x-50, y);
			Icon i = new ImageIcon("����.png");
			lab_wolf.setIcon(i);
			victory();
			return;
		}
		if(key == 38){
			//�����������ƶ�
			if(datas[wy-1][wx] == 0){
				wy = wy-1;
				int x =(int)lab_wolf.getLocation().getX();
				int y =(int)lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x, y-50);
				Icon i = new ImageIcon("���.png");
				lab_wolf.setIcon(i);
				return;
			}
			
			if(datas[wy-1][wx] == 1){
				return;
			}
			if(datas[wy-1][wx] == 4 && datas[wy-2][wx] == 1){
				return;
			}
			if(datas[wy-1][wx] == 4 && datas[wy-2][wx] == 4){
				return;
			}
			if(datas[wy-1][wx] == 4 && datas[wy-2][wx] == 12){
				return;
			}
			if(datas[wy-1][wx] == 12 && datas[wy-2][wx] == 1){
				return;
			}
			if(datas[wy-1][wx] == 12 && datas[wy-2][wx] == 4){
				return;
			}
			if(datas[wy-1][wx] == 12 && datas[wy-2][wx] == 12){
				return;
			}
			
			if(datas[wy-1][wx] == 8){
				wy = wy-1;
				int x =(int)lab_wolf.getLocation().getX();
				int y =(int)lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x, y-50);
				Icon i = new ImageIcon("���.png");
				lab_wolf.setIcon(i);
				return;
			}

			if(datas[wy-1][wx] == 4 && datas[wy-2][wx] == 0){
				datas[wy-1][wx] = 0;
				datas[wy-2][wx] = 4;
			}

			if(datas[wy-1][wx] == 4 && datas[wy-2][wx] == 8){
				datas[wy-1][wx] = 0;
				datas[wy-2][wx] = 12;
				num++;
			}
			if(datas[wy-1][wx] == 12 && datas[wy-2][wx] == 0){
				datas[wy-1][wx] = 8;
				datas[wy-2][wx] = 4;
				num--;
			}
			if(datas[wy-1][wx] == 12 && datas[wy-2][wx] == 8){
				datas[wy-1][wx] = 8;
				datas[wy-2][wx] = 12;
			}
			sheeps[wy-1][wx].setLocation(12+wx*50,36+wy*50-100);
			sheeps[wy-2][wx] = sheeps[wy-1][wx];
			sheeps[wy-1][wx] = null;
			wy = wy-1;
			int x =(int)lab_wolf.getLocation().getX();
			int y =(int)lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x, y-50);
			Icon i = new ImageIcon("���.png");
			lab_wolf.setIcon(i);
			victory();
			return;
		}
		if(key == 39){
			//�����������ƶ�
			if(datas[wy][wx+1] == 0){
				wx = wx+1;
				int x =(int)lab_wolf.getLocation().getX();
				int y =(int)lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x+50, y);
				Icon i = new ImageIcon("����.png");
				lab_wolf.setIcon(i);
				return;
			}
			
			if(datas[wy][wx+1] == 1){
				return;
			}
			if(datas[wy][wx+1] == 4 && datas[wy][wx+2] == 1){
				return;
			}
			if(datas[wy][wx+1] == 4 && datas[wy][wx+2] == 4){
				return;
			}
			if(datas[wy][wx+1] == 4 && datas[wy][wx+2] == 12){
				return;
			}
			if(datas[wy][wx+1] == 12 && datas[wy][wx+2] == 1){
				return;
			}
			if(datas[wy][wx+1] == 12 && datas[wy][wx+2] == 4){
				return;
			}
			if(datas[wy][wx+1] == 12 && datas[wy][wx+2] == 12){
				return;
			}
			
			if(datas[wy][wx+1] == 8){
				wx = wx+1;
				int x =(int)lab_wolf.getLocation().getX();
				int y =(int)lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x+50, y);
				Icon i = new ImageIcon("����.png");
				lab_wolf.setIcon(i);
				return;
			}

			if(datas[wy][wx+1] == 4 && datas[wy][wx+2] == 0){
				datas[wy][wx+1] = 0;
				datas[wy][wx+2] = 4;
			}

			if(datas[wy][wx+1] == 4 && datas[wy][wx+2] == 8){
				datas[wy][wx+1] = 0;
				datas[wy][wx+2] = 12;
				num++;
			}
			if(datas[wy][wx+1] == 12 && datas[wy][wx+2] == 0){
				datas[wy][wx+1] = 8;
				datas[wy][wx+2] = 4;
				num--;
			}
			if(datas[wy][wx+1] == 12 && datas[wy][wx+2] == 8){
				datas[wy][wx+1] = 8;
				datas[wy][wx+2] = 12;
			}
			sheeps[wy][wx+1].setLocation(12+wx*50+100,36+wy*50);
			sheeps[wy][wx+2] = sheeps[wy][wx+1];
			sheeps[wy][wx+1] = null;
			wx = wx+1;
			int x =(int)lab_wolf.getLocation().getX();
			int y =(int)lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x+50, y);
			Icon i = new ImageIcon("����.png");
			lab_wolf.setIcon(i);
			//�ж�ʤ��
			victory();
			return;
		}
		if(key == 40){
			//�����������ƶ�
			if(datas[wy+1][wx] == 0){
				wy = wy+1;
				int x =(int)lab_wolf.getLocation().getX();
				int y =(int)lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x, y+50);
				Icon i = new ImageIcon("����.png");
				lab_wolf.setIcon(i);
				return;
			}
			
			if(datas[wy+1][wx] == 1){
				return;
			}
			if(datas[wy+1][wx] == 4 && datas[wy+2][wx] == 1){
				return;
			}
			if(datas[wy+1][wx] == 4 && datas[wy+2][wx] == 4){
				return;
			}
			if(datas[wy+1][wx] == 4 && datas[wy+2][wx] == 12){
				return;
			}
			if(datas[wy+1][wx] == 12 && datas[wy+2][wx] == 1){
				return;
			}
			if(datas[wy+1][wx] == 12 && datas[wy+2][wx] == 4){
				return;
			}
			if(datas[wy+1][wx] == 12 && datas[wy+2][wx] == 12){
				return;
			}
			
			if(datas[wy+1][wx] == 8){
				wy = wy+1;
				int x =(int)lab_wolf.getLocation().getX();
				int y =(int)lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x, y+50);
				Icon i = new ImageIcon("����.png");
				lab_wolf.setIcon(i);
				return;
			}

			if(datas[wy+1][wx] == 4 && datas[wy+2][wx] == 0){
				datas[wy+1][wx] = 0;
				datas[wy+2][wx] = 4;
			}

			if(datas[wy+1][wx] == 4 && datas[wy+2][wx] == 8){
				datas[wy+1][wx] = 0;
				datas[wy+2][wx] = 12;
				num++;
			}
			if(datas[wy+1][wx] == 12 && datas[wy+2][wx] == 0){
				datas[wy+1][wx] = 8;
				datas[wy+2][wx] = 4;
				num--;
			}
			if(datas[wy+1][wx] == 12 && datas[wy+2][wx] == 8){
				datas[wy+1][wx] = 8;
				datas[wy+2][wx] = 12;
			}
			sheeps[wy+1][wx].setLocation(12+wx*50,36+wy*50+100);
			sheeps[wy+2][wx] = sheeps[wy+1][wx];
			sheeps[wy+1][wx] = null;
			wy = wy+1;
			int x =(int)lab_wolf.getLocation().getX();
			int y =(int)lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x, y+50);
			Icon i = new ImageIcon("����.png");
			lab_wolf.setIcon(i);
			victory();
			return;
		}
	}
	public void keyTyped(KeyEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
		
	}
	
	
}
