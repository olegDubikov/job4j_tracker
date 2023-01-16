package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0D;
        int count = 0;
        double averageScore = 0;
        for (Pupil pupil : pupils) {
            for (SubjectRec subjectRec : pupil.subjectRecs()) {
                count++;
                score += subjectRec.score();
                averageScore = score / count;
            }
        }
        return averageScore;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0D;
            int count = 0;
            for (SubjectRec subjectRec : pupil.subjectRecs()) {
                count++;
                score += subjectRec.score();
            }
            list.add(new Label(pupil.name(), score / count));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (SubjectRec subjectRec : pupil.subjectRecs()) {
                int temp = map.getOrDefault(subjectRec.name(), 0);
                map.put(subjectRec.name(), subjectRec.score() + temp);
            }
        }
        for (Map.Entry<String, Integer> mapEntry : map.entrySet()) {
            list.add(new Label(mapEntry.getKey(), (float) mapEntry.getValue() / pupils.size()));
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        int score = 0;
        for (Pupil pupil : pupils) {
            for (SubjectRec subjectRec : pupil.subjectRecs()) {
                score += subjectRec.score();

            }
            list.add(new Label(pupil.name(), score));
            score = 0;
            list.sort(Comparator.naturalOrder());
        }
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (SubjectRec subjectRec : pupil.subjectRecs()) {
                int temp = map.getOrDefault(subjectRec.name(), 0);
                map.put(subjectRec.name(), subjectRec.score() + temp);
            }
        }
        for (Map.Entry<String, Integer> mapEntry : map.entrySet()) {
            list.add(new Label(mapEntry.getKey(), mapEntry.getValue()));
            list.sort(Comparator.naturalOrder());
        }
        return list.get(list.size() - 1);
    }
}