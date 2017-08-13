package com.DocStorm.Repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.DocStorm.Models.DocumentTranslation;
import com.DocStorm.Models.User;

@Repository
public interface DocumentTranslation_Repository  extends JpaRepository<DocumentTranslation, Integer>{

//	@Query("select *  from 	documenttranlation dt where dt.LangCode = :LangCode")
//    List<DocumentTranslation> findByLangCode(@Param("LangCode") String LangCode);
}
