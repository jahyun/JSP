package exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exam.dto.Member;

public class MemberDAO {
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
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jspuserc","jsp1234");
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
	}
	//회원삭제
	public void deleteMember(){
		System.out.println("회원삭제");
	}

}
