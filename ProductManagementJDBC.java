import java.sql.*;
import java.util.Scanner;

public class ProductManagementJDBC {
    static final String URL = "jdbc:mysql://localhost:3306/store";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    static void insertProduct(Scanner sc) throws SQLException {
        String sql = "INSERT INTO Product(ProductID, ProductName, Price, Quantity) VALUES(?,?,?,?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Product ID: "); int id = sc.nextInt(); sc.nextLine();
            System.out.print("Product Name: "); String name = sc.nextLine();
            System.out.print("Price: "); double price = sc.nextDouble();
            System.out.print("Quantity: "); int qty = sc.nextInt();

            ps.setInt(1, id); ps.setString(2, name);
            ps.setDouble(3, price); ps.setInt(4, qty);
            ps.executeUpdate();
            System.out.println("Product inserted.");
        }
    }

    static void retrieveProduct(Scanner sc) throws SQLException {
        String sql = "SELECT * FROM Product WHERE ProductID=?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Product ID: "); int id = sc.nextInt();
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next())
                    System.out.println(rs.getInt("ProductID") + " | "
                            + rs.getString("ProductName") + " | ₹" + rs.getDouble("Price")
                            + " | Qty: " + rs.getInt("Quantity"));
                else System.out.println("Product not found.");
            }
        }
    }

    static void updateQuantity(Scanner sc) throws SQLException {
        String sql = "UPDATE Product SET Quantity=? WHERE ProductID=?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Product ID: "); int id = sc.nextInt();
            System.out.print("New quantity: "); int qty = sc.nextInt();
            ps.setInt(1, qty); ps.setInt(2, id);
            System.out.println(ps.executeUpdate() > 0 ? "Quantity updated." : "Product not found.");
        }
    }

    static void lowStockProducts() throws SQLException {
        String sql = "SELECT * FROM Product WHERE Quantity < 10";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next())
                System.out.println(rs.getInt("ProductID") + " | "
                        + rs.getString("ProductName") + " | ₹" + rs.getDouble("Price")
                        + " | Qty: " + rs.getInt("Quantity"));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("\n1.Insert  2.Retrieve  3.Update Quantity  4.Low Stock  5.Exit");
                int choice = sc.nextInt();
                if (choice == 1) insertProduct(sc);
                else if (choice == 2) retrieveProduct(sc);
                else if (choice == 3) updateQuantity(sc);
                else if (choice == 4) lowStockProducts();
                else if (choice == 5) break;
                else System.out.println("Invalid choice.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}