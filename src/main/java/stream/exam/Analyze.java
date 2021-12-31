package stream.exam;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(st -> st.getSubject()
                        .stream())
                        .mapToInt(sb -> sb.getScore())
                        .average()
                        .orElse(-1);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(
                        pupil.getName(),
                        pupil.getSubject().stream()
                                .mapToInt(Subject::getScore)
                                .average().
                                orElse(-1)))
                .collect(Collectors.toList());

    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
         return stream
                    .flatMap(p -> p.getSubject().
                        stream())
                            .collect(Collectors.toList())
                        .stream()
                            .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new,
                                    Collectors.averagingDouble(Subject::getScore)))
                        .entrySet()
                        .stream()
                            .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                            .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                    .map(pupil -> new Tuple(
                        pupil.getName(),
                        pupil.getSubject().stream()
                            .mapToInt(Subject::getScore)
                            .sum()
                ))
                    .max(Tuple::compareTo).orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                    .flatMap(pupil -> pupil.getSubject().stream())
                    .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                    .entrySet()
                    .stream()
                    .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                    .max(Tuple::compareTo).orElse(null);
    }
}
