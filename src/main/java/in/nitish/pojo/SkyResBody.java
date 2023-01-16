package in.nitish.pojo;

import lombok.Data;

@Data
public class SkyResBody {

	private String errorcode;
	private String errorDesc ;
	private PartnerResponse partnerResponse;
	private String message;
	private String status;
	
}
