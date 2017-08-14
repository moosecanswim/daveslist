package me.moosecanswim.daveslist.Repository;

import me.moosecanswim.daveslist.Model.House;
import org.springframework.data.repository.CrudRepository;

public interface HouseRepository extends CrudRepository<House,Long> {
}
