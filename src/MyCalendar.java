//60171649 ����

import java.util.Scanner;
import java.util.ArrayList;

public class MyCalendar {
	String checkyear;
	Scanner sc = new Scanner(System.in);
	String Checkyear;
	ArrayList<Integer> Month_31 = new ArrayList<Integer>();
	ArrayList<Integer> Month_30 = new ArrayList<Integer>();
	int[] int_calendar = new int[3];
	int Year;
	int Month;
	int Date;
	String Day;
	int UserInput;
	
	//������ ��¥�� ����ϱ� ���� �޼ҵ�
	public void Calendar_Calculator() {
		this.Year = int_calendar[0];
		int days = 0;
		CheckYear();
		
		if(Month_31.contains(int_calendar[1]) && 1<=int_calendar[2] && int_calendar[2]<=31) {
			this.Month = int_calendar[1];
			this.Date = int_calendar[2];
			}
		
		else if(Month_30.contains(int_calendar[1]) && 1<=int_calendar[2] && int_calendar[2]<=30) {
			this.Month = int_calendar[1];
			this.Date = int_calendar[2];
			}
		
		else if(int_calendar[1] == 2 && Checkyear == "����" && 1<=int_calendar[2] && int_calendar[2]<=29) {
			this.Month = int_calendar[1];
			this.Date = int_calendar[2];
			}
		else if(int_calendar[1] ==2 && Checkyear != "����" && 1<=int_calendar[2] && int_calendar[2]<=28) {
			this.Month = int_calendar[1];
			this.Date = int_calendar[2];
		}
		
		else {
			throw new IllegalArgumentException("���Ұ����� ���Դϴ�");
		}
		
		for(int i = 1; i<=Month; i++) {
			if(i == Month) {
				days = days + Date;
			} else if(i==1 || i==3 || i ==5 || i ==7 || i ==8 || i == 10 || i == 12) {
				days = days + 31;
			} else if(i==4 || i==6 || i ==9 || i ==11 ) {
				days = days + 30;
			} else if(i==2 && Checkyear == "����") {
				days = days + 29;
			} else if(i==2 && Checkyear != "����") {
				days =days + 28;
			}
		}
			
		if(days%7 == 1) {
			Day = "������";
		} else if(days%7 == 2) {
			Day = "ȭ����";
		} else if(days%7 == 3) {
			Day = "������";
		} else if(days%7 == 4) {
			Day = "�����";
		} else if(days%7 == 5) {
			Day = "�ݿ���";
		} else if(days%7 == 6) {
			Day = "�����";
		} else if(days%7 == 0) {
			Day = "�Ͽ���";
		}
		
	}
	
	//������ ����ϱ����� �޼ҵ�
	public void CheckYear() {
		if(int_calendar[0]%4==0 && int_calendar[0]%100 !=0 || int_calendar[0]%400==0) {
			checkyear = "����";
		}
	}

	//Add,Roll����� �ϴ� �˰����� ¥������ �ʿ��� �޼ҵ� 
	public int CheckDates(int month) {
		int max = 0;
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			max = 31;
		} else if(month == 4 || month == 6 || month == 9 || month == 11) {
			max = 30;
		} else if(checkyear =="����" && month == 2) {
			max = 29;
		} else if(checkyear !="����" && month == 2) {
			max = 28;
		}
		return max;
	}
	
	//Add��Roll����� �ϱ����� �޼ҵ�(ADD,ROLL)��忡 ���� ����Ǵ� �˰����� �ٸ���.
	public void add(int year,int month,int day,String mode) {
		if(mode=="ADD") {
			CheckYear();
			int_calendar[2] = int_calendar[2] + day;
			if(int_calendar[2]>CheckDates(int_calendar[1])) {
				while(int_calendar[2]>CheckDates(int_calendar[1])) {
					int_calendar[2]=int_calendar[2]-CheckDates(int_calendar[1]);
					int_calendar[1]++;
					if(int_calendar[1]>12) {
						int_calendar[1]=int_calendar[1]%12;
						int_calendar[0]++;
						CheckYear();
					}
				}
			}
			else if(int_calendar[2]<0) {
				while(int_calendar[2]<0) {
					int_calendar[2] = int_calendar[2] + CheckDates(int_calendar[1]);
					int_calendar[1]--;
					if(int_calendar[1]<1) {
						while(int_calendar[1]<1){
							int_calendar[1]=12-Math.abs(int_calendar[1]);
							int_calendar[0]--;
							CheckYear();
						}
					}
				}
			}
		
			int_calendar[1] = int_calendar[1] + month;
			if(int_calendar[1]>12) {
				int_calendar[1]=int_calendar[1]%12;
				int_calendar[0]++;
			}
			else if(int_calendar[1]<1) {
				while(int_calendar[1]<1) {
					int_calendar[1]=12-Math.abs(int_calendar[1]);
					int_calendar[0]--;
				}
			}
		
			int_calendar[0] = int_calendar[0] + year;
		}
		
		else if(mode == "ROLL") {
			CheckYear();
			int Origin_year = int_calendar[0];
			int Origin_month = int_calendar[1];
			
			int_calendar[2] = int_calendar[2] + day;
			if(int_calendar[2]>CheckDates(int_calendar[1])) {
				while(int_calendar[2]>CheckDates(int_calendar[1])) {
					int_calendar[2]=int_calendar[2]-CheckDates(int_calendar[1]);
					int_calendar[1]++;
					if(int_calendar[1]>12) {
						int_calendar[1]=int_calendar[1]%12;
						int_calendar[0]++;
						CheckYear();	
					}
				}
				int_calendar[0] = Origin_year;
				int_calendar[1] = Origin_month;
			}
			
			else if(int_calendar[2]<0) {
				while(int_calendar[2]<0) {
					int_calendar[2] = int_calendar[2] + CheckDates(int_calendar[1]);
					int_calendar[1]--;
					if(int_calendar[1]<1) {
						while(int_calendar[1]<1) {
						int_calendar[1]=12-Math.abs(int_calendar[1]);
						int_calendar[0]--;
						CheckYear();
					}
				}
			}
				int_calendar[0] = Origin_year;
				int_calendar[1] = Origin_month;
			}
			
			int_calendar[1] = int_calendar[1] + month;
			if(int_calendar[1]>12) {
				int_calendar[1]=int_calendar[1]%12;
				int_calendar[0]++;
			}
			else if(int_calendar[1]<1) {
				while(int_calendar[1]<1) {
				int_calendar[1]=12-Math.abs(int_calendar[1]%12);
				int_calendar[0]--;
			}
		}
			int_calendar[0] = Origin_year;
			
			int_calendar[0] =int_calendar[0] + year;
		}
	}
		
	//�ʱⰪ 1�� 1�� 1�� ����� �������� ��������� �޼ҵ�
	public void Start() {
		Month_31.add(1);
		Month_31.add(3);
		Month_31.add(5);
		Month_31.add(7);
		Month_31.add(8);
		Month_31.add(10);
		Month_31.add(12);
		
		Month_30.add(4);
		Month_30.add(6);
		Month_30.add(9);
		Month_30.add(11);
		
		int_calendar[0] = 1;
		int_calendar[1] = 1;
		int_calendar[2] = 1;
		this.Year = int_calendar[0];
		Calendar_Calculator();
		
		while(UserInput != 4){
		
			System.out.println("�޴��� �����ϼ���.");
			System.out.println("1.��¥ ����");
			System.out.println("2.Add");
			System.out.println("3.Roll");
			System.out.println("4.����");
			System.out.print("> ");
			this.UserInput = sc.nextInt();
			if(UserInput == 1) {
				try {
					Number1();
				}
				catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					System.out.println("\n");
				}	
			} else if(UserInput == 2) {
				try {
					Number2();
				}
				catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					System.out.println("\n");
				}
			} else if(UserInput == 3) {
				try {
					Number3();
				}
				catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					System.out.println("\n");
				}
			}else if(UserInput == 4) {
				System.out.println("���α׷��� �����մϴ�.");
			}
		}
	}
	
	//��¥���ñ��
	public void Number1() {
		System.out.println("��_��_�� �� �Է��ϼ���.");
		String str = sc.next();
		String[]str_calendar =  str.split("_");
		int_calendar[0] = Integer.parseInt(str_calendar[0]);
		int_calendar[1] = Integer.parseInt(str_calendar[1]);
		int_calendar[2] = Integer.parseInt(str_calendar[2]);
		this.Year = int_calendar[0];
		Calendar_Calculator();
		System.out.printf("%d�� %d�� %d�� %s�Դϴ�.",Year,Month,Date,Day);
		System.out.println("\n");
	}
	
	//ADD���
	public void Number2() {
		int Add_Year = 0;
		int Add_Month = 0;
		int Add_Day = 0;
		String Add_All;

		System.out.println("Field�� �����ϼ���: 1)Year 2)Month 3)Day 4)All");
		int Input_Field = sc.nextInt();
		
		if(Input_Field == 1) {
			System.out.println("���� �Է��ϼ���.");
			Add_Year = sc.nextInt();
			add(Add_Year,0,0,"ADD");
			Calendar_Calculator();
			System.out.printf("%d�� %d�� %d�� %s�Դϴ�.",Year,Month,Date,Day);
			System.out.println("\n");
		}else if(Input_Field == 2) {
			System.out.println("���� �Է��ϼ���.");
			Add_Month = sc.nextInt();
			add(0,Add_Month,0,"ADD");
			Calendar_Calculator();
			System.out.printf("%d�� %d�� %d�� %s�Դϴ�.",Year,Month,Date,Day);
			System.out.println("\n");
		} else if(Input_Field == 3) {
			System.out.println("���� �Է��ϼ���.");
			Add_Day = sc.nextInt();
			add(0,0,Add_Day,"ADD");
			Calendar_Calculator();
			System.out.printf("%d�� %d�� %d�� %s�Դϴ�.",Year,Month,Date,Day);
			System.out.println("\n");
		} else if(Input_Field == 4) {
			System.out.println("���� �Է��ϼ���.");
			Add_All = sc.next();
			String[] Add_All_array = Add_All.split("_");
			Add_Year =Integer.parseInt(Add_All_array[0]);
			Add_Month =Integer.parseInt(Add_All_array[1]);
			Add_Day =Integer.parseInt(Add_All_array[2]);
			add(Add_Year,Add_Month,Add_Day,"ADD");
			Calendar_Calculator();
			System.out.printf("%d�� %d�� %d�� %s�Դϴ�.",Year,Month,Date,Day);
			System.out.println("\n");
		}
	}
	
	//ROLL���
	public void Number3() {
		int Add_Year = 0;
		int Add_Month = 0;
		int Add_Day = 0;
		String Add_All;

		System.out.println("Field�� �����ϼ���: 1)Year 2)Month 3)Day 4)All");
		int Input_Field = sc.nextInt();
		
		if(Input_Field == 1) {
			System.out.println("���� �Է��ϼ���.");
			Add_Year = sc.nextInt();
			add(Add_Year,0,0,"ROLL");
			Calendar_Calculator();
			System.out.printf("%d�� %d�� %d�� %s�Դϴ�.",Year,Month,Date,Day);
			System.out.println("\n");
		}else if(Input_Field == 2) {
			System.out.println("���� �Է��ϼ���.");
			Add_Month = sc.nextInt();
			add(0,Add_Month,0,"ROLL");
			Calendar_Calculator();
			System.out.printf("%d�� %d�� %d�� %s�Դϴ�.",Year,Month,Date,Day);
			System.out.println("\n");
		} else if(Input_Field == 3) {
			System.out.println("���� �Է��ϼ���.");
			Add_Day = sc.nextInt();
			add(0,0,Add_Day,"ROLL");
			Calendar_Calculator();
			System.out.printf("%d�� %d�� %d�� %s�Դϴ�.",Year,Month,Date,Day);
			System.out.println("\n");
		} else if(Input_Field == 4) {
			System.out.println("���� �Է��ϼ���.");
			Add_All = sc.next();
			String[] Add_All_array = Add_All.split("_");
			Add_Year =Integer.parseInt(Add_All_array[0]);
			Add_Month =Integer.parseInt(Add_All_array[1]);
			Add_Day =Integer.parseInt(Add_All_array[2]);
			add(Add_Year,Add_Month,Add_Day,"ROLL");
			Calendar_Calculator();
			System.out.printf("%d�� %d�� %d�� %s�Դϴ�.",Year,Month,Date,Day);
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		MyCalendar mc = new MyCalendar();
		mc.Start();


	}

}
