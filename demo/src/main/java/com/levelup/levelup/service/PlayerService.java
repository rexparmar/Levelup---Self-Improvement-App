package com.levelup.levelup.service;

import com.levelup.levelup.dto.LoginRequest;
import com.levelup.levelup.dto.PlayerCreateRequest;
import com.levelup.levelup.dto.PlayerCreateResponse;
import com.levelup.levelup.model.Player;
import com.levelup.levelup.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    public PlayerCreateResponse addPlayer(PlayerCreateRequest playerCreateRequest){
        Player player = new Player();
        String username = playerCreateRequest.getUsername();
        String password = playerCreateRequest.getPassword();
        String encoded = passwordEncoder.encode(password);
        player.setUsername(username);
        player.setPassword(encoded);
        player.setXp(0);
        player.setCharisma(0);
        player.setEndurance(0);
        player.setLevel(0);
        player.setCreatedDate(LocalDate.now());
        player.setLuck(0);
        player.setWisdom(0);
        player.setIntelligence(0);
        player.setCurrentClass("Beginner");
        player.setStrength(0);
        player.setEmail(playerCreateRequest.getEmail());
        player.setTitle("Starter");
        playerRepository.save(player);
        return new PlayerCreateResponse("Player registered successfully! You better not give up champ!",null);
    }

    public PlayerCreateResponse login(LoginRequest loginRequest){
        String email = loginRequest.getEmail();
        Player loginPlayer = playerRepository.findByEmail(email).orElseThrow(()->
                new UsernameNotFoundException("User not found!"));
        if(passwordEncoder.matches(loginRequest.getPassword(),loginPlayer.getPassword())){
            return new PlayerCreateResponse("Login Successful!", jwtService.generateToken(loginPlayer.getEmail()));
        }
        return new PlayerCreateResponse("Login failed! Please check credentials!",null);
    }

    public Player getPlayerById(Long playerId){
        return playerRepository.findById(playerId).orElseThrow(()->new UsernameNotFoundException("User not found!"));
    }

}
