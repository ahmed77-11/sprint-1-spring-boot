package com.ahmed.motos;

import java.util.Date;
import java.util.List;

import com.ahmed.motos.entities.Model;
import com.ahmed.motos.entities.Moto;
import com.ahmed.motos.repos.MotoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MotosApplicationTests {

	@Autowired // inject all the method in the interface
	private MotoRepository motoRepository;
	@Test
	public void testCreateMoto() {
		Moto moto = new Moto("kawazaki",1200.500,new Date());
		motoRepository.save(moto); //save it in the data base 
	}
	@Test
	public void testFindMoto()
	{
		Moto m = motoRepository.findById(1L).get();
		System.out.println(m);
	}
	@Test
	public void testUpdateMoto()
	{
		Moto m = motoRepository.findById(1L).get();
		m.setPrixMoto(1000.0);
		motoRepository.save(m);
	}
	@Test
	public void testDeleteMoto()
	{
		motoRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousProduits()
	{
		List<Moto> motos = motoRepository.findAll();
		for ( Moto m : motos)
		{
			System.out.println(m);
		}
	}

	@Test
	public void testFindMotoByMarque()
	{
		List<Moto> motos = motoRepository.findByMarqueMoto("BMW");
		for(Moto m:motos) {
			System.out.println(m);
		}
	}
	@Test
	public void testFindMotoByMarqueContains()
	{
		List<Moto> motos = motoRepository.findByMarqueMotoContains("O");
		for(Moto m:motos) {
			System.out.println(m);
		}
	}
	@Test
	public void testfindByMarquePrix()
	{
		List<Moto> motos = motoRepository.findByMarquePrix("BMW", 1000.5);
		for (Moto m : motos)
		{
			System.out.println(m);
		}
	}
	@Test
	public void testfindByCategorie()
	{
		Model mod = new Model();
		mod.setIdModel(2L);
		List<Moto> motos = motoRepository.findByModel(mod);
		for (Moto m : motos)
		{
			System.out.println(m);
		}
	}
	@Test
	public void findByModelIdModel()
	{
		List<Moto> motos = motoRepository.findByModelIdModel(1L);
		for (Moto m : motos)
		{
			System.out.println(m);
		}
	}
	@Test
	public void testfindByOrderByMarqueMotoAsc()
	{
		List<Moto> motos =
				motoRepository.findByOrderByMarqueMotoAsc();
		for (Moto m : motos)
		{
			System.out.println(m);
		}
	}
	@Test
	public void testTrierMotosMarquesPrix()
	{
		List<Moto> motos = motoRepository.trierMotosMarquesPrix();
		for (Moto m : motos)
		{
			System.out.println(m);
		}
	}



}
