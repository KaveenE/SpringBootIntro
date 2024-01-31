package com.eniot.intern.service;

import com.eniot.intern.lib.entity.Intern;

import java.util.List;

public interface InternService {
  Intern hireIntern(Intern newIntern);
  List<Intern> findAll();
  List<Intern> searchIntern(String name, String school);
}
