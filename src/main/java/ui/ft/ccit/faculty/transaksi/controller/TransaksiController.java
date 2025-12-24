package ui.ft.ccit.faculty.transaksi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ui.ft.ccit.faculty.transaksi.model.Transaksi;
import ui.ft.ccit.faculty.transaksi.service.TransaksiService;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiController {

    private final TransaksiService service;

    public TransaksiController(TransaksiService ts) {
        this.service = ts;
    }

    @GetMapping
    public List<Transaksi> getTransaksis(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {

        return service.getAll(page, size);
    }

    @GetMapping("/{kode}")
    public Transaksi getTransaksi(@PathVariable String kode) {
        return service.getById(kode);
    }

    @GetMapping(params = "pid")
    public List<Transaksi> getByPelanggan(
            @RequestParam String pid,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {

        return service.getByPelanggan(pid, page, size);
    }

    @GetMapping(params = "kid")
    public List<Transaksi> getByKaryawan(
            @RequestParam String kid,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {

        return service.getByKaryawan(kid, page, size);
    }

    @PostMapping
    public Transaksi create(@RequestBody Transaksi transaksi){
        return  service.create(transaksi);
    }

    @DeleteMapping("/{kode}")
    public void delete(@PathVariable String kode){
        service.delete(kode);
    }



}
