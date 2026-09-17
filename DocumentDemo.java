interface Confidential {
}
class Report {
    String name;
    Report(String name) {
        this.name = name;
    }
}
class FinancialReport extends Report implements Confidential {
    FinancialReport(String name) {
        super(name);
    }
}
class PublicDocument extends Report {
    PublicDocument(String name) {
        super(name);
    }
}
class EmployeeDocument extends Report implements Confidential {
    EmployeeDocument(String name) {
        super(name);
    }
}
public class DocumentDemo {
    public static void main(String[] args) {
        Report[] documents = {
            new FinancialReport("Financial Report"),
            new PublicDocument("Public Notice"),
            new EmployeeDocument("Employee Records")
        };
        for (Report document : documents) {
            System.out.println("Document: " + document.name);
            if (document instanceof Confidential) {
                System.out.println("Status: Confidential");
            } else {
                System.out.println("Status: Not Confidential");
            }
            System.out.println();
        }
    }
}
