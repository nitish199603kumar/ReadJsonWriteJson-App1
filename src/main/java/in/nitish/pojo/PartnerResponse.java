package in.nitish.pojo;


import java.util.List;

import lombok.Data;

@Data
public class PartnerResponse {
	
  
  private String alternateEnquiryFlag;
  private String oneStopJourny;
  private List<String> quotaList;
  private String serverId;
  private String serveyFlag;
  private String timeStamp;
  private List<TrainBtwnStnsList> trainBtwnStnsList;
  private String vikalpInSpecialTrainsAccomFlag;
  
}
