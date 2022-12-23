package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Allview;

public class SCRDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public static Connection getConnection () throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager
				.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "sys1234");
		return con;
	}
	
	public String ViewAll(HttpServletResponse response, HttpServletRequest request) {
		ArrayList<Allview> list = new ArrayList<Allview>();
		try {
			conn = getConnection();
			String sql = " select a.stid,b.stname,case when substr(resident,8,1) = '3' then '남' else '여' end, c.subject, decode(class,'01','전공필수','02','전공선택','03','교양필수','04','교양선택') as major, c.professor ,mid, final,attend, report,etc, round((mid*0.3)+(final*0.3)+(attend*0.2)+(report*0.1)+(etc*0.1),1) as score , case when round((mid*0.3)+(final*0.3)+(attend*0.2)+(report*0.1)+(etc*0.1),1) >= 90 then 'A' when round((mid*0.3)+(final*0.3)+(attend*0.2)+(report*0.1)+(etc*0.1),1) >= 80 then 'B' when round((mid*0.3)+(final*0.3)+(attend*0.2)+(report*0.1)+(etc*0.1),1) >= 70 then 'C' when round((mid*0.3)+(final*0.3)+(attend*0.2)+(report*0.1)+(etc*0.1),1) >= 60 then 'D' else 'F' end as grade from TABLE_RESULT_03 A inner join TABLE_STD_01 B on a.stid = b.stid inner join TABLE_SUBJECT_02 C on a.dtcode = c.subjectcode order by c.subject, a.stid   ";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {	
				Allview av = new Allview();
				av.setId(rs.getString(1));
				av.setName(rs.getString(2));
				av.setSex(rs.getString(3));
				av.setSubject(rs.getString(4));
				av.setMajor(rs.getString(5));
				av.setProfessor(rs.getString(6));
				av.setMid(rs.getString(7));
				av.setfScore(rs.getString(8));
				av.setAttend(rs.getString(9));
				av.setReport(rs.getString(10));
				av.setEtc(rs.getString(11));
				av.setScore(rs.getString(12));
				av.setGrade(rs.getString(13));
				list.add(av);
			}				
				request.setAttribute("alllist", list);
				conn.close();
				ps.close();
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "viewAll.jsp";
	}
	
	public int ScoreInsert(HttpServletResponse response, HttpServletRequest request) {
		
		String stid = request.getParameter("stid");
		String scode = request.getParameter("scode");
		int mid = Integer.parseInt(request.getParameter("mid"));
		int fin = Integer.parseInt(request.getParameter("fin"));
		int att = Integer.parseInt(request.getParameter("att"));
		int rep = Integer.parseInt(request.getParameter("rep"));
		int etc = Integer.parseInt(request.getParameter("etc"));
		
		int result = 0;
		
		try {
			conn = getConnection();
			
			String sql = "insert into TABLE_RESULT_03 values (?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, stid);
			ps.setString(2, scode);
			ps.setInt(3, mid);
			ps.setInt(4, fin);
			ps.setInt(5, att);
			ps.setInt(6, rep);
			ps.setInt(7, etc);
			
			result = ps.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String 
}
