package contract;

import fr.exia.showboard.BoardFrame;

import javax.swing.*;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

	void displayMessage(final String message);

	void followMyPlayer();

	void updateView();

	BoardFrame getBoardFrame();
}
