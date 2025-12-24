package ui.ft.ccit.faculty.transaksi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ui.ft.ccit.faculty.transaksi.model.DetailTransaksi;
import ui.ft.ccit.faculty.transaksi.model.KodeIdPK;

public interface DetailTransaksiRepository extends JpaRepository<DetailTransaksi, KodeIdPK> {
    
    Page<DetailTransaksi> findByIdKode(String kode, Pageable pageable);

    boolean existsByIdKode(String kode);
}