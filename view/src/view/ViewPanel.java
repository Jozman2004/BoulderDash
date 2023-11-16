package view;
import fr.exia.showboard.IPawn;
import javax.swing.*;
import java.awt.*;

public class ViewPanel extends JPanel {

	private static final long serialVersionUID = -998294702363713521L;

	private final IPawn pawn;

	public ViewPanel(final IPawn pawn) {
		super();
		this.pawn = pawn;
	}

	@Override
	protected final void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		graphics.drawImage(this.pawn.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
}