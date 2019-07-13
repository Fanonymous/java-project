import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test extends JFrame implements ActionListener {
	JButton b[], begin;// 1,b2;
	Panel p;

	Test() {
		p = new Panel();
		p.setLayout(null);
		b = new JButton[9];
		begin = new JButton("¿ªÊ¼");
		this.add(begin, BorderLayout.SOUTH);
		begin.addActionListener(this);
		for (int i = 0; i < b.length; i++) {
			b[i] = new JButton("" + (i + 1));
			b[i].addActionListener(this);
			p.add(b[i]);
			b[i].setSize(100, 100);
			b[i].setLocation(i % 3 * 100, i / 3 * 100);
		}
		p.remove(b[8]);

		this.add(p);
		this.setSize(315, 350);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Test();

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int x, y, xn, yn;
		JButton bt = (JButton) e.getSource();
		xn = b[8].getBounds().x;
		yn = b[8].getBounds().y;
		if (bt == begin) {
			for (int i = 0; i < 10; i++) {
				int r = (int) (Math.random() * 4 + 1);// 1-4
				if (r == 1) {// up
					yn -= 100;
					if (yn <= 200 && yn >= 0 && xn <= 200 && xn > 0) {
						for (int j = 0; j < 8; j++) {
							if (b[j].getBounds().x == xn
									&& b[j].getBounds().y == yn) {
								b[j].setLocation(xn, yn + 100);
								b[8].setLocation(xn, yn);
								break;
							}

						}
					}

				}
				if (r == 2) {// down
					yn += 100;
					if (yn <= 200 && yn >= 0 && xn <= 200 && xn > 0) {
						for (int j = 0; j < 8; j++) {
							if (b[j].getBounds().x == xn
									&& b[j].getBounds().y == yn) {
								b[j].setLocation(xn, yn - 100);
								b[8].setLocation(xn, yn);
								break;
							}

						}
					}

				}
				if (r == 3) {// left
					xn -= 100;
					if (yn <= 200 && yn >= 0 && xn <= 200 && xn > 0) {
						for (int j = 0; j < 8; j++) {
							if (b[j].getBounds().x == xn
									&& b[j].getBounds().y == yn) {
								b[j].setLocation(xn+100, yn);
								b[8].setLocation(xn, yn);
								break;
							}

						}
					}

				}
				if (r == 4) {// right
					xn += 100;
					if (yn <= 200 && yn >= 0 && xn <= 200 && xn > 0) {
						for (int j = 0; j < 8; j++) {
							if (b[j].getBounds().x == xn
									&& b[j].getBounds().y == yn) {
								b[j].setLocation(xn-100, yn);
								b[8].setLocation(xn, yn);
								break;
							}

						}
					}

				}

			}

		} else {

			x = bt.getBounds().x;
			y = bt.getBounds().y;
			if (x == xn && yn - y == 100) {
				bt.setLocation(xn, yn);
				b[8].setLocation(x, y);
			} else if (x == xn && y - yn == 100) {
				bt.setLocation(xn, yn);
				b[8].setLocation(x, y);
			}
			if (y == yn && x - xn == 100) {
				bt.setLocation(xn, yn);
				b[8].setLocation(x, y);
			} else if (y == yn && xn - x == 100) {
				bt.setLocation(xn, yn);
				b[8].setLocation(x, y);
			}

		}
	}

}
