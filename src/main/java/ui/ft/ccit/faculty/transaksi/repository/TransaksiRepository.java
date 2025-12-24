package ui.ft.ccit.faculty.transaksi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ui.ft.ccit.faculty.transaksi.model.Transaksi;


public interface TransaksiRepository extends JpaRepository<Transaksi, String> {
    
    Page<Transaksi> findByIdPelanggan(String idPelanggan, Pageable pageable);

    Page<Transaksi> findByIdKaryawan(String idKaryawan, Pageable pageable);
}
