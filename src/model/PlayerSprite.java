package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerSprite {
    final int rows = 15;
    final int cols = 6;
    BufferedImage[] sprites = new BufferedImage[rows * cols];

    public BufferedImage[] Image(){
        final int width = 16;
        final int height = 16;
        try {
            BufferedImage bigImg = ImageIO.read(new File("src\\model\\elements\\sprite\\74336.png"));

            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    sprites[(i * cols) + j] = bigImg.getSubimage(
                        j * width,
                        i * height,
                        width,
                        height
                    );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sprites;
    }

    public static void main(String[] args) throws Exception {
        PlayerSprite player = new PlayerSprite();
        player.Image();

        JFrame frame = new JFrame("PlayerSprite");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Créer un JPanel pour contenir les sprites
        JPanel panel = new JPanel();

        // Ajouter chaque sprite au JPanel
        for (BufferedImage sprite : player.sprites) {
            if (sprite != null) {
                JLabel spriteLabel = new JLabel(new ImageIcon(sprite));
                panel.add(spriteLabel);
            }
        }

        // Ajouter le JPanel au JFrame
        frame.add(panel);

        frame.setVisible(true);
    }
}


// import java.awt.image.BufferedImage;
// import java.io.File;
// import java.io.IOException;
// import javax.imageio.ImageIO;
// import javax.swing.*;

// public class PlayerSprite {

//     final int rows = 5;
//     final int cols = 5;
//     BufferedImage[] sprites = new BufferedImage[rows * cols];

//     public BufferedImage[] Image(){
//         final int width = 16;
//         final int height = 16;
//         try {
//             BufferedImage bigImg = ImageIO.read(new File("src\\sprites\\74336.png"));

//             for(int i = 0; i < rows; i++) {
//                 for(int j = 0; j < cols; j++) {
//                     sprites[(i * cols) + j] = bigImg.getSubimage(
//                         j * width,
//                         i * height,
//                         width,
//                         height
//                     );
//                 }
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//         return sprites;
//     }

//     public static void main(String[] args) throws Exception {
//         PlayerSprite PlayerSprite = new PlayerSprite();
//         PlayerSprite.Image();

//         JFrame frame = new JFrame("Hello World");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setSize(400, 400);

//         JLabel label = new JLabel("Hello World", JLabel.CENTER);
//         frame.add(label);

//         // Ajoutez le premier sprite à la fenêtre
//         if (PlayerSprite.sprites.length > 0 && PlayerSprite.sprites[0] != null) {
//             JLabel spriteLabel = new JLabel(new ImageIcon(PlayerSprite.sprites[0]));
//             frame.add(spriteLabel);
//         }

//         frame.setVisible(true);
//     }
// }
