package interfaces;

import models.Schedule;
import java.util.List;

public interface ScheduleDAO {
    void addSchedule(Schedule schedule);
    void updateSchedule(Schedule schedule);
    void deleteSchedule(Schedule schedule);
    Schedule getScheduleById(int id);
    List<Schedule> getAllSchedules();
}