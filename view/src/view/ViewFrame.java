package view;


import fr.exia.showboard.IPawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;
import view.ViewPanel;

public class ViewFrame extends JFrame implements KeyListener {

	private static final long serialVersionUID = -697358409737458175L;

	private Dimension dimension;
	private Rectangle displayFrame;
	private final Observer observer = new Observer() {
		@Override
		public void update(Observable o, Object arg) {

		}
	};

	public ViewFrame(final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame();
		this.addKeyListener(this);
		this.requestFocus();
	}

	private void buildViewFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setDimension(new Dimension(1, 1));
	}

	@Override
	public final void keyTyped(final KeyEvent keyEvent) {
		// Nop
	}

	@Override
	public final void keyPressed(final KeyEvent keyEvent) {
		// Nop
	}

	@Override
	public final void keyReleased(final KeyEvent keyEvent) {
		// Nop
	}


	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}


	public final Dimension getDimension() {
		return this.dimension;
	}


	public final void setDimension(final Dimension dimension) {
		this.dimension = dimension;
		this.setSize(dimension);
	}


	public final Rectangle getDisplayFrame() {
		return this.displayFrame;
	}


	public final void setDisplayFrame(final Rectangle displayFrame) {
		this.displayFrame = displayFrame;
	}

	public final void addPawn(final IPawn pawn) {
		final ViewPanel viewPanel = new ViewPanel(pawn);
		this.setContentPane(viewPanel);
		this.setSize(pawn.getX(), pawn.getY());
		this.setLocationRelativeTo(null);
	}


	public final void removeAllPawns() {
		this.setContentPane(new JPanel());
	}


	public final void followCharacter(final int x, final int y) {
		// Nop
	}
	public final Observer getObserver() {
		return this.observer;
	}
}