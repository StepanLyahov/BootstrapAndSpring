package com.kurosv.mysite.repository;

import com.kurosv.mysite.model.Term;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermRepository extends JpaRepository<Term, Long> {

}
