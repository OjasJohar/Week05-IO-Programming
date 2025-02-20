package com.bridgelabz.practice_problem_1.create_json_object;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testStudentGettersAndSetters() {
        List<String> subjects = Arrays.asList("Math", "Science", "English");
        Student student = new Student("John Doe", 20, subjects);

        // Verify initial values
        assertEquals("John Doe", student.getName());
        assertEquals(20, student.getAge());
        assertEquals(subjects, student.getSubjects());

        // Modify values
        student.setName("Jane Doe");
        student.setAge(22);
        student.setSubjects(Arrays.asList("History", "Physics"));

        // Verify updated values
        assertEquals("Jane Doe", student.getName());
        assertEquals(22, student.getAge());
        assertEquals(Arrays.asList("History", "Physics"), student.getSubjects());
    }
}
