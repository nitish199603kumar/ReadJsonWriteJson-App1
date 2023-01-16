package in.nitish.entity;

import in.nitish.pojo.SkyResBody;
import in.nitish.pojo.SkyResHeader;
import in.nitish.pojo.SkyResHeader1;
import in.nitish.pojo.SkyResTrailer;
import lombok.Data;

//@Entity
@Data
//@Table(name="json_resp_store_db")
public class SkyResMessage {
	
//	@Id
//	private Integer id;
//	private String name;

	private SkyResHeader skyResHeader;
	private SkyResBody   skyResBody;
	private SkyResTrailer skyResTrailer;
	
}
