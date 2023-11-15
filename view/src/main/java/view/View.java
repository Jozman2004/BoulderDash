package view;

import contract.ControllerOrder;
import contract.IController;
import contract.IView;
import controller.Controller;
import entity.IMap;
import fr.exia.showboard.BoardFrame;
import entity.mobile.IMobile;
import fr.exia.showboard.IPawn;
import fr.exia.showboard.ISquare;
import model.Model;
import sun.jvm.hotspot.utilities.Observable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

/**
 * @author G4
 */
public class View extends Observable implements Runnable, KeyListener, IView {

	private static final int test = 2;
	private static final int mapView = 31;
	private Rectangle closeView;

	private IMap map;
	private IMobile myPlayer;
	private int view;
	private IController orderPerformer;
	final BoardFrame attribut = new BoardFrame("Score");
	final BoardFrame boardFrame = new BoardFrame("BoulderDash 1200");
	private IController controllerOrder;

	public View(final IMap map, final IMobile myPlayer) throws IOException {
		this.setView(mapView);
		this.setMap(map);
		this.setMyPlayer(myPlayer);
		this.getMyPlayer().getSprite().loadImage();
		this.setCloseView(new Rectangle(0, this.getMyPlayer().getY(), IMap.getWidth(), mapView));
		SwingUtilities.invokeLater(this);
	}

	private void setMyPlayer(IMobile myPlayer) {
	}

	private IPawn getMyPlayer() {
		return (IPawn) this.myPlayer;
	}

	public View(Model model, ViewFrame viewFrame) {

	}

	public static ControllerOrder keyCodeToControllerOrder(int keyCode) {
		return null;
	}

	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
		System.exit(0);
	}

	@Override
	public final void run() {
		boardFrame.setDimension(new Dimension(IMap.getWidth(), IMap.getHeight()));
		boardFrame.setDisplayFrame(this.closeView);
		boardFrame.setLocation(500, 50);
		boardFrame.setSize(1000, 1000);
		boardFrame.setHeightLooped(false);
		boardFrame.addKeyListener(this);
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);

		refresh();

		boardFrame.addPawn(this.getMyPlayer());
		this.getMap().getObservable().addObserver(boardFrame.getObserver());
		this.followMyPlayer();
		boardFrame.setVisible(true);
	}

	public final void refresh() {
		for (int x = 0; x < IMap.getWidth(); x++) {
			for (int y = 0; y < IMap.getHeight(); y++) {
				boardFrame.addSquare((ISquare) this.map.getOnTheMapXY(x, y), x, y);
			}
		}
	}

	public final void show(final int yStart) {
		int y = yStart % IMap.getHeight();
		for (int view = 0; view < this.getView(); view++) {
			for (int x = 0; x < IMap.getWidth(); x++) {
				if ((x == this.getMyPlayer().getX()) && (y == yStart)) {
					System.out.print(this.getMyPlayer().getSprite().getConsoleImage());
				} else {
					System.out.print(this.getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage());
				}
			}
			y = (y + 1) % IMap.getHeight();
			System.out.print("\n");
		}
	}

	private ControllerOrder keyCodeToUserOrder(final int keyCode) {
		ControllerOrder controllerOrder;
		switch (keyCode) {
			case KeyEvent.VK_RIGHT:
				controllerOrder = ControllerOrder.RIGHT;
				refresh();
				break;
			case KeyEvent.VK_LEFT:
				controllerOrder = ControllerOrder.LEFT;
				refresh();
				break;
			case KeyEvent.VK_DOWN:
				controllerOrder = ControllerOrder.DOWN;
				refresh();
				break;
			case KeyEvent.VK_UP:
				controllerOrder = ControllerOrder.UP;
				refresh();
				break;
			default:
				controllerOrder = ControllerOrder.NOP;
				refresh();
				break;
		}
		return controllerOrder;
	}

	@Override
	public void keyTyped(final KeyEvent keyEvent) {
		// Nop
	}

	@Override
	public final void keyPressed(final KeyEvent keyEvent) {
		try {
			this.getControllerOrder().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void keyReleased(final KeyEvent keyEvent) {
		// Nop
	}


	public final void followMyPlayer() {
		this.getCloseView().y = this.getMyPlayer().getY() - IMap.getHeight() / 2;
		this.getCloseView().x = this.getMyPlayer().getX() - IMap.getHeight() / 2;
	}

	private IMap getMap() {
		return this.map;
	}

	private void setMap(final IMap map) throws IOException {
		this.map = map;
		for (int x = 0; x < IMap.getWidth(); x++) {
			for (int y = 0; y < IMap.getHeight(); y++) {
				this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
			}
		}
	}

	/**
	 * Prints the message.
	 *
	 * @param message the message
	 */
	@Override
	public void printMessage(String message) {

	}

	/**
	 * @param controller
	 */
	@Override
	public void setController(Controller controller) {

	}

	/**
	 * @return
	 */
	@Override
	public IController getControllerOrder() {
		return this.controllerOrder;
	}

	/**
	 * @return
	 */
	@Override
	public Rectangle getCloseView() {
		return this.closeView;
	}

	/**
	 * @return
	 */
	@Override
	public int getView() {
		return this.view;
	}

	/**
	 * @param mapView
	 */
	@Override
	public void setView(int mapView) {

	}

	/**
	 * @param rectangle
	 */
	@Override
	public void setCloseView(Rectangle rectangle) {

	}
}