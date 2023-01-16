package in.nitish.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import in.nitish.entity.ReadJson;
import in.nitish.entity.ReadJson1;
import in.nitish.entity.SkyResMessage;
import in.nitish.pojo.SkyResBody;
import in.nitish.pojo.SkyResHeader;
import in.nitish.pojo.TrainBtwnStnsList;
import in.nitish.repoitory.ReadJson1Repo;
import in.nitish.repoitory.ReadJsonRepo;
import in.nitish.repoitory.SkyResHeaderRepo;
import in.nitish.repoitory.TrainBtwnStnsListRepo;
//import in.nitish.repoitory.TrainBtwnStnsListRepo;
import in.nitish.service.ReadJsonService;

@Service
public class ReadJsonServiceImpl implements ReadJsonService {
	
	private static final Logger logger=LoggerFactory.getLogger(ReadJsonServiceImpl.class);
	
	@Autowired
	private ReadJsonRepo readJsonRepo;
	
	@Autowired
	private ReadJson1Repo readJson1Repo;
	
	@Autowired
	private SkyResHeaderRepo skyResHeaderRepo;
	
	@Autowired
	private TrainBtwnStnsListRepo trainBtwnStnsListRepo;
	
	@Override
	public ReadJson readJson() {
		ObjectMapper objectMapper=new ObjectMapper();
		ReadJson readJson=null;
		try {
			JsonNode readTree = objectMapper.readTree(new File(".//readjson.json"));
			readJson=objectMapper.readValue(readTree.toString(), ReadJson.class);
			String name = readTree.get("name").asText();
			System.out.println(name);
			readJsonRepo.save(readJson);	
	
		} catch (IOException e) {
			logger.info("File not Found !!");
			e.printStackTrace();
		}
		
		
		return readJson;
	}


	@Override
	public ReadJson1 readJson1() {
		ObjectMapper objectMapper=new ObjectMapper();
		ReadJson1 readJson1=null;
		try {
			
			JsonNode readTree = objectMapper.readTree(new File(".//readjson1.json"));
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			System.out.println("(ReadJson1) JsonNode --->" +readTree);
			
			readJson1=objectMapper.readValue(readTree.toString(), ReadJson1.class);
			/*
			String name = readTree.get("name").asText();
			System.out.println(name);
			
			JsonNode jsonAddress1 = (JsonNode)readTree.get("address");
			String phone = jsonAddress1.get("phone").asText();
			System.out.println(phone);
			
			JsonNode skyResHeader =(JsonNode) jsonAddress1.get("skyResHeader");
			String reqRefNo = skyResHeader.get("reqRefNo").asText();
			System.out.println("ReqRefNo--->" +reqRefNo);
			String errMsgSys = skyResHeader.get("errMsgSys").asText();
			
			System.out.println("errMsgSys--->" +errMsgSys);

			JsonNode booking_details = readTree.get("booking_details");
			System.out.println("Booking_Details ---> "+booking_details);
			String booking_detailsString = readTree.get("booking_details").asText();
			System.out.println("Booking_Details Converted into String --> " +booking_detailsString);
			String train_No = objectMapper.readTree(booking_detailsString).get("trainNo").asText();			
//			String trainNo = booking_details.get("trainNo").asText();
			System.out.println("train No---> " +train_No);
			
			*/
			
			
			
			
//			readJson1=new ReadJson1();
//			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
////			readJson1=objectMapper.readValue(readTree.toString(), ReadJson1.class);
//			String name = readTree.get("name").asText();
//			System.out.println(name);
//			readJson1.setName(name);
//			
//			Address1 address1=new Address1();
//			JsonNode jsonAddress1 = (JsonNode)readTree.get("Address1");
//			String phone = jsonAddress1.get("phone").asText();
//			System.out.println(phone);
//			address1.setPhone(phone);
//			readJson1.setAddress1(address1);
//			System.out.println("nitish");
//			
//			
//			
//			readJson1=objectMapper.readValue(readTree.toString(), ReadJson1.class);
//			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		readJson1Repo.save(readJson1);
		return readJson1;
	}


	@Override
	public SkyResMessage readJson2() {
		ObjectMapper objectMapper=new ObjectMapper();
		SkyResMessage skyResMessage=null;
		
		try {
			JsonNode readTree = objectMapper.readTree(new File("F:\\OLD DESKTOP DATA\\SPRING BOOT PRACTICAL\\15-ReadJsonWriteJson-App1\\data\\readjson2.json"));
			System.out.println("readTree ->" +readTree);
			
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			skyResMessage=objectMapper.readValue(readTree.toString(),SkyResMessage.class);
			
			SkyResHeader skyResHeader_obj=new SkyResHeader();
			JsonNode skyResHeader = readTree.get("skyResHeader");
			
			skyResHeader_obj.setSvrId(skyResHeader.get("svrId").asText());
			skyResHeader_obj.setReqRefNo(skyResHeader.get("reqRefNo").asText());
			skyResHeader_obj.setSkyRefNo(skyResHeader.get("skyRefNo").asText());
			skyResHeader_obj.setProcStatus(skyResHeader.get("procStatus").asText());
			skyResHeader_obj.setErrCode(skyResHeader.get("errCode").asText());
			skyResHeader_obj.setErrMsgSys(skyResHeader.get("errMsgSys").asText());
			skyResHeader_obj.setErrMsgUsr(skyResHeader.get("errMsgUsr").asText());
			
			skyResHeaderRepo.save(skyResHeader_obj);
			String reqRefNo = skyResHeader.get("reqRefNo").asText();
			System.out.println("reqRefNo---> " +reqRefNo);
			
			SkyResBody skyResBody_obj=new SkyResBody();
			
			JsonNode skyResBody = readTree.get("skyResBody");
			String errorcode = skyResBody.get("errorcode").asText();
			logger.info("errorcode--->{}",errorcode);
			
			JsonNode partnerResponse = skyResBody.get("partnerResponse");
			String alternateEnquiryFlag = partnerResponse.get("alternateEnquiryFlag").asText();
			logger.info("alternateEnquiryFlag---> {}",alternateEnquiryFlag);
			
			 ArrayNode trainBtwnStnsList = (ArrayNode) partnerResponse.get("trainBtwnStnsList");
			 for(int i=0;i<trainBtwnStnsList.size();i++)
			 {
				 JsonNode trainBtwnStnsList_objet = trainBtwnStnsList.get(i);
				 TrainBtwnStnsList trainBtwnStnsListObj=new TrainBtwnStnsList();
				 
				 trainBtwnStnsListObj.setArrivalTime(trainBtwnStnsList_objet.get("arrivalTime").asText());
				 trainBtwnStnsListObj.setAtasOpted(trainBtwnStnsList_objet.get("atasOpted").asText());
				 trainBtwnStnsListObj.setDepartureTime(trainBtwnStnsList_objet.get("departureTime").asText());
				 trainBtwnStnsListObj.setDistance(trainBtwnStnsList_objet.get("distance").asText());
				 trainBtwnStnsListObj.setDuration(trainBtwnStnsList_objet.get("duration").asText());
				 trainBtwnStnsListObj.setFlexiFlag(trainBtwnStnsList_objet.get("duration").asText());
				 trainBtwnStnsListObj.setFromStnCode(trainBtwnStnsList_objet.get("fromStnCode").asText());
				 trainBtwnStnsListObj.setRunningFri(trainBtwnStnsList_objet.get("runningFri").asText());
				 trainBtwnStnsListObj.setRunningMon(trainBtwnStnsList_objet.get("runningMon").asText());
				 trainBtwnStnsListObj.setRunningSat(trainBtwnStnsList_objet.get("runningSat").asText());
				 trainBtwnStnsListObj.setRunningSun(trainBtwnStnsList_objet.get("runningSun").asText());
				 trainBtwnStnsListObj.setRunningThu(trainBtwnStnsList_objet.get("runningThu").asText());
				 trainBtwnStnsListObj.setRunningTue(trainBtwnStnsList_objet.get("runningTue").asText());
				 trainBtwnStnsListObj.setRunningWed(trainBtwnStnsList_objet.get("runningWed").asText());
				 trainBtwnStnsListObj.setToStnCode(trainBtwnStnsList_objet.get("toStnCode").asText());
				 trainBtwnStnsListObj.setTrainName(trainBtwnStnsList_objet.get("trainName").asText());
				 trainBtwnStnsListObj.setTrainNumber(trainBtwnStnsList_objet.get("trainNumber").asText());
				 trainBtwnStnsListObj.setTrainOwner(trainBtwnStnsList_objet.get("trainOwner").asText());
				 trainBtwnStnsListObj.setTrainType(trainBtwnStnsList_objet.get("trainType").asText());
				 trainBtwnStnsListObj.setTrainsiteId(trainBtwnStnsList_objet.get("trainsiteId").asText());
				 
				 List<String> avlClassesList=new ArrayList<String>();
				 ArrayNode avlClasses = (ArrayNode) trainBtwnStnsList_objet.get("avlClasses");
				 for(int j=0;j<avlClasses.size();j++) {
					 String avlClassesData = avlClasses.get(j).asText();
					 avlClassesList.add(avlClassesData);
					 
				 }
				 
				 trainBtwnStnsListObj.setAvlClasses(avlClassesList);
				 logger.info("TrainBtwnStnsListObj {}",trainBtwnStnsListObj);
				 trainBtwnStnsListRepo.save(trainBtwnStnsListObj);
			 }	
			
					
		} catch (IOException e) {
			System.out.println("File Not Found !!");
			e.printStackTrace();
		}
		
		return skyResMessage;
	}

}
