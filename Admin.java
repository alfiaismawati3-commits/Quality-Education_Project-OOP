import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Admin extends User implements Notifiable {

    private String idAdmin;

    // Constructor
    public Admin(String username, String password, String idAdmin) {
        super(username, password);
        this.idAdmin = idAdmin;
    }

    // Getter & Setter (ENCAPSULATION)
    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    // Override dari abstract User (POLYMORPHISM)
    @Override
    public String getRole() {
        return "Admin Sistem";
    }

    // Override verifyPassword dari User
    @Override
    protected boolean verifyPassword(String input) {
        return super.verifyPassword(input);
    }

    // Implementasi interface Notifiable
    @Override
    public void kirimNotifikasi(String judul, String pesan) {
        System.out.println("[NOTIF -> ADMIN] " + getUsername()
                + " | " + judul + ": " + pesan);
    }

    // Method bisnis Admin: validasi materi yang dikirim instruktur
    public void validasiMateri(Materi materi) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        materi.setValidasi("Telah divalidasi oleh " + getUsername());
        materi.setWaktuValidasi(LocalDateTime.now().format(dtf));
        System.out.println("Sistem: Materi '" + materi.getJudulMateri()
                + "' berhasil divalidasi.");
    }

    // Tampilkan profil admin
    public void tampilkanProfil() {
        System.out.println("=== Profil Admin ===");
        System.out.println("ID Admin  : " + idAdmin);
        System.out.println("Username  : " + getUsername());
        System.out.println("Role      : " + getRole());
        System.out.println("Status    : Administrator");
        System.out.println("====================");
    }
}