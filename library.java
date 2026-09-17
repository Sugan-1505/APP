class Book {
    String title;
    String author;
    double price;
    public static void main(String[] args) {
        Book b1 = new Book();
        b1.title = "Java Programming";
        b1.author = "James Gosling";
        b1.price = 599.50;
        System.out.println("Book Details");
        System.out.println("Title  : " + b1.title);
        System.out.println("Author : " + b1.author);
        System.out.println("Price  : Rs." + b1.price);
    }
}
