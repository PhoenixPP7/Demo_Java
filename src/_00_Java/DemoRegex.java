package _00_Java;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoRegex {
	public static void main(String[] args) throws Exception {
		//实现只保留字符串strA中的小写字母;
		String strA = "asdj;lk3.24	21k;230a.4;lz	xcaq";
		String regexA = "[^a-z]";		//匹配非小写英文字母的字符;
		//String regexA = "\\t";		//匹配制表符;
		//String regexA = ".";			//匹配所有字符;
		//String regexA = "\\.";		//匹配小数点".";
		System.out.println(strA.replaceAll(regexA,""));
		
		//实现字符串拆分,按数字拆分;
		String strB = "asdj;lk32421k;234;lzxcaq";
		String regexB = "\\d+";		//1个或多个数字
		String [] resultB = strB.split(regexB);
		for (int x = 0 ; x < resultB.length ; x ++){
			System.out.println(resultB[x]);
		}
		
		//验证一个字符串是否是数字,如果是将其转换为double型;例=10合法,10.11合法;
		String strC = "10.9666";
		//String regexC = "\\d+.{0,1}\\d{0,2}";
		String regexC = "\\d+(\\.\\d+)?";		//"小数点"和"1个或多个数字"出现0次或1次;
		if (strC.matches(regexC)){
			System.out.println(Double.parseDouble(strC));
		}
		
		//验证是否是一个IP地址
		String strD = "10.101.113.11";
		String regexD = "(\\d{1,3}\\.){3}\\d{1,3}{1}";		//第一部分="1个-3个数字"及"小数点"需出现3次,第二部分="1个-3个数字"出现1次;
		System.out.println(strD.matches(regexD));
		
		//验证字符串是否是日期格式,如果是将其转换为Date型数据;
		String strE = "2018-11-28";
		String regexE = "\\d{4}(-\\d{2}){2}";
		if (strE.matches(regexE)){
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strE);
			System.out.println(date);
		}
		
		//验证电话号码,例=83367111;010-83367111;(010)-83367111(括号成对出现);
		String strF = "(010)-83367111";
		String regexF = "(\\d{3,4}-)|(\\(\\d{3,4}\\)-)?\\d{7,8}";
		System.out.println(strF.matches(regexF));
		
		//验证email地址;
		//要求1=邮件名称由字母、数字、"_"、"."组成,必须以字母开头,字母或数字结尾,长度不超过30;
		//要求2=根域名只能是".com"、".cn"、".net"、".com.cn"、".net.cn"、".edu"、".gov"、".org";
		String strG = "lzp533x@qq.com";
		String regexG = "[a-zA-Z][a-zA-Z0-9_\\.]{0,28}[a-zA-Z0-9]@\\w+\\.(com|cn|net|com\\.cn|net\\.cn|edu|gov|org)";
		System.out.println(strG.matches(regexG));
		
		//使用[java.util.regex.Pattern]的[split()]方法拆分;
		String strH = "a123123b253253c456456d1231";
		String regexH = "\\d+";		//1个或多个数字;
		Pattern pattern = Pattern.compile(regexH);	//使用[Pattern]的[compile()]方法编译正则regexH;
		String [] resultH = pattern.split(strH);	//使用[Pattern]的对象[split()]方法对strH字符串执行拆分;
		System.out.println(Arrays.toString(resultH));
		
		//使用[java.util.regex.Pattern]的[matcher()]方法验证;
		String strI = "56541";
		String regexI = "\\d+";		//1个或多个数字;
		Pattern patternI = Pattern.compile(regexI);	//使用[Pattern]的[compile()]方法编译正则regexI;
		Matcher mat = patternI.matcher(strI);		//进行正则匹配;
		System.out.println(mat.matches());			//输出匹配结果
	}
}


/*
==========正则表达式
	说明=使用正则可以实现验证代码的简化;
=====[java.lang.String](重要)
	说明=实际开发中往往使用[String]类使用正则;因为[Pattern]和[Matcher]使用较麻烦,且[String]类使用正则可以实现同样的效果;
	方法=
		正则验证=[public boolean matches(String regex)];使用指定的字符串进行正则验证,判断其是否符合指定的正则表达式结构;
		替换全部=[public String replaceAll(String regex,String replacement)]
		替换首个=[public String replaceFirst(String regex,String replacement)]
		拆分全部=[public String[] split(String regex)]
		拆分部分=[public String[] split(String regex,int limit)]

=====[java.util.regex]包支持(了解)
=====[java.util.regex.Pattern]
	说明=此类的构造方法被私有化了,要想取得此类对象需使用[compile()]方法;
	方法=
		取得[Matcher]类对象=[public Matcher matcher(CharSequence input)]
		编译正则=[public static Pattern compile(String regex)]
		拆分正则=[public String[] split(CharSequence input,int limit)]
=====[java.util.regex.Matcher]
	说明=此类的对象需要使用[Pattern]类中[matcher()]方法;
	方法=进行正则匹配=[public boolean matches()];

=====正则标记(重要)
	说明=所有正则标记在[Pattern]类中查看;以下带有"\"的标记,如果真的要表示,需要再使用"\"表示转义,例="制表符"="\\t";
1.单个字符(数量为1)
	字符=表示由一位字符组成;
	\\=表示转义字符"\";
	\t=表示匹配"\t"符号(制表符);
	\n=表示匹配"\n"符号(换行符);
2.字符集(数量为1)
	[abc]=表示可以是a、b、c中的任意一位;
	[^abc]=表示不可以是a、b、c中的任意一位;
	[a-z]=表示可以是小写字母;
	[a-zA-Z]=表示可以是小写或大写字母;
	[0-9]=表示可以是任意一位数字;
3.简化字符集(数量1)
	.=表示任意一位字符;(如数字字母特殊符号,所以split()方法拆分时不能用".");
	\\.=表示真的小数点.;
	\d=表示可以是任意一位数字;(等价于"[0-9]");
	\D=表示不可以是任意一位数字;(等价于"[^0-9]");
	\s=表示任意的空白字符;例="\t"、"\n"都是空白字符;
	\S=表示不可以是任意的空白字符;
	\w=表示可以是任意一位小写字母、大写字母、数字、下划线_;(等价于"[a-zA-Z_0-9]");
	\W=表示不可以是任意一位小写字母、大写字母、数字、下划线_;(等价于"[^a-zA-Z_0-9]");
4.边界匹配(Java中不要使用,可以在JavaSript中使用)
	^=表示正则的开始;
	$=表示正则的结束;
5.数量表达式
	正则?=表示正则可以出现0次或1次;
	正则+=表示正则可以出现1次或1次以上;
	正则*=表示正则可以出现0次或1次或1次以上;
	正则{n}=表示正则出现n次;
	正则{n,}=表示正则出现n次及以上;
	正则{n,m}=表示正则出现n次至m次;
6.逻辑运算
	正则1正则2=表示判断完正则1之后继续判断正则2,都需要满足;
	正则1|正则2=表示正则1或正则2有一组满足即可;
	(正则)=将多个正则作为一组,可以为这一组单租设置出现次数;
*/