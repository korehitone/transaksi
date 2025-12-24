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

import ui.ft.ccit.faculty.transaksi.model.Pemasok;
import ui.ft.ccit.faculty.transaksi.service.PemasokService;

@RestController
@RequestMapping("/api/pemasok")
public class PemasokController {

    private final PemasokService pemasokService;

    public PemasokController(PemasokService ps) {
        this.pemasokService = ps;
    }

    @GetMapping
    public List<Pemasok> getPemasoks(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        return pemasokService.getAll(page, size);
    }

    @GetMapping("/{id}")
    public Pemasok getPemasok(@PathVariable String id) {
        return pemasokService.getById(id);
    }

    @GetMapping(params = "nama")
    public List<Pemasok> search(
            @RequestParam String nama,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {

        return pemasokService.search(nama, page, size);
    }

    @PostMapping
    public Pemasok create(@RequestBody Pemasok pemasok){
        return pemasokService.insert(pemasok);
    }

    @PutMapping("/{id}")
    public Pemasok update(@PathVariable String id, @RequestBody Pemasok pemasok){
        return pemasokService.update(id, pemasok);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        pemasokService.delete(id);
    }
}
