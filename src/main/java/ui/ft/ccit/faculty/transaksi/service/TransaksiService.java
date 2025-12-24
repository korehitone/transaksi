package ui.ft.ccit.faculty.transaksi.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ui.ft.ccit.faculty.transaksi.DataAlreadyExistsException;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
import ui.ft.ccit.faculty.transaksi.model.Transaksi;
import ui.ft.ccit.faculty.transaksi.repository.KaryawanRepository;
import ui.ft.ccit.faculty.transaksi.repository.PelangganRepository;
import ui.ft.ccit.faculty.transaksi.repository.TransaksiRepository;

@Service
@Transactional
public class TransaksiService {

    private final TransaksiRepository repository;
    private final KaryawanRepository kr;
    private final PelangganRepository pr;

    public TransaksiService(TransaksiRepository tr, KaryawanRepository kr, PelangganRepository pr) {
        this.repository = tr;
        this.kr = kr;
        this.pr = pr;
    }

    public List<Transaksi> getAll(Integer page, Integer size) {
        int p = (page != null && page >= 0) ? page : 0;
        int s = (size != null && size > 0) ? size : 25;

        return repository.findAll(PageRequest.of(p, s)).getContent();
    }

    public Transaksi getById(String kode) {
        return repository.findById(kode)
                .orElseThrow(() -> new DataNotFoundException("Transaksi", kode));
    }

    public List<Transaksi> getByPelanggan(String pid, Integer page, Integer size) {
        int p = (page != null && page >= 0) ? page : 0;
        int s = (size != null && size > 0) ? size : 25;

        if (!pr.existsById(pid)) {
            throw new DataNotFoundException("Pelanggan", pid);
        }

        return repository.findByIdPelanggan(pid, PageRequest.of(p, s)).getContent();
    }

    public List<Transaksi> getByKaryawan(String kid, Integer page, Integer size) {
        int p = (page != null && page >= 0) ? page : 0;
        int s = (size != null && size > 0) ? size : 25;

        if (!kr.existsById(kid)) {
            throw new DataNotFoundException("Pelanggan", kid);
        }

        return repository.findByIdKaryawan(kid, PageRequest.of(p, s)).getContent();
    }

    public Transaksi create(Transaksi transaksi) {
        if (transaksi.getKode() == null || transaksi.getKode().isBlank()) {
            throw new IllegalArgumentException("kode Transaksi wajib diisi");
        }

        if (repository.existsById(transaksi.getKode())) {
            throw new DataAlreadyExistsException("Transaksi", transaksi.getKode());
        }

        return repository.save(transaksi);
    }

    public void delete(String kode) {
        if (!repository.existsById(kode)) {
            throw new DataNotFoundException("Transaksi", kode);
        }

        repository.deleteById(kode);
    }
}
