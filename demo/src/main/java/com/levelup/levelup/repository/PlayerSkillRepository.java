package com.levelup.levelup.repository;

import com.levelup.levelup.model.Player;
import com.levelup.levelup.model.PlayerSkill;
import com.levelup.levelup.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerSkillRepository extends JpaRepository<PlayerSkill,Long> {
    Optional<PlayerSkill> findByPlayerAndSkill(Player player, Skill skill);
}
