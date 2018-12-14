package _00_Java.AJAX;

public class ServiceFactory {
	public static IMemberService getIMemberServiceInstance() {
		return new MemberServiceImpl();
	}
}
