package views;

import javax.swing.*;

import controllers.MovieController;
import models.Movie;
import models.MovieEntity;

import java.awt.*;

import java.awt.event.*;

/**
 * 
 * @author Salvador de J. Ron Osio
 *
 */

public class MovieView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	int pos;
	Movie model;
	JPanel panel;
	MovieController controller;
	JTable board;
	JButton btnCancel, btnEdit, btnNew, btnDelete;

	public MovieView(MovieController controller) {

		this.controller = controller;

	}

	public void display() {

		this.setTitle("Movie Manager Application");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());

                /*
                    TOP BUTTONS
                */
                
		panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(this);
		panel.add(btnDelete);

		btnEdit = new JButton("Update");
		btnEdit.setEnabled(false);
		btnEdit.addActionListener(this);
		panel.add(btnEdit);

		btnNew = new JButton("New");
		btnNew.addActionListener(this);
		panel.add(btnNew);

		this.add(panel, BorderLayout.NORTH);

                /*
                    END OF TOP BUTTONS
                */

		model = new Movie();

		board = new JTable(model);

		board.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				if (board.isRowSelected(board.getSelectedRow())) {
					btnDelete.setEnabled(true);
					btnEdit.setEnabled(true);

				}

			}

		});

		this.add(new JScrollPane(board), BorderLayout.CENTER);

                /*
                    BOTTOM BUTTONS
                */
                
		panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		panel.add(btnCancel);

		this.add(panel, BorderLayout.SOUTH);

                /*
                    END OF BOTTOM BUTTONS
                */

		this.pack();

		this.setLocationRelativeTo(null);

		this.setVisible(true);

	}

	public void create(int pos, MovieEntity m, int cant) {

		this.pos = pos;

		Object data[] = {

				m.getTitulo(), m.getLength(), m.getYear(), m.getGenre()

		};

		model.addRow(data);

	}

	public void delete(int pos) {

		this.pos = pos;

		model.removeRow(pos);

		checkbtn();

	}

	public void edit(int pos, MovieEntity m) {

		this.pos = pos;

		model.setValueAt(m.getTitulo(), pos, 0);
		model.setValueAt(m.getLength(), pos, 1);
		model.setValueAt(m.getYear(), pos, 2);
		model.setValueAt(m.getGenre(), pos, 3);

	}

	public void checkbtn() {

		if (board.getRowCount() <= 0 || !board.isRowSelected(board.getSelectedRow())) {

			btnDelete.setEnabled(false);
			btnEdit.setEnabled(false);

		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource().equals(btnCancel)) {

			System.exit(0);
		}

		if (arg0.getSource().equals(btnNew)) {

			controller.add();

		}

		if (arg0.getSource().equals(btnDelete)) {

			if (JOptionPane.showConfirmDialog(this, "Are you sure do you want to delete this movie?", "Delete Movie",
					JOptionPane.YES_NO_OPTION) == 0) {
				controller.delete(board.getSelectedRow());

			}

		}

		if (arg0.getSource().equals(btnEdit)) {

			controller.edit(board.getSelectedRow());
		}

	}

}
