package cn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Example extends JPanel implements ActionListener {
	mybutton block[];

	public Example() {

		if (music.checkb1()) {
			this.setLayout(null);
			block = new mybutton[9];
			Icon icon;

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					icon = new ImageIcon(this.getClass().getClassLoader().getResource("picture/"+(i * 3 + j + 1)+".jpg"));
					block[i * 3 + j] = new mybutton(icon);
					block[i * 3 + j].addActionListener(this);
					this.add(block[i * 3 + j]);
					block[i * 3 + j].setSize(100, 100);
					block[i * 3 + j].setLocation(j * 100, i * 100);
				}
			}

			this.remove(block[8]);
			// System.out.println(block[8].getBounds().x);
		}
		if (music.checkb2()) {
			this.setLayout(null);
			block = new mybutton[9];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					block[i * 3 + j] = new mybutton(i * 3 + j + 1);// +1
					block[i * 3 + j].addActionListener(this);
					this.add(block[i * 3 + j]);
					block[i * 3 + j].setSize(100, 100);
					block[i * 3 + j].setLocation(j * 100, i * 100);
				}
			}
			this.remove(block[8]);
			// System.out.println(block[8].getBounds().x);
		}
	}

	public void actionPerformed(ActionEvent e) {
		int x, y, xn, yn;
		mybutton b1 = (mybutton) e.getSource();

		x = b1.getBounds().x;
		y = b1.getBounds().y;
		xn = block[8].getBounds().x;// .blockNull.getBounds().x;
		yn = block[8].getBounds().y;// blockNull.getBounds().y;
		if (x == xn && y - yn == 100) // 单击空方块的下方方块 down
			b1.setLocation(x, y - 100);
		else if (x == xn && yn - y == 100) // 单击空方块的上方方块 up
			b1.setLocation(x, y + 100);
		else if (y == yn && x - xn == 100) // 单击空方块的右边方块 right
			b1.setLocation(x - 100, y);
		else if (y == yn && xn - x == 100) // 单击空方块的左边方块 left
			b1.setLocation(x + 100, y);
		else
			return;
		block[8].setLocation(x, y);// move block[8] to
		if (isFinish())
			//System.out.println("恭喜你成功了！");
			JOptionPane.showMessageDialog(this, "恭喜你成功了！");

	}

	public void start() {// 对方格进行重新排列，打乱顺序

		while (block[0].getBounds().x <= 100 && block[0].getBounds().y <= 100)

		{
			int x = block[8].getBounds().x;
			int y = block[8].getBounds().y;
			int direction = (int) (Math.random() * 4);// 产生0-3，对应空方格的上下左右移动
			if (direction == 0) {// 空方格左移动，与左侧方格互换位置，左侧方格右移动
				x -= 100;
				if (test(x, y)) {
					for (int j = 0; j < 8; j++) {
						if ((block[j].getBounds().x == x) && (block[j].getBounds().y == y)) {// 依次寻找左侧的按钮
							block[j].setLocation(x + 100, y);//
							block[8].setLocation(x, y);
							break;// 找到后跳出for循环
						}
					}
				}
			} else if (direction == 1) {// RIGHT
				x += 100;
				if (test(x, y)) {
					for (int j = 0; j < 8; j++) {
						if ((block[j].getBounds().x == x) && (block[j].getBounds().y == y)) {
							block[j].setLocation(x - 100, y);
							block[8].setLocation(x, y);
							break;
						}
					}
				}
			} else if (direction == 2) {// UP
				y -= 100;
				if (test(x, y)) {
					for (int j = 0; j < 8; j++) {
						if ((block[j].getBounds().x == x) && (block[j].getBounds().y == y)) {
							block[j].setLocation(x, y + 100);
							block[8].setLocation(x, y);
							break;
						}
					}
				}
			} else {// DOWN
				y += 100;
				if (test(x, y)) {
					for (int j = 0; j < 8; j++) {
						if ((block[j].getBounds().x == x) && (block[j].getBounds().y == y)) {
							block[j].setLocation(x, y - 100);
							block[8].setLocation(x, y);
							break;
						}
					}
				}
			}

		}

	}

	private boolean test(int x, int y) {
		if ((x >= 0 && x <= 200) && (y >= 0 && y <= 200))
			return true;
		else
			return false;
	}

	public boolean isFinish() {// 判断是否拼合成功
		for (int i = 0; i < 8; i++) {
			int x = block[i].getBounds().x;
			int y = block[i].getBounds().y;
			if (y / 100 * 3 + x / 100 != i) {
				// System.out.print("x=" + x + "y=" + y);
				return false;
			}
		}
		return true;
	}

}
