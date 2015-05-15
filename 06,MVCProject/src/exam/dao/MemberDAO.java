package exam.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import exam.dto.Member;

public class MemberDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//생성자
	public MemberDAO(){
		System.out.println("생성자");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //ojdbc6.jar 클래스 추가
	    
	    //2.데이터 베이스와 연결
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jspuserc","jsp1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//서버연결주소,아이디,비밀번호 설정해줘야함
	    //getconnection 메소드는 connection타입 return , 기본제공 객체라 new안해도됨    
	}
	
	//회원가입
	public void insertMember(Member member){
		System.out.println("회원가입");
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, default)";
		
		String id = member.getId();
		String pwd = member.getPwd();
		String name = member.getName();
		int age = member.getAge();
		String gender = member.getGender();
		String addr = member.getAddr();
		Date date = member.getRegDate();
	try{	
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		pstmt.setString(3, name);
		pstmt.setInt(4, age);
		pstmt.setString(5, gender);
		pstmt.setString(6, addr);
		
		
		pstmt.executeUpdate();
	}catch(SQLException e){
		e.printStackTrace();
	}
	
	}
	
	//DTO 미사용
	public int loginMember(String id, String pwd){
		String sql = "select * from member where id=? and password=?";
		int result = 0;
		try{	
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
		
	
			if(rs.next()){
				result =1;
			}else{
				result=0;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
		
	}	
	//DTO 미사용
		public void loginMember(Member member){
			String sql = "select * from member where id=? and password=?";
			
			
		}	
	public List<Member> listMember(){
		String sql = "Select * from member order by id desc";
		List<Member> list = new ArrayList<Member>();
		
		try{
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Member m = new Member();
				m.setId(rs.getString("id"));
				m.setName(rs.getString("name"));
				m.setAge(rs.getInt("age"));
				m.setGender(rs.getString("gender"));
				m.setAddr(rs.getString("addr"));
				
				list.add(m);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	public void detailMember(){
		
	}
	public void deleteMember(){
		System.out.println("회원삭제");
		
	}

}
