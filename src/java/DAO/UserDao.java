/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author Welcome
 */
import Model.VoterDetailsModel;
import Model.VotingProcess;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao {
    
    private Connection con = new DatabaseConnection().connect();
    VoterDetailsModel vdm = new VoterDetailsModel();
    //Connection currentCon = null;
    ResultSet rs = null;
    Statement stmt = null;
    public static String ano = null;
    public  String getAno(String fp){
        String ano = null;
        String getAnoQuery = "select ano from uidai_citizen_detail where fingerprint = '"+ fp +"'";
        try{
           // con = DatabaseConnection.connect();
            stmt = con.createStatement();
            rs = stmt.executeQuery(getAnoQuery);
            if(rs.next()){
                UserDao.ano = rs.getString("ano");
            }
        }catch(Exception e){
            
        }
        return UserDao.ano;
    }
    public  Date getDate(String ano){
        System.out.println("Fetching Date...");
        Date date = null;
        String getDob = "select dob from uidai_citizen_detail where ano = '"+ ano +"'";
        try{
            //currentCon = DatabaseConnection.connect();
            stmt = con.createStatement();
            rs = stmt.executeQuery(getDob);
            if(rs.next()){
                date = rs.getDate("dob");
            }
             con.close();
        } catch(Exception e){
            System.out.println(e);
        }
        return date;
    }
    
    public  String getConstituencyDetails(String ano){
        
        
        System.out.println("getCons ano test..."+ano);
        String constituency = null;
        String v_name = "";
        String v_fname = "";
        String v_state = "";
        String v_district = "";
        String v_gender = "";
        int v_age = VotingProcess.getAge(ano);
        System.out.println(v_age);
        String getAadharDetails = "select name,father_name,gender,state,district from uidai_citizen_detail where ano = '"+ ano +"'";
        System.out.println(getAadharDetails);
        try{
        //currentCon = DatabaseConnection.connect();
        stmt = con.createStatement();
        rs = stmt.executeQuery(getAadharDetails);
        if(rs.next()){
            v_name = rs.getString("name");
            v_fname = rs.getString("father_name");
            v_gender = rs.getString("gender");
            v_state = rs.getString("state");
            v_district = rs.getString("district");          
        }
        System.out.println("VOTER DETAILS");
        System.out.println("--------------");
        System.out.println("VOTER NAME "+v_name );
        System.out.println("VOTER FATHER "+v_fname );
        System.out.println("VOTER GENDER "+v_gender );
        System.out.println("VOTER STATE "+v_state );
        System.out.println("VOTER DISTRICT "+v_district );
     
        constituency = getConstituency(v_name,v_fname,v_gender,v_age,v_state,v_district);
        
        } catch(Exception e){
        }
        vdm.setV_name(v_name);
        vdm.setV_fname(v_fname);
        vdm.setConstituency(constituency);
        vdm.setV_district(v_district);
        vdm.setV_age(v_age);
        System.out.println(constituency);
        return constituency;
    }
    public String getConstituency(String v_name,String v_fname,String v_gender,int v_age,String v_state,String v_district){
        String constituency = null;
        String getCDetail = "select v_constituency from nvsp_constituency where (v_name = '" + v_name + "'&&v_fname = '" + v_fname + "'&&gender = '" + v_gender + "'&&age = '" + v_age + "'&&state = '" + v_state + "'&&district = '" + v_district + "')";
        //Connection newCon = DatabaseConnection.connect();
        System.out.println(getCDetail);
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(getCDetail);
            if(rs.next()){
             constituency = rs.getString("v_constituency");
            }
        System.out.println(constituency);
        } catch(Exception e){
            
        }
        
        return constituency;
    }
    public  boolean isVotingDone(String ano){
        boolean voted = true;
        boolean present = false;
        String isAnoPresent = "select * from ec_isVoted where voted_ano = '"+ ano +"'";
        try{
           // con = DatabaseConnection.connect();
            stmt = con.createStatement();
            rs = stmt.executeQuery(isAnoPresent);
            if(rs.next()){
                System.out.println(" Already Voted");
                present = true;
            }
            if(!present){
                System.out.println("Not voted");
                voted = false;
            }
        }catch(Exception e){
            
        }
        vdm.setIsVoted(voted);
        return voted;
    }
    
    public  void castVote(String ano,int vc){
        
        String insertAno = "insert into ec_isvoted values('"+ ano +"','"+ vc +"')";
        try{
           // currentCon = DatabaseConnection.connect();
            stmt = con.createStatement();
            
            int i = stmt.executeUpdate(insertAno);
            if(i>0){
                System.out.println("voted");
            }
            else{
                System.out.println("could not insert into isvoted");
            }
        }catch(Exception e){
            
        }
    }
    public void updateParty(String cname){
        String updateParty = "update ec_party set votes = votes+1 where candidate = '"+ cname +"'";
        try{
            stmt = con.createStatement();
            int i = stmt.executeUpdate(updateParty); 
            if(i>0){
                System.out.println("updated party");
            }
        } catch(Exception e){
            
        }
    }
    public  void castFakeVote(){
        String fake = "fake";
        String fake_vote = "update ec_party set votes = votes+1 where candidate='"+ fake +"'";
        try{
            //currentCon = DatabaseConnection.connect();
            stmt = con.createStatement();
            int i = stmt.executeUpdate(fake_vote);
            if(i>0)
                System.out.println("fake");
        } catch(Exception e){
            
        }
    }
    
    public List<String> getCandidate(){
        List<String> candidates = new ArrayList<String>();
        String fake = "fake";
        String getCandidates = "select candidate from ec_party";
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(getCandidates);
            while(rs.next()){
                candidates.add(rs.getString("candidate"));
            }
            System.out.println(candidates);
        }catch(Exception e){
            
        }
        return candidates;
    }
    
    public void addSessionAno(String add){
        String insert = "insert into currentsession(session_ano) values( '"+ add +"')";
        try{
            stmt = con.createStatement();
            int i = stmt.executeUpdate(insert);
            if(i>0){
                System.out.println("session_ano inserted");
            }
        } catch(Exception e){
            
        }
    }
    public void addSessionCname(String add){
        String insert = "update currentsession set session_cname='"+ add +"'";
        try{
            stmt = con.createStatement();
            int i = stmt.executeUpdate(insert);
            if(i>0){
                System.out.println("session_cname inserted");
            }
        } catch(Exception e){
            
        }
    }
    public List<String> getSessionData(){
        List<String> session = new ArrayList<String>();
        String get = "select * from currentsession";
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(get);
            if(rs.next()){
                session.add(rs.getString("session_ano"));
                session.add(rs.getString("session_cname"));
            }
        } catch(Exception e){
            
        }
        System.out.println(session.size());
        return session;
    }
    public void truncate(){
        String truncate = "truncate table currentsession";
        try{
            stmt = con.createStatement();
            int i = stmt.executeUpdate(truncate);
            if(i>0){
                System.out.println("session deleted");
            }
        } catch(Exception e){
        
    }
    }
}