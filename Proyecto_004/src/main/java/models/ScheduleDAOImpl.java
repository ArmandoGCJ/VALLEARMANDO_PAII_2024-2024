package models;


import models.Schedule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import interfaces.ScheduleDAO;

import java.util.List;

public class ScheduleDAOImpl implements ScheduleDAO {

    private final SessionFactory sessionFactory;

    public ScheduleDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSchedule(Schedule schedule) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(schedule);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(schedule);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSchedule(Schedule schedule) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(schedule);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Schedule getScheduleById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Schedule.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Schedule> getAllSchedules() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Schedule", Schedule.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
