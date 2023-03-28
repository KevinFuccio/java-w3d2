package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import user.Student;

public class DBConnection {
	private String url = "jdbc:postgresql://localhost:5432/";
	private String dbName = "Students";
	private String username = "postgres";
	private String password = "123456";
	Statement st;

	public DBConnection() throws SQLException {
		Connection connect = DriverManager.getConnection(url + dbName, username, password);
		st = connect.createStatement();
		createTabStudents();
	}

	public void createTabStudents() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS Students(" + "student_id SERIAL PRIMARY KEY,"
				+ "name VARCHAR NOT NULL," + "last_name VARCHAR NOT NULL," + "gender VARCHAR NOT NULL,"
				+ "birthdate DATE NOT NULL," + "avg INT2 NOT NULL," + "min_vote INT2 NOT NULL,"
				+ "max_vote INT2 NOT NULL)";
		this.st.executeUpdate(sql);
	}

	public void createStudent(Student s) throws SQLException {
		String sql = "INSERT INTO Students(name,last_name,gender,birthdate,avg,min_vote,max_vote)" + "VALUES ('"
				+ s.getName() + "','" + s.getLastName() + "','" + s.getGender() + "','" + s.getBirthdate() + "','"
				+ s.getAvg() + "','" + s.getMinVote() + "','" + s.getMaxVote() + "')";
		this.st.executeUpdate(sql);
	}
	
	public void updateStudent(Student s) throws SQLException {
		String sql = "UPDATE Students " + "SET name='" + s.getName() + "', lastname='" + s.getLastName() + "', gender='"
				+ s.getGender() + "' " + "WHERE id_user = " + s.getId();
		this.st.executeUpdate(sql);
	}

	public Student studentFind(int id) throws SQLException {
		Student studente = null;
		String sql = "SELECT * FROM Students WHERE student_id = " + id;
		ResultSet rs = this.st.executeQuery(sql);
		if (rs.next()) {
			Long id_student = rs.getLong("student_id");
			String name = rs.getString("name");
			String lastName = rs.getString("last_name");
			String gender = rs.getString("gender");
			Date birthdate = rs.getDate("birthdate");
			Integer avg = rs.getInt("avg");
			Integer minVote = rs.getInt("min_vote");
			Integer maxVote = rs.getInt("max_vote");
			studente = new Student(id_student, name, lastName, gender, birthdate, avg, minVote, maxVote);
		}
		return studente;
	}
	public void getBest() throws SQLException {
		Student studente = null;
		String sql = "SELECT * FROM Students ORDER BY avg DESC LIMIT 1";
		ResultSet rs = this.st.executeQuery(sql);
		if (rs.next()) {
			Long id_student = rs.getLong("student_id");
			String name = rs.getString("name");
			String lastName = rs.getString("last_name");
			String gender = rs.getString("gender");
			Date birthdate = rs.getDate("birthdate");
			Integer avg = rs.getInt("avg");
			Integer minVote = rs.getInt("min_vote");
			Integer maxVote = rs.getInt("max_vote");
			studente = new Student(id_student, name, lastName, gender, birthdate, avg, minVote, maxVote);
		}
		System.out.println("studente con media piu alta: \n"+ studente.toString());
	}

	public void getVoteRange(int min, int max) throws SQLException {
		System.out.println("Elenco studenti con voti compresi tra " + min + " e " + max +":");
		String sql = "SELECT * FROM Students WHERE min_vote <= " + min + " AND max_vote <= " + max
				+ " ORDER BY avg DESC";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			Long id_student = rs.getLong("student_id");
			String name = rs.getString("name");
			String lastName = rs.getString("last_name");
			String gender = rs.getString("gender");
			Date birthdate = rs.getDate("birthdate");
			Integer avg = rs.getInt("avg");
			Integer minVote = rs.getInt("min_vote");
			Integer maxVote = rs.getInt("max_vote");
			Student studente = new Student(id_student, name, lastName, gender, birthdate, avg, minVote, maxVote);			
			System.out.println(studente.toString());
		}
		
	}

	public void deleteStudent(Student s) throws SQLException {
		String sql = "DELETE FROM Students WHERE student_id = " + s.getId();
		st.executeUpdate(sql);
	}
}
