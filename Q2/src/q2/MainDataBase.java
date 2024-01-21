package q2;

public class MainDataBase {

	public static void main(String[] args) {

		try {
			ManageDataBase d1 = new ManageDataBase("jdbc:mysql://localhost:3306/GL", "root", "5424");

			// insert 5 Records
			d1.add();


			//Modify Email_Id column to varchar(30) NOT NULL.
			d1.alter();


			// Insert 2 records and check
			d1.add();
			d1.display();


			// Update the name of employee Id 3 to Karthik and phone number to 1234567890.
			d1.update();


			// Delete employee records 3 and 4.
			d1.deleteOne();


			// Remove all records from the table employee.
			d1.deleteAll();


			d1.disconnect();

		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}






	}

}
