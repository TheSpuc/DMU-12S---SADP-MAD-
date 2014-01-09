package Opg2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YesNoPanel extends JPanel {

	private String textToShow;
	private String txtYesButton;
	private String txtNoButton;
	private List<AnswerListener> listeners;
	private JLabel lblNewLabel;
	private JButton btnYes;
	private JButton btnNo;

	/**
	 * Create the panel.
	 */
	public YesNoPanel() {
		textToShow = "";
		txtNoButton = "";
		txtYesButton = "";
		listeners = new ArrayList<>();
		setLayout(null);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(180, 106, 46, 14);
		add(lblNewLabel);

		btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fireAnswerEvent(true, new AnswerEvent(this));

			}
		});
		btnYes.setBounds(70, 171, 89, 23);
		add(btnYes);

		btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireAnswerEvent(false, new AnswerEvent(this));
			}
		});
		btnNo.setBounds(235, 171, 89, 23);
		add(btnNo);

	}

	public String getTextToShow() {
		return textToShow;
	}

	public void setTextToShow(String textToShow) {
		this.textToShow = textToShow;
	}

	public String getTxtYesButton() {
		return txtYesButton;
	}

	public void setTxtYesButton(String txtYesButton) {
		this.txtYesButton = txtYesButton;
	}

	public String getTxtNoButton() {
		return txtNoButton;
	}

	public void setTxtNoButton(String txtNoButton) {
		this.txtNoButton = txtNoButton;
	}

	public void addAnswerListener(AnswerListener l) {
		listeners.add(l);
	}

	public void removeAnswerListner(AnswerListener l) {
		listeners.remove(l);
	}

	private void fireAnswerEvent(boolean yes, AnswerEvent ae) {
		List<AnswerListener> list;
		synchronized (this) {
			list = new ArrayList<>(listeners);
		}
		for (AnswerListener al : list) {
			if (yes) {
				al.Yes(ae);
			} else {
				al.No(ae);
			}
		}
	}
}
