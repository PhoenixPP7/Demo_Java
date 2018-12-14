package _00_Java.reflect;
public class UtilValidate {
    /**
     * 验证数据是否为空;
     * @param data 需要验证的数据;
     * @return 如果数据不为空,返回true;否则返回false;
     */
    public static boolean validateEmpty(String data) {
        if(data == null || "".equals(data)){
            return false;
        }
        return true;
    }
    /**
     * 对数据进行正则验证;
     * @param data 需要进行正则验证的数据;
     * @param regex 需要执行验证的正则表达式;
     * @return 如果正则验证通过,返回true;否则返回false;
     */
    public static boolean validateRegex(String data,String regex) {
        if (validateEmpty(data)) {
            return data.matches(regex);
        }
        return false;
    }
    /**
     * 验证两个数据是否相同;
     * @param dataa 需要验证的数据1;
     * @param datab 需要验证的数据2;
     * @return 如果两个数据相同返回 true,否则返回false;
     */
    public static boolean validateSame(String dataa,String datab) {
        if (validateEmpty(dataa) && validateEmpty(datab)) {
            return dataa.equalsIgnoreCase(datab);
        }
        return false;
    }
}
