package com.web.rest;

import com.web.entity.SanPham;
import com.web.repository.SanphamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SanPhamRest {

    @Autowired
    private SanphamRepository sanphamRepository;

    @GetMapping("/sanpham")
    public List<SanPham> findAll(){
        return sanphamRepository.findAll();
    }

    @GetMapping("/timkiem")
    public List<SanPham> findByNameAndQuantity(@RequestParam("danhmuc") String danhmuc, @RequestParam("quantity") Integer quantity){
        return sanphamRepository.findByDanhMucAndQuantity("%"+danhmuc+"%", quantity);
    }

    @GetMapping("/findById")
    public SanPham findById(@RequestParam("id") Long id){
        return sanphamRepository.findById(id).get();
    }

    @PostMapping("/add")
    public void addOrUpdate(@RequestBody SanPham sanPham){
        sanphamRepository.save(sanPham);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") Long id){
        sanphamRepository.deleteById(id);
    }
}
