package com.levelup.levelup.repository;

import com.levelup.levelup.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByUsername(String username);
    Optional<Player> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
