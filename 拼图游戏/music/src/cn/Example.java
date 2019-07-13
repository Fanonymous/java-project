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
		if (x == xn && y - yn == 100) // �����շ�����·����� down
			b1.setLocation(x, y - 100);
		else if (x == xn && yn - y == 100) // �����շ�����Ϸ����� up
			b1.setLocation(x, y + 100);
		else if (y == yn && x - xn == 100) // �����շ�����ұ߷��� right
			b1.setLocation(x - 100, y);
		else if (y == yn && xn - x == 100) // �����շ������߷��� left
			b1.setLocation(x + 100, y);
		else
			return;
		block[8].setLocation(x, y);// move block[8] to
		if (isFinish())
			//System.out.println("��ϲ��ɹ��ˣ�");
			JOptionPane.showMessageDialog(this, "��ϲ��ɹ��ˣ�");

	}

	public void start() {// �Է�������������У�����˳��

		while (block[0].getBounds().x <= 100 && block[0].getBounds().y <= 100)

		{
			int x = block[8].getBounds().x;
			int y = block[8].getBounds().y;
			int direction = (int) (Math.random() * 4);// ����0-3����Ӧ�շ�������������ƶ�
			if (direction == 0) {// �շ������ƶ�������෽�񻥻�λ�ã���෽�����ƶ�
				x -= 100;
				if (test(x, y)) {
					for (int j = 0; j < 8; j++) {
						if ((block[j].getBounds().x == x) && (block[j].getBounds().y == y)) {// ����Ѱ�����İ�ť
							block[j].setLocation(x + 100, y);//
							block[8].setLocation(x, y);
							break;// �ҵ�������forѭ��
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

	public boolean isFinish() {// �ж��Ƿ�ƴ�ϳɹ�
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
