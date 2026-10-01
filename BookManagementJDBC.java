import java.sql.*;
import java.util.Scanner;

public class BookManagementJDBC {
    static final String URL = "jdbc:mysql://localhost:3306/library";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    static void insertBook(Scanner sc) throws SQLException {
        String sql = "INSERT INTO Book(BookID, Title, Author, Price, Availability) VALUES(?,?,?,?,?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Book ID: "); int id = sc.nextInt(); sc.nextLine();
            System.out.print("Title: "); String title = sc.nextLine();
            System.out.print("Author: "); String author = sc.nextLine();
            System.out.print("Price: "); double price = sc.nextDouble();
            System.out.print("Available (true/false): "); boolean available = sc.nextBoolean();

            ps.setInt(1, id); ps.setString(2, title); ps.setString(3, author);
            ps.setDouble(4, price); ps.setBoolean(5, available);
            ps.executeUpdate();
            System.out.println("Book inserted.");
        }
    }

    static void searchBook(Scanner sc) throws SQLException {
        String sql = "SELECT * FROM Book WHERE BookID=?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Book ID: "); int id = sc.nextInt();
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next())
                    System.out.println(rs.getInt("BookID") + " | " + rs.getString("Title")
                            + " | " + rs.getString("Author") + " | ₹" + rs.getDouble("Price")
                            + " | Available: " + rs.getBoolean("Availability"));
                else System.out.println("Book not found.");
            }
        }
    }

    static void displayAvailable() throws SQLException {
        String sql = "SELECT * FROM Book WHERE Availability=true";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next())
                System.out.println(rs.getInt("BookID") + " | " + rs.getString("Title")
                        + " | " + rs.getString("Author") + " | ₹" + rs.getDouble("Price"));
        }
    }

    static void issueBook(Scanner sc) throws SQLException {
        String sql = "UPDATE Book SET Availability=false WHERE BookID=?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Book ID to issue: "); int id = sc.nextInt();
            ps.setInt(1, id);
            System.out.println(ps.executeUpdate() > 0 ? "Availability updated." : "Book not found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("\n1.Insert  2.Search  3.Display Available  4.Issue  5.Exit");
                int choice = sc.nextInt();
                if (choice == 1) insertBook(sc);
                else if (choice == 2) searchBook(sc);
                else if (choice == 3) displayAvailable();
                else if (choice == 4) issueBook(sc);
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