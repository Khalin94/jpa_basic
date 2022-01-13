package org.khalin.jpa_basic.repository;

import org.khalin.jpa_basic.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
