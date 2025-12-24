package ui.ft.ccit.faculty.transaksi.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelanggan")
public class Pelanggan {
    
    @Id
    @Column(name = "id_pelanggan", length = 4)
    private String id;

    private String nama;

    @Column(name = "jenis_kelamin", length = 1)
    private char gender = 'L';

    private String alamat;

    private String telepon;

    @Column(name = "tgl_lahir")
    private LocalDate lahir;

    @Column(name = "jenis_pelanggan")
    private char member = 'S';

    protected Pelanggan() {}

    public Pelanggan(String nama, char gender, String alamat, String telepon, LocalDate lahir, char member) {
        this.nama = nama;
        this.gender = gender;
        this.alamat = alamat;
        this.telepon = telepon;
        this.lahir = lahir;
        this.member = member;
    }

    public Pelanggan(String id, String nama, char gender, String alamat, String telepon, LocalDate lahir, char member) {
        this.id = id;
        this.nama = nama;
        this.gender = gender;
        this.alamat = alamat;
        this.telepon = telepon;
        this.lahir = lahir;
        this.member = member;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setGender(char gender) {
        this.gender = gender;
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

     
    public char getMember() {
        return member;
    }

    public void setMember(char member) {
        this.member = member;
    }

}
