package com.management.animal.controller;

import com.common.SearchCondition;
import com.management.animal.model.dto.AnimalLogDTO;
import com.management.animal.model.service.AnimalService;
import com.management.animal.view.AnimalPrint;

import java.util.List;
import java.util.Map;

public class AnimalController {

    //파이널 필드 선언
     private final AnimalService animalService;
     private final AnimalPrint animalPrint;

     //파이널 필드 선언 초기화
    public AnimalController() {
        animalService = new AnimalService();
        animalPrint = new AnimalPrint();
    }
    // * 주석을 지우고 Controller 역할에 해당하는 내용을 작성하세요.

    // 1. 자주 사용할 Service와 Print 객체를 선언하고, Controller 객체 생성 시 생성되도록 작성하세요.

    public void selectAllAnimalList() {
        List<AnimalLogDTO> animalLogList = animalService.selectAllAnimalList();

        if(animalLogList != null) {
            animalPrint.printAllAnimalList(animalLogList);
        } else {
            animalPrint.printErrorMessage("selecAllList");
        }
    }

    public void selectAnimalByCondition(SearchCondition searchCondition) {
        List<AnimalLogDTO> animalLogList = animalService.selectAnimalByCondition(searchCondition);

        if(animalLogList != null && !animalLogList.isEmpty()) {
            animalPrint.pintAnimalList(animalLogList, searchCondition);
        }else {
            animalPrint.printErrorMessage("selectSearchList");
        }
    }

   public void registNewAnimal(AnimalLogDTO animalLogDTO) {


        if(animalService.registNewAnimal(animalLogDTO)){
            animalPrint.printSuccessMessage("insert");
        } else {
            animalPrint.printErrorMessage("insert");
        }

    }

    public void modifyAnimalInfo(AnimalLogDTO animalLogDTO) {

        if(animalService.modifyAnimalInfo(animalLogDTO)){
            animalPrint.printSuccessMessage("update");
        } else {
            animalPrint.printErrorMessage("update");
        }
    }

    public void deleteAnimal(Map<String, Integer> parameter) {

        if (animalService.deleteAnimal(parameter)) {
            animalPrint.printSuccessMessage("delete");
        } else {
            animalPrint.printErrorMessage("delete");
        }
    }
}
//AnimalController