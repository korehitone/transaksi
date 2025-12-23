package ui.ft.ccit.faculty.transaksi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ui.ft.ccit.faculty.transaksi.model.JenisBarang;
import ui.ft.ccit.faculty.transaksi.service.JenisBarangService;

@RestController
@RequestMapping("/api/barang/jenis")
public class JenisBarangController {

    private final JenisBarangService jenisBarangService;

    public JenisBarangController(JenisBarangService jbs){
        this.jenisBarangService = jbs;
    }

    @GetMapping
    public List<JenisBarang> jenisBarangs(){
        return jenisBarangService.getAll();
    }

    @PostMapping
    public JenisBarang insert(@RequestBody JenisBarang jenisBarang){
        return jenisBarangService.insert(jenisBarang);
    }

    @PutMapping
    public JenisBarang update(@RequestBody JenisBarang jenisBarang){
        return jenisBarangService.update(jenisBarang);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Byte id){
        jenisBarangService.delete(id);
    }
}
