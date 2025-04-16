public class Main {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();

        // Show Login Page
        LoginPage loginPage = new LoginPage(userManagement);
        loginPage.showLoginPage();
    }
}
