package service;

public class MembershipServiceImpl implements MembershipService {

	@Override
	public boolean comparePW(String pw, String pwOk) {
		// TODO Auto-generated method stub
		return pw.contentEquals(pwOk);
	}
	
}
