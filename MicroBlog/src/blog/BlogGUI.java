package blog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import base.Post;
import base.User;

public class BlogGUI{
	
	private JFrame mainFrame;
	private JLabel charLimit;
	private JTextArea postTextArea, postContent;
	private JButton refresh;
	private JButton post;
	private Blog myBlog;
	
	public BlogGUI() {
		User user = new User(1, "A", "a@cse.ust.hk");
		myBlog = new Blog(user);
		String loadfilepath="C:/Users/lhwongae/workspace/A.blog";
		myBlog.load(loadfilepath);
	}
	
	public void setWindows() {
		mainFrame = new JFrame("Your Name");
		mainFrame.setSize(500, 500);
		mainFrame.setLayout(new GridLayout(2,1,1,5));
		mainFrame.getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		charLimit = new JLabel("You can still input 120 Characters");
		postTextArea = new JTextArea("What's on your mind?");
		postTextArea.addKeyListener(new lengthListener());
		postTextArea.setLineWrap(true);
		postTextArea.setWrapStyleWord(true);
		postContent = new JTextArea("Here is put my posts!");
		postContent.setLineWrap(true);
		postContent.setWrapStyleWord(true);
		postContent.setEditable(false);
		refresh = new JButton("refresh");
		post = new JButton("post");
		
		JPanel p1 = new JPanel(new BorderLayout());
		p1.setBorder(BorderFactory.createLineBorder(Color.gray));
		p1.add(charLimit, BorderLayout.NORTH);
		postTextArea.setBackground(new Color(255,255,224));
		p1.add(postTextArea, BorderLayout.CENTER);
		
		JPanel p2 = new JPanel(new GridLayout(1,2));
		refresh.setBackground(new Color(176,196,222));
		refresh.addActionListener(new refreshListener());
		p2.add(refresh);
		post.setBackground(new Color(135,206,250));
		post.addActionListener(new postListener());
		p2.add(post);
		
		p1.add(p2, BorderLayout.SOUTH);
		
		mainFrame.add(p1);
		mainFrame.add(postContent);
		
		mainFrame.setVisible(true);
	}
	
	class postListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String content = postTextArea.getText();
			if(content.length() == 0 || content.length() > 140)
				return;
			
			String savefilepath="C:/Users/lhwongae/workspace/A.blog";
			Date date = new Date();
			Post post = new Post(date, content);
			myBlog.post(post);
			myBlog.save(savefilepath);
			postTextArea.setText("");
			charLimit.setText("You can still input 140 Characters");
		}
	}
	
	class refreshListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String loadfilepath="C:/Users/lhwongae/workspace/A.blog";
			myBlog.load(loadfilepath);
			postContent.setText(myBlog.toString());
		}	
	}
	
	class lengthListener implements KeyListener{
		public void keyTyped(KeyEvent e){
			
		}
		
		public void keyPressed(KeyEvent e){
			
		}
		
		public void keyReleased(KeyEvent e){
			int content_length = postTextArea.getText().length();
			if(content_length > 140){
				charLimit.setText("Your post length has exceeded 140!");
			}
			else charLimit.setText("You can still input " + (140 - content_length) + " Characters");
		}
	}
	
	public static void main(String[] args) {
		BlogGUI blogGUi = new BlogGUI();
		blogGUi.setWindows();
	}
}
