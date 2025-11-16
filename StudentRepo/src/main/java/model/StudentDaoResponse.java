package model;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.luv2code.cruddemo.entity.Address;
import com.luv2code.cruddemo.entity.EducationalDetails;
import com.luv2code.cruddemo.entity.FamilyDetails;
import com.luv2code.cruddemo.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.core.annotation.Order;

@Data
@ToString
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonPropertyOrder({"student", "address", "educationalDetails"}) ///provide the order for json response
public class StudentDaoResponse {

    private Address address;
    private Student student;
    private EducationalDetails educationalDetails;
    private FamilyDetails familyDetails;

}
