package logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import logos.entity.ItemsModel;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsModel, Integer> {
	@Query("SELECT c From ItemsModel c Where c.model = :model")
	ItemsModel findByModel(@Param("model") String model);

}