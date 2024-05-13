package interfaces;

import models.Professor;
import java.util.List;

public interface ProfessorDAO {
    void addProfessor(Professor professor);
    void updateProfessor(Professor professor);
    void deleteProfessor(Professor professor);
    Professor getProfessorById(int id);
    List<Professor> getAllProfessors();
}