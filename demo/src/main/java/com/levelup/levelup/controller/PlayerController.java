package com.levelup.levelup.controller;

import com.levelup.levelup.dto.LoginRequest;
import com.levelup.levelup.dto.PlayerCreateRequest;
import com.levelup.levelup.dto.PlayerCreateResponse;
import com.levelup.levelup.model.Player;
import com.levelup.levelup.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/register")
    public PlayerCreateResponse addPlayer(@RequestBody PlayerCreateRequest playerCreateRequest){
        return playerService.addPlayer(playerCreateRequest);
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable Long playerId){
        return playerService.getPlayerById(playerId);
    }

    @PostMapping("/login")
    public PlayerCreateResponse login(@RequestBody LoginRequest loginRequest){
        return playerService.login(loginRequest);
    }

    @PostMapping("/levelup/{id}/{xp}")
    public Player addXp(@PathVariable Long id,@PathVariable int xp){
        return playerService.addXp(id,xp);
    }
}
