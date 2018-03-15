package kz.kaznitu.mysrs.repositories;

import kz.kaznitu.mysrs.models.Computer;
import org.springframework.data.repository.CrudRepository;

public interface ComputerRepository extends CrudRepository<Computer,Integer> {
}
