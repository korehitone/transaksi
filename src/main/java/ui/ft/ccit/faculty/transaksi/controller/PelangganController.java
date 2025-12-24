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

import ui.ft.ccit.faculty.transaksi.model.Pelanggan;
import ui.ft.ccit.faculty.transaksi.service.PelangganService;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {

    private final PelangganService service;

    public PelangganController(PelangganService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pelanggan> getPelanggans(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {

        return service.getAll(page, size);
    }

    @GetMapping("/{id}")
    public Pelanggan getPelanggan(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping(params = "nama")
    public List<Pelanggan> search(
            @RequestParam String nama,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        return service.search(nama, page, size);
    }

    @GetMapping(params = "gender")
    public List<Pelanggan> getByGender(
            @RequestParam char gender,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        return service.getByGender(gender, page, size);
    }

    @GetMapping(params = "member")
    public List<Pelanggan> getByMember(
            @RequestParam char member,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        return service.getByMember(member, page, size);
    }

    @PostMapping
    public Pelanggan create(@RequestBody Pelanggan pelanggan) {
        return service.insert(pelanggan);
    }

    @PutMapping("/{id}")
    public Pelanggan update(@PathVariable String id, @RequestBody Pelanggan pelanggan) {
        return service.update(id, pelanggan);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

}
