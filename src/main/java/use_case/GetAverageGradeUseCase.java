package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team team = gradeDB.getMyTeam();
        String[] members = team.getMembers();
        int gradeTotal = 0;
        for (int i = 0; i < members.length; i++) {
            gradeTotal += gradeDB.getGrade(members[i], course).getGrade();
        }
        return gradeTotal/members.length;
    }
}
