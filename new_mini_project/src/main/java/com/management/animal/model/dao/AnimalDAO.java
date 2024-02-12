package com.management.animal.model.dao;

import com.common.SearchCondition;
import com.management.animal.model.dto.AnimalDTO;
import com.management.animal.model.dto.AnimalLogDTO;

import java.util.List;
import java.util.Map;

public interface AnimalDAO {
    List<AnimalLogDTO> selectAllAnimalList();
    List<AnimalLogDTO> selectAnimalByCondition(SearchCondition searchCondition);
    int insertAnimalLog(AnimalLogDTO animalLogDTO);
    int insertAnimal(AnimalDTO animalDTO);
    int updateAnimalLog(AnimalLogDTO animalLogDTO);
    int updateAnimal(AnimalDTO animalDTO);
    int deleteAnimalLog(Map<String, Integer> parameter);
    int deleteAnimal(Map<String, Integer> parameter);
}
//AnimalDAO