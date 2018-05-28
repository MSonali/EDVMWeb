/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Welcome
 */
import DAO.UserDao;
import java.util.Calendar;
import java.util.Date;

public class VotingProcess {
    public static String ano = null;
    public static int getAge(String ano){
        VotingProcess.ano = ano;
        UserDao dao = new UserDao();
        System.out.println(ano);
        Date dob;
        dob = dao.getDate(ano);
        System.out.println(dob);
        Calendar calendar = Calendar.getInstance();
        Calendar now =  Calendar.getInstance();
        calendar.setTime(dob);
        int born_year = calendar.get(Calendar.YEAR);
        int curr_year = now.get(Calendar.YEAR);
        int age = curr_year - born_year;
        System.out.println(age);
        return age;
    }
    public static void checkIfCanVote(String fp){
        //Scanner sc = new Scanner(System.in);
        UserDao dao = new UserDao();
        System.out.println("userfp"+fp);
        ano = dao.getAno(fp);
        System.out.println(ano);
        if(VotingProcess.getAge(ano)>= 18){
            String cname = null;
            int vc = 1;
            String confirm_vote = null;
            //getConstituency
            String voter_constituency = dao.getConstituencyDetails(ano);
            //redirect to the particular server and fetch voter details and candidate details
            boolean voted = dao.isVotingDone(ano);
            if(voter_constituency != null && voted == false){
        //VOTING PROCESS...
                while(vc<3){
                    //activateMachine();
                    System.out.println("enter candidate");
                    //cname = getCandidate();
                   // cname = sc.next();
                    System.out.println("you've voted for "+cname);
                    //pressbuttn-cast vote
                    //get cname
                    //confirm_vote = getConfirmationFromUserViaLed(cname);
                    System.out.println("give confirmation...yes/no");
                    //confirm_vote = sc.next();
                    if("yes".equals(confirm_vote)){
                      //  dao.castVote(ano, cname,vc);
                        vc++;
                    }                       
                    else
                        vc++;
                }
                if(vc==3){
                    dao.castFakeVote();
                }
                else{
                    //display voted successfully on led
                    System.out.println("voted successfully");
                }
            }
            else{
                //display already voted on led or display not a registered voter...
                System.out.println("already voted ");
            }
        }
        else{
            //display under age...
            System.out.println("under age");
        }
    }
}
