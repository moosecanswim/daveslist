package me.moosecanswim.daveslist.Repository;

import me.moosecanswim.daveslist.Model.House;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HouseRepository extends CrudRepository<House,Long> {
    List<House> findByRented(String input);

}
