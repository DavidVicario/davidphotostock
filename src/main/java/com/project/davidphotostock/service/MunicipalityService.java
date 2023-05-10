package com.project.davidphotostock.service;

import com.project.davidphotostock.domain.Municipality;
import java.util.List;

public interface MunicipalityService {
    
    List<Municipality> obtainAllMunicipalities();
    
    Municipality obtainMunicipalityById(Integer id);
    
    Municipality obtainMunicipalityByName(String name);
    
    List<Municipality> obtainMunicipalityByProvince(Integer idProvince);
    
}
