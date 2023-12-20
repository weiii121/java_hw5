//P6, P8, P10, P14, P19, 
//P21, P24, P26, P30, P32,
//P34, P35, P36, P40, P44,
//P45, P46, P47, P48, P50,
//P52, P55
package pa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import pc.Car5;
public class HW5 {

	public static void main(String[] args) {
		System.out.println("========== P5 P6 P10 P14 ==========");
		Car5 car5 = new Car5();
		car5.show();
		
		
		System.out.println("========== P19 P21 P24 P26==========");
		try {
			int[] test;
			test = new int[5];
			
			System.out.println("將值指定給test[10]");
			
			test[10] = 80;
			System.out.println("將80指定給test[10]");
			
		}catch(ArrayIndexOutOfBoundsException err){
			System.out.println("超過陣列的範圍了");
			System.out.println("發生了" + err + "這個例外");
		}finally {
			System.out.println("最後一定會執行這個處理");
		}
		
		System.out.println("順利地執行完畢");
		
		System.out.println("========== P30 P32 ==========");
		Car31 car31 = new Car31();
		try {
			car31.setCar(1234, -10.0);
		}catch (CarException err){
			System.out.println("拋出" + err + "了");
		}
		
		System.out.println("========== P34 ==========");
		System.out.println("請輸入字串");
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			System.out.println("已輸入字串" + str);
		}catch(IOException err) {
			System.out.println("輸入輸出有誤");
		}
		
		System.out.println("========== P35 ==========");
		try {
			FileWriter fw = new FileWriter("test1.txt");
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println("Hello!");
			pw.println("GoodBye!");
			
			pw.close();
			
			System.out.println("資料已經寫入檔案了");
		}catch(IOException err) {
			System.out.println("輸出入錯誤");
		}
		
		System.out.println("========== P36 ==========");
		try {
			BufferedReader br = new BufferedReader(new FileReader("test1.txt"));
			String str1 = br.readLine();
			String str2 = br.readLine();
			
			System.out.println("寫入到檔案中的兩個字串是");
			System.out.println(str1);
			System.out.println(str2);
			br.close();
		}catch(IOException err){
			System.out.println("輸出入錯誤");
		}
		
		System.out.println("========== P40 ==========");
		if(args.length != 1) {
			System.out.println("請指定正確的檔案名稱");
			System.exit(1);
		}
		try {
			BufferedReader br1 = new BufferedReader(new FileReader(args[0]));
			String str;
			while((str = br1.readLine()) != null) {
				System.out.println(str);
			}
			br1.close();
		}catch(IOException err) {
			System.out.println("輸出入錯誤");
		}
		
		System.out.println("========== P44 ==========");
		Car44 car44 = new Car44("1號車");
		car44.start();
		for(int i = 0; i < 5; i++) {
			System.out.println("正在進行main()的處理工作");
		}
		
		System.out.println("========== P45 P46 P47 ==========");
		Car44 car45_1 = new Car44("1號車");
		car45_1.start();
		
		Car44 car45_2 = new Car44("2號車");
		car45_2.start();
		
		for(int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("正在進行main()的處理工作");
			}catch(InterruptedException err) {
				
			}
			
		}
		
		System.out.println("========== P48 ==========");
		
		Car48 car48 = new Car48("1號車");
		car48.start();
		
		try {
			car48.join();
		}catch(InterruptedException err){
			
		}
		System.out.println("結束main()的處理工作。");
		
		System.out.println("========== P50 ==========");
		Car50 car50 = new Car50("1號車");
		
		Thread th1 = new Thread(car50);
		th1.start();
		for(int i = 0; i < 5; i++) {
			System.out.println("正在進行main()的處理工作");
		}
		
		System.out.println("========== P52 P55 ==========");
		Company cmp = new Company();
		
		Driver drv1 = new Driver(cmp);
		drv1.start();
		
		Driver drv2 = new Driver(cmp);
		drv2.start();
		
	}
}

class Car31 {
	private int num;
	private double gas;
	
	public Car31() {
		num = 0;
		gas = 0.0;
		System.out.println("已生產了汽車");
	}
	
	public void setCar(int n, double g) throws CarException {
		if(g < 0) {
			CarException err = new CarException();
			throw err;
		}
		num = n;
		gas = g;
		System.out.println("將車號設為" + num+ "汽油輛設為" + gas);
	}
	
	public void show() {
		System.out.println("車號是" + num);
		System.out.println("汽油輛是" + num);
	}

}

class CarException extends Exception{
	
}

class Car44 extends Thread{
	private String name;
	
	public Car44(String nm) {
		name = nm;
	}
	
	public void run() {
		for(int i = 0; i < 5; i++) {
			try {
				sleep(1000);
				System.out.println("正在進行" + name + "的處理工作");
			}catch(InterruptedException err) {
				
			}
			
		}
	}
}

class Car48 extends Thread{
	private String name;
	
	public Car48(String nm) {
		name = nm;
	}
	
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("正在進行" + name + "的處理工作");
		}
	}
}

class Car50 implements Runnable{
	private String name;
	
	public Car50(String nm) {
		name = nm;
	}
	
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("正在進行" + name + "的處理工作");
		}
	}
}

class Company{
	private int sum = 0;
	public synchronized void add(int a) {
		int temp = sum;
		System.out.println("目前的合計金額是" + temp + "元");
		System.out.println("賺到" + a + "元了。");
		temp = temp + a;
		System.out.println("合計金額是" + temp + "元");
		sum = temp;
	}
}

class Driver extends Thread{
	private Company comp;
	public Driver(Company c) {
		comp = c;
	}
	
	public void run() {
		for(int i = 0; i < 3; i++) {
			comp.add(50);
		}
	}
}
