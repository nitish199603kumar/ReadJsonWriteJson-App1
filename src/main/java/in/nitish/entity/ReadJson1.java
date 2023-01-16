package in.nitish.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import in.nitish.pojo.Address1;
import lombok.Data;

@Data
@Entity
@Table(name="read_json1")
@JsonInclude(Include.NON_NULL)
public class ReadJson1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Address1 address;

}
