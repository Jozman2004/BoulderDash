import java.io.IOException;

import controller.BoulderDashController;
import controller.IBoulderDashController;
import model.BoulderDashModel;
import model.IBoulderDashModel;
import view.BoulderDashView;
import view.IBoulderDashView;

public abstract class BoulderDash {
    /** The Constant startX. */
    private static final int startX = 5;

    /** The Constant startY. */
    private static final int startY = 0;
    public static void main(final String[] args) throws IOException, InterruptedException {
        final IBoulderDashModel model = new BoulderDashModel("src\\maps\\MAP1.txt", startX, startY);
        final IBoulderDashView view = new BoulderDashView(model.getRoad(), model.getPlayer());
        final IBoulderDashController controller = new BoulderDashController(view, model);
        ((BoulderDashView) view).setOrderPerformer(controller.getOrderPeformer());

        controller.play();
    }
}
