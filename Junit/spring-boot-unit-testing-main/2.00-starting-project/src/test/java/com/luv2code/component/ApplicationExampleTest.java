package com.luv2code.component;

import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.Student;
import com.luv2code.component.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class ApplicationExampleTest {

    private static int count = 0;

    @Value("${info.app.name}")
    private String appInfo;

    @Value("${info.app.description}")
    private String appDescription;


    @Value("${info.app.version}")
    private String appVersion;


    @Value("${info.app.name}")
    private String SchoolName;

    @Autowired
    CollegeStudent collegeStudent;

    @Autowired
    StudentGrades studentGrades;

    @Autowired
    ApplicationContext context;

    @BeforeEach
    public void beforeEach(){
        count = count +1;
        System.out.println("Testing : " + appInfo + "which is" + appDescription + " version: "+appVersion+"execution of test method "+ count);

        collegeStudent.setFirstname("Swathi");
        collegeStudent.setLastname("Kummara");
        collegeStudent.setEmailAddress("swathi70935@gmail.com");
        studentGrades.setMathGradeResults(new ArrayList<>(Arrays.asList(100.0,85.0,90.0,75.0)));
        collegeStudent.setStudentGrades(studentGrades);
    }
   @DisplayName("Add grade result for student grades")
    @Test
    public void addGradeResultsForStudentGrades(){
        assertEquals(350.0,studentGrades.addGradeResultsForSingleClass(collegeStudent.getStudentGrades().getMathGradeResults()));
   }


   @DisplayName("Add grade results for student grades not equal")
    @Test
    public void addGradeResultsFOrStudentGradesAssertNotEquals(){
        assertNotEquals(0,studentGrades.addGradeResultsForSingleClass(collegeStudent.getStudentGrades().getMathGradeResults()));
   }

   @DisplayName("Is grade Greater")
    @Test
    public void isGradeGreaterStudentGrades(){
        assertTrue(studentGrades.isGradeGreater(90,75),"failure should be true");
   }
   @DisplayName("is grade greater false")
    @Test
    public void isGradeGreaterStudentGradesAssertFalse(){
        assertFalse(studentGrades.isGradeGreater(89,92),"failure - should be false");
   }

   @DisplayName("Check null for student grades")
    @Test
    public void checkNullForStudentGrades(){
        assertNotNull(studentGrades.checkNull(studentGrades.checkNull(collegeStudent.getStudentGrades().getMathGradeResults())),"object should not be null");
   }

   @DisplayName("create student without grade inti")
    @Test
    public void createStudentWithoutGradesInit(){
        CollegeStudent studentTwo = context.getBean("collegeStudent",CollegeStudent.class);
        studentTwo.setFirstname("harika");
        studentTwo.setLastname("kummara");
        studentTwo.setEmailAddress("harika@gmail.com");
        assertNotNull(studentTwo.getFirstname());
        assertNotNull(studentTwo.getLastname());
        assertNotNull(studentTwo.getEmailAddress());
        assertNull(studentGrades.checkNull(studentTwo.getStudentGrades()));
   }

   @DisplayName("Verify students are prototypes")
    @Test
    public void verifyStudentAsproto(){
       CollegeStudent studentTwo = context.getBean("collegeStudent",CollegeStudent.class);
  assertNotSame(collegeStudent,studentTwo);
   }

   @DisplayName("Find Grade point average")
    @Test
    public void findGradePointAverage(){
        assertAll("Testing all assertEqulas",()->assertEquals(350.0,studentGrades.addGradeResultsForSingleClass(
                collegeStudent.getStudentGrades().getMathGradeResults()
        )),()->assertEquals(87.5,studentGrades.findGradePointAverage(
                collegeStudent.getStudentGrades().getMathGradeResults()
        )));
   }
}
