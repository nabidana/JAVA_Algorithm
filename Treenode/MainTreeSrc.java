package JAVAFD.treesearch;
import java.util.*;

import JAVAFD.Treefarm.TreeNode;

public class MainTreeSrc {
    public static void main(String[] args) {
        int menu_num = 0;
        int node_len = 0;
        int nodeCount = 1;
        int delNodeVal = 0;
        int flag = 0;
        Scanner scan_chose = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("| 트리노드 알고리즘                    |");
        System.out.println("| 전체노드의 길이를 설정해주세요.       |");
        System.out.println("| ※문자 입력시 종료됩니다.            |");
        System.out.println("--------------------------------------");
        System.out.print("설정할 전체 노드의 길이 : ");
        try{
            node_len = scan_chose.nextInt();
        } catch (InputMismatchException e) {
            scan_chose.nextLine();
            System.out.println("\r\n 문자를 입력하셨습니다. 종료합니다.");
            System.exit(0);
        }
        TreeNode[] nodes = new TreeNode[node_len];
        for (int i = 0; i < node_len; i++) {
            nodes[i] = new TreeNode(i);
        }

        do{
            System.out.println("--------------------------------------");
            System.out.println("| 트리노드 알고리즘                    |");
            System.out.println("| 1. 노드 추가                        |");
            System.out.println("| 2. 노드 삭제                        |");
            System.out.println("| 3. 전체 노드 조회                   |");
            System.out.println("| 4. 노드탐색                         |");
            System.out.println("| 5. 종료(exit)                      |");
            System.out.println("| ※문자 입력시 종료됩니다.            |");
            System.out.println("-------------------------------------");
            System.out.print("실행할 번호를 입력하세요 : ");
            try{
                menu_num = scan_chose.nextInt();
                System.out.println("\r\n");
            }catch(InputMismatchException e) {
                scan_chose.nextLine();
                System.out.println("창의력은 그만! 종료합니다.");
                System.exit(0);
            }
            menu_num = scan_chose.nextInt();
            System.out.println("\r\n");

            if (menu_num == 5) {
                System.out.println("-------------------------------------");
                System.out.println("\r\n종료합니다.");
                System.exit(0);
            }

            if(menu_num == 1) {
                System.out.println("-------------------------------------");
                System.out.println("노드를 추가합니다.");
                System.out.println("노드의 값은 0 이 될수 없습니다.");
                System.out.println("문자입력시 강제종료됩니다. 제발...");
                if(nodes[0].getData() == null) {
                    System.out.print("루트노드의 입력할 값을 입력해주세요 : ");
                    try{
                        int imScanNum = scan_chose.nextInt();
                        if( imScanNum == 0) {
                            System.out.println("SORRY. 노드값은 0이 안된다구요!");
                            flag = 0;
                        }
                        nodes[0].putData(imScanNum);
                    }catch(InputMismatchException e){
                        scan_chose.nextLine();
                        System.out.println("GET OUT .............");
                        System.exit(0);
                    }
                }else {

                    for(int i = 0; i <= node_len; i++) {
                        if(nodes[i].getData() == null){
                            try{
                                System.out.println("현재 노드번호는 " + nodeCount + "이고, 전체 노드는 "
                                 + node_len + "입니다.");
                                System.out.println("노드에 입력할 값을 입력해주세요 : ");
                                int urNodeVal = scan_chose.nextInt();
                                if( urNodeVal == 0) {
                                    System.out.println("노드값은 0이... 안되....요..........");
                                    flag = 0;
                                }
                                nodes[nodeCount].putData(urNodeVal);
                                nodes[0].Calculation(nodes[nodeCount], nodes[0]);
                                nodeCount = nodeCount + 1;
                            }catch(InputMismatchException e){
                                scan_chose.nextLine();
                                System.out.println("BYE...............");
                                System.exit(0);
                            }
                        }else{
                            System.out.println("현재 전체노드 " + node_len + "의 개수가 모두 차있습니다.");
                            System.out.println("돌아갑니다. \r\n");
                            flag = 0;
                        }
                    }
                    try{
                        System.out.println("현재 노드번호는 " + nodeCount + "이고, 전체 노드는 " + node_len + "입니다.");
                        System.out.println("노드에 입력할 값을 입력해주세요 : ");
                        int urNodeVal = scan_chose.nextInt();
                        nodes[nodeCount].putData(urNodeVal);
                        nodes[0].Calculation(nodes[nodeCount], nodes[0]);
                        nodeCount = nodeCount + 1;
                    }catch(InputMismatchException e){
                        scan_chose.nextLine();
                        System.out.println("BYE...............");
                        System.exit(0);
                    }
                }
            }

            if(menu_num == 2) {
                System.out.println("-------------------------------------");
                System.out.println("노드를 삭제합니다.");
                System.out.println("※문자 입력시 종료됩니다.");
                System.out.println("노드 삭제는 노드의 값을 기준으로 삭제하게 됩니다.");
                System.out.println("삭제할 노드의 값을 입력해주세요 : ");
                try{
                    delNodeVal = scan_chose.nextInt();
                }catch(InputMismatchException e) {
                    scan_chose.nextLine();
                    System.out.println("너무해요. 문자 입력은.... 종료합니다.");
                    System.exit(0);
                }
                int NodeRVal = nodes[0].SearchingSubTree(delNodeVal, nodes[0]);
                if(NodeRVal == 0) {
                    System.out.println("입력하신 숫자는 노드에 없는 숫자입니다.");
                    System.out.println("메뉴로 돌아갑니다. \r\n");
                    flag = 0;
                }else{
                    Random r = new Random();
                    int ranNumber = r.nextInt()+node_len+1;
                    TreeNode delNodes = new TreeNode(ranNumber);
                    delNodes.putData(nodes[NodeRVal].getData());
                    delNodes.makeRightSubTree(nodes[NodeRVal].getRightSubTree());
                    delNodes.makeLeftsubTree(nodes[NodeRVal].getLeftSubTree());
                    delNodes.makeUpSubTree(nodes[NodeRVal].getUpSubTree());
                    int thisNodeVl = (int)nodes[NodeRVal].getData();
                    int upsNodeVl = (int)nodes[NodeRVal].getUpSubTree().getData();
                    int leftNodeVl = (int)nodes[NodeRVal].getLeftSubTree().getData();
                    int rightNodeVl = (int)nodes[NodeRVal].getRightSubTree().getData();
                    if(upsNodeVl == leftNodeVl){
                        System.out.println("자식 노드의 값이 중복되어서 사용이 불가능합니다.");
                        flag = 0;
                    }else if(upsNodeVl == rightNodeVl) {
                        System.out.println("자식 노드의 값이 중복되어서 사용이 불가능합니다.");
                        flag = 0;
                    }else{
                        nodes[NodeRVal].getRightSubTree().makeUpSubTree(nodes[NodeRVal].getUpSubTree());
                        if(nodes[NodeRVal].getLeftSubTree()  == null){
                            nodes[NodeRVal].getRightSubTree().changeLeftsubTree(nodes[NodeRVal].getLeftSubTree());
                        }else{
                            
                        }
                    }
                }
            }
        }while(flag==0);
    }
}
