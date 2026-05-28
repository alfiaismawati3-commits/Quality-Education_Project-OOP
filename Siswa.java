public class Siswa extends User implements Notifiable {

    private String idSiswa;
    private String tingkat;

    // Constructor
    public Siswa(String username, String password, String idSiswa, String tingkat) {
        super(username, password);
        this.idSiswa = idSiswa;
        this.tingkat = tingkat;
    }

    // Getter & Setter (ENCAPSULATION)
    public String getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(String idSiswa) {
        this.idSiswa = idSiswa;
    }

    public String getTingkat() {
        return tingkat;
    }

    public void setTingkat(String tingkat) {
        this.tingkat = tingkat;
    }

    // Override dari abstract User (POLYMORPHISM)
    @Override
    public String getRole() {
        return "Siswa (Tingkat: " + tingkat + ")";
    }

    // Override verifyPassword dari User
    @Override
    protected boolean verifyPassword(String input) {
        return super.verifyPassword(input);
    }

    // Implementasi interface Notifiable
    @Override
    public void kirimNotifikasi(String judul, String pesan) {
        System.out.println("[NOTIF -> SISWA] " + getUsername()
                + " (Tingkat: " + tingkat + ") | " + judul + ": " + pesan);
    }

    // Tampilkan profil siswa
    public void tampilkanProfil() {
        System.out.println("=== Profil Siswa ===");
        System.out.println("ID Siswa  : " + idSiswa);
        System.out.println("Username  : " + getUsername());
        System.out.println("Tingkat   : " + tingkat);
        System.out.println("Role      : " + getRole());
        System.out.println("====================");
    }
}