package ui.ft.ccit.faculty.transaksi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
import ui.ft.ccit.faculty.transaksi.model.JenisBarang;
import ui.ft.ccit.faculty.transaksi.repository.JenisBarangRepository;

@Service
@Transactional
public class JenisBarangService {

    private final JenisBarangRepository jenisBarangRepository;

    public JenisBarangService(JenisBarangRepository jbr) {
        this.jenisBarangRepository = jbr;
    }

    public List<JenisBarang> getAll() {
        return jenisBarangRepository.findAll();
    }

    public JenisBarang getById(Byte id) {
        return jenisBarangRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("JenisBarang", id.toString()));
    }

    public JenisBarang insert(JenisBarang jenisBarang) {
        return jenisBarangRepository.save(jenisBarang);
    }

    public JenisBarang update(JenisBarang jenisBarang) {
        JenisBarang jb = getById(jenisBarang.getIdJenisBarang());

        jb.setNamaJenis(jenisBarang.getNamaJenis());

        return jenisBarangRepository.save(jb);
    }

    public void delete(Byte id) {
        if (!jenisBarangRepository.existsById(id)) {
            throw new DataNotFoundException("JenisBarang", id.toString());
        }
        jenisBarangRepository.deleteById(id);
    }
}
