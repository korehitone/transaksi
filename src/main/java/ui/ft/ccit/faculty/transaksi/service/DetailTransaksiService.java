package ui.ft.ccit.faculty.transaksi.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ui.ft.ccit.faculty.transaksi.DataAlreadyExistsException;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
import ui.ft.ccit.faculty.transaksi.model.DetailTransaksi;
import ui.ft.ccit.faculty.transaksi.model.KodeIdPK;
import ui.ft.ccit.faculty.transaksi.repository.DetailTransaksiRepository;

@Service
@Transactional
public class DetailTransaksiService {

    private final DetailTransaksiRepository repository;

    public DetailTransaksiService(DetailTransaksiRepository dtr) {
        this.repository = dtr;
    }

    public List<DetailTransaksi> getAll(Integer page, Integer size) {
        int p = (page != null && page >= 0) ? page : 0;
        int s = (size != null && size > 0) ? size : 25;

        return repository.findAll(PageRequest.of(p, s)).getContent();
    }

    public DetailTransaksi getById(String kode, String idBarang) {
        KodeIdPK kip = new KodeIdPK(kode, idBarang);
        return repository.findById(kip)
                .orElseThrow(() -> new DataNotFoundException("Transaksi", kip.toString()));
    }

    public List<DetailTransaksi> getByKode(String kode, Integer page, Integer size) {
        int p = (page != null && page >= 0) ? page : 0;
        int s = (size != null && size > 0) ? size : 25;

        if (!repository.existsByIdKode(kode)) {
            throw new DataNotFoundException("Transaksi", kode);
        }

        return repository.findByIdKode(kode, PageRequest.of(p, s)).getContent();
    }

    public DetailTransaksi insert(DetailTransaksi detailTransaksi) {
        if ((detailTransaksi.getId().getKode() == null && detailTransaksi.getId().getIdBarang() == null)
                || (detailTransaksi.getId().getKode().isBlank() && detailTransaksi.getId().getIdBarang().isBlank())) {
            throw new IllegalArgumentException("kode Transaksi dan id barang wajib diisi");
        }

        if (repository.existsById(detailTransaksi.getId())) {
            throw new DataAlreadyExistsException("DetailTransaksi", detailTransaksi.getId().toString());
        }

        return repository.save(detailTransaksi);
    }

    public DetailTransaksi update(DetailTransaksi detailTransaksi){
        DetailTransaksi d = getById(detailTransaksi.getId().getKode(), detailTransaksi.getId().getIdBarang());

        d.setJumlah(detailTransaksi.getJumlah());

        return repository.save(d);
    }


    public void delete(String kode, String idBarang){
        KodeIdPK kip = new KodeIdPK(kode, idBarang);

        if (!repository.existsById(kip)) {
            throw new DataNotFoundException("DetailTransaksi", kip.toString());
        }

        repository.deleteById(kip);
    }

}
