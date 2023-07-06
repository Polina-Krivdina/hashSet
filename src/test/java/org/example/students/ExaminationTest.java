package org.example.students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ExaminationTest {
    private Offset offset;
    @BeforeEach
    void setUp() {
        offset = new Examination();
    }

    @Test
    void putStudent() throws ItemNotFoundException {
        Score score = new Score("Ivanov", "math", 5);
        offset.putStudent(score);
        Score actual = offset.getStudent(score.name());

        Assertions.assertEquals(score, actual);
    }

    @Test
    void getStudent() throws ItemNotFoundException {
        Score score1 = new Score("Sasha", "math", 5);
        Map<String, Score>  zachet = new HashMap<>();
        zachet.put(score1.name(), score1);

        Score scoreActual = zachet.get(score1.name());
        Assertions.assertEquals(score1, scoreActual);
        Assertions.assertThrows(ItemNotFoundException.class, () -> offset.getStudent("2"));
    }

    @Test
    void getAverageScore() {
        Score score1 = new Score("Sasha", "math", 2);
        Score score2 = new Score("Sasha", "math", 3);
        Score score3 = new Score("Sasha", "math", 5);
        Score score4 = new Score("Sasha", "math", 2);
        Score score5 = new Score("Sasha", "math", 4);
        Score score6 = new Score("Sasha", "math", 2);

        List<Score> zachet = List.of(score1, score2, score3, score4, score5,score6);

        float averageMark = offset.getAverageScore(zachet);
        Assertions.assertEquals(3,averageMark);
    }

    @Test
    void getStudentsNotOnceTime() {
        Score score1 = new Score("Sasha", "math", 2);
        Score score2 = new Score("Masha", "math", 3);
        Score score3 = new Score("Kesha", "math", 5);
        Score score4 = new Score("Vadim", "math", 2);
        Score score5 = new Score("Ruslan", "math", 4);
        Score score6 = new Score("Polina", "math", 2);
        Score score7 = new Score("Sasha", "math", 2);

        List<Score> zachet = List.of(score1, score2, score3, score4, score5,score6, score7);
        offset.getStudentsNotOnceTime(zachet);


        Assertions.assertEquals("Sasha", score1.name());
    }

    @Test
    void getLastFiveExcelentStudents() {
        Score score1 = new Score("Sasha", "math", 5);
        Score score2 = new Score("Masha", "math", 3);
        Score score3 = new Score("Kesha", "math", 5);
        Score score4 = new Score("Vadim", "math", 2);
        Score score5 = new Score("Ruslan", "math", 5);
        Score score6 = new Score("Polina", "math", 5);
        Score score7 = new Score("Yura", "math", 5);

        List<Score> students = List.of(score1, score2, score3, score4, score5,score6, score7);
        List<String> excellentStudents = new ArrayList<>();
        List<String> exvellentStudents = offset.getLastFiveExcellentStudents(students);

        Assertions.assertEquals(List.of("Sasha", "Kesha", "Ruslan", "Polina","Yura"), exvellentStudents);

    }

    @Test
    void getAllSubjects() {
        Score score1 = new Score("Sasha", "math", 5);
        Score score2 = new Score("Masha", "math", 3);
        Score score3 = new Score("Kesha", "math", 5);
        Score score4 = new Score("Vadim", "math", 2);
        Score score5 = new Score("Ruslan", "math", 5);
        Score score6 = new Score("Polina", "math", 5);
        Score score7 = new Score("Yura", "math", 5);

        List<Score> students = List.of(score1, score2, score3, score4, score5,score6, score7);
        offset.getAllSubjects(students);
        Assertions.assertEquals(7, students.size());
    }
}