package Opg1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import Opg1_4september.MainTest;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=39,149
	 */
	private final Person person = new Person();
	private JTextField textField;
	private JButton btnChangeName;
	private JTextField textField_1;
	private JButton btnChangeAddress;
	private JTextArea textArea;
	private JTextField textField_2;
	private JButton btnChangeAge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		person.addAgeErrorEventListener(new AgeErrorEventListener() {
			public void ageOutOfRange(AgeErrorEvent event) {
				textField_2.setText("Invalid!");
			}
		});
		person.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				textArea.append("Property changed! Property: " + arg0.getPropertyName() + " oldV: " + arg0.getOldValue() + " newV: " + arg0.getNewValue() + "\n");
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setText("");
		textField.setBounds(90, 25, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		btnChangeName = new JButton("Change name");
		btnChangeName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				person.setName(textField.getText());
			}
		});
		btnChangeName.setBounds(186, 24, 117, 23);
		contentPane.add(btnChangeName);

		textField_1 = new JTextField();
		textField_1.setBounds(90, 60, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		btnChangeAddress = new JButton("Change address");
		btnChangeAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				person.setAddress(textField_1.getText());
			}
		});
		btnChangeAddress.setBounds(186, 58, 117, 23);
		contentPane.add(btnChangeAddress);

		textArea = new JTextArea();
		textArea.setBounds(10, 129, 414, 121);
		contentPane.add(textArea);

		textField_2 = new JTextField();
		textField_2.setBounds(90, 91, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		btnChangeAge = new JButton("Change age");
		btnChangeAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				person.setAge(Integer.parseInt(textField_2.getText().trim()));
			}
		});
		btnChangeAge.setBounds(186, 92, 117, 23);
		contentPane.add(btnChangeAge);
	}
}
