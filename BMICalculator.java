import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator extends JFrame {

   private JTextField weightTextField, heightTextField, bmiTextField, resultTextField;

   public BMICalculator() {

      setTitle("BMI Calculator");
      setSize(300, 250);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JLabel weightLabel = new JLabel("Weight (kg):");
      JLabel heightLabel = new JLabel("Height (m):");
      JLabel bmiLabel = new JLabel("BMI:");
      JLabel resultLabel = new JLabel("Result:");

      weightTextField = new JTextField(10);
      heightTextField = new JTextField(10);
      bmiTextField = new JTextField(10);
      bmiTextField.setEditable(false);
      resultTextField = new JTextField(20);
      resultTextField.setEditable(false);

      JButton calculateButton = new JButton("Calculate");
      calculateButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            calculateBMI();
         }
      });

      setLayout(new GridLayout(5, 2));

      add(weightLabel);
      add(weightTextField);
      add(heightLabel);
      add(heightTextField);
      add(bmiLabel);
      add(bmiTextField);
      add(resultLabel);
      add(resultTextField);
      add(new JLabel());
      add(calculateButton);

      setVisible(true);
   }

   private void calculateBMI() {
      try {
         double weight = Double.parseDouble(weightTextField.getText());
         double height = Double.parseDouble(heightTextField.getText());

         double bmi = weight / (height * height);

         bmiTextField.setText(String.format("%.2f", bmi));

         String result;
         if (bmi < 18.5) {
            result = "Underweight";
         } else if (bmi >= 18.5 && bmi < 25) {
            result = "Normal Weight";
         } else {
            result = "Overweight";
         }

         resultTextField.setText(result);
      } catch (NumberFormatException ex) {
         JOptionPane.showMessageDialog(this, "Please enter valid numbers for weight and height.", "Error",
               JOptionPane.ERROR_MESSAGE);
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new BMICalculator();
         }
      });
   }
}
