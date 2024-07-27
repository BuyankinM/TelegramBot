package ru.buyankin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.buyankin.entity.RawData;

public interface RawDataDAO extends JpaRepository<RawData, Long> {
}
