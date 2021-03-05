package ru.rybinskov.lesson7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rybinskov.lesson7.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
