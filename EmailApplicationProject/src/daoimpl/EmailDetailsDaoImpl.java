package daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import config.MyConnection;

import dao.EmailDetailsDao;
import model.EmailDetails;




public class EmailDetailsDaoImpl implements EmailDetailsDao{
	Connection con;
	Statement statement;
	
	public EmailDetailsDaoImpl() throws SQLException
	{
		con=MyConnection.getConnection();
		statement=con.createStatement();
	}
	
	
	
	
	
	@Override
	public boolean compose(EmailDetails details) {
		// TODO Auto-generated method stub
		int res=0;
		try {
			res = statement.executeUpdate("insert into emaildetails3 values('"+details.getEmailid()+"','"+details.getTo()+"','"+details.getFrom()+"','"+details.getSubject()+"','"+details.getEmailbody()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("cannot insert"+e.getMessage());
			
		}
		if(res==1)
		{
		return  true;
		}else
		return false;
		}
		
		
		
	

	@Override
	public ArrayList<EmailDetails> inbox(String username1) {
		// TODO Auto-generated method stub
		
		try
		{
			
		
		ResultSet rs=statement.executeQuery("select *From emaildetails3 where email_to='"+username1+"' ");
		ArrayList<EmailDetails> list=new ArrayList<>();
		while(rs.next())
		{
		
			EmailDetails dt= new EmailDetails();
		
		dt.setEmailid(rs.getString("email_Id"));
		dt.setTo(rs.getString("email_to"));
		dt.setFrom(rs.getString("email_From"));
		dt.setSubject(rs.getString("email_subject"));
		dt.setEmailbody(rs.getString("email_emailbody"));
		list.add(dt);
		
		}
		
		return list;
		}catch (SQLException e)
		{
			System.out.println(e.getMessage());
		return null;
		}
		
		
		
	}

	

	

}
		
		
		
	

	

	


