package ui.ft.ccit.faculty.transaksi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ui.ft.ccit.faculty.transaksi.model.DetailTransaksi;
import ui.ft.ccit.faculty.transaksi.service.DetailTransaksiService;

@RestController
@RequestMapping("/api/transaksi/detail")
public class DetailTransaksisController {

    private final DetailTransaksiService service;

    public DetailTransaksisController(DetailTransaksiService dts) {
        this.service = dts;
    }

    @GetMapping
    public List<DetailTransaksi> getDetailTransaksis(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {

        return service.getAll(page, size);
    }

    @GetMapping("/{kode}/{idBarang}")
    public DetailTransaksi getDetailTransaksi(
            @PathVariable String kode,
            @PathVariable String idBarang) {
        return service.getById(kode, idBarang);
    }

    @GetMapping(params = "kode")
    public List<DetailTransaksi> getDetailByKode(
            @RequestParam String kode,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {

        return service.getByKode(kode, page, size);
    }

    @PostMapping
    public DetailTransaksi create(
            @RequestBody DetailTransaksi detailTransaksi) {
        return service.insert(detailTransaksi);
    }

    @PutMapping
    public DetailTransaksi update(
            @RequestBody DetailTransaksi detailTransaksi) {
        return service.update(detailTransaksi);
    }

    @DeleteMapping("/{kode}/{idBarang}")
    public void delete(
            @PathVariable String kode,
            @PathVariable String idBarang

    ) {
        service.delete(kode, idBarang);
    }

}
