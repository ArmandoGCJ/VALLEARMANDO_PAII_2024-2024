package interfaces;

import models.Subject;
import java.util.List;

public interface SubjectDAO {
    void addSubject(Subject subject);
    void updateSubject(Subject subject);
    void deleteSubject(Subject subject);
    Subject getSubjectById(int id);
    List<Subject> getAllSubjects();
}