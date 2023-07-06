package org.example.students;

import java.util.List;

public interface Offset {
    void putStudent(Score score);
    Score getStudent(String name) throws ItemNotFoundException;
    float getAverageScore(List<Score> students);
    String getStudentsNotOnceTime(List<Score> students);
    List<String> getLastFiveExcellentStudents(List<Score> students);
    void getAllSubjects(List<Score> students);



}
