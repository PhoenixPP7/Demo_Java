package _09_backup_GUI;
/*	������ƣ�Java�¼��������
 * 	Դ�ļ���ƣ�TestActionEvent.java
 *	Ҫ  �㣺
 *  	1. Java�¼��������
 *		2. �¼�Դ���¼��������������
 *		3. �����һ�����������ע�������
 */

import java.awt.*;
import java.awt.event.*;

public class TestActionEvent {
    public static void main(String args[]) {
			Frame f = new Frame("Test");
			Button b = new Button("Press Me!");
			Monitor bh = new Monitor();
			b.addActionListener(bh);
			f.add(b,BorderLayout.CENTER);
			f.pack();
			f.setVisible(true);
    }
}

class Monitor implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("a button has been pressed");    
    }
}
