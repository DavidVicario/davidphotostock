package com.project.davidphotostock.service;

import com.project.davidphotostock.domain.Province;
import java.util.List;

public interface ProvinceService {
    
    List<Province> obtainAllProvinces();
    
    Province obtainProvinceById(Integer id);
    
    Province obtainProvinceByName(String name);
    
    List<Province> obtainProvinceByCcaa(Integer idCcaa);
    
}
