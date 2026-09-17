interface BasicSecurity {
    void login();
    void logout();
}
interface AdvancedSecurity extends BasicSecurity {
    void fingerprintAuthentication();
    void faceRecognition();
}
public class BankingApplication implements AdvancedSecurity {
    @Override
    public void login() {
        System.out.println("User logged in successfully.");
    }
    @Override
    public void logout() {
        System.out.println("User logged out successfully.");
    }
    @Override
    public void fingerprintAuthentication() {
        System.out.println("Fingerprint authentication successful.");
    }
    @Override
    public void faceRecognition() {
        System.out.println("Face recognition authentication successful.");
    }
    public static void main(String[] args) {
        BankingApplication app = new BankingApplication();
        app.login();
        app.fingerprintAuthentication();
        app.faceRecognition();
        app.logout();
    }
}
