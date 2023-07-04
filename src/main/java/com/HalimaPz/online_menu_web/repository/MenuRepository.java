package com.HalimaPz.online_menu_web.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HalimaPz.online_menu_web.model.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {
    void deleteById(Long menuId);
    
    @Override
    List<Menu> findAll();

}
