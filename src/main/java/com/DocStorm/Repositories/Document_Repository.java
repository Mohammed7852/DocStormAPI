package com.DocStorm.Repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.DocStorm.Models.Document;
import com.DocStorm.Models.DocumentTranslation;;

@Repository
public interface Document_Repository extends JpaRepository<Document, Integer> {

//	@Query("select * from 	document d where d.tag = :tag")
//    List<Document> findByTag(@Param("tag") String tag);
}
