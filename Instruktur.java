public class Instruktur extends User implements Notifiable {

    private String idInstruktur;

    // Constructor
    public Instruktur(String username, String password, String idInstruktur) {
        super(username, password);
        this.idInstruktur = idInstruktur;
    }

    // Getter & Setter (ENCAPSULATION)
    public String getIdInstruktur() {
        return idInstruktur;
    }

    public void setIdInstruktur(String idInstruktur) {
        this.idInstruktur = idInstruktur;
    }

    // Override dari abstract User (POLYMORPHISM)
    @Override
    public String getRole() {
        return "Instruktur";
    }

    // Override verifyPassword dari User
    @Override
    protected boolean verifyPassword(String input) {
        return super.verifyPassword(input);
    }

    // Implementasi interface Notifiable
    @Override
    public void kirimNotifikasi(String judul, String pesan) {
        System.out.println("[NOTIF -> INSTRUKTUR] " + getUsername()
                + " | " + judul + ": " + pesan);
    }

    // Tampilkan profil instruktur
    public void tampilkanProfil() {
        System.out.println("=== Profil Instruktur ===");
        System.out.println("ID Instruktur : " + idInstruktur);
        System.out.println("Username      : " + getUsername());
        System.out.println("Role          : " + getRole());
        System.out.println("Status        : Aktif sebagai Instruktur");
        System.out.println("=========================");
    }
}