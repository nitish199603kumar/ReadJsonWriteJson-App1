package in.nitish.pojo;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="trainbtwnstnslist")
public class TrainBtwnStnsList {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String arrivalTime;
	private String atasOpted;
//	private String[] avlClasses;
	@Embedded
	private List<String> avlClasses;
	private String departureTime;
	private String distance;
	private String duration;
	private String flexiFlag;
	private String fromStnCode;
	private String runningFri;
	private String runningMon;
	private String runningSat;
	private String runningSun;
	private String runningThu;
	private String runningTue;
	private String runningWed;
	private String toStnCode;
	private String trainName;
	private String trainNumber;
	private String trainOwner;
	private String trainType;
	private String trainsiteId;

}
