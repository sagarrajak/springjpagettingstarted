package com.example.response;

import com.example.entity.Student;
import lombok.*;

//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private long id;

    private String firstName;

    private String lastName;

    private String email;

    public  StudentResponse(Student student) {
        email = student.getEmail();
        firstName = student.getFirstName();
        lastName = student.getLastName();
        id = student.getId();
    }
}
