package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import runPart.Properties;


public class FacilityManage {

	/**
	 * 是否存在该设备
	 * @param no
	 * @param Category
	 * @return
	 */
	public static boolean isExist_Facility(String no) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from facility";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                System.out.println("编号"+"\t"+"\t"+"\t"+"类别");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.println();
                    if(rs.getString(1).equals(no)) {
                        rs.close();
                        stmt.close();
                        conn.close();
                        System.out.println("find facility");
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
    	System.out.println("false");
		return false;
    }
	
	public static boolean isExist_runStatus(Integer runNo,String no) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from runstatus";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                System.out.println("运行编号"+"\t"+"设备编号");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.println();
                    if(rs.getString(1).equals(runNo.toString()) && rs.getString(2).equals(no)) {
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
	
	public static boolean isRun_Facility(String no,String runNo) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select * from runstatus";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                System.out.println("设备编号"+"\t"+"运行编号"+"\t开始运行时间"+"\t结束运行时间");
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minute = cal.get(Calendar.MINUTE);
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.print(rs.getString(3)+":"+rs.getString(4)+"\t");
                    System.out.print(rs.getString(5)+":"+rs.getString(6)+"\t");
                    System.out.println();
                    if(rs.getString(1).equals(no) && rs.getString(2).equals(runNo) && 
                    		Integer.parseInt(rs.getString(5))>hour && Integer.parseInt(rs.getString(6))>minute) {
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
	 * 设备添加（无房间信息）
	 * @param no
	 * @param Category
	 * @param inRemainWarPer
	 */
	public static void add_Facility(String no,String Category, Integer inRemainWarPer) {
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
            
            sql = "insert into facility(No,Category,RemainWarPer,isFault) values('"+no+"','"+Category+
            		"','"+inRemainWarPer.toString()+"');";

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
	 *  设备添加（有房间信息）
	 * @param no
	 * @param Category
	 * @param inRemainWarPer
	 * @param roomName
	 */
	public static void add_Facility(String no,String Category, Integer inRemainWarPer, String roomName) {
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
            
            sql = "insert into facility(FacilityNo,Category,RemainWarPer,RoomName,isFault,ControledNum) values('"+no+"','"+Category+
            		"','"+inRemainWarPer.toString()+"','" +roomName +"','false',0);";

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
	 * 删除设备，以及设备的运行状态
	 * @param no
	 */
	public static void delete_Facility(String no) {
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
            
            sql = "call facilityDelete('"+no+"');";
            
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
	

	
	public static void facility_Time_add(String no,
			Integer openHour,Integer openMinute, Integer endHour, Integer endMinute) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-changePassword");
                
            String url=Properties.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-changePassword");

            String sql = "insert into runstatus(FacilityNo,OpenHour,OpenMin,CloseHour,CloseMin) values('"
            +no+"','"+openHour.toString()+"','"+openMinute.toString()+
            	"','"+endHour.toString()+"','"+endMinute.toString()+"');";
    
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
	 * 设备房间修改
	 * @param no
	 * @param category
	 * @param roomname
	 */
	public static void facility_room_change(String no,String roomname) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-changePassword");
                
            String url=Properties.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-changePassword");

            String sql = "update facility set RoomName = '"+roomname+"' where No = '"+no+
            		"';";    //要执行的SQL
            
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
	 * 
	 * @param no
	 * @param runNo
	 */
	public static void delete_runstatus(String no,Integer runNo) {
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
            
            sql = "Delete from runstatus where FacilityNo = '"+no+
            		"'and RunNo = " + runNo.toString()+ ";";

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

	public static boolean select_guarantee(Integer guarantee) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");
            String sql = "select FacilityNo,Category,AccumuRuntime,RemainWarPer "
            		+ "from facility"
            		+ " where facility.RemainWarPer <= '" + guarantee.toString()+"';";    //要执行的SQL
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                System.out.println("设备编号"+"\t种类"+"\t总运行小时"+"\t剩余保修期（月）");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.print(rs.getString(3) + "\t");
                    System.out.print(rs.getString(4) + "\t");
                    System.out.println();
                    
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
	 * 查询指定房间内正在工作的设备
	 * @param roomName
	 * @return
	 */
	public static boolean select_runFacility(String roomName) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");
            String sql = "select No,Category,Name "
            		+ "from room, facility"
            		+ " where Name ='"+roomName+"' and isFault = 'false'"
            				+ "and facility.RoomName = room.Name;";    //要执行的SQL
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                System.out.println("编号"+"\t种类"+"\t房间");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.print(rs.getString(3) + "\t");
                    System.out.println();
                    
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
	
	
	public static Integer getFacilitycount(String bool) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select count(*) from facility where isFault = '"+bool+ "';";    //要执行的SQL
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

	
	public static String[][] select_allrunFacility() {
		int i = getFacilitycount("false");
		String[][] anStrings = new String[i][4];
    	try{
            //调用Class.forName()方法加载驱动程序
    		
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");
            String sql = "select FacilityNo,Category,RemainWarper,RoomName "
            		+ "from facility"
            		+ " where isFault = 'false';";    //要执行的SQL
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                System.out.println("编号"+"\t种类"+"\t房间");
                int j=0;
                while (rs.next()&&j<i){
                    anStrings[j][0]= rs.getString(1);
                    anStrings[j][1]= rs.getString(2);
                    anStrings[j][2]= rs.getString(3);
                    anStrings[j][3]= rs.getString(4);
                    j++;
                }
                rs.close();
                stmt.close();
                conn.close();
                return anStrings;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return anStrings;
    }
	
	
	public static String[][] select_allFaultFacility() {
		int i = getFacilitycount("true");
		String[][] anStrings = new String[i][5];
    	try{
            //调用Class.forName()方法加载驱动程序
    		
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");
            String sql = "select FacilityNo,Category,RemainWarper,RoomName,FaultType "
            		+ "from facility"
            		+ " where isFault = 'true';";    //要执行的SQL
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                System.out.println("编号"+"\t种类"+"\t房间");
                int j=0;
                while (rs.next()&&j<i){
                    anStrings[j][0]= rs.getString(1);
                    anStrings[j][1]= rs.getString(2);
                    anStrings[j][2]= rs.getString(3);
                    anStrings[j][3]= rs.getString(4);
                    anStrings[j][4]= rs.getString(5);
                    j++;
                }
                rs.close();
                stmt.close();
                conn.close();
                return anStrings;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return anStrings;
    }
	
	public static void changeFacility(String FacilityNo,String category,String newValue) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-changePassword");
                
            String url=Properties.JDBC_URL;    //JDBC的URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-changePassword");

            String sql = "update facility set "+category +"='"+newValue+"' where FacilityNo = '"+FacilityNo+"';";    //要执行的SQL
            
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
	
	public static Integer getLogscount(String category) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select count(*) from logs where Category = '"+category+ "';";    //要执行的SQL
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
	
	public static String[][] select_Logs(String category) {
		int i = getLogscount(category);
		String[][] anStrings = new String[i][4];
    	try{
            //调用Class.forName()方法加载驱动程序
    		
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");
            String sql = "select Time,Events,Category,KeyWords "
            		+ "from logs "
            		+ "where Category = '"+category+ "' order by Time asc;";    //要执行的SQL
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                System.out.println("编号"+"\t种类"+"\t房间");
                int j=0;
                while (rs.next()&&j<i){
                    anStrings[j][0]= rs.getString(1);
                    anStrings[j][1]= rs.getString(2);
                    anStrings[j][2]= rs.getString(4);
                    anStrings[j][3]= rs.getString(3);
                    j++;
                }
                rs.close();
                stmt.close();
                conn.close();
                return anStrings;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return anStrings;
    }
	
	public static void delete_Logs(String category) {
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
            
            sql = "Delete from logs where Category = '"+category+"';";

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
	
	public static boolean select_faultFacility(String roomName) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");
            String sql = "select No,facility.Category,Name,FaultType "
            		+ "from room, facility, runstatus "
            		+ " where Name ='"+roomName+"' and isFault = 'true' "
            				+ "and facility.RoomName = room.Name "
            				+ "and facility.No = runstatus.FacilityNo ;";    //要执行的SQL
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            	System.out.println("编号"+"\t种类"+"\t房间"+"\t错误类别");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.print(rs.getString(3) + "\t");
                    System.out.print(rs.getString(4) + "\t");
                    System.out.println();
                    
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
	
	public static void add_Control(String userAccount,String facilityNo) {
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
            
            sql = "insert into control(UserAccount,FacilityNo) values('"+userAccount+"','"+facilityNo+
            		"');";

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
	
	public static void delete_Control(String userAccount, String facilityNo ) {
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
            
            sql = "Delete from control where UserAccount = '"+userAccount+
            		"'and FacilityNo = '" + facilityNo+ "';";
            
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
	
	
	public static Integer getControlcount(String bool) {
    	try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");

            String sql = "select count(*) from control where UserAccount = '"+bool+ "';";    //要执行的SQL
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
	
	public static String[][] Select_Control(String account) {
		int i = getControlcount(account);
		String[][] anStrings = new String[i][4];
    	try{
            //调用Class.forName()方法加载驱动程序
    		
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-isExist_Customer");
            String sql = "select UserAccount,FacilityNo,RoomName,isFault "
            		+ "from controlFacilityView"
            		+ " where UserAccount = '"+account+"';";    //要执行的SQL
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
                System.out.println("编号"+"\t种类"+"\t房间");
                int j=0;
                while (rs.next()&&j<i){
                    anStrings[j][0]= rs.getString(1);
                    anStrings[j][1]= rs.getString(2);
                    anStrings[j][2]= rs.getString(3);
                    anStrings[j][3]= rs.getString(4);
                    j++;
                }
                rs.close();
                stmt.close();
                conn.close();
                return anStrings;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return anStrings;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		isExist_Facility("L5");
		
		
	}

}
