package models;

import java.util.*;

import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Salvador de J. Ron Osio
 *
 */


public class Movie extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	ArrayList<MovieEntity> list = new ArrayList<MovieEntity>();

	public Movie() {

		addColumn("Titulo");

		addColumn("Duracion");

		addColumn("Año");

		addColumn("Genero");

	}

	public boolean isCellEditable(int row, int column) {

		return false;

	}

	public void create(MovieEntity m) {

		list.add(m);

	}

	public MovieEntity read(int pos) {

		return list.get(pos);
	}

	public void update(int pos, MovieEntity m) {

		list.set(pos, m);

	}

	public void delete(int pos) {

		list.remove(pos);
	}

	public int qty() {

		return list.size();
	}

}
