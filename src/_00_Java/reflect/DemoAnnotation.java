package _00_Java.reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DemoAnnotation {
	public String name() default "无名氏";	//定义了一个name属性;因为此处有default默认值,所以调用处也可以不声明name属性;
	public String value();					//定义了一个value属性;
}
//定义了此Annotation后,使用此Annotation的地方就可以使用name和value两个属性设置内容了;