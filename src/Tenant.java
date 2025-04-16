class Tenant extends User {

    public Tenant(String username, String password) {
        super(username, password, "Tenant");
    }

    @Override
    public void register() {
        System.out.println("Tenant registered: " + username);
    }
}
