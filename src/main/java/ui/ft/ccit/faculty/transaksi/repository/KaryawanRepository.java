package ui.ft.ccit.faculty.transaksi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ui.ft.ccit.faculty.transaksi.model.Karyawan;

public interface KaryawanRepository extends JpaRepository<Karyawan, String> {

    Page<Karyawan> findByNamaContainingIgnoreCase(String nama, Pageable pageable);

    Page<Karyawan> findByGender(char gender, Pageable pageable);

    Page<Karyawan> findByGajiBetween(Double minGaji, Double maxGaji, Pageable pageable);

}
