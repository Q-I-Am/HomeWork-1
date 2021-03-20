import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Main {
		static int playScore = 0;// 玩家积分
		static int otherScore = 0;// 对方（电脑）积分
public static void playScoreUP(){
playScore += 1;
}
public static void otherScoreUP(){
otherScore += 1;
}


	public static void main(String[] args) {
		int times = 0;// 对战次数
		String[] figure = { "锤头", "剪刀", "布" };
		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		System.out.println("---------------------欢迎进入游戏世界---------------------");
		System.out.println();
		System.out.println("\t\t********************************");
		System.out.println("\t\t**欢迎来到人机猜拳大战小游戏  **");
		System.out.println("\t\t**出拳规则: 0.石头 1.剪刀 2.布**");
		System.out.println("\t\t**赛制：1.三局两胜 2.五局三胜 **");
		System.out.println("\t\t********************************");
		System.out.println();
		System.out.println("请选择对方角色（1：刘备 2：孙权 3：曹操）：");
		int num = sc.nextInt();
		String otherName = null;// 对方角色
		switch (num) {// 通过输入的值判断对方的角色
		case 1:
			otherName = "刘备";
			break;
		case 2:
			otherName = "孙权";
			break;
		case 3:
			otherName = "曹操";
			break;
		default:
			System.out.println("输入有误，请重新开始");
System.exit(0);
		}
		System.out.print("请输入你的姓名：");
		String playName = sc.next();// 玩家角色
		System.out.println(playName + " VS " + otherName );
		System.out.println();
		System.out.print("是否开始游戏？（y/n）");
		String choose = sc.next();
		String chooseNext = "n";
 
		do {
			if ("y".equals(choose)) {// 开始游戏
System.out.print("请选择游戏赛制（三局两胜输入1 or 五局三胜输入2）:");
int saizhi = sc.nextInt();
switch (saizhi) {// 通过输入的值判断
case 1:
	VS3 vs3 = new VS3();
                vs3.crGuessingGame(sc);
times++;// 对战次数＋1
	break;
case 2:
	VS5 vs5 = new VS5();
                vs5.crGuessingGame(sc);
times++;// 对战次数＋1
	break;
default:
	System.out.println("输入有误，请重新开始");
System.exit(0);
}
 
				System.out.print("\n是否开始下一轮（y/n）:");
				chooseNext = sc.next();
 
			} else if ("n".equals(choose)) {// 一开始就没启动游戏，直接结束
				break;
			}
		} while ("y".equals(chooseNext));// 输入y时，继续下一轮
 
		System.out.println("---------------------------------------------------------");
		System.out.println(playName + " VS " + otherName + "对战");
		System.out.println("对战次数：" + times);
		System.out.println();
		System.out.println("姓名\t得分");
		System.out.println(playName + "\t" + playScore);
		System.out.println(otherName + "\t" + otherScore);
		sc.close();
	}
}



//石头剪刀布猜拳游戏，三局两胜
class VS3 {
	// 用于存放猜拳结果
	private static List<String> gameResult;
 
	public static void crGuessingGame(Scanner sc) {
		gameResult = new ArrayList<String>();
		// 存储结果集
		char[] finger = { '锤', '剪', '布' };
		// 用于接收每一次的猜拳结果
		String result;
		// 用于计算机猜拳
		Random random = new Random();
		// 记录计算机获胜次数
		int computerWinNumber = 0;
		// 计算玩家获胜次数
		int playerWinNumber = 0;
		// 记录猜拳第几轮
		int i = 0;
		// 循环出拳
		while (true) {
			System.out.println("第" + (i + 1) + "轮，请出拳：");
			// 计算机生成的随机数
			int computerGet = random.nextInt(3);
			// 用户输入的数
			int playerInput = sc.nextInt();
if(playerInput !=0 && playerInput !=1 && playerInput !=2) {
System.out.println("输入错误，程序退出。请重新运行程序！");
System.exit(0);
}
			// 记录猜拳结果
			result = finger[computerGet] + "," + finger[playerInput];
			// 将结果放入集合中
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
			// 记录游戏轮数
			i++;
			// 判断是否有人取得胜利
			if (computerWinNumber == 2 || playerWinNumber == 2) {
				break;
			}
 
		}
		// 判断获胜者
		if (computerWinNumber > playerWinNumber) {
			System.out.println("电脑获胜！");
Main.otherScoreUP(); // 电脑积分＋1
		} else {
			System.out.println("恭喜你获胜！");
Main.playScoreUP(); //玩家积分＋1
		}
		// 输出猜拳结果
		System.out.println("具体结果如下：");
		System.out.println("电脑，用户");
		for (String results : gameResult) {
			System.out.println("{ " + results + " }");
		}
 
	}
}


//石头剪刀布猜拳游戏，五局三胜
class VS5 {
	// 用于存放猜拳结果
	private static List<String> gameResult;
 
	public static void crGuessingGame(Scanner sc) {
		gameResult = new ArrayList<String>();
		// 存储结果集
		char[] finger = { '锤', '剪', '布' };
		// 用于接收每一次的猜拳结果
		String result;
		// 用于计算机猜拳
		Random random = new Random();
		// 记录计算机获胜次数
		int computerWinNumber = 0;
		// 计算玩家获胜次数
		int playerWinNumber = 0;
		// 记录猜拳第几轮
		int i = 0;
		// 循环出拳
		while (true) {
			System.out.println("第" + (i + 1) + "轮，请出拳：");
			// 计算机生成的随机数
			int computerGet = random.nextInt(3);
			// 用户输入的数
			int playerInput = sc.nextInt();
if(playerInput !=0 && playerInput !=1 && playerInput !=2) {
System.out.println("输入错误，程序退出。请重新运行程序！");
System.exit(0);
}
			// 记录猜拳结果
			result = finger[computerGet] + "," + finger[playerInput];
			// 将结果放入集合中
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
			// 记录游戏轮数
			i++;
			// 判断是否有人取得胜利
			if (computerWinNumber == 3 || playerWinNumber == 3) {
				break;
			}
 
		}
		// 判断获胜者
		if (computerWinNumber > playerWinNumber) {
			System.out.println("电脑获胜！");
Main.otherScoreUP(); // 电脑积分＋1
		} else {
			System.out.println("恭喜你获胜！");
Main.playScoreUP(); //玩家积分＋1
		}
		// 输出猜拳结果
		System.out.println("具体结果如下：");
		System.out.println("电脑，用户");
		for (String results : gameResult) {
			System.out.println("{ " + results + " }");
		}
 
	}
}