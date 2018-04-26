package ho.service;

import java.util.Map;

import ho.dto.MemberDTO;
import net.sf.json.JSONObject;

public interface LoginServiceInterface {

	public int login(MemberDTO dto);
	public String register(MemberDTO dto);
	public MemberDTO getUserInformation(MemberDTO dto);
	public MemberDTO jsonToString(String apiResult);
	
	
}
