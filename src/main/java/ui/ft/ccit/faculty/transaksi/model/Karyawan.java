package ui.ft.ccit.faculty.transaksi.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "karyawan")
public class Karyawan {

    @Id
    @Column(name = "id_karyawan", length = 4)
    private String id;

    @Column(name = "nama", length = 20, nullable = false)
    private String nama;

    @Column(name = "jenis_kelamin", length = 1, nullable = false)
    private char gender = 'L';

    @Column(name = "alamat", length = 50, nullable = false)
    private String alamat;

    @Column(name = "telepon", length = 15)
    private String telepon;

    @Column(name = "tgl_lahir", nullable = false)
    private LocalDate lahir;

    @Column(name = "gaji", nullable = false)
    private Double gaji;
    

    protected Karyawan() {
        // untuk JPA
    }

    public Karyawan(String idKaryawan, String nama, char jenisKelamin,
            String alamat, String telepon, LocalDate lahir, Double gaji) {
        this.id = idKaryawan;
        this.nama = nama;
        this.gender= jenisKelamin;
        this.alamat = alamat;
        this.telepon = telepon;
        this.lahir = lahir;
        this.gaji = gaji;
    }

    public Karyawan(String nama, char jenisKelamin,
            String alamat, String telepon, LocalDate lahir, Double gaji) {
        this.nama = nama;
        this.gender = jenisKelamin;
        this.alamat = alamat;
        this.telepon = telepon;
        this.lahir = lahir;
        this.gaji = gaji;
    }

    // === GETTERS & SETTERS ===

    public String getId() {
        return id;
    }

    public void setId(String idKaryawan) {
        this.id = idKaryawan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char jenisKelamin) {
        this.gender = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public LocalDate getLahir() {
        return lahir;
    }

    public void setLahir(LocalDate lahir) {
        this.lahir = lahir;
    }

    public Double getGaji() {
        return gaji;
    }

    public void setGaji(Double gaji) {
        this.gaji = gaji;
    }
}