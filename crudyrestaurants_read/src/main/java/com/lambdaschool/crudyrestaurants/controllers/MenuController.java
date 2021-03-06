package com.lambdaschool.crudyrestaurants.controllers;

import com.lambdaschool.crudyrestaurants.models.Menu;
import com.lambdaschool.crudyrestaurants.services.MenuService;
import com.lambdaschool.crudyrestaurants.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The entry point for clients to access menu data.
 */
@RestController
@RequestMapping("/menus")
public class MenuController
{
    /**
     * Using the menu service to process menu data.
     */
    @Autowired
    private MenuService menuService;

    /**
     * Returns a list of all menus.
     * <br>Example: <a href="http://localhost:2019/menus/menus">http://localhost:2019/menus/menus</a>.
     *
     * @see RestaurantService#findAllRestaurants() MenuService.findAllMenus().
     * @return JSON list of all menus with a status of OK.
     */
    @GetMapping(value = "/menus",
            produces = {"application/json"})
    public ResponseEntity<?> listAllMenus()
    {
        List<Menu> myMenus = menuService.findAllMenus();
        return new ResponseEntity<>(myMenus,
                HttpStatus.OK);
    }
}
