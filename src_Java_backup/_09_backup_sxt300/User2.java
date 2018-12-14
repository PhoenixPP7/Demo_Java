package _09_backup_sxt300;

/**
 * ����static�ؼ��ֵ��÷�
 * @author ���
 *
 */
public class User2 {
    int id; // id
    String name; // �˻���
    String pwd; // ����
    
    static String company = "������ѧ��"; // ��˾����
    
    
    public User2(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public void login() {
    	printCompany();
    	System.out.println(company); 
        System.out.println("��¼��" + name);
    }
    
    public static void printCompany() {
//         login();//���÷Ǿ�̬��Ա������ͻᱨ��
        System.out.println(company);
    }
    
    public static void main(String[] args) {
        User2 u = new User2(101, "��С��");
        User2.printCompany();
        User2.company = "��������үү";
        User2.printCompany();
    }
}