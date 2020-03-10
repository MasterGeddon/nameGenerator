package Visuell;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Generator.NameGenerator;

public class GenPan extends JPanel {

	private NameGenerator namGam;
	public JButton gen;
	// public JButton fetzen;
	public JComboBox genMode;

	public JTextField anzNamen;
	public JTextField namenGroot;
	public JScrollPane scrollP;
	public JTable nameTable = new JTable();

	private static int ANZ_TEXTFIELD_LIMIT = 3;
	private static int TEXTFIELD_HEIGHT = 10;
	private static int TEXTFIELD_WIDTH = 30;
	private static int ANZ_NAMEN = 20;
	private static int NAMEN_LENGTH = 2;

	private boolean number1 = true;
	private boolean number2 = true;
	private String[][] nameList;

	public String[][] getNameList() {
		return nameList;
	}

	public String[] mode = { "Bitte Auswählen", "Namensliste", "Fetzen" };

	public GenPan() {

		JPanel topPane = new JPanel();
		genMode = new JComboBox(mode);

		scrollP = new JScrollPane();

		topPane.setLayout(new FlowLayout());
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
					int test = Integer.parseInt(namenGroot.getText() + "");
					number1 = true;
				} catch (NumberFormatException e) {
					number1 = false;
				}

				System.out.println(number1 + " " + arg0.getKeyChar());

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

				try {
					int test = Integer.parseInt(namenGroot.getText());
					number1 = true;
				} catch (NumberFormatException e) {
					number1 = false;
				}
				System.out.println(number1 + " " + arg0.getKeyChar());
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
					int test = Integer.parseInt(anzNamen.getText() + "");
					number2 = true;
				} catch (NumberFormatException e) {
					number2 = false;
				}

				System.out.println(number2 + " " + arg0.getKeyChar());

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

				try {
					int test = Integer.parseInt(anzNamen.getText());
					number2 = true;
				} catch (NumberFormatException e) {
					number2 = false;
				}
				System.out.println(number2 + " " + arg0.getKeyChar());
			}

		});

		gen = new JButton("Generieren");
		gen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int temp1 = ANZ_NAMEN;
				int temp2 = NAMEN_LENGTH;
				namGam = new NameGenerator();
				// TODO Auto-generated method stub
				if (genMode.getSelectedIndex() != 0) {
					nameTable = new JTable();
					int tempCol = 1;
					if (genMode.getSelectedIndex() == 1) {

						if (!anzNamen.getText().contentEquals("") && number2) {
							int f = Integer.parseInt(anzNamen.getText());
							namGam.setAnzN(f);
							temp1 = f;
						} else {
							namGam.setAnzN(ANZ_NAMEN);
						}
						if (!namenGroot.getText().contentEquals("") && number1) {
							int f = Integer.parseInt(namenGroot.getText());
							namGam.setnLang(f);
							temp2 = f;
						} else {
							namGam.setnLang(NAMEN_LENGTH);
						}
						String[] namen = namGam.getNamen_a_m();
						nameList = namGam.generate_multipleNames(namGam.getAnzN(), namGam.getnLang(), namen);

					} else if (genMode.getSelectedIndex() == 2) {
						if (!anzNamen.getText().contentEquals("") && number2) {
							int f = Integer.parseInt(anzNamen.getText());
							namGam.setAnzN(f);
							temp1 = f;
						} else {
							namGam.setAnzN(ANZ_NAMEN);
						}
						if (!namenGroot.getText().contentEquals("") && number1) {
							int f = Integer.parseInt(namenGroot.getText());
							namGam.setnLang(f);
							temp2 = f;

						} else {
							namGam.setnLang(NAMEN_LENGTH);
						}
						namGam.fetzen(namGam.getAnzN() * namGam.getnLang());
						nameList = namGam.generate_multipleNames(namGam.getAnzN(), namGam.getnLang(),
								namGam.getFetzWort());
					}

					if (nameList != null) {
						System.out.println("teast");
						DefaultTableModel tableModel = new DefaultTableModel();
						for (int i = 0; i < temp2; i++) {

							tableModel.addColumn("Name " + (i + 1));
						}

						for (String[] a : nameList) {
							for (String b : a) {
								System.out.print(b + " ");
							}
							System.out.print("\n");
							tableModel.addRow(a);
						}
						System.out.println("===================== \n");
						scrollP.removeAll();
						scrollP.repaint();
						nameTable = new JTable(tableModel);
						nameTable.setVisible(true);
						scrollP = new JScrollPane(nameTable);
						scrollP.setVisible(true);
						add(scrollP);
						revalidate();
						repaint();
						repaint();
					}

				}

			}
		});

		topPane.add(gen);
		topPane.add(genMode);
		topPane.add(anzNamen);
		topPane.add(namenGroot);

		topPane.setVisible(true);
		setLayout(new BorderLayout());
		add(topPane, BorderLayout.NORTH);
		add(scrollP, BorderLayout.CENTER);

		setVisible(true);
		scrollP.repaint();
		scrollP.revalidate();
		repaint();
	}

}
