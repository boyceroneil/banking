package com.example.demo.rest;

import com.example.demo.crud.CRUD;
import com.example.demo.entity.Market;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class MarketController {
    private final CRUD crud;
    @Autowired
    public MarketController(@Qualifier("marketIMPL") CRUD crud) {//why does vehicleIMPL need to be lower case

        this.crud = crud;
    }

    @GetMapping("/receiveAllMarket")
    public List<Object> searchAll(){
        return crud.searchAll();
    }

    @PostMapping("/addMarket")
    public Market addVMarket(@RequestBody Market market){
        market.setId(0);
        crud.saveUpdate(market);
        return market;
    }
    @PutMapping("/updateMarket")
    public Market updateMarket(@RequestBody Market market){
        crud.saveUpdate(market);
        return market;
    }
    @DeleteMapping("/deleteMarket/{market}")
    public String deleteMarket(@PathVariable int market){
        Market temp = (Market) crud.searchId(market);
        if(temp == null){
            throw new RuntimeException("Vehicle is not here" + market);
        }
        crud.deleteId(market);
        return "removed vehicle id: " + market;
    }
}
