package com.management.animal.model.service;

import com.common.SearchCondition;
import com.management.animal.model.dao.AnimalDAO;
import com.management.animal.model.dto.AnimalLogDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

public class AnimalService {

    private AnimalDAO animalDAO;

    public List<AnimalLogDTO> selectAllAnimalList() {
        SqlSession sqlSession = getSqlSession();
        animalDAO = sqlSession.getMapper(AnimalDAO.class);
        List<AnimalLogDTO> animalLogList = animalDAO.selectAllAnimalList();

        sqlSession.close();

        return animalLogList;
    }

    public List<AnimalLogDTO> selectAnimalByCondition(SearchCondition searchCondition) {
        SqlSession sqlSession = getSqlSession();
        animalDAO = sqlSession.getMapper(AnimalDAO.class);
        List<AnimalLogDTO> animalLogList = animalDAO.selectAnimalByCondition(searchCondition);

        sqlSession.close();

        return animalLogList;
    }

    public boolean registNewAnimal(AnimalLogDTO animalLogDTO) {
        SqlSession sqlSession = getSqlSession();
        animalDAO = sqlSession.getMapper(AnimalDAO.class);

        int result1 = animalDAO.insertAnimal(animalLogDTO.getAnimalDTO());

        int animalCode = animalLogDTO.getAnimalDTO().getAnimalCode();
        animalLogDTO.setAnimalCode(animalCode);
        int result2 = animalDAO.insertAnimalLog(animalLogDTO);


        if(result1 > 0 && result2 > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result1 > 0 && result2 > 0;

    }

    public boolean modifyAnimalInfo(AnimalLogDTO animalLogDTO) {

        SqlSession sqlSession = getSqlSession();
        animalDAO = sqlSession.getMapper(AnimalDAO.class);

        int result1 = animalDAO.updateAnimal(animalLogDTO.getAnimalDTO());

        int animalCode = animalLogDTO.getAnimalDTO().getAnimalCode();
        animalLogDTO.setAnimalCode(animalCode);
        int result2 = animalDAO.updateAnimalLog(animalLogDTO);

        if(result1 > 0 && result2 > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result1 > 0 && result2 > 0;
    }

    public boolean deleteAnimal(Map<String, Integer> parameter) {
        SqlSession sqlSession = getSqlSession();
        animalDAO = sqlSession.getMapper(AnimalDAO.class);

        int result1 = animalDAO.deleteAnimalLog(parameter); // 외래키제약조건으로 인해 먼저 삭제해야함 (결국 순서가 중요해써...)
        int result2 = animalDAO.deleteAnimal(parameter); // 동물 먼저 삭제하려고 하면 동물로그에 해당 동물에 대한 로그가 존재해 외래키제약 조건위반됨 ㅠㅠ

        if(result1 > 0 && result2 > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result1 > 0 && result2 > 0;
    }
}
//AnimalService