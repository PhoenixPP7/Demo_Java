package _09_backup_sxt300;

/**
 * ���Ծ�̬��ʼ�����ʹ��
 * @author ���
 *
 */
public class User3 {
    int id;        //id
    String name;   //�˻���
    String pwd;   //����
    static String company; //��˾����
    
    static {
        System.out.println("ִ����ĳ�ʼ������");
        company = "������ѧ��";
        printCompany();
    }  
    
    public static void printCompany(){
        System.out.println(company);
    }  
    public static void main(String[] args) {
        User3  u3 = null;
    }
}