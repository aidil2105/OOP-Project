class Admin extends User {

    public Admin(String username, String password) {
        super(username, password, "Admin");
    }

    @Override
    public void register() {
        System.out.println("Admin registered: " + username);
    }
}
