package org.javalusir.swing;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This is a easy JFrame Demo
 * @author javalusir
 *
 */
@SuppressWarnings("serial")
public class MyFrame extends JFrame{

	public Connection conn = null;

	public static void main(String[] args) {
		final JFrame jFrame = new JFrame();
		final JLabel jlabel = new JLabel("开始:");
		final JLabel jlabel2 = new JLabel("结束:");
		final JLabel jlabel3 = new JLabel("结果:");
		final JTextField jText = new JTextField();
		final JTextField jText2 = new JTextField();
		final JTextArea jTextArea = new JTextArea();
		final JButton jButton = new JButton("确定");
		final JButton jButtoncz = new JButton("重置");
		final JPanel panel = new JPanel();
		
		LayoutManager layout = new GridLayout(1,6);
		jFrame.setTitle("我的JFrame");
		layout.addLayoutComponent("1", jButton);
		jTextArea.setTabSize(Integer.MAX_VALUE);
		panel.setLayout(layout);
		
		panel.add(jlabel);
		panel.add(jText);
		panel.add(jlabel2);
		panel.add(jText2);
		panel.add(jButton);
		panel.add(jButtoncz);
		panel.add(jlabel3);
		panel.add(jTextArea);
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jText.getText().equals("")||jText2.getText().equals("")){
					return;
				}
				System.out.println(jText.getText());
			}
		});
		jButtoncz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jText.getText().equals("")&&jText2.getText().equals("")){
					return;
				}
				jText.setText("");
				jText2.setText("");
				jTextArea.setText("");
			}
		});
		jText2.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jText.getText().equals("")||jText2.getText().equals("")){
					return;
				}
				if(e.KEY_EVENT_MASK==8){
					System.out.println("EnterPerssed");
				}
			}
		});
		jFrame.setSize(780, 70);
		jFrame.setLocation(100, 220);

		jFrame.add(panel);
		
		
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
