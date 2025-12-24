package ui.ft.ccit.faculty.transaksi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ui.ft.ccit.faculty.transaksi.model.Pemasok;

public interface PemasokRepository extends JpaRepository<Pemasok, String> {

    Page<Pemasok> findByNamaPemasokContainingIgnoreCase(String nama, Pageable pageable);
}
