package ru.buyankin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.buyankin.entity.BinaryContent;

public interface BinaryContentDAO extends JpaRepository<BinaryContent, Long> {
}
