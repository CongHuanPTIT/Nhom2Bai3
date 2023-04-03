package com.web.repository;

import com.web.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanphamRepository extends JpaRepository<SanPham, Long> {

    @Query("select s from SanPham s where (s.name like ?1 or s.name = ?1) and s.quantity >= ?2")
    public List<SanPham> findByDanhMucAndQuantity(String danhmuc, Integer quantity);
}
