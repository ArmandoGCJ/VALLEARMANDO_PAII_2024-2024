package interfaces;

import java.sql.Connection;
import java.sql.SQLException;

import javax.security.auth.Subject;

public interface IDAOSubject {
	
	public void create(Connection connection, Subject subject) throws SQLException;

	public Subject read(Connection connection, Subject subject, int id_subject) throws SQLException;

	public void update(Connection connection,  Subject subject, int id_subject)throws SQLException;

	public void delete(Connection connection, int id_subject)throws SQLException;
	
	public void createTable(Connection connection) throws SQLException;

	void create(Connection connection, model_package.Subject subject) throws SQLException;

	model_package.Subject read(Connection connection, model_package.Subject subject, int id_subject)
			throws SQLException;

	void update(Connection connection, model_package.Subject subject, int id_subject) throws SQLException;

}
