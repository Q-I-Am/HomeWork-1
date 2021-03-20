import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Main {
		static int playScore = 0;// ��һ���
		static int otherScore = 0;// �Է������ԣ�����
public static void playScoreUP(){
playScore += 1;
}
public static void otherScoreUP(){
otherScore += 1;
}


	public static void main(String[] args) {
		int times = 0;// ��ս����
		String[] figure = { "��ͷ", "����", "��" };
		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		System.out.println("---------------------��ӭ������Ϸ����---------------------");
		System.out.println();
		System.out.println("\t\t********************************");
		System.out.println("\t\t**��ӭ�����˻���ȭ��սС��Ϸ  **");
		System.out.println("\t\t**��ȭ����: 0.ʯͷ 1.���� 2.��**");
		System.out.println("\t\t**���ƣ�1.������ʤ 2.�����ʤ **");
		System.out.println("\t\t********************************");
		System.out.println();
		System.out.println("��ѡ��Է���ɫ��1������ 2����Ȩ 3���ܲ٣���");
		int num = sc.nextInt();
		String otherName = null;// �Է���ɫ
		switch (num) {// ͨ�������ֵ�ж϶Է��Ľ�ɫ
		case 1:
			otherName = "����";
			break;
		case 2:
			otherName = "��Ȩ";
			break;
		case 3:
			otherName = "�ܲ�";
			break;
		default:
			System.out.println("�������������¿�ʼ");
System.exit(0);
		}
		System.out.print("���������������");
		String playName = sc.next();// ��ҽ�ɫ
		System.out.println(playName + " VS " + otherName );
		System.out.println();
		System.out.print("�Ƿ�ʼ��Ϸ����y/n��");
		String choose = sc.next();
		String chooseNext = "n";
 
		do {
			if ("y".equals(choose)) {// ��ʼ��Ϸ
System.out.print("��ѡ����Ϸ���ƣ�������ʤ����1 or �����ʤ����2��:");
int saizhi = sc.nextInt();
switch (saizhi) {// ͨ�������ֵ�ж�
case 1:
	VS3 vs3 = new VS3();
                vs3.crGuessingGame(sc);
times++;// ��ս������1
	break;
case 2:
	VS5 vs5 = new VS5();
                vs5.crGuessingGame(sc);
times++;// ��ս������1
	break;
default:
	System.out.println("�������������¿�ʼ");
System.exit(0);
}
 
				System.out.print("\n�Ƿ�ʼ��һ�֣�y/n��:");
				chooseNext = sc.next();
 
			} else if ("n".equals(choose)) {// һ��ʼ��û������Ϸ��ֱ�ӽ���
				break;
			}
		} while ("y".equals(chooseNext));// ����yʱ��������һ��
 
		System.out.println("---------------------------------------------------------");
		System.out.println(playName + " VS " + otherName + "��ս");
		System.out.println("��ս������" + times);
		System.out.println();
		System.out.println("����\t�÷�");
		System.out.println(playName + "\t" + playScore);
		System.out.println(otherName + "\t" + otherScore);
		sc.close();
	}
}



//ʯͷ��������ȭ��Ϸ��������ʤ
class VS3 {
	// ���ڴ�Ų�ȭ���
	private static List<String> gameResult;
 
	public static void crGuessingGame(Scanner sc) {
		gameResult = new ArrayList<String>();
		// �洢�����
		char[] finger = { '��', '��', '��' };
		// ���ڽ���ÿһ�εĲ�ȭ���
		String result;
		// ���ڼ������ȭ
		Random random = new Random();
		// ��¼�������ʤ����
		int computerWinNumber = 0;
		// ������һ�ʤ����
		int playerWinNumber = 0;
		// ��¼��ȭ�ڼ���
		int i = 0;
		// ѭ����ȭ
		while (true) {
			System.out.println("��" + (i + 1) + "�֣����ȭ��");
			// ��������ɵ������
			int computerGet = random.nextInt(3);
			// �û��������
			int playerInput = sc.nextInt();
if(playerInput !=0 && playerInput !=1 && playerInput !=2) {
System.out.println("������󣬳����˳������������г���");
System.exit(0);
}
			// ��¼��ȭ���
			result = finger[computerGet] + "," + finger[playerInput];
			// ��������뼯����
			gameResult.add(result);
			switch (computerGet) {
			case 0:
				if (playerInput == 1)
					computerWinNumber++;
				if (playerInput == 2)
					playerWinNumber++;
				break;
 
			case 1:
				if (playerInput == 2)
					computerWinNumber++;
				if (playerInput == 0)
					playerWinNumber++;
 
				break;
			case 2:
				if (playerInput == 0)
					computerWinNumber++;
				if (playerInput == 1)
					playerWinNumber++;
				break;
 
			default:
				break;
			}
			// ��¼��Ϸ����
			i++;
			// �ж��Ƿ�����ȡ��ʤ��
			if (computerWinNumber == 2 || playerWinNumber == 2) {
				break;
			}
 
		}
		// �жϻ�ʤ��
		if (computerWinNumber > playerWinNumber) {
			System.out.println("���Ի�ʤ��");
Main.otherScoreUP(); // ���Ի��֣�1
		} else {
			System.out.println("��ϲ���ʤ��");
Main.playScoreUP(); //��һ��֣�1
		}
		// �����ȭ���
		System.out.println("���������£�");
		System.out.println("���ԣ��û�");
		for (String results : gameResult) {
			System.out.println("{ " + results + " }");
		}
 
	}
}


//ʯͷ��������ȭ��Ϸ�������ʤ
class VS5 {
	// ���ڴ�Ų�ȭ���
	private static List<String> gameResult;
 
	public static void crGuessingGame(Scanner sc) {
		gameResult = new ArrayList<String>();
		// �洢�����
		char[] finger = { '��', '��', '��' };
		// ���ڽ���ÿһ�εĲ�ȭ���
		String result;
		// ���ڼ������ȭ
		Random random = new Random();
		// ��¼�������ʤ����
		int computerWinNumber = 0;
		// ������һ�ʤ����
		int playerWinNumber = 0;
		// ��¼��ȭ�ڼ���
		int i = 0;
		// ѭ����ȭ
		while (true) {
			System.out.println("��" + (i + 1) + "�֣����ȭ��");
			// ��������ɵ������
			int computerGet = random.nextInt(3);
			// �û��������
			int playerInput = sc.nextInt();
if(playerInput !=0 && playerInput !=1 && playerInput !=2) {
System.out.println("������󣬳����˳������������г���");
System.exit(0);
}
			// ��¼��ȭ���
			result = finger[computerGet] + "," + finger[playerInput];
			// ��������뼯����
			gameResult.add(result);
			switch (computerGet) {
			case 0:
				if (playerInput == 1)
					computerWinNumber++;
				if (playerInput == 2)
					playerWinNumber++;
				break;
 
			case 1:
				if (playerInput == 2)
					computerWinNumber++;
				if (playerInput == 0)
					playerWinNumber++;
 
				break;
			case 2:
				if (playerInput == 0)
					computerWinNumber++;
				if (playerInput == 1)
					playerWinNumber++;
				break;
 
			default:
				break;
			}
			// ��¼��Ϸ����
			i++;
			// �ж��Ƿ�����ȡ��ʤ��
			if (computerWinNumber == 3 || playerWinNumber == 3) {
				break;
			}
 
		}
		// �жϻ�ʤ��
		if (computerWinNumber > playerWinNumber) {
			System.out.println("���Ի�ʤ��");
Main.otherScoreUP(); // ���Ի��֣�1
		} else {
			System.out.println("��ϲ���ʤ��");
Main.playScoreUP(); //��һ��֣�1
		}
		// �����ȭ���
		System.out.println("���������£�");
		System.out.println("���ԣ��û�");
		for (String results : gameResult) {
			System.out.println("{ " + results + " }");
		}
 
	}
}