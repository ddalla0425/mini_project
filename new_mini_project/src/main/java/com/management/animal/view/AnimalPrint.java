package com.management.animal.view;

import com.common.SearchCondition;
import com.management.animal.model.dto.AnimalLogDTO;

import java.util.List;

public class AnimalPrint {

    // * 모든 출력은 System.out.println()을 통해 콘솔에 출력하는 것을 의미합니다.
    // 주석을 지우고 다음 네 가지 메소드를 작성하세요.

    public void printAllAnimalList(List<AnimalLogDTO> allAnimalList) {
        System.out.println("┌────────────────────────────────────────────┐");
        System.out.println("                 조회 된 목록");
        System.out.println("└────────────────────────────────────────────┘");
        for(AnimalLogDTO animal : allAnimalList) {
            System.out.println(animal);
        }

    }

    public void pintAnimalList(List<AnimalLogDTO> animalLogList, SearchCondition searchCondition) {
        System.out.println("┌────────────────────────────────────────────┐");
        System.out.println("                  검색 성공!");
        System.out.println("└────────────────────────────────────────────┘");
        animalLogList.forEach(System.out::println);
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";
        switch (successCode) {
            case "insert" -> successMessage = "정보 등록에 성공하였습니다.";
            case "update" -> successMessage = "정보 수정에 성공하였습니다.";
            case "delete" -> successMessage = "정보 삭제에 성공하였습니다.";
        }
        // 3. 성공메시지를 출력하는 메소드
        //    (조건) 성공코드를 전달받아 성공을 알리는 메시지를 출력하세요.
        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";
        switch(errorCode){
            case "selectAllList" -> errorMessage = "전제 조회에 실패했습니다.";
            case "selectSearchList" -> errorMessage = "검색 결과가 존재하지 않습니다.";
            case "insert" -> errorMessage = "정보 등록에 실패하였습니다.";
            case "update" -> errorMessage = "정보 수정에 실패하였습니다.";
            case "delete" -> errorMessage = "정보 삭제에 실패하였습니다.";
        }
        // 4. 에러메시지를 출력하는 메소드
        //    (조건) 에러코드를 전달받아 에러를 알리는 메시지를 출력하세요.
        System.out.println(errorMessage);
    }

}
//AnimalPrint