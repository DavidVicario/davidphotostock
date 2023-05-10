package com.project.davidphotostock.service;

import com.project.davidphotostock.domain.Ccaa;
import java.util.List;

public interface CcaaService {
    
    List<Ccaa> obtainAllCcaa();
    
    Ccaa obtainCcaaById(Integer id);
    
    Ccaa obtainCcaaByName(String name);
    
}
