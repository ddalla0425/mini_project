package com.management.animal.view;

import com.common.SearchCondition;
import com.management.animal.controller.AnimalController;
import com.management.animal.model.dto.AnimalDTO;
import com.management.animal.model.dto.AnimalLogDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnimalMenu {
    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        AnimalController animalController = new AnimalController();

        do {
            System.out.println("┌───── Abandoned Animal Management Menu ─────┐");
            System.out.println("         보호소 동물 정보 관리 화면입니다.");
            System.out.println("└────────────────────────────────────────────┘");
            System.out.println("     1. 전체 조회");
            System.out.println("     2. 조건 조회");
            System.out.println("     3. 정보 입력");
            System.out.println("     4. 정보 수정");
            System.out.println("     5. 정보 삭제");
            System.out.println("     9. 이전 메뉴로 이동");
            System.out.println("└────────────────────────────────────────────┘");
            System.out.print("원하는 관리 메뉴의 번호를 입력해 주세요 : ");
            int selectMenu = sc.nextInt();

            AnimalLogDTO animalLogDTO = new AnimalLogDTO();
            AnimalDTO animalDTO = new AnimalDTO();

            switch (selectMenu) {
                case 1 : animalController.selectAllAnimalList(); break;
                case 2 : animalController.selectAnimalByCondition(inputSearchCondition()); break;
                case 3 : animalController.registNewAnimal(inputNewAnimalInfo()); break;
                case 4 : animalController.modifyAnimalInfo(inputModifyAnimalInfo(animalLogDTO, animalDTO)); break;
                case 5 : animalController.deleteAnimal(inputAnimalCode()); break;
                case 9 : System.out.println("========상위 메뉴로 이동합니다.========"); return;
                default : System.out.println("잘못된 번호입니다. 확인 후 다시 입력해 주세요."); break;
            }

        } while(true);
    }

    private static SearchCondition inputSearchCondition() {

        Scanner sc = new Scanner(System.in);
        String searchOption = "";
        String searchValue = "";

        System.out.println("┌────────────────────────────────────────────┐");
        System.out.println("          조회하고 싶은 조건을 선택하세요.");
        System.out.println("└────────────────────────────────────────────┘");
        System.out.println("     1. 동물번호로 조회");
        System.out.println("     2. 개체별 조회 (개,고양이,기타)");
        System.out.println("     3. 품종별 조회 ");
        System.out.println("     4. 특징별 조회 (내장칩,중성화,목걸이)");
        System.out.println("     5. 모색으로 조회");
        System.out.println("     6. 퇴소한 동물 조회");
        System.out.println("     9. 이전 메뉴로 이동");
        System.out.println("└────────────────────────────────────────────┘");
        System.out.print("원하는 조건의 번호를 입력해 주세요 : ");
        int selectMenu = sc.nextInt();

        switch (selectMenu) {
            case 1:
                sc.nextLine();
                searchOption = "animalCode";
                System.out.print("조회할 동물 번호를 입력해 주세요 : ");
                searchValue = sc.nextLine();
                break;
            case 2:
                sc.nextLine();
                searchOption = "refCategoryName";
                System.out.print("조회할 개체 유형을 입력해 주세요 (개 or 고양이 or 기타) : ");
                searchValue = sc.nextLine();
                break;
            case 3:
                sc.nextLine();
                searchOption = "categoryName";
                System.out.print("조회할 품종을 입력해 주세요 : ");
                searchValue = sc.nextLine();
                break;
            case 4:
                sc.nextLine();
                System.out.print("조회할 특징을 알려주세요 (내장칩,중성화,목걸이 : Y 목록만 출력합니다.) : ");
                searchOption = sc.nextLine();
                break;
            case 5 :
                sc.nextLine();
                searchOption = "animalColor";
                System.out.print("조회할 털 색상을 입력해 주세요 : ");
                searchValue = sc.nextLine();
                break;
            case 6 :
                searchOption = "checkOutAnimal";
                break;
            case 9 :
                System.out.println("┌────────────────────────────────────────────┐");
                System.out.println("             상위 메뉴로 이동합니다.");
                System.out.println("└────────────────────────────────────────────┘");
                ; return null;
            default : System.out.println("잘못된 번호입니다. 확인 후 다시 입력해 주세요."); break;
            }

        SearchCondition searchCondition = new SearchCondition(searchOption, searchValue);

        return searchCondition;
    }

    private static AnimalLogDTO inputNewAnimalInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("┌────────────────────────────────────────────┐");
        System.out.println("            등록할 정보를 입력해주세요.");
        System.out.println("└────────────────────────────────────────────┘");
        AnimalLogDTO animalLogDTO = new AnimalLogDTO();
        AnimalDTO animalDTO = new AnimalDTO();

        getAnimalInfo(animalLogDTO, animalDTO);


        System.out.println("──────────────────────────────────────────────");

        return animalLogDTO;
    }

    private static AnimalLogDTO inputModifyAnimalInfo(AnimalLogDTO animalLogDTO, AnimalDTO animalDTO) {
        Scanner sc = new Scanner(System.in);
        System.out.println("┌────────────────────────────────────────────┐");
        System.out.println("           수정할 정보를 입력해주세요.");
        System.out.println("   수정을 원하지 않는 정보는 SKIP을 입력하세요");
        System.out.println("   수정을 원하지 않는 코드정보는 0을 입력하세요");
        System.out.println("└────────────────────────────────────────────┘");
        System.out.print("수정 대상 동물코드를 입력해 주세요 : ");
        int animalCode = sc.nextInt();

        animalDTO.setAnimalCode(animalCode);

        getAnimalInfo(animalLogDTO, animalDTO);

        System.out.println("[1.공고기간 2.보호기간 3.임시보호 4.입양 5.반환 6.안락사]");
        System.out.print("* 동물의 처리상태에 해당하는 번호를 입력해 주세요 : ");
        int statusCode  = sc.nextInt();
        System.out.print("* 동물의 처리날짜를 입력해 주세요 : ");
        sc.nextLine();
        String logDate  = sc.nextLine();
        System.out.print("  동물의 처리상태에 대한 상세내용을 입력해 주세요 : ");
        String logRemark  = sc.nextLine();

        animalLogDTO.setStatusCode(statusCode);
        animalLogDTO.setLogDate(logDate);
        animalLogDTO.setLogRemark(logRemark);


        animalLogDTO.setAnimalDTO(animalDTO);

        System.out.println("──────────────────────────────────────────────");

        return animalLogDTO;
    }

    private static AnimalLogDTO getAnimalInfo(AnimalLogDTO animalLogDTO, AnimalDTO animalDTO) {
        Scanner sc = new Scanner(System.in);

        System.out.print("* 동물 성별을 입력해 주세요(암컷 or 수컷 or 모름) : ");
        String animalGender = sc.nextLine();
        System.out.print("* 동물의 모색을 입력해 주세요(여러색일 경우 (,) 로 나눠주세요) : ");
        String animalColor = sc.nextLine();
        System.out.print("* 동물의 나이를 입력해 주세요(모를때는 '모름' 이라고 입력해주세요) : ");
        String animalAge = sc.nextLine();
        System.out.print("  동물의 체중을 입력해 주세요 : ");
        String animalWeight = sc.nextLine();
        System.out.print("* 내장칩 유무를 입력해 주세요(Y/N) : ");
        String builtInChip = sc.nextLine();
        System.out.print("* 중성화 유무를 입력해 주세요(Y/N) : ");
        String neuteringSurgery = sc.nextLine();
        System.out.print("  목걸이 유무를 입력해 주세요(Y/N) : ");
        String animalCollar = sc.nextLine();
        System.out.print("* 구조일자를 입력해 주세요(19920101 형식) : ");
        String rescueDate = sc.nextLine();
        System.out.print("* 포획장소를 입력해 주세요 : ");
        String capturePlace  = sc.nextLine();
        System.out.print("  동물의 건강상태를 입력해 주세요 (양호 or 불량): ");
        String healthCondition  = sc.nextLine();
        System.out.println("[4.말티즈 5.시베리안허스키 6.비숑 7.꼬똥드뚤레아 8.푸들 9.시바 10.진돗개]");
        System.out.println("[11.포메라이언 12.치와와 13.시고르자브종 14.스코티시폴드 15.터키쉬앙고라 16.러시안블루 17.페르시안]");
        System.out.println("[18.브리티시숏헤어 19.스핑크스 20.샴 21.벵골 22.렉돌 23.기르고르냐이]");
        System.out.println("[24.판다 25.라쿤 26.고라니]");
        System.out.print("* 동물의 품종에 해당하는 코드를 입력해 주세요 : ");
        int categoryCode  = sc.nextInt();

        animalDTO.setAnimalGender(animalGender);
        animalDTO.setAnimalColor(animalColor);
        animalDTO.setAnimalAge(animalAge);
        animalDTO.setAnimalWeight(animalWeight);
        animalDTO.setBuiltInChip(builtInChip);
        animalDTO.setNeuteringSurgery(neuteringSurgery);
        animalDTO.setAnimalCollar(animalCollar);
        animalDTO.setRescueDate(rescueDate);
        animalDTO.setCapturePlace(capturePlace);
        animalDTO.setHealthCondition(healthCondition);
        animalDTO.setCategoryCode(categoryCode);

        animalLogDTO.setAnimalCode(animalDTO.getAnimalCode());
        animalLogDTO.setStatusCode(1);
        animalLogDTO.setLogDate(rescueDate);
        animalLogDTO.setAdmissionStatus("Y");
        animalLogDTO.setAnimalDTO(animalDTO);

        return animalLogDTO;
    }


    private static Map<String, Integer> inputAnimalCode() {
        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 동물 코드를 입력해주세요. : ");

        int animalCode = sc.nextInt();
        System.out.println("──────────────────────────────────────────────");

        Map<String, Integer> parameter = new HashMap<>();
        parameter.put("animalCode", animalCode);

        return parameter;
    }
}
//AnimalMenu