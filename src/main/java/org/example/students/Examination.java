package org.example.students;

import java.util.*;

public class Examination implements Offset{
    private final Map <String, Score> zachet = new HashMap<>();
    @Override
    public void putStudent(Score score) {
        zachet.put(score.name(), score);
    }

    @Override
    public Score getStudent(String name) throws ItemNotFoundException {
        Score score = zachet.get(name);
        if(score == null){
            throw new ItemNotFoundException(name);
        }
        return score;

    }

    @Override
    public float getAverageScore(List<Score> students) {
        int sumScore = 0;
        for(int i = 0; i< students.size(); i++){
            sumScore = sumScore + students.get(i).score();
        }
        return sumScore/students.size();

    }

    @Override
    public String getStudentsNotOnceTime(List<Score> students) {
        String name = "";
        Set <Score>onceTime = new HashSet<>();
        for(Score score: students) {
            if(!onceTime.add(score)) {
                name = score.name();
            }
        }
        return name;
    }

    @Override
    public List<String> getLastFiveExcellentStudents(List<Score> students) {
        List<String> excellentStudents = new ArrayList<>();
        for(Score items: students){
            if(items.score()==5){
                excellentStudents.add(items.name());
            }
        }
        return excellentStudents;
    }

    @Override
    public void getAllSubjects(List<Score> students) {
        for (int i = 0; i< students.size(); i++) {
            System.out.println(students.get(i));
        }
    }
}
