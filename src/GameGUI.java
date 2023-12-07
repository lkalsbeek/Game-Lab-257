import javax.swing.*;
import javax.swing.text.DefaultCaret;

import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame implements KeyListener{
	
	private JTextArea textArea;
	private JLabel label;
	private JTextField textField;
	private NPC current;
	
	public void print(String s) {
		textArea.append(s+"\n\n");
	}
	
	public GameGUI() {
		setTitle("Dock Escape");
		setSize(755,510);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
//		label = new JLabel(Game.getCurrentRoom().getName());
//		label.setFont(new Font(null, Font.BOLD, 25));
//		label.setForeground(Color.BLACK);
//		add(label, BorderLayout.NORTH);
		
		textArea = new JTextArea();
		textArea.setRows(15);
		textArea.setColumns(30);
		textArea.setFont(new Font(null, Font.PLAIN, 20));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		DefaultCaret caret = (DefaultCaret) textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JScrollPane scroll = new JScrollPane(textArea);
		add(scroll, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setFont(new Font(null, Font.PLAIN, 20));
		textField.addKeyListener(this);
		add(textField, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == '\n') {
			if(NPC.convo == true) {
				int choice = Integer.parseInt(textField.getText());
				NPC.npc.response(choice);
			}else {
				Game.command(textField.getText()); 
			}
			textField.setText("");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}


