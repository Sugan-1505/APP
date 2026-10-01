import javax.swing.*;
import java.awt.*;

class ServiceModel {
    public int calculateCost(boolean general, boolean oil, boolean brake, boolean battery) {
        int cost = 0;
        if (general) cost += 1000;
        if (oil) cost += 800;
        if (brake) cost += 1200;
        if (battery) cost += 500;
        return cost;
    }
}

class ServiceView extends JFrame {
    JTextField regField = new JTextField();
    JComboBox<String> vehicleType = new JComboBox<>(new String[]{"Two Wheeler", "Car"});
    JCheckBox general = new JCheckBox("General Service - ₹1000");
    JCheckBox oil = new JCheckBox("Oil Change - ₹800");
    JCheckBox brake = new JCheckBox("Brake Service - ₹1200");
    JCheckBox battery = new JCheckBox("Battery Check - ₹500");
    JButton calculate = new JButton("Calculate Cost");

    ServiceView() {
        setTitle("Vehicle Service Cost Estimator");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 1, 5, 5));

        add(new JLabel("Vehicle Registration Number:"));
        add(regField);
        add(vehicleType);
        add(general);
        add(oil);
        add(brake);
        add(battery);
        add(calculate);
    }
}

public class VehicleServiceCostEstimatorMVC {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ServiceModel model = new ServiceModel();
            ServiceView view = new ServiceView();

            view.calculate.addActionListener(e -> {
                int total = model.calculateCost(
                        view.general.isSelected(),
                        view.oil.isSelected(),
                        view.brake.isSelected(),
                        view.battery.isSelected());

                JOptionPane.showMessageDialog(view,
                        "Registration No: " + view.regField.getText()
                        + "\nVehicle Type: " + view.vehicleType.getSelectedItem()
                        + "\nTotal Service Cost: ₹" + total);
            });

            view.setVisible(true);
        });
    }
}