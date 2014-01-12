package Opg22;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements Observer {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnClick;
	private JTextField textField;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
						  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						} catch(Exception e) {
						  System.out.println("Error setting native LAF: " + e);
						}
					MainFrame frame = new MainFrame();
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

	public Door door;

	public MainFrame() {

		door = new Door();
		door.addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		lblNewLabel = new JLabel("Current State");
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setText(door.getCurrentState() + "");
		panel.add(textField);
		textField.setColumns(10);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		btnClick = new JButton("Click");
		btnClick.addActionListener(new BtnClickActionListener());

		panel_1.add(btnClick);
	}

	@Override
	public void update(Observable o, Object arg) {
		textField.setText(door.getCurrentState().toString());
	}

	private class BtnClickActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			door.click();
		}
	}
}
