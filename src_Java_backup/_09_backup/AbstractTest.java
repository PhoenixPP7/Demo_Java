package _09_backup;

abstract class AbstractDemo {
	void methodNormal(){}
	abstract void method();
/*
��˵��һ������=��ͨ���е���ͨ������{}��ʾ������;���󷽷�û�з�����;���г��󷽷������ǳ�����,ʹ��abstract����,��=
	abstract class AbstractDemo{
		abstract void method();
	}
	������ʹ��ԭ��=
		1.���������������,����������뱻����̳�;
		2.�������������븲д������֮�е����г��󷽷�,��ǿ�����าд;
		3.������Ķ���ʵ������Ҫ���������,�����������ת�͵ķ�ʽ����,��=��������ָ���������;
		4.ʵ��ʹ����,�̳�һ����ָ��ͨ��̳г�����;
		5.�����಻����final����,��Ϊfinal�������಻�ܱ��̳�,������������;
		
	������¼=
		switchֻ֧����ֵ�ж�,if֧�������ж�;
 */
}

class AbstractSon extends AbstractDemo{//����̳г�����;
	public void method(){//��д������󷽷�;
		System.out.println("AbstractSon!");
	}
}

public abstract class AbstractTest{
	public static void main(String args []) {
		//AbstractDemo ad = new AbstractDemo();
		//ad.method();
		AbstractDemo ad = new AbstractSon();//����ת��
		ad.method();
	}
}