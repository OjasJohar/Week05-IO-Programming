package com.bridgelabz.advanced_problems.convert_csv_to_object;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CSVToStudentListTest {

    private static final String TEST_FILE_PATH = "src/test/resources/test_students.csv";

    @BeforeEach
    public void setUp() throws IOException {
        File file = new File(TEST_FILE_PATH);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("id,name,age,marks\n");
                writer.write("1,John Doe,20,85.5\n");
                writer.write("2,Jane Smith,22,90.0\n");
                writer.write("3,Emily Johnson,19,78.2\n");
            }
        }
    }

    @Test
    public void testReadCSV() {
        List<Student> students = CSVToStudentList.readCSV(TEST_FILE_PATH);

        assertNotNull(students);
        assertFalse(students.isEmpty());

        assertEquals(3, students.size());

        Student student = students.get(0);
        assertEquals(1, student.getId());
        assertEquals("John Doe", student.getName());
        assertEquals(20, student.getAge());
        assertEquals(85.5, student.getMarks());
    }

    @AfterEach
    public void tearDown() {
        File file = new File(TEST_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }
}
