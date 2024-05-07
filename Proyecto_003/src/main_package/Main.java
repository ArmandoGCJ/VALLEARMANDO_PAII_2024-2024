package main_package;

import java.sql.SQLException;

import database.Conexion;
import model_package.Alumn;
import model_package.Professor;
import model_package.Schedule;
import model_package.Subject;

/** 
 *  @author Nelson Armando Valle García
 */

public class Main {

    public static void main(String[] args) throws SQLException {

        
        Alumn person1 = new Alumn(1, "Armando", "Valle", 23);
        Alumn person2 = new Alumn(2, "Leonardo", "Ramirez", 22);
        Alumn person3 = new Alumn(3, "Anthony", "cajamarca", 21);
        Alumn person4 = new Alumn(4, "Mariaelena", "Gonzales", 20);
       
         person1.createTable(Conexion.getConnection());
         person2.createTable(Conexion.getConnection());
         person3.createTable(Conexion.getConnection());
         person4.createTable(Conexion.getConnection());
         
        //Creamos un alumno en la db
        person1.create(Conexion.getConnection(), person1);
        person2.create(Conexion.getConnection(), person2);
        person3.create(Conexion.getConnection(), person3);
        person4.create(Conexion.getConnection(), person4);

        
        // Creamos un profesor
        Professor p1 = new Professor(0, "Rocio", "Garcia", 33);
        Professor p2 = new Professor(1, "Wladimir", "Carrillo", 32);
        Professor p3 = new Professor(2, "Byaron", "Torres",31 );
        Professor p4 = new Professor(3, "Marco", "Cedeño", 30);

        //Metodo para crear la tabla
         p1.createTable(Conexion.getConnection());
         p2.createTable(Conexion.getConnection());
         p3.createTable(Conexion.getConnection());
         p4.createTable(Conexion.getConnection());


        //Creamos un profesor en la db
        p1.create(Conexion.getConnection(), p1);
        p2.create(Conexion.getConnection(), p2);
        p3.create(Conexion.getConnection(), p3);
        p4.create(Conexion.getConnection(), p4);

        // Creamos una materia
        Subject subject = new Subject(1, "Historia", "Materia donde se ve el mundo sus exterior e interiror", 1);
        Subject subject2 = new Subject(2, "Ciencia Naturales", "Materia donde se ve la vida de los animales y plantas", 2);
        Subject subject3 = new Subject(3, "Fisica", "Materia donde se ve las propiedades de la energia , materia , espacio y tiempo ", 3);
        Subject subject4 = new Subject(4, "Ingles", "Materia donde se ve el verbo To Be ", 4);
        
 
        //Metodo para crear la tabla
         subject.createTable(Conexion.getConnection());
         subject2.createTable(Conexion.getConnection());
         subject3.createTable(Conexion.getConnection());
         subject4.createTable(Conexion.getConnection());
 

        //Creamos una materia en la db
        subject.create(Conexion.getConnection(), subject);
        subject2.create(Conexion.getConnection(), subject2);
        subject3.create(Conexion.getConnection(), subject3);
        subject4.create(Conexion.getConnection(), subject4);

        Schedule sche = new Schedule(subject.getId(), person1.getId(), p1.getId(), "7", "9", "Lunes");
        Schedule sche2 = new Schedule(subject2.getId(), person2.getId(), p2.getId(), "11", "1", "Martes");
        Schedule sche3 = new Schedule(subject3.getId(), person3.getId(), p3.getId(), "2", "4", "Miercoles");
        Schedule sche4 = new Schedule(subject4.getId(), person4.getId(), p4.getId(), "4", "6", "Jueves");
        
        
        
        
        sche.createTable(Conexion.getConnection());
        sche2.createTable(Conexion.getConnection());
        sche3.createTable(Conexion.getConnection());
        sche4.createTable(Conexion.getConnection());
        
        sche.create(Conexion.getConnection(), sche);
        sche2.create(Conexion.getConnection(), sche2);
        sche3.create(Conexion.getConnection(), sche3);
        sche4.create(Conexion.getConnection(), sche4);

    }

}