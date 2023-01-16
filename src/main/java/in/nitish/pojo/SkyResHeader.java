package in.nitish.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="skyresheader")
public class SkyResHeader  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String svrId;
	private String reqRefNo;
	private String skyRefNo;
	private String procStatus;
	private String errCode;
	private String errMsgSys;
	private String errMsgUsr;
}
