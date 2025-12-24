package ui.ft.ccit.faculty.transaksi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "detail_transaksi")
public class DetailTransaksi {

    @EmbeddedId
    private KodeIdPK id;

    private short jumlah;

    protected DetailTransaksi() {}

    public DetailTransaksi(
        @JsonProperty("kode") String kode, 
        @JsonProperty("idBarang") String idBarang, 
        @JsonProperty("jumlah") short jumlah) {
        this.id = new KodeIdPK(kode, idBarang);
        this.jumlah = jumlah;
    }

    public DetailTransaksi(short jumlah) {
        this.jumlah = jumlah;
    }



    public KodeIdPK getId() {
        return id;
    }

    public void setId(KodeIdPK id) {
        this.id = id;
    }

    public short getJumlah() {
        return jumlah;
    }

    public void setJumlah(short jumlah) {
        this.jumlah = jumlah;
    }
}