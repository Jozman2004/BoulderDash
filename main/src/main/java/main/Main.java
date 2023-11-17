/**
 * @author Laetitia, Arthur, Anthony
 * @version 1.0.8
 */
package main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;
import controller.Controller;
import model.DBConnection;
import model.Model;
import view.View;

/**
 * The Class Main.
 *
 * @author Laetitia, Arthur, Anthony
 */
public abstract class Main {


    private static String[] filenames = new String[] {"BoulderDashMap1.txt", "Sprites/Space.png", "Sprites/Rock.png", "Sprites/Diamond.png", "Sprites/Door.png", "Sprites/Butterfly.png", "Sprites/Ground.png", "Sprites/Died.png", "Sprites/Down1.png", "Sprites/Left1.png", "Sprites/Stable.png", "Sprites/Right1.png", "Sprites/Up1.png", "Sprites/Win.png", "Sprites/Wall.png"};

    private static View view;
    private static IModel model;
    private static IController controller;
    private static DBConnection dbConnection;

    /**
     * The main method.
     *
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(final String[] args) {
        file();
        checkFiles();
        //menu();
        game();

        System.exit(0);
    }


    // The method for do the verification of the file after read
    static void checkFiles() {
        File file;
        for (String filename : filenames) {
            file = new File(filename);
            if (!file.exists()){
                JOptionPane.showMessageDialog(null, "File \"" + filename + "\" is missing.\nPlease put the file back in its place and then restart.", "BoulderDash - Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                return;
            }
        }
    }

    // The method for try to create the file
    static void file() {
        DBConnection db = new DBConnection();
        db.open();
        db.loadBD("map1");
        List<String> mapLines = db.loadBD("map1");
        db.saveToFile(mapLines,"BoulderDashMap1.txt");
        db.close();
    }

    // The method for start the game
    static void game() {
        do {
            model = new Model(filenames[0], 1, 1);

            if (model.getMap().isCorrect()) {
                view = new View(model.getMap(), model.getMyPlayer());
                controller = new Controller(view, model);
                view.setOrderPerformer(controller.getOrderPerformer());

                controller.play();

            } else {
                JOptionPane.showMessageDialog(null, "The map isn't in the right format!\nCheck your map file (map.txt).", "BoulderDash - Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        while(true);
    }
}
