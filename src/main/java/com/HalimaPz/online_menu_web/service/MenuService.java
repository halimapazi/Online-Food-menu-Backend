package com.HalimaPz.online_menu_web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HalimaPz.online_menu_web.model.Menu;
import com.HalimaPz.online_menu_web.repository.MenuRepository;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(Long menuId) throws MenuNotAvailableException {
        Optional<Menu> optionalMenu = menuRepository.findById(menuId);
        if(optionalMenu.isPresent()) {
            return optionalMenu.get();
        }else{
            throw new MenuNotAvailableException("Menu not found" + menuId);
        }
    }

    public Menu updateMenu(Long menuId, Menu updatedMenu) throws MenuNotAvailableException  {
        Optional<Menu> optionalMenu = menuRepository.findById(menuId);
        if (optionalMenu.isPresent()) {
            Menu menu = optionalMenu.get();
            menu.setName(updatedMenu.getName());
            menu.setCategory(updatedMenu.getCategory());
            menu.setDescription(updatedMenu.getDescription());
            menu.setPrice(updatedMenu.getPrice());
            return menuRepository.save(menu);
        } else{
            throw new MenuNotAvailableException("Could not find requested Menu with ID:" + menuId);
        }
        
    }

    public void deleteMenu(Long menuId) throws MenuNotAvailableException {
        Optional<Menu> optionalMenu = menuRepository.findById(menuId);
        if (optionalMenu.isPresent()){
            menuRepository.deleteById(menuId);
        }else{
            throw new MenuNotAvailableException("Menu not found" + menuId);

        }
        
    }

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }
}
