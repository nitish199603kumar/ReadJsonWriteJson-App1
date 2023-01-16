package in.nitish.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@Entity
@Table(name="skyresheader1")
@JsonInclude(Include.NON_NULL)
public class SkyResHeader1 {

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
