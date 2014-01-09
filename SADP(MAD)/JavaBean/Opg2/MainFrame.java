package Opg2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private YesNoPanel yesNoPanel;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(216, 369, 202, 14);
		contentPane.add(lblNewLabel);

		yesNoPanel = new YesNoPanel();
		yesNoPanel.setBounds(94, 21, 434, 309);
		contentPane.add(yesNoPanel);
		yesNoPanel.addAnswerListener(new AnswerListener() {

			@Override
			public void Yes(AnswerEvent event) {
				lblNewLabel.setText("Yes was pressed");

			}

			@Override
			public void No(AnswerEvent event) {
				lblNewLabel.setText("No was pressed");

			}

		});

	}
}
