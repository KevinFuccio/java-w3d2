package pack;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import connector.DBConnection;


public class Main {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			DBConnection db = new DBConnection();
//			Student s1 = new Student("Alfredo","Castelluccio","M",sdf.parse("2000-12-04"),3,8);
//			Student s3 = new Student("Bebo","Macis","M",sdf.parse("1992-04-12"),6,10);
//			db.createStudent(s3);
//			db.deleteStudent(db.studentFind(2));
			db.getVoteRange(3, 8);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
