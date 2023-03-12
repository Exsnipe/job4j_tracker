package collection.hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        int scoreAmount = 0;
        double scoreSum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreAmount++;
                scoreSum += subject.score();
            }
        }
        return scoreSum / scoreAmount;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            labels.add(averageScoreOfPupil(pupil));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectsMap = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (!subjectsMap.containsKey(subject.name())) {
                    subjectsMap.put(subject.name(), subject.score());
                } else {
                    int currentScore = subjectsMap.get(subject.name());
                    subjectsMap.put(subject.name(), currentScore + subject.score());
                }
            }
        }
        List<Label> result = new ArrayList<>();
        for (String subjectName : subjectsMap.keySet()) {
            result.add(new Label(subjectName,
                    (double) subjectsMap.get(subjectName) / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> resultList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int subjectAmount = 0;
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                subjectAmount++;
                score += subject.score();
            }
            resultList.add(new Label(pupil.name(), score));
        }
        Collections.sort(resultList);
        return resultList.get(resultList.size() - 1);

    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectsMap = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (!subjectsMap.containsKey(subject.name())) {
                    subjectsMap.put(subject.name(), subject.score());
                } else {
                    int currentScore = subjectsMap.get(subject.name());
                    subjectsMap.put(subject.name(), currentScore + subject.score());
                }
            }
        }
        List<Label> result = new ArrayList<>();
        for (String subjectName : subjectsMap.keySet()) {
            result.add(new Label(subjectName,
                    (double) subjectsMap.get(subjectName)));
        }
        Collections.sort(result);
        return result.get(result.size() - 1);
    }

    private static Label averageScoreOfPupil(Pupil pupil) {
        int subjectAmount = 0;
        double score = 0;
        for (Subject subject : pupil.subjects()) {
            subjectAmount++;
            score += subject.score();
        }
        return new Label(pupil.name(), score / subjectAmount);
    }

}
