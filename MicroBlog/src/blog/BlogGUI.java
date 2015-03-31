package blog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BlogGUI implements ActionListener {
	
	private JFrame mainFrame;
	private JLabel charLimit;
	private JTextArea postTextArea;
	private JTextField postContent;
	private JButton refresh;
	private JButton post;
	
	public BlogGUI() {
		
	}
	
	public void setWindows() {
		mainFrame = new JFrame("Your Name");
		mainFrame.setSize(500, 500);
		mainFrame.setLayout(new GridLayout(2,1,1,5));
		mainFrame.getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		charLimit = new JLabel("You can still input 140 Characters");
		postTextArea = new JTextArea("What's on your mind?");
		postContent = new JTextField("Here is put my posts!");
		refresh = new JButton("refresh");
		post = new JButton("post");
		
		JPanel p1 = new JPanel(new BorderLayout());
		p1.setBorder(BorderFactory.createLineBorder(Color.gray));
		p1.add(charLimit, BorderLayout.NORTH);
		postTextArea.setBackground(new Color(255,255,224));
		p1.add(postTextArea, BorderLayout.CENTER);
		
		JPanel p2 = new JPanel(new GridLayout(1,2));
		refresh.setBackground(new Color(176,196,222));
		refresh.addActionListener(this);
		p2.add(refresh);
		post.setBackground(new Color(135,206,250));
		post.addActionListener(this);
		p2.add(post);
		
		p1.add(p2, BorderLayout.SOUTH);
		
		mainFrame.add(p1);
		postContent.setHorizontalAlignment(postContent.CENTER);
		postContent.setEnabled(true);
		mainFrame.add(postContent);
		
		mainFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == refresh){
			postContent.setText("You click REFRESH!");
		}
		else if(e.getSource() == post){
			postContent.setText("Here is put my posts!");
		}
	}
	
	public static void main(String[] args) {
		BlogGUI blogGUi = new BlogGUI();
		blogGUi.setWindows();
	}
}
