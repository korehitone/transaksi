package ui.ft.ccit.faculty.transaksi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ui.ft.ccit.faculty.transaksi.model.Pelanggan;


public interface PelangganRepository extends JpaRepository<Pelanggan, String> {
    
    Page<Pelanggan> findByNamaContainingIgnoreCase(String nama, Pageable pageable);

    Page<Pelanggan> findByGender(char gender, Pageable pageable);
    Page<Pelanggan> findByMember(char member, Pageable pageable);
}
