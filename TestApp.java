import java.sql.*;
import javax.sql.*;


class TestApp{

	public static void main(String[] args){

		Connection connection=null;
		Statement statement =null;
		ResultSet resultSet=null;


			try{
					//First Step
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("Driver loaded Succcesfully.....!");

					//Second steps
					String url="jdbc:mysql://localhost:3306/INEURON";
					String userName="root";
					String passWord="Mysql2023";
					connection=DriverManager.getConnection(url,userName,passWord);

					System.out.println("The connection established Succcesfully.....");
					System.out.println("The impemented class is :: "+ connection.getClass().getName());

					//Third step create Statement object

					String sqlQuery= "Select id,firstName,middleName,lastName,salary From Employee";
					statement=connection.createStatement();
					System.out.println("The impemented class is :: "+ statement.getClass().getName());

					resultSet=statement.executeQuery(sqlQuery);
					System.out.println("The impemented class is :: "+ resultSet.getClass().getName());

					//Forth step Process the resultSet
					System.out.println("");

					while(resultSet.next()){

						Integer id=resultSet.getInt(1);
						String firtName=resultSet.getString(2);
						String middleName=resultSet.getString(3);
						String lastName=resultSet.getString(4);
						Integer salary=resultSet.getInt(5);

						System.out.println(id+"\t"+firtName+"\t"+middleName+"\t"+lastName+"\t"+salary);


					}




			}catch( ClassNotFoundException ce){

				ce.printStackTrace();


			}catch(SQLException se){

				se.printStackTrace();
			}catch(Exception e){

				e.printStackTrace();
			}finally{

				if(connection!=null)
				{

				try{

					connection.close();
					System.out.println("Connection closed Succcesfully.....");
				}catch(SQLException se){

					se.printStackTrace();


				}
			}

		}
		
	}
	
}