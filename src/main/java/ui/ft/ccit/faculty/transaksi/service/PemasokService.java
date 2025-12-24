package ui.ft.ccit.faculty.transaksi.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ui.ft.ccit.faculty.transaksi.DataAlreadyExistsException;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
import ui.ft.ccit.faculty.transaksi.model.Pemasok;
import ui.ft.ccit.faculty.transaksi.repository.PemasokRepository;

@Service
@Transactional
public class PemasokService {

    private final PemasokRepository pemasokRepository;

    public PemasokService(PemasokRepository pr) {
        this.pemasokRepository = pr;
    }

    public List<Pemasok> getAll(Integer page, Integer size) {
        int p = (page != null && page >= 0) ? page : 0;
        int s = (size != null && size > 0) ? size : 25;

        return pemasokRepository.findAll(PageRequest.of(p, s)).getContent();
    }

    public Pemasok getById(String id) {
        return pemasokRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Pemasok", id));
    }

    public List<Pemasok> search(String name, Integer page, Integer size) {
        int p = (page != null && page >= 0) ? page : 0;
        int s = (size != null && size > 0) ? size : 25;

        return pemasokRepository.findByNamaPemasokContainingIgnoreCase(name, PageRequest.of(p, s)).getContent();
    }

    public Pemasok insert(Pemasok pemasok) {
        if (pemasok.getIdPemasok() == null || pemasok.getIdPemasok().isBlank()) {
            throw new IllegalArgumentException("id Pemasok wajib diisi");
        }

        if (pemasokRepository.existsById(pemasok.getIdPemasok())) {
            throw new DataAlreadyExistsException("Pemasok", pemasok.getIdPemasok());
        }

        return pemasokRepository.save(pemasok);
    }

    public Pemasok update(String id, Pemasok pemasok) {
        Pemasok p = getById(id);

        p.setNamaPemasok(pemasok.getNamaPemasok());
        p.setAlamat(pemasok.getAlamat());
        p.setTelepon(pemasok.getTelepon());
        p.setEmail(pemasok.getEmail());

        return pemasokRepository.save(p);
    }

    public void delete(String id) {
        if (!pemasokRepository.existsById(id)) {
            throw new DataNotFoundException("Pemasok", id);
        }

        pemasokRepository.deleteById(id);
    }
}
