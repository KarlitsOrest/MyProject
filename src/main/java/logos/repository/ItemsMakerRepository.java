package logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import logos.entity.ItemsMake;


public interface ItemsMakerRepository extends JpaRepository<ItemsMake, Integer> {

}