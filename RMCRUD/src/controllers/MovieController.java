package controllers;

import models.Movie;
import models.MovieEntity;
import views.MovieForm;
import views.MovieView;

/**
 * 
 * @author Salvador de J. Ron Osio
 *
 */

public class MovieController {

	MovieView view;

	MovieForm form;

	Movie model;

	public MovieController() {

		view = new MovieView(this);
		form = new MovieForm(this);
		form.display();
		model = new Movie();

	}

	public void view() {

		view.display();

	}

	public void add() {

		form.setVisible(true);

		form.setTitle("Nuevo Registro");
		form.create(model.qty(), new MovieEntity());

	}

	public void update(int pos, String title, String duration, String year, String gender) {

		MovieEntity aux = new MovieEntity();

		aux.setTitle(title);

		aux.setDuration(duration);

		aux.setYear(year);

		aux.setGender(gender);

		if (pos >= model.qty()) {

			model.create(aux);

			view.create(pos, model.read(pos), model.qty());
		} else {

			model.update(pos, aux);

			view.edit(pos, model.read(pos));
		}

		form.setVisible(false);
	}

	public void delete(int pos) {

		model.delete(pos);

		view.delete(pos);

	}

	public void edit(int pos) {

		form.setTitle("Modificar Registro");
		form.setVisible(true);
		form.edit(pos, model.read(pos));

	}

}
