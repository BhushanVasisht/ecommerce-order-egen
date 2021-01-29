package com.egen.orderproc.repository;

import com.egen.orderproc.model.ItemSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemSet, String> {

    @Query(value = "SELECT * FROM orders_itemset WHERE order_id = ?1", nativeQuery = true)
    List<ItemSet> findItemSetById(String order_id);

}
