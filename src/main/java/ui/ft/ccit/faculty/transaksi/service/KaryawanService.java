package ui.ft.ccit.faculty.transaksi.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ui.ft.ccit.faculty.transaksi.DataAlreadyExistsException;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
import ui.ft.ccit.faculty.transaksi.model.Karyawan;
import ui.ft.ccit.faculty.transaksi.repository.KaryawanRepository;

@Service
@Transactional
public class KaryawanService {

    private final KaryawanRepository repository;

    public KaryawanService(KaryawanRepository kr) {
        this.repository = kr;
    }

    public List<Karyawan> getAll(Integer page, Integer size) {
        int p = (page != null && page >= 0) ? page : 0;
        int s = (size != null && size > 0) ? size : 25;

        return repository.findAll(PageRequest.of(p, s)).getContent();
    }

    public Karyawan getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Karyawan", id));
    }

    public List<Karyawan> search(String nama, Integer page, Integer size) {
        int p = (page != null && page >= 0) ? page : 0;
        int s = (size != null && size > 0) ? size : 25;

        return repository.findByNamaContainingIgnoreCase(nama, PageRequest.of(p, s)).getContent();
    }

    public List<Karyawan> getByGender(char gender, Integer page, Integer size) {
        int p = (page != null && page >= 0) ? page : 0;
        int s = (size != null && size > 0) ? size : 25;

        return repository.findByGender(gender, PageRequest.of(p, s)).getContent();
    }

    public List<Karyawan> getByGaji(Double min, Double max, Integer page, Integer size) {
        int p = (page != null && page >= 0) ? page : 0;
        int s = (size != null && size > 0) ? size : 25;

        return repository.findByGajiBetween(min, max, PageRequest.of(p, s)).getContent();
    }

    public Karyawan insert(Karyawan karyawan) {
        if (karyawan.getId() == null || karyawan.getId().isBlank()) {
            throw new IllegalArgumentException("id Karyawan wajib diisi");
        }

        if (repository.existsById(karyawan.getId())) {
            throw new DataAlreadyExistsException("Karyawan", karyawan.getId());
        }

        return repository.save(karyawan);
    }

    public Karyawan update(String id, Karyawan karyawan){
        Karyawan k = getById(id);

        k.setNama(karyawan.getNama());
        k.setGender(karyawan.getGender());
        k.setAlamat(karyawan.getAlamat());
        k.setTelepon(karyawan.getTelepon());
        k.setLahir(karyawan.getLahir());
        k.setGaji(karyawan.getGaji());

        return repository.save(k);
    }

    public void delete(String id){
        if (!repository.existsById(id)) {
            throw new DataNotFoundException("Karyawan", id);
        }

        repository.deleteById(id);
    }
}
