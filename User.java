public abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter & Setter (ENCAPSULATION)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Verifikasi password
    protected boolean verifyPassword(String input) {
        return this.password.equals(input);
    }

    // Method login konkret
    public void login() {
        System.out.println(username + " berhasil login sebagai " + getRole() + ".");
    }

    // Abstract method — wajib di-override semua subclass (POLYMORPHISM)
    public abstract String getRole();
}