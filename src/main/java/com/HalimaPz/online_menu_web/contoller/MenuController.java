package com.HalimaPz.online_menu_web.contoller;

import com.HalimaPz.online_menu_web.model.Menu;
import com.HalimaPz.online_menu_web.service.MenuNotAvailableException;
import com.HalimaPz.online_menu_web.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/menu")
@CrossOrigin(origins="*", allowedHeaders="*")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping
    public ResponseEntity<Menu> addMenu(@RequestBody Menu menu) {
        Menu savedMenu = menuService.createMenu(menu);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMenu);
    }

    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenus() {
        List<Menu> menus = menuService.getAllMenus();
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/{menuId}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Long menuId) {
        Menu menu = menuService.getMenuById(menuId);
        return ResponseEntity.ok(menu);
    }

    

    @PutMapping("/{menuId}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long menuId, @RequestBody Menu updatedMenu) {
        Menu menu = menuService.updateMenu(menuId, updatedMenu);
        return ResponseEntity.ok(menu);
    }

    @DeleteMapping("/{menuId}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long menuId) {
        menuService.deleteMenu(menuId);
        return ResponseEntity.noContent().build();
    }
}
