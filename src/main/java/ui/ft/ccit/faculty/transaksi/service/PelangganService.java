package ui.ft.ccit.faculty.transaksi.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ui.ft.ccit.faculty.transaksi.DataAlreadyExistsException;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
import ui.ft.ccit.faculty.transaksi.model.Pelanggan;
import ui.ft.ccit.faculty.transaksi.repository.PelangganRepository;

@Service
@Transactional
public class PelangganService {

    private final PelangganRepository repository;

    public PelangganService(PelangganRepository pr) {
        this.repository = pr;
    }

    public List<Pelanggan> getAll(Integer page, Integer size) {
        int p = (page != null && page >= 0) ? page : 0;
        int s = (size != null && size > 0) ? size : 25;

        return repository.findAll(PageRequest.of(p, s)).getContent();
    }

    public Pelanggan getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Pelanggan", id));
    }

    public List<Pelanggan> search(String nama, Integer page, Integer size) {
        int p = (page != null && page >= 0) ? page : 0;
        int s = (size != null && size > 0) ? size : 25;

        return repository.findByNamaContainingIgnoreCase(nama, PageRequest.of(p, s)).getContent();
    }

    public List<Pelanggan> getByGender(char gender, Integer page, Integer size) {
        int p = (page != null && page >= 0) ? page : 0;
        int s = (size != null && size > 0) ? size : 25;

        return repository.findByGender(gender, PageRequest.of(p, s)).getContent();
    }

    public List<Pelanggan> getByMember(char member, Integer page, Integer size) {
        int p = (page != null && page >= 0) ? page : 0;
        int s = (size != null && size > 0) ? size : 25;

        return repository.findByMember(member, PageRequest.of(p, s)).getContent();
    }

    public Pelanggan insert(Pelanggan pelanggan) {
        if (pelanggan.getId() == null || pelanggan.getId().isBlank()) {
            throw new IllegalArgumentException("id Pelanggan wajib diisi");
        }

        if (repository.existsById(pelanggan.getId())) {
            throw new DataAlreadyExistsException("Pelanggan", pelanggan.getId());
        }

        return repository.save(pelanggan);
    }

    public Pelanggan update(String id, Pelanggan pelanggan) {
        Pelanggan p = getById(id);

        p.setNama(pelanggan.getNama());
        p.setGender(pelanggan.getGender());
        p.setAlamat(pelanggan.getAlamat());
        p.setTelepon(pelanggan.getTelepon());
        p.setLahir(pelanggan.getLahir());
        p.setMember(pelanggan.getMember());

        return repository.save(p);
    }

    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new DataNotFoundException("Pelanggan", id);
        }

        repository.deleteById(id);
    }

}
