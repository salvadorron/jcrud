package views;

import javax.swing.*;

import controllers.MovieController;
import models.Movie;
import models.MovieEntity;

import java.awt.event.*;

import java.awt.*;

/**
 * 
 * @author Salvador de J. Ron Osio
 *
 */

public class MovieForm extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	int pos;
	Movie model;
	MovieController controller;
	JPanel panel, gridPanel;
	JLabel lblTitle, lblDuration, lblYear, lblGender;
	JTextField txtTitle, txtDuration, txtYear, txtGender;
	JButton btnCancel, btnAcept;

	public MovieForm(MovieController controller) {

		this.controller = controller;

	}

	public void display() {
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLayout(new BorderLayout());

		panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		btnAcept = new JButton("Aceptar");
		btnAcept.addActionListener(this);
		panel.add(btnAcept);

		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(this);
		panel.add(btnCancel);

		this.add(panel, BorderLayout.SOUTH);

		gridPanel = new JPanel(new GridLayout(8, 0));

		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblTitle = new JLabel("Titulo:");
		panel.add(lblTitle);
		gridPanel.add(panel);

		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		txtTitle = new JTextField(20);
		panel.add(txtTitle);
		gridPanel.add(panel);

		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblDuration = new JLabel("Duracion:");
		panel.add(lblDuration);
		gridPanel.add(panel);

		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		txtDuration = new JTextField(20);
		panel.add(txtDuration);
		gridPanel.add(panel);

		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblYear = new JLabel("Año:");
		panel.add(lblYear);
		gridPanel.add(panel);

		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		txtYear = new JTextField(20);
		panel.add(txtYear);
		gridPanel.add(panel);

		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblGender = new JLabel("Genero:");
		panel.add(lblGender);
		gridPanel.add(panel);

		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		txtGender = new JTextField(20);
		panel.add(txtGender);
		gridPanel.add(panel);

		model = new Movie();

		this.add(gridPanel, BorderLayout.CENTER);

		this.pack();

		this.setLocationRelativeTo(null);

		this.setVisible(false);

	}

	public void create(int pos, MovieEntity m) {

		this.pos = pos;

		Object datos[] = {

				m.getTitulo(), m.getDuration(), m.getYear(), m.getGender()

		};

		model.addRow(datos);

		txtTitle.setText(null);
		txtDuration.setText(null);
		txtYear.setText(null);
		txtGender.setText(null);

	}

	public void edit(int pos, MovieEntity m) {

		this.pos = pos;

		txtTitle.setText(m.getTitulo());
		txtDuration.setText(m.getDuration());
		txtYear.setText(m.getYear());
		txtGender.setText(m.getGender());

	}

	public boolean isEmpty() {

		if (txtTitle.getText().isEmpty() || txtDuration.getText().isEmpty() || txtYear.getText().isEmpty()
				|| txtGender.getText().isEmpty()) {

			return true;

		} else {

			return false;

		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource().equals(btnCancel)) {

			this.setVisible(false);

		}

		if (arg0.getSource().equals(btnAcept)) {

			if (!isEmpty()) {

				controller.update(pos, txtTitle.getText(), txtDuration.getText(), txtYear.getText(),
						txtGender.getText());

			} else {

				Toolkit.getDefaultToolkit().beep();

				JOptionPane.showMessageDialog(this, "Debe Llenar Todos Los Campos");

			}

		}

	}

}
