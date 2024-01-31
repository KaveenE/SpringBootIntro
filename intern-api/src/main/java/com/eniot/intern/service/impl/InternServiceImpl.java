package com.eniot.intern.service.impl;

import com.eniot.intern.dao.InternRepository;
import com.eniot.intern.lib.entity.Intern;

import com.eniot.intern.service.InternService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InternServiceImpl implements InternService {

  private final InternRepository dao;

  @Override
  public Intern hireIntern(Intern newIntern) {
    return dao.saveAndFlush(newIntern);
  }

  @Override
  public List<Intern> findAll() {
    return dao.findAll(Sort.by("name"));
  }

  @Override
  public List<Intern> searchIntern(String name, String school) {
    if(!name.isEmpty() && !school.isEmpty()){
      return dao.findPersonByNameEqualsIgnoreCaseOrSchoolEqualsIgnoreCase(name,school);
    }else if(!name.isEmpty()) {
      return dao.findPersonByNameEqualsIgnoreCase(name);
    }else if(!school.isEmpty()) {
      return dao.findPersonBySchoolEqualsIgnoreCase(school);
    }
    else{
      return dao.findAll();
    }
  }
}
