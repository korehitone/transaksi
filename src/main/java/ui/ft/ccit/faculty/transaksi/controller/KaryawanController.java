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

import ui.ft.ccit.faculty.transaksi.model.Karyawan;
import ui.ft.ccit.faculty.transaksi.service.KaryawanService;

@RestController
@RequestMapping("/api/karyawan")
public class KaryawanController {

    private final KaryawanService service;

    public KaryawanController(KaryawanService s) {
        this.service = s;
    }

    @GetMapping
    public List<Karyawan> getKaryawans(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {

        return service.getAll(page, size);
    }

    @GetMapping("/{id}")
    public Karyawan getKaryawan(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping(params = "nama")
    public List<Karyawan> search(
            @RequestParam String nama,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        return service.search(nama, page, size);
    }

    @GetMapping(params = "gender")
    public List<Karyawan> getByGender(
            @RequestParam char gender,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        return service.getByGender(gender, page, size);
    }

    @GetMapping("/gaji")
    public List<Karyawan> getByGaji(
            @RequestParam Double min,
            @RequestParam Double max,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        return service.getByGaji(min, max, page, size);
    }

    @PostMapping
    public Karyawan create(@RequestBody Karyawan karyawan){
        return service.insert(karyawan);
    }

    @PutMapping("/{id}")
    public Karyawan update(@PathVariable String id, @RequestBody Karyawan karyawan){
        return service.update(id, karyawan);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
