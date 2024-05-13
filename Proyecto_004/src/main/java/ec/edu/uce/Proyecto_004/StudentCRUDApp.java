package ec.edu.uce.Proyecto_004;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import models.Student;
import models.StudentDAOImpl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import interfaces.StudentDAO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentCRUDApp extends JFrame {

    private final StudentDAO studentRepository;

    private final JTable studentTable;
    private final DefaultTableModel tableModel;
    private final JTextField idField, nameField, lastNameField, ageField;

    public StudentCRUDApp(StudentDAO studentRepository) {
        super("Student CRUD App");
        this.studentRepository = studentRepository;

        // Configuración de la ventana
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear campos de texto
        idField = new JTextField(5);
        nameField = new JTextField(20);
        lastNameField = new JTextField(20);
        ageField = new JTextField(5);

        // Crear tabla de estudiantes
        tableModel = new DefaultTableModel();
        studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);

        // Botones
        JButton addButton = new JButton("Agregar");
        JButton updateButton = new JButton("Actualizar");
        JButton deleteButton = new JButton("Eliminar");

        // Configurar diseño de la ventana
        setLayout(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(2, 4));
        formPanel.add(new JLabel("ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Apellido:"));
        formPanel.add(lastNameField);
        formPanel.add(new JLabel("Edad:"));
        formPanel.add(ageField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Cargar datos de la base de datos al iniciar la aplicación
        loadStudentData();

        // Agregar listeners a los botones
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });
    }

    private void loadStudentData() {
        List<Student> students = studentRepository.getAllStudents();

        tableModel.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Apellido", "Edad"});
        tableModel.setRowCount(0);

        for (Student student : students) {
            tableModel.addRow(new Object[]{student.getId(), student.getName(), student.getLastname(), student.getAge()});
        }
    }


    private void addStudent() {
        String name = nameField.getText();
        String lastName = lastNameField.getText();
        int age = Integer.parseInt(ageField.getText());

        Student student = new Student(age, name, lastName, age); // Corregido
        studentRepository.addStudent(student);

        loadStudentData();
    }

    private void updateStudent() {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String lastName = lastNameField.getText();
        int age = Integer.parseInt(ageField.getText());

        Student student = new Student(id, name, lastName, age);
        studentRepository.updateStudent(student);

        loadStudentData();
    }

    private void deleteStudent() {
        int id = Integer.parseInt(idField.getText());
        Student student = studentRepository.getStudentById(id);
        if (student != null) {
            studentRepository.deleteStudent(student);
            loadStudentData();
        } else {
            JOptionPane.showMessageDialog(this, "Estudiante no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        StudentDAO studentmodels = new StudentDAOImpl(sessionFactory); 
        StudentCRUDApp app = new StudentCRUDApp(studentmodels);
        app.setVisible(true);
    }
}
