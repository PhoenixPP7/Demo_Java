package _00_Java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

public class UtilBeanOperate {
	private Object currentObject;	//表示当前程序的保存对象;
	private String attribute;		//表示要操作的属性;		
	private String value;			//表示要操作的内容;
	private String arrayValue [];	//表示要操作的数组内容;
	private Field field;			//表示要操作的成员对象;
	
	/**
	 * 进行数据的接收及操作,接收后才可以进行数据的设置操作;
	 * @param currentObject 表示当前要操作此功能的类对象;
	 * @param attribute	包含了"对象.属性.属性..."字符串;
	 * @param value 表示属性的内容;
	 */
	public UtilBeanOperate(Object currentObject,String attribute,String value) {
		this.currentObject = currentObject;	//保存当前的操作对象;
		this.attribute = attribute;			//表示要操作的属性;	
		this.value = value;					//表示要操作的内容;
		this.handleParameteter();
		this.setValue();
	}
	
	/**
	 * 进行树组数据的接收及操作,接收后才可以进行数据的设置操作;
	 * @param currentObject 表示当前要操作此功能的类对象;
	 * @param attribute	包含了"对象.属性.属性..."字符串;
	 * @param value 表示数组属性的内容;
	 */
	public UtilBeanOperate(Object currentObject,String attribute,String arrayValue[]) {
		this.currentObject = currentObject;	//保存当前的操作对象;
		this.attribute = attribute;			//表示要操作的属性;	
		this.arrayValue = arrayValue;		//表示要操作的内容;
		this.handleParameteter();
		this.setValue();
	}
	
	private void handleParameteter() {	//对传入的数据进行处理;通过当前对象和操作的属性
		try {
			String result[] = this.attribute.split("\\.");
			if (result.length == 2) { //表示现在是单级操作;
				//对于类中的getter方法上不存在参数的情况,所以参数类型为空;
				Method getMet = this.currentObject.getClass().getMethod("get" + UtilString.initcap(result[0]));
				this.currentObject = getMet.invoke(this.currentObject);//调用了getter方法;
				this.field = this.currentObject.getClass().getDeclaredField(result[1]);//取得对象成员
			} else {//表示现在是多级操作
				for (int x = 0 ; x < result.length ; x ++){
					//必须知道当前操作的成员对象,因为只要有对象存在才可以找到属性类型,才可以调用setter方法;
					this.field = this.currentObject.getClass().getDeclaredField(result[x]);
					if (x < result.length -1) { //现在不是最后一块组成,后面还有内容
						Method met = this.currentObject.getClass().getMethod("get" + UtilString.initcap(result[x]));
						this.currentObject = met.invoke(this.currentObject);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setValue() {
		try {
			Method setMet = this.currentObject.getClass().getMethod("set" + UtilString.initcap(this.field.getName()),this.field.getType());
			String type = this.field.getType().getSimpleName(); //取得数据类型;
			if ("int".equalsIgnoreCase(type) || "integer".equalsIgnoreCase(type)) {
				if (this.value.matches("\\d+")) {
					setMet.invoke(this.currentObject,Integer.parseInt(this.value));
				}
			} else if ("double".equalsIgnoreCase(type)) {
				if (this.value.matches("\\d+(\\.\\d+)?")) {
					setMet.invoke(this.currentObject,Double.parseDouble(this.value));
				}
			} else if ("string".equalsIgnoreCase(type)){
				setMet.invoke(this.currentObject,this.value);
			} else if ("date".equalsIgnoreCase(type)) {
				if (this.value.matches("\\d{4}-\\d{2}-\\d{2}")) {
					setMet.invoke(this.currentObject,new SimpleDateFormat("yyyy-MM-dd").parse(this.value));
				}
				if (this.value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
					setMet.invoke(this.currentObject,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(this.value));
				}
			} else if ("string[]".equalsIgnoreCase(type)) {//字符串数组
				setMet.invoke(this.currentObject,new Object[]{this.arrayValue});
			} else if ("int[]".equalsIgnoreCase(type)) {//整数类型数组
				int temp [] =new int [this.arrayValue.length] ;
				for (int x = 0 ; x < temp.length ; x ++) {
					if (this.arrayValue[x].matches("\\d+")){
						temp [x] = Integer.parseInt(this.arrayValue[x]);
					}
				}
				setMet.invoke(this.currentObject,new Object[]{temp});
			} else if ("integer[]".equalsIgnoreCase(type)) {//整数类型数组
				Integer temp [] =new Integer [this.arrayValue.length] ;
				for (int x = 0 ; x < temp.length ; x ++) {
					if (this.arrayValue[x].matches("\\d+")){
						temp [x] = Integer.parseInt(this.arrayValue[x]);
					}
				}
				setMet.invoke(this.currentObject,new Object[]{temp});
			} else if ("double[]".equals(type)) {//小数类型数组
				double temp [] =new double [this.arrayValue.length] ;
				for (int x = 0 ; x < temp.length ; x ++) {
					if (this.arrayValue[x].matches("\\d+(\\.\\d+)?")){
						temp [x] = Double.parseDouble(this.arrayValue[x]);
					}
				}
				setMet.invoke(this.currentObject,new Object[]{temp});
			} else if ("Double[]".equals(type)) {//小数类型数组
				Double temp [] =new Double [this.arrayValue.length] ;
				for (int x = 0 ; x < temp.length ; x ++) {
					if (this.arrayValue[x].matches("\\d+(\\.\\d+)?")){
						temp [x] = Double.parseDouble(this.arrayValue[x]);
					}
				}
				setMet.invoke(this.currentObject,new Object[]{temp});
			}
			//setMet.invoke(this.currentObject, this.value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
