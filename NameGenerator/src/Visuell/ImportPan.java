package Visuell;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ImportPan extends JPanel {

	public JFileChooser chooser = new JFileChooser();
	public JTextField name = new JTextField();
	public JScrollPane scroller = new JScrollPane();
	public JTable table = new JTable ();
	
	
	
	public ImportPan () {
		
		
		
		
		setLayout(new GridLayout(0,2));
		
		
		add(chooser);
		add(name);
		scroller.add(table);
		
		add(scroller);	
		setVisible(true);
		
		
	}
	
}
