package ui.ft.ccit.faculty.transaksi.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaksi")
public class Transaksi {

    @Id
    @Column(name = "kode_transaksi", length = 4)
    private String kode;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "tgl_transaksi", nullable = false)
    private LocalDateTime tgl;

    @Column(name = "id_pelanggan", nullable = false)
    private String idPelanggan;

    @Column(name = "id_karyawan", nullable = false)
    private String idKaryawan;

    protected Transaksi() {}
    
    public Transaksi(String kode, LocalDateTime tgl, String idPelanggan, String idKaryawan) {
        this.kode = kode;
        this.tgl = tgl;
        this.idPelanggan = idPelanggan;
        this.idKaryawan = idKaryawan;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public LocalDateTime getTgl() {
        return tgl;
    }

    public void setTgl(LocalDateTime tgl) {
        this.tgl = tgl;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

}
