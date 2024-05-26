import java.sql.*;
public class JDBCDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		insertRecord();
//		commitDemo();
		batchDemo();
		readRecord();
			}
	public static void readRecord() throws SQLException {
		String url ="Jdbc:mysql://localhost:3306/jdbcdemo";
		String userName ="root";
		String passWord="CheChu09@";
		String query ="select * from employee";
		
Connection con = DriverManager.getConnection( url, userName, passWord);
Statement st=con.createStatement();
ResultSet rs =st.executeQuery(query);

while(rs.next()) {

System.out.println("ID is "+ rs.getInt(1));
System.out.println("Name is "+ rs.getString(2));
System.out.println("Salary is "+ rs.getInt(3));
}

con.close();	

	}
	
public static void insertRecord() throws SQLException {
		String url ="Jdbc:mysql://localhost:3306/jdbcdemo";
		String userName ="root";
		String passWord="CheChu09@";
		String query ="insert into employee values(5,'vic',45000)";
		
Connection con = DriverManager.getConnection( url, userName, passWord);
Statement st=con.createStatement();
int row = st.executeUpdate(query);

System.out.println("The number of row inserted" + row );

con.close();	

	}


public static void insertVar() throws SQLException {
	String url ="Jdbc:mysql://localhost:3306/jdbcdemo";
	String userName ="root";
	String passWord="CheChu09@";
	
	int Id = 6;
	String name = "Anile";
	int salary = 25000;
	
	String query ="insert into employee values(" +Id + ",'" + name + "'," + salary +")";
	
Connection con = DriverManager.getConnection( url, userName, passWord);
Statement st=con.createStatement();
int row = st.executeUpdate(query);

System.out.println("The number of row inserted" + row );

con.close();	

}

public static void insertUsingPst() throws Exception {
	// TODO Auto-generated method stub


String url ="Jdbc:mysql://localhost:3306/jdbcdemo";
	String userName ="root";
	String passWord="CheChu09@";
	int id = 8;
	String name ="Nithi";
	Double salary = 95.56;
	String query ="insert into employee values(?,?,?)";
//System.out.println(query);
	
Connection con = DriverManager.getConnection( url, userName, passWord);
PreparedStatement pst = con.prepareStatement(query);
pst.setInt(1,id);
pst.setString(2,name);
pst.setDouble(3,salary);
int rows = pst.executeUpdate();
System.out.println("Number of rows inserted: "+rows);


con.close();	
}

public static void delete() throws Exception {
	// TODO Auto-generated method stub


String url ="Jdbc:mysql://localhost:3306/jdbcdemo";
	String userName ="root";
	String passWord="CheChu09@";
	int id = 8;
	
	String query ="Delete from employee where emp_id ="+id;
//System.out.println(query);
	
Connection con = DriverManager.getConnection( url, userName, passWord);
Statement st = con.createStatement();
int rows = st.executeUpdate(query);

System.out.println("Number of rows deleted: "+rows);


con.close();	
}

public static void update() throws Exception {
	// TODO Auto-generated method stub


String url ="Jdbc:mysql://localhost:3306/jdbcdemo";
	String userName ="root";
	String passWord="CheChu09@";
	int id = 8;
	
	String query ="update  employee set salary = 45000 where emp_id = 1 ";
//System.out.println(query);
	
Connection con = DriverManager.getConnection( url, userName, passWord);
Statement st = con.createStatement();
int rows = st.executeUpdate(query);

System.out.println("Number of rows updated: "+rows);


con.close();	
}
//calling simple stored procedure
public static void Sp() throws SQLException {
	String url ="Jdbc:mysql://localhost:3306/jdbcdemo";
	String userName ="root";
	String passWord="CheChu09@";

	
Connection con = DriverManager.getConnection( url, userName, passWord);
Statement st= con.createStatement();
ResultSet rs =st.executeQuery("{call GetEmp()}");

while(rs.next()) {

System.out.println("ID is "+ rs.getInt(1));
System.out.println("Name is "+ rs.getString(2));
System.out.println("Salary is "+ rs.getInt(3));
}

con.close();	

}

//calling simple stored procedure with input parameter

public static void Sp2() throws SQLException {
	String url ="Jdbc:mysql://localhost:3306/jdbcdemo";
	String userName ="root";
	String passWord="CheChu09@";
	int id = 4;

	
Connection con = DriverManager.getConnection( url, userName, passWord);
CallableStatement st= con.prepareCall("{call GetEmpId(?)}");
st.setInt(1, id);
ResultSet rs =st.executeQuery();

while(rs.next()) {

System.out.println("ID is "+ rs.getInt(1));
System.out.println("Name is "+ rs.getString(2));
System.out.println("Salary is "+ rs.getInt(3));
}

con.close();	

}

public static void Sp3() throws SQLException {
	String url ="Jdbc:mysql://localhost:3306/jdbcdemo";
	String userName ="root";
	String passWord="CheChu09@";
	int id = 1;

	
Connection con = DriverManager.getConnection( url, userName, passWord);
CallableStatement st= con.prepareCall("{call GetEmpById(?,?)}");
st.setInt(1, id);
st.registerOutParameter(2, Types.VARCHAR);
st.executeUpdate();
System.out.println(st.getString(2));


con.close();	

}
//commit and autocommit
public static void commitDemo()throws SQLException{
 String url = "jdbc:mysql://localhost:3306/jdbcdemo";
 String userName = "root";
 String passWord ="CheChu09@";
 String query1 ="update employee set salary = 75000 where emp_id =1";
 String query2 = "update employee set salary =39000 where emp_id = 3";
 
 
Connection con=	DriverManager.getConnection(url, userName, passWord);
Statement st = con.createStatement();
con.setAutoCommit(false);


int rows1 = st.executeUpdate(query1);
System.out.println("number of rows updated"+ rows1);
int rows2 = st.executeUpdate(query2);
System.out.println("Number of rows updated"+rows2);

if(rows1>0 && rows2>0) {
	con.commit();
}


con.close();
}

public static void batchDemo() throws SQLException{
	String url = "jdbc:mysql://localhost:3306/jdbcdemo";
	String userName = "root";
	String passWord ="CheChu09@";
	
	String query1 ="update employee set salary = 4200000 where emp_id = 1";
	String query2 ="update employee set salary = 4200000 where emp_id = 2";
	String query3="update employee set salary = 4200000 where emp_id = 3";
	String query4 ="update employee set salary = 4200000 where emp_id = 4";
	
	Connection con= DriverManager.getConnection(url, userName, passWord);
	Statement st = con.createStatement();
	con.setAutoCommit(false);
	st.addBatch(query1);
	st.addBatch(query2);
	st.addBatch(query3);
	st.addBatch(query4);
int[] res = st.executeBatch();

for(int i:res) {
//	System.out.println("Number of Rows updated "+i);
//	if(i>0) {
//		System.out.println("Number of Rows updated "+i);
//	}
	if(i>0) {
		
		continue;
	}else
		con.rollback();
}
con.commit();
con.close();

} 

}
