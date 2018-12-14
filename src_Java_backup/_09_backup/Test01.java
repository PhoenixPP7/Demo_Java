package _09_backup;
/*
 * 
*/

public class Test01 {
	byte score;
	short age;
	int sumScore;
	long fileSize;
	float x,y;
	double result1;
	char gender;
	boolean isContinue;
/*	double sqrt20=Math.sqrt(20);//将20的平方根保存至sqrt20这个变量中
	double sqrt10=Math.sqrt(10);//将10的平方根保存至sqrt10这个变量中
	double add=sqrt20+sqrt10;
	double minus=sqrt20-sqrt10;
	double result=(sqrt20+sqrt10)/(sqrt20-sqrt10);
	result=Math.round(result*10)/10.0;
	result=Math.round(resulet*10)/10.0;*/
			
	public static void main(String[] args) {
		double sqrt20=Math.sqrt(20);//将20的平方根保存至sqrt20这个变量中
		double sqrt10=Math.sqrt(10);//将10的平方根保存至sqrt10这个变量中
		double add=sqrt20+sqrt10;
		double minus=sqrt20-sqrt10;
		double result=(sqrt20+sqrt10)/(sqrt20-sqrt10);
		System.out.println("sqrt20="+sqrt20);
		System.out.println("sqrt10="+sqrt10);
		System.out.println("(sqrt(20)+sqrt(10))/(sqrt(20)-sqrt(10))="+result);
	}
	
	

}
