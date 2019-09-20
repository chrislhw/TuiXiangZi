package game;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//继承Frame类
public class MainFrame extends Frame implements KeyListener{
	//构造方法
	public MainFrame(){
		//做笼子的方法
		cageInit();
		//做人物的方法
		wolfInit();
		//做箱子的方法
		sheepInit();
		//作障碍的方法
		treeInit();
		//制作背景的方法
		backgroundInit();
		//设置窗体
		setMainFrameUI();
		//监听机制，检测用户是否动用了键盘
		this.addKeyListener(this);
	}	
	//设置一个JLabel组件
	JLabel[][] sheeps = new JLabel[12][16];
	//利用二维数组进行场景数据的模拟，其中1代表障碍，0代表空地
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
	//人物横向的位置
	int wx ;
	//人物纵向的位置
	int wy ;
	//移到目标的箱子的数目
	int num = 0;
	//箱子的总数
	int total = 4;
	
	//障碍的初始化
	private void treeInit(){
		//插入图片
		Icon ic = new ImageIcon("树.png");
		//遍历二维数组
		for(int i = 0;i<datas.length;i++){
			for(int j = 0;j<datas[i].length;j++){
				//如果数组元素的值是1，做障碍
				if(datas[i][j] == 1){
					JLabel lab_tree = new JLabel(ic);
					//3.设置障碍的大小和位置
					lab_tree.setBounds(12+50*j,36+50*i,50,50);                           
					//4.将障碍添加到窗体中
					this.add(lab_tree);
				}
			}
		}
	}
	//目标（笼子）的初始化
	private void cageInit() {
		//插入图片
		Icon i = new ImageIcon("笼子.png");
		JLabel lab_cage1 = new JLabel(i);
		//设置大小和位置
		lab_cage1.setBounds(212, 386, 50, 50);
		//添加进窗体
		this.add(lab_cage1);
		//将目标对应位置上的数据为8，使得数字8在数组中代表目标（笼子）
		datas[7][4] = 8;
		//第二个箱子的制作同上
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
	//箱子（羊）的初始化
	private void sheepInit(){
		//插入图片
		Icon i = new ImageIcon("未抓羊.gif");
		JLabel lab_sheep1 = new JLabel(i);
		//设置箱子的大小和位置
		lab_sheep1.setBounds(12+4*50, 36+5*50, 50, 50);
		//把箱子添加到窗体中
		this.add(lab_sheep1);
		//将箱子对应位置上的数据改为4，使4在数组中代表箱子
		datas[5][4] = 4;
		sheeps[5][4] = lab_sheep1;
	//制作第二只羊，方法与第一只羊一样
		JLabel lab_sheep2 = new JLabel(i);
		lab_sheep2.setBounds(312, 336, 50, 50);	
		this.add(lab_sheep2);
		datas[6][6] = 4;
		sheeps[6][6] = lab_sheep2;
		//第三只羊的做法同上
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
	//人物的初始化
	private void wolfInit() {
		//人物的初始位置（见45行，47行）
		wx = 4 ;
		wy = 6 ;
		//插入人物的图片
		Icon i = new ImageIcon("正面.png");
		lab_wolf = new JLabel(i);
		//设置人物的大小和位置
		lab_wolf.setBounds(12 + wx*50, 36 + wy*50, 50, 50);
		//把人物添加到窗体里面
		this.add(lab_wolf);
	}
	JLabel lab_wolf;
	//背景初始化
	private void backgroundInit() {
		//插入图片
		Icon i = new ImageIcon("背景.png");
		JLabel lab_bg = new JLabel(i);
		//设置背景的位置和大小
		lab_bg.setBounds(12, 36, 800, 600);
		//将背景添加到窗体里面
		this.add(lab_bg);
	}
	//设置主窗体界面
	private void setMainFrameUI(){
		//设置窗体的布局模式为自由布局
		this.setLayout(null);
		//设置窗口的标题
		this.setTitle("喜羊羊与灰太狼版推箱子 ");
		//设置窗体是否可调节大小
		this.setResizable(true);
		//设置窗口的位置
		this.setLocation(110, 30);
		//设置窗口尺寸
		this.setSize(826,650);
		//设置窗体是否显示
		this.setVisible(true);
	}
	//胜利判定
	private void victory(){
		//如果移到目标的箱子的数目等于总数（sum==total）（见49,50行），则判定为胜利，游戏结束
		if(num == total){
			System.out.println("胜利");
		}
		/*
			将每一种情况全部设计出来，不管是按哪一个键都有这十三种情况
				-----人物	树木
				-----人物	箱子		树木
				-----人物	箱子		箱子
				-----人物	箱子		目标箱子
				-----人物	目标箱子		树木
				-----人物	目标箱子		箱子
				-----人物	目标箱子		目标箱子
				不做任何事情
				-----人物	空地
				-----人物	空目标
				人坐标	人图片	人显示位置
				-----人物	箱子		空地
				人坐标	人图片	人显示位置	箱子位置		箱JLabel		4-0	0-4
				-----人物	箱子		空目标
				人坐标	人图片	人显示位置	箱子位置		箱JLabel		4-0	8-12  num++;
				-----人物	目标箱子		空地
				人坐标	人图片	人显示位置	箱子位置		箱JLabel		12-8	0-4   num--;
				-----人物	目标箱子		空目标
				人坐标	人图片	人显示位置	箱子位置		箱JLabel		12-8	8-12

		 */
	}
	public void keyReleased(KeyEvent e) {
		//利用键盘码值将点击键盘用数值代替
		//左用37替换，上用38替换，右用39替换，下用40替换
		int key = e.getKeyCode();
		if(key == 37){
			//让人物向左移动
			if(datas[wy][wx-1] == 0){
				wx = wx-1;
				int x =(int)lab_wolf.getLocation().getX();
				int y =(int)lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x-50, y);
				Icon i = new ImageIcon("向左.png");
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
				Icon i = new ImageIcon("向左.png");
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
			Icon i = new ImageIcon("向左.png");
			lab_wolf.setIcon(i);
			victory();
			return;
		}
		if(key == 38){
			//让人物向上移动
			if(datas[wy-1][wx] == 0){
				wy = wy-1;
				int x =(int)lab_wolf.getLocation().getX();
				int y =(int)lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x, y-50);
				Icon i = new ImageIcon("向后.png");
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
				Icon i = new ImageIcon("向后.png");
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
			Icon i = new ImageIcon("向后.png");
			lab_wolf.setIcon(i);
			victory();
			return;
		}
		if(key == 39){
			//让人物向右移动
			if(datas[wy][wx+1] == 0){
				wx = wx+1;
				int x =(int)lab_wolf.getLocation().getX();
				int y =(int)lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x+50, y);
				Icon i = new ImageIcon("向右.png");
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
				Icon i = new ImageIcon("向右.png");
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
			Icon i = new ImageIcon("向右.png");
			lab_wolf.setIcon(i);
			//判断胜利
			victory();
			return;
		}
		if(key == 40){
			//让人物向下移动
			if(datas[wy+1][wx] == 0){
				wy = wy+1;
				int x =(int)lab_wolf.getLocation().getX();
				int y =(int)lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x, y+50);
				Icon i = new ImageIcon("正面.png");
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
				Icon i = new ImageIcon("正面.png");
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
			Icon i = new ImageIcon("正面.png");
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
