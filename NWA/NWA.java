import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NWA extends JFrame {
	
	JTextField sequenceAInput;
	JTextField sequenceBInput;
	JPanel gridPanel;
	JButton quit;
	JButton align;
	JLabel banner;
	JPanel sequenceInputs;
	private static final long serialVersionUID = 1L;
	final String allowedLetters = "aAcCgGtT";

	public NWA() {
		banner = new JLabel("Enter two DNA sequences and press align");
		sequenceAInput = new JTextField("", 15);
		sequenceAInput.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				textProcessing(c, e);
			}
		});
		sequenceBInput = new JTextField("", 15);
		sequenceBInput.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				textProcessing(c, e);
			}
		});
		sequenceInputs = new JPanel();
		sequenceInputs.setLayout(new BoxLayout(sequenceInputs, BoxLayout.Y_AXIS));
		sequenceInputs.add(sequenceAInput);
		sequenceInputs.add(sequenceBInput);
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(4,4,4,4));
		quit = new JButton("quit");
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
				if (answer == 0){
					System.exit(0);
				}
            }
        });     
        align = new JButton("Align");
        align.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		align();
        	}
        });
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    c.fill = GridBagConstraints.BOTH;
	    c.gridx = 0;
	    c.gridy = 0;
	    panel.add(banner, c);
	    c.gridx = 5;
	    c.gridy = 0;
		panel.add(sequenceInputs, c);
		c.gridx = -4;
		c.gridy = 1;
		panel.add(gridPanel, c);
		c.gridx = 0;
		c.gridy = 3;
		panel.add(align, c);
		c.gridx = 5;
		c.gridy = 3;
		panel.add(quit,c);
		this.setContentPane(panel);
		this.pack();
		this.setTitle("Needleman-Wunsch Algorithm");
		this.setResizable(true);
		//this.setSize(800,600);
	}
	
	/**
	 * If the character is not in the approved characters list, or a special key, it is discarded
	 * @param c the character typed in to the textField box
	 * @param e the KeyEvent started by a key being typed 
	 */
	public void textProcessing(char c, KeyEvent e){
		if (!(contains(c) ||
				(c == KeyEvent.VK_BACK_SPACE) ||
				(c == KeyEvent.VK_DELETE))) {
				e.consume();
			}
	}
	
	
	/**
	 *  I put this in to its own method just for ease of reading
	 * @param c character to be checked against allowedLetters
	 * @return whether c is in allowedLetters
	 */
	public boolean contains(char c) {
		for (int i = 0; i < allowedLetters.length(); i++){
			if ( allowedLetters.charAt(i) == c) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The function where the actual algorithm takes place
	 */
	public void align() {
		System.out.println("A: " + sequenceAInput.getText());
		System.out.println("B: " + sequenceBInput.getText());
		
		String sequenceA = sequenceAInput.getText();
		String sequenceB = sequenceBInput.getText();
		
		int lengthOfA = sequenceA.length();
		int lengthOfB = sequenceB.length();
		
		int differenceInLength = Math.abs(lengthOfA - lengthOfB);
		if (differenceInLength > 5) {
			int answer = JOptionPane.showConfirmDialog(null, "Your strings differ by " + differenceInLength +
					", are you sure you wish to proceed?", "Verification", JOptionPane.YES_NO_OPTION);
			if (answer == 0) {
				//align
				System.out.println("Proceeding");
				
				int[][] score = new int[lengthOfA][lengthOfB];
				
				
				
				
				
			} else {
				;
				// Do nothing this time
			}
		}
		
		
		
	}
	
}
