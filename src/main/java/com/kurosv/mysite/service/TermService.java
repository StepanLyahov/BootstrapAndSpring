package com.kurosv.mysite.service;

import com.kurosv.mysite.model.Term;
import org.springframework.stereotype.Service;


@Service
public class TermService {

    public Term createTerm(String start, String end) {
        Term term = new Term();
        term.setStart(start);
        term.setEnd(end);
        return term;
    }
}
