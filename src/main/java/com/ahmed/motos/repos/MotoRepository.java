package com.ahmed.motos.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ahmed.motos.entities.Model;
import com.ahmed.motos.entities.Moto;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "rest")
public interface MotoRepository extends JpaRepository<Moto, Long> {
	
	List<Moto> findByMarqueMoto(String marque);
	List<Moto> findByMarqueMotoContains(String marque); 
	
	@Query("select m from Moto m where m.marqueMoto like %:marque and m.prixMoto > :prix")
	List<Moto> findByMarquePrix  (@Param("marque") String nom,@Param("prix") Double prix);
	
	@Query("select m from Moto m where m.model = ?1")
	List<Moto> findByModel (Model model);
	
	List<Moto> findByModelIdModel(long id);
	List<Moto> findByOrderByMarqueMotoAsc();

	@Query("select m from Moto m order by m.marqueMoto ASC, m.prixMoto DESC")
	List<Moto> trierMotosMarquesPrix();

}
