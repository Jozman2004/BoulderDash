// package model.elements.mobile;

// import java.util.concurrent.CountDownLatch;

// public class PlayerSelector {
//     private Frame mainFrame;
//     private Label headerLabel;
//     private Label statusLabel;
//     private Panel controlPanel;
//     private String choice;

//     public String getChoice() {
//         return choice;
//     }


//     public void setChoice(String choice) {
//         this.choice = choice;
//     }

//     private final CountDownLatch latch = new CountDownLatch(1);

//     public VehicleSelector(){
//         prepareGUI();
//     }


//     private void prepareGUI(){
//         mainFrame = new Frame("Vehicle Selector");
//         mainFrame.setSize(400,400);
//         mainFrame.setLayout(new GridLayout(3, 1));
//         mainFrame.addWindowListener(new WindowAdapter() {
//             public void windowClosing(WindowEvent windowEvent){
//                 System.exit(0);
//             }        
//         });    

//         headerLabel = new Label();
//         headerLabel.setAlignment(Label.CENTER);
//         statusLabel = new Label();        
//         statusLabel.setAlignment(Label.CENTER);
//         statusLabel.setSize(350,100);

//         controlPanel = new Panel();
//         controlPanel.setLayout(new FlowLayout());

//         mainFrame.add(headerLabel);
//         mainFrame.add(controlPanel);
//         mainFrame.add(statusLabel);
//         mainFrame.setVisible(true);  
//     }

//     public void showChoiceDemo(){
//         headerLabel.setText("Select your vehicle"); 

//         final Choice vehicleChoice = new Choice();
//         vehicleChoice.add("Car");
//         vehicleChoice.add("Moto");
//         vehicleChoice.add("Truck");

//         Button showButton = new Button("Select");

//         showButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {     
//                 String data = "Vehicle Selected: " 
//                 + vehicleChoice.getItem(vehicleChoice.getSelectedIndex());
//                 statusLabel.setText(data);
//                 mainFrame.dispose();
//                 choice = vehicleChoice.getItem(vehicleChoice.getSelectedIndex());

//                 latch.countDown(); // Release the latch
//             }
//         });

//         controlPanel.add(vehicleChoice);
//         controlPanel.add(showButton);
//         mainFrame.setVisible(true);

//         try {
//             latch.await(); // Wait for the latch to be released
//         } catch (InterruptedException ex) {
//             ex.printStackTrace();
//         }

//     }
// }
