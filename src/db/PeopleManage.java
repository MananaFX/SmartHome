package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import runPart.Properties;


/*
 * 
 *驱动类
 */
public class PeopleManage {
	
	/****
	 * 
	 * 管理员查询所有用户
	 */
	public static void SelcetAllUser() {
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			try {
				conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username, Properties.password);
				String sql = "SELECT * FROM User";
				stat = conn.createStatement();
				rs=stat.executeQuery(sql);
				//遍历结果集
			while(rs.next()) {
				String userAccount = rs.getString("Account");
				String password = rs.getString("Password");
				String canAdd = rs.getString("CanAdd");
				String canDelete = rs.getString("CanDelete");
				String canControl = rs.getString("CanControl");
				String staffNo = rs.getString("StaffNo");
				User user = new User(userAccount, password,
					Boolean.parseBoolean(canAdd), Boolean.parseBoolean(canDelete),
					Boolean.parseBoolean(canControl),staffNo);
				System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stat.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void SelcetAllUserView() {
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			try {
				conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username, Properties.password);
				String sql = "SELECT * FROM UserView";
				stat = conn.createStatement();
				rs=stat.executeQuery(sql);
				//遍历结果集
			while(rs.next()) {
				String userAccount = rs.getString("Account");
				String canAdd = rs.getString("CanAdd");
				String canDelete = rs.getString("CanDelete");
				String canControl = rs.getString("CanControl");
				String staffNo = rs.getString("StaffNo");
				User user = new User(userAccount,
					Boolean.parseBoolean(canAdd), Boolean.parseBoolean(canDelete),
					Boolean.parseBoolean(canControl),staffNo);
				System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stat.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void SelcetAllSecurity() {
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			try {
				conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username, Properties.password);
				String sql = "SELECT * FROM security";
				stat = conn.createStatement();
				rs=stat.executeQuery(sql);
				//遍历结果集
			while(rs.next()) {
				String staffno = rs.getString("staffno");
				String fingprintNo = rs.getString("FingprintNo");
				String irisNo = rs.getString("IrisNo");
				String accountNum = rs.getString("AccountNum");
				String isHome = rs.getString("isHome");
				String inOutNum = rs.getString("InOutNum");
				Security security = new Security(staffno, Integer.parseInt(fingprintNo), Integer.parseInt(irisNo),
						Integer.parseInt(accountNum), Boolean.parseBoolean(isHome),Integer.parseInt(inOutNum));
				System.out.println(security);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stat.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void SelcetAllSecurityView() {
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			try {
				conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username, Properties.password);
				String sql = "SELECT * FROM securityview";
				stat = conn.createStatement();
				rs=stat.executeQuery(sql);
				//遍历结果集
			while(rs.next()) {
				String staffno = rs.getString("staffno");
				String accountNum = rs.getString("AccountNum");
				String isHome = rs.getString("isHome");
				String inOutNum = rs.getString("InOutNum");
				Security security = new Security(staffno,Integer.parseInt(accountNum),
						Boolean.parseBoolean(isHome),Integer.parseInt(inOutNum));
				System.out.println(security);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stat.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 是否存在该用户
	 * @param user
	 * @param password
	 * @return
	 */
	public static boolean isExist_User(String user,String password) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from User";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                System.out.println("用户名"+"\t"+"密码");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.println();
                    if(rs.getString(1).equals(user) && rs.getString(2).equals(password)) {
                    	System.out.println("find it");
                        rs.close();
                        stmt.close();
                        conn.close();
                    	return true;
                    }
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }
	
	public static boolean isExist_User(String user) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from UserView";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                System.out.println("用户名"+"\t");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.println();
                    if(rs.getString(1).equals(user)){
                        rs.close();
                        stmt.close();
                        conn.close();
                    	return true;
                    }
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }

	
	public static String[] select_UserAuthority(String user) {
		String[] falBoolean = new String[3];
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from userview where Account = '"+
            user +"';";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            String[] Authority = new String[3];
            rs.next();
            Authority[0]= rs.getString(2);
            Authority[1]= rs.getString(3);
            Authority[2]= rs.getString(4);
            rs.close();
            stmt.close();
            conn.close();
            return Authority;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return falBoolean;
    }
	
	public static String select_UserSecurity(String user) {

    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from userview where Account = '"+
            user +"';";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            String securityNo;
            rs.next();
            securityNo = rs.getString(5);
            rs.close();
            stmt.close();
            conn.close();
            return securityNo;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return "ERROR";
    }
	
	
	public static String[][] select_UserAuthority() {
		String[][] falBoolean = new String[3][3];
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from userview ;";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            int i=getcount("userview"); 
            int j=0;
            String[][] authority = new String[i][6]; 
            while (rs.next()&&j<i){
                authority[j][0]= rs.getString(1);
                authority[j][1]= rs.getString(2);
                authority[j][2]= rs.getString(3);
                authority[j][3]= rs.getString(4);
                authority[j][4]= rs.getString(5);
                authority[j][5]= rs.getString(6);
                j++;
            }
            
            rs.close();
            stmt.close();
            conn.close();
            return authority;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return falBoolean;
    }
	
	public static String[] select_SingleUserAuthority(String Account) {
		String[] falBoolean = new String[3];
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from userview where Account = '"+Account+"' ;";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            rs.next();
            String[] authority = new String[6]; 
                authority[0]= rs.getString(1);
                authority[1]= rs.getString(2);
                authority[2]= rs.getString(3);
                authority[3]= rs.getString(4);
                authority[4]= rs.getString(5); 
                authority[5]= rs.getString(6); 
            rs.close();
            stmt.close();
            conn.close();
            return authority;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return falBoolean;
    }
	
	public static Integer getcount(String tableName) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select count(*) from "+tableName+";";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            rs.next();
            Integer i =Integer.parseInt(rs.getString(1));
            
            rs.close();
            stmt.close();
            conn.close();
            return i;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return -1;
    }
	
	/**
	 * 用户注册
	 * @param user
	 * @param password
	 */
	public static void regist_User(String user,String password) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-regist_Customer");
                
            String url=Properties.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-regist_Customer");
            String sql="";
            
            System.out.println("无安防信息");
            sql = "insert into user(Account,CanControl,Password,ControlNum) values('"+user+"','true','"+password+"',0);";

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	
	/**
	 * 带安防信息用户注册
	 * @param user
	 * @param password
	 * @param staffNo
	 * @param fingprintNo
	 * @param irisNo
	 */
	public static void regist_User_Security(String user,String password,String staffNo,Integer fingprintNo,Integer irisNo) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-regist_Customer");
                
            String url=Properties.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-regist_Customer");
            String sql="";
            if(isExist_Security(staffNo, fingprintNo, irisNo)) {
            	System.out.println("有对应安防信息");
            	sql = "insert into user(Account,Password,CanAdd,CanDelete,CanControl,StaffNo,ControlNum) values('"+user+"','"
            			+password+"','true','true','true','"+staffNo+"',0);";    //要执行的SQL
            }
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            security_AccountNumAdd(user);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	
	public static void security_AccountNumAdd(String user) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-regist_Customer");
                
            String url=Properties.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-regist_Customer");
            String sql="";
            sql = "Update security set AccountNum = AccountNum + 1 where staffno in ("
            			+ "select StaffNo from user where Account = '"+user+"');";    //要执行的SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	
	
	
	/**
	 * 修改用户密码
	 * @param user
	 * @param password
	 * @param newPassword
	 */
	
	public static void changePassword_User(String user,String password,String newPassword) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-changePassword");
                
            String url=Properties.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-changePassword");

            String sql = "update User set Password = '"+newPassword+"' where Account = '"+user+"';";    //要执行的SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	
	public static void delete_User(String account) {
    	try{
            //调用Class.forName()方法加载驱动程序
    		security_AccountNumMinus(account);
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-regist_Customer");
                
            String url=Properties.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-regist_Customer");
            String sql="";
            
            sql = "call userDelete('"+account+"');";
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	
	public static void delete_Security(String staffNo) {
    	try{
            //调用Class.forName()方法加载驱动程序
    		beforedelete_Security(staffNo);
    		security_AccountNumMinus(staffNo);
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-regist_Customer");
                
            String url=Properties.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-regist_Customer");
            String sql="";
            
            sql = "call SecurityDelete('"+staffNo+"');";
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	
	public static void beforedelete_Security(String staffNo) {
    	try{
            //调用Class.forName()方法加载驱动程序
    		security_AccountNumMinus(staffNo);
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-regist_Customer");
                
            String url=Properties.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-regist_Customer");
            String sql="";
            
            sql = "select Account from user where user.StaffNo = '"+staffNo+"';";
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()){
                String accountString =  rs.getString(1);
                delete_User(accountString);
            }
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	
	public static String[][] select_Security() {
		String[][] falBoolean = new String[3][4];
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from securityview ;";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            int i=getcount("securityview"); 
            int j=0;
            String[][] authority = new String[i][4]; 
            while (rs.next()&&j<i){
                authority[j][0]= rs.getString(1);
                authority[j][1]= rs.getString(2);
                authority[j][2]= rs.getString(3);
                authority[j][3]= rs.getString(4);
                j++;
            }
            
            rs.close();
            stmt.close();
            conn.close();
            return authority;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return falBoolean;
    }
	
	
	public static void security_AccountNumMinus(String user) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-regist_Customer");
                
            String url=Properties.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-regist_Customer");
            String sql="";
            sql = "Update security set AccountNum = AccountNum - 1 where staffno in ("
            			+ "select StaffNo from user where Account = '"+user+"');";    //要执行的SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	
	/**
	 * 是否存在该管理员
	 * @param user
	 * @param password
	 * @return
	 */
	public static boolean isExist_Admin(String user,String password) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from Admin";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                System.out.println("用户名"+"\t"+"\t"+"\t"+"密码");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.println();
                    if(rs.getString(1).equals(user) && rs.getString(2).equals(password)) {
                        rs.close();
                        stmt.close();
                        conn.close();
                    	return true;
                    }
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }
	
	/**
	 * 安防信息是否存在该账号
	 * @param staffNo
	 * @param fingprintNo
	 * @param irisNo
	 * @return
	 */
	public static boolean isExist_Security(String staffNo,Integer fingprintNo,Integer irisNo) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from Security";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                System.out.println("人员编号"+"\t"+"指纹"+"\t"+"虹膜");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.println();
                    if(rs.getString(1).equals(staffNo) && (rs.getString(2).equals(fingprintNo.toString())||rs.getString(3).equals(irisNo.toString()))) {
                        rs.close();
                        stmt.close();
                        conn.close();
                    	return true;
                    }
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }
	/**
	 * 管理员注册
	 * @param user
	 * @param password
	 * @param staffNo
	 * @param fingprintNo
	 * @param irisNo
	 */
	public static void regist_Admin_Security(String user,String password,String staffNo,Integer fingprintNo,Integer irisNo) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-regist_Customer");
                
            String url=Properties.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-regist_Customer");
            String sql="";
            if(isExist_Security(staffNo, fingprintNo, irisNo)) {
            	System.out.println("有对应安防信息");
            	sql = "insert into Admin(Account,Password,StaffNo) values('"+user+"','"
            			+password+"','"+staffNo+"');";    //要执行的SQL
            }
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	
	/**
	 * 修改管理员密码
	 * @param user
	 * @param password
	 * @param newPassword
	 */
	
	public static void changePassword_Admin(String user,String password,String newPassword) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-changePassword");
                
            String url=Properties.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-changePassword");

            String sql = "update Admin set Password = '"+newPassword+"' where Account = '"+user+"';";    //要执行的SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	
	/**
	 * 修改用户的权限
	 * @param user
	 * @param CanAdd
	 * @param CanDelete
	 * @param CanControl
	 */
	public static void Alter_UserAuthority(String user,Boolean CanAdd,Boolean CanDelete,Boolean CanControl) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-regist_Customer");
                
            String url=Properties.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-regist_Customer");
            String sql="";
            sql = "Update user set CanControl='"+CanControl.toString()+"', CanAdd='"+
            			CanAdd.toString()+"',CanDelete='"+CanDelete.toString()+
            			"'WHERE Account='"+user+"';";  //要执行的SQL
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            SelcetAllUser();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    
    }
	
	
	
	public static void main(String[] args) {
	}
}
