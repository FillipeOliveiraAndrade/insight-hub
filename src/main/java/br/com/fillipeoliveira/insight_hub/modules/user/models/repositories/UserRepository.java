package br.com.fillipeoliveira.insight_hub.modules.user.models.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fillipeoliveira.insight_hub.modules.user.models.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {}
