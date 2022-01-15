package com.drive.GoogleDriveProject;

import com.drive.GoogleDriveProject.Course.service.Fizzsurvice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CourseApplicationTest {
    @Test
    void testFizz(){
        // check non-divisible numbers return themselves
        Fizzsurvice fizzsurvice=new Fizzsurvice();
        assertEquals("1",fizzsurvice.getFizz(1));
        // check numbers divisible by 3
        assertEquals("Fizz",fizzsurvice.getFizz(33));
        //check numbers divisible by 3 and 5
        assertEquals("FizzBuzz",fizzsurvice.getFizz(15));
        //check invalid inputs
        assertThrows(IllegalArgumentException.class,()->fizzsurvice.getFizz(0));

    }
}
