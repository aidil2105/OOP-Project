class Landlord extends User {

    public Landlord(String username, String password) {
        super(username, password, "Landlord");
    }

    @Override
    public void register() {
        System.out.println("Landlord registered: " + username);
    }
}
