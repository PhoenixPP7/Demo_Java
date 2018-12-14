package _00_Java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class UtilAttributeType {
	private Object currentObject; //当前的操作对象;
	private String attribute; //属性的字符串描述;
	private Field field; //属性的成员
	
	public UtilAttributeType(Object currentObject, String attribute){
		this.currentObject = currentObject;
		this.attribute = attribute;
		this.handleParameteter();
	}
	
	private void handleParameteter() {//对传入的数据进行处理;
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
	
	public Field getField() {
		return this.field;
	}
	
	public String getFiledType() {
		return this.field.getType().getSimpleName();
	}
	
}
