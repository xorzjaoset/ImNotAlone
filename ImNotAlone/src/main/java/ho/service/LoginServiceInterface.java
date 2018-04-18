package ho.service;

import ho.dto.MemberDTO;

public interface LoginServiceInterface {

	public int login(MemberDTO dto);
	public String register(MemberDTO dto);
	public MemberDTO getUserInformation(MemberDTO dto);
	
	
}
