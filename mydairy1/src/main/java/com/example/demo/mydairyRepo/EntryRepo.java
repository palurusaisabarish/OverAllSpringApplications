package com.example.demo.mydairyRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.mydairyEntites.Entry;

public interface EntryRepo  extends JpaRepository<Entry, Long>{

	@Query(value = "select * from entires where userid=:id",nativeQuery = true)
	public List<Entry> findByUserid(long id);
}



