import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MateriControllerTest {

    private MateriController controller;
    private Instruktur instruktur;
    private Admin admin;

    @BeforeEach
    void setUp() {
        controller = new MateriController();
        instruktur = new Instruktur("pak_bayu", "pass123", "INS-001");
        admin      = new Admin("admin1", "admin123", "ADM-01");
    }

    @Test
    void testAddMateri() {
        controller.addMateri("OOP Analysis", "Software Design", "Isi materi", instruktur);
        assertEquals(1, controller.getSize());
    }

    @Test
    void testViewAllMateriTidakKosong() {
        controller.addMateri("Java Collections", "Pemrograman", "Isi", instruktur);
        assertFalse(controller.getMateriList().isEmpty());
    }

    @Test
    void testUpdateMateri() {
        controller.addMateri("Judul Lama", "Kategori", "Isi Lama", instruktur);
        controller.updateMateri(1, "Judul Baru", "Isi Baru");
        assertEquals("Judul Baru", controller.getMateriById(1).getJudulMateri());
    }

    @Test
    void testDeleteMateri() {
        controller.addMateri("OOP Analysis", "Software Design", "Isi", instruktur);
        controller.deleteMateri(1);
        assertEquals(0, controller.getSize());
    }

   @Test
    void testValidasiMateri() {
        // 1. Tambahkan materi baru ke controller
        controller.addMateri("OOP Analysis", "Software Design", "Isi materi", instruktur);
        Materi m = controller.getMateriById(1);

        // 2. Buat objek NotifikasiController untuk menampung alur notifikasi baru
        NotifikasiController notifController = new NotifikasiController();

        // 3. Pastikan status awalnya memang belum divalidasi
        assertEquals("Belum divalidasi", m.getStatusValidasi());

        // 4. Panggil metode validasi baru yang ada di dalam MateriController
        controller.validasiMateri(admin, 1, notifController);

        // 5. Cek apakah status materi sudah berubah (Berhasil divalidasi)
        assertNotEquals("Belum divalidasi", m.getStatusValidasi());

        // 6. Opsional: Kamu juga bisa tes apakah notifikasinya otomatis masuk ke riwayat!
        assertEquals(1, notifController.getSize());
    }
}