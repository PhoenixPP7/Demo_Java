package _08_review;

public class TestBubbleSort {

	public static void main(String[] args) {
		Date[] days = new Date[5];
		days[0] = new Date(2008, 1, 1);
		days[1] = new Date(2009, 1, 25);
		days[2] = new Date(2008, 6, 20);
		days[3] = new Date(2007, 6, 10);
		days[4] = new Date(2007, 12, 15);
		
		bubbleSort(days);
		
		for(int i = 0; i < days.length; i++) {
			System.out.println(days[i]);
		}
	}
	
	public static Date[] bubbleSort(Date[] d) {
		int len = d.length;
		for(int i = d.length - 1; i >= 1; i--) {
			for(int j = 0; j <= i - 1; j++) {
				if(d[j].compare(d[j+1]) > 0) {
					Date temp = d[j];
					d[j] = d[j+1];
					d[j+1] = temp;
				}
			}
		}
		return d;
	}

}

class Date{
	int y, m, d;
	
	Date(int _y,int _m,int _d){
		y = _y;
		m = _m;
		d = _d;
	}
	
	public int compare(Date date) {
		return y > date.y ? 1
			   : y < date.y ? -1
			   : m > date.m ? 1
			   : m < date.m ? -1
			   : d > date.d ? 1
			   : d < date.d ? -1
			   : 0;
	}
	
	public String toString() {
		return "Year - Month - Day  = " + y + " - " + m + " - " + d;
	}
}