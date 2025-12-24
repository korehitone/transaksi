package ui.ft.ccit.faculty.transaksi.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class KodeIdPK implements Serializable {

    @Column(name = "kode_transaksi", length = 4)
    private String kode;

    @Column(name = "id_barang", length = 4)
    private String idBarang;

    public KodeIdPK() {
    }

    public KodeIdPK(String kode, String idBarang) {
        this.kode = kode;
        this.idBarang = idBarang;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        // if (!(o instanceof KodeIdPK kodeIdPK))
        //     return false;
        if (o == null || getClass() != o.getClass()) return false;
        KodeIdPK kodeIdPK = (KodeIdPK) o;
        return Objects.equals(kode, kodeIdPK.kode) && Objects.equals(idBarang, kodeIdPK.idBarang);
    }

    @Override
    public int hashCode(){
        return Objects.hash(kode, idBarang);
    }
}
