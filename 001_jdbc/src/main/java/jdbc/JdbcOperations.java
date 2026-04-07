package jdbc;
import java.sql.*;
public class JdbcOperations {

	public static void main(String[] args) throws Exception{
//System.out.println("Hello World!");
		String URL="jdbc:mysql://localhost:3306/fsad";
		String userName="root";
		String dbPassword="#Sivakrishna1";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(URL,userName,dbPassword);
		//String qry = "INSERT INTO STUDENTS VALUES(?,?,?)";
		//PreparedStatement ps = con.prepareStatement(qry);
		//ps.setInt(1, 1001);
		//ps.setString(2, "John");
		//ps.setString(3, "CSE");
		String qry="UPDATE STUDENTS SET NAME=?,DEPT=? WHERE ROLLNO=?";
		PreparedStatement ps=con.prepareStatement(qry);
		ps.setString(1, "SIVAKRISHNA B");
		ps.setString(2, "CLOUD ");
		ps.setInt(3, 1001);
		//DELETE operation
		//String qry="DELETE FROM STUDENTS WHERE ROLLNO=?";
		//PreparedStatement ps=con.prepareStatement(qry);
		//ps.setInt(1, 1002);
        
		ps.execute();
		System.out.println("Done");
		
		//READ OPEARATION
		//String qry="SELECT * FROM STUDENTS";
		//PreparedStatement ps=con.prepareStatement(qry);
		//ResultSet rs=ps.executeQuery();
		//while(rs.next())
		//{
		//System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)); 	
		//}
	}

}
