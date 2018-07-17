package logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import logos.entity.ItemsMake;
@Repository
public interface MakerRepository extends JpaRepository<ItemsMake, Integer> {

	@Query("Select m from ItemsMake m Where m.title = :title")
	ItemsMake findMakerByName(@Param("title") String title);
}
