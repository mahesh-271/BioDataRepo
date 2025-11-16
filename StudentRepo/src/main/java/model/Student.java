package model;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

@Data
@ToString
public class Student {

    private String name;
    private String college;

}
