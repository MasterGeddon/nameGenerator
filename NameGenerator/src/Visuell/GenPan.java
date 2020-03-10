package Visuell;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Generator.NameGenerator;

public class GenPan extends JPanel{

	
	private NameGenerator namGam;
	public JButton gen;
	//public JButton fetzen;
	public JComboBox genMode;
	
	public JTextField anzNamen;
	public JTextField namenGroot;
	public JScrollPane scrollP;
	public JTable nameTable;
	
	private static int ANZ_TEXTFIELD_LIMIT =3;
	private static int TEXTFIELD_HEIGHT =10; 
	private static int TEXTFIELD_WIDTH =30; 
	private static int ANZ_NAMEN = 20;
	private static int NAMEN_LENGTH = 2;
	
	private boolean number = true;
	
	private String[][] nameList;
	
	
	public String[][] getNameList() {
		return nameList;
	}


	public String[] mode= {"Bitte Auswählen","Namensliste","Fetzen"};
	
	public GenPan() {
		
		genMode = new JComboBox(mode);
		
		setLayout(new FlowLayout());
		
		
		anzNamen = new JTextField(ANZ_TEXTFIELD_LIMIT);
		
		anzNamen.setToolTipText("Anzahl an Namen");
		anzNamen.setSize(TEXTFIELD_HEIGHT, TEXTFIELD_WIDTH);
		
		namenGroot = new JTextField(ANZ_TEXTFIELD_LIMIT);
		
		
		namenGroot.setToolTipText("Maximaler Name");
		namenGroot.setSize(TEXTFIELD_HEIGHT, TEXTFIELD_WIDTH);
		
		namenGroot.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				try {
					int test = Integer.parseInt(arg0.getKeyChar()+"");
					
				}catch(NumberFormatException e) {
					number = false;
				}
				
				System.out.println(number +" "+arg0.getKeyChar());
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
				try {
					int test = Integer.parseInt(namenGroot.getText());
					number = true;
				}catch(NumberFormatException e) {
					number = false;
				}
				System.out.println(number +" "+arg0.getKeyChar());
			}
			
		});
		
		anzNamen.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				try {
					int test = Integer.parseInt(arg0.getKeyChar()+"");
					
				}catch(NumberFormatException e) {
					number = false;
				}
				
				System.out.println(number +" "+arg0.getKeyChar());
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
				try {
					int test = Integer.parseInt(anzNamen.getText());
					number = true;
				}catch(NumberFormatException e) {
					number = false;
				}
				System.out.println(number +" "+arg0.getKeyChar());
			}
			
		});
		
		gen = new JButton("Generieren");
		gen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				namGam = new NameGenerator();
				// TODO Auto-generated method stub
				if(genMode.getSelectedIndex()!=0) {
					nameTable = new JTable();
					int tempCol=1;
					if(genMode.getSelectedIndex()==1) {
						
						
						if(!anzNamen.getText().contentEquals("")&&number) {
							int f=Integer.parseInt(anzNamen.getText());
							namGam.setAnzN(f);
							
						}else {
							namGam.setAnzN(ANZ_NAMEN);
						}
						if(!namenGroot.getText().contentEquals("")&&number) {
							int f=Integer.parseInt(namenGroot.getText());
							namGam.setAnzN(f);
							
						}else {
							namGam.setnLang(NAMEN_LENGTH);
						}
						String [] namen = namGam.getNamen_a_m();
						nameList = namGam.generate_multipleNames(namGam.getAnzN(), namGam.getnLang(), namen);
						
						
					}else if(genMode.getSelectedIndex()==2){
						if(!anzNamen.getText().contentEquals("")&&number) {
							int f=Integer.parseInt(anzNamen.getText());
							namGam.setAnzN(f);
							
						}else {
							namGam.setAnzN(ANZ_NAMEN);
						}
						if(!namenGroot.getText().contentEquals("")&&number) {
							int f=Integer.parseInt(namenGroot.getText());
							namGam.setAnzN(f);
							
						}else {
							namGam.setnLang(NAMEN_LENGTH);
						}
						namGam.fetzen(namGam.getAnzN()*namGam.getnLang());
						nameList = namGam.generate_multipleNames(namGam.getAnzN(), namGam.getnLang(),namGam.getFetzWort());
					}
					
				}
				
				
				
				
				
			}
		});
		
		add(gen);
		add(genMode);
		add(anzNamen);
		add(namenGroot);
		
		
		
		
		setVisible(true);
	}
	
	
}
