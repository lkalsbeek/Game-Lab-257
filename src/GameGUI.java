import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame {
	
	private JTextArea textArea;
	private JLabel label;
	
	public void print(String s) {
		textArea.append(s+"\n\n");
	}
	
	public GameGUI() {
		setTitle("Dock Escape");
		setSize(755,510);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		label = new JLabel(Game.getCurrentRoom().getName());
		label.setFont(new Font(null, Font.BOLD, 30));
		label.setForeground(Color.BLACK);
		add(label);
		
		textArea = new JTextArea();
		textArea.setRows(15);
		textArea.setColumns(30);
		textArea.setFont(new Font(null, Font.PLAIN, 26));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		add(scroll);
		
		setVisible(true);
	}

	

}


