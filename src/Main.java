import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StudySession obj1=new StudySession(1,"Mathematics","Algebra",30,Priority.MEDIUM,Status.PENDING,LocalDate.of(2026,9,27));
        StudySession obj2=new StudySession(2,"ComputerScience","HTML",60,Priority.LOW,Status.COMPLETED,LocalDate.of(2026,9,12));
        ArrayList<StudySession> Sessions=new ArrayList<>();
        Sessions.add(obj1);
        Sessions.add(obj2);
        int choice=0;
        int pendingcount=0;
        while(choice!=9){
            System.out.println("-----STUDY SESSION PLANNER-----");
            System.out.println("1.ADD STUDY SESSION");
            System.out.println("2.VIEW ALL STUDY SESSIONS");
            System.out.println("3.SEARCH STUDY SESSION");
            System.out.println("4.UPDATE STUDY SESSION");
            System.out.println("5.DELETE STUDY SESSION");
            System.out.println("6.MARK SESSION AS COMPLETED");
            System.out.println("7.VIEW PENDING SESSIONS");
            System.out.println("8.DISPLAY STATISTICS");
            System.out.println("9.EXIT");
            System.out.print("ENTER YOUR CHOICE:");
            try{
                choice=sc.nextInt();
                switch(choice){
                    case 1:
                 int a=0;
                 int d=0;
                 boolean sessionID=false;
                 boolean duplicate=false;
        while(sessionID==false){
        try{
        System.out.print("ENTER THE SESSION ID:");
        a=sc.nextInt();
        if(a>0){
            duplicate=false;
            for(StudySession sess:Sessions){
                if(a==sess.sessionID){
                    duplicate=true;
                    break;
            }
        }
        if(duplicate==true){
            System.out.println("SESSION ID ALREADY EXIST!");
        }
        else{
            sessionID=true;
        }
    }
        else{
            System.out.println("THE SESSION ID SHOULD BE POSITIVE.");
        }
        }
        catch(InputMismatchException e){
            System.out.println("INVALID INPUT!");
            sc.nextLine();
        }
    }
        sc.nextLine();
        boolean subject=false;
        String b=null;
        while(subject==false){
            System.out.print("ENTER THE SUBJECT:");
            b=sc.nextLine();
            if(b.isBlank()){
                System.out.println("SUBJECT CANNOT BE BLANK!");
            }
            else{
            subject=true;
            }
        }
        boolean topic=false;
        String c=null;
        while(topic==false){
            System.out.print("ENTER THE TOPIC:");
            c=sc.nextLine();
            if(c.isBlank()){
                System.out.println("TOPIC CANNOT BE BLANK!");
            }
            else{
                topic=true;
            }
        }
        boolean duration=false;
        while(duration==false){
        try{
        System.out.print("ENTER THE DURATION NEEDED:");
        d=sc.nextInt();
        if(d>0){
        duration=true;
        }
        else{
            System.out.println("DURATION MUST BE GREATER THAN ZERO.");
        }
    }
        catch(InputMismatchException e){
            System.out.println("INVALID INPUT!");
            sc.nextLine();
        }
    }
        sc.nextLine();
        String e;
        boolean prior=false;
        Priority pri=null;
        while(prior==false){
            try{
                System.out.print("ENTER THE PRIORITY LEVEL:");
                e=sc.nextLine();
                pri=Priority.valueOf(e.toUpperCase());
                prior=true;
                }
            catch(IllegalArgumentException E){
                    System.out.println("INVALID INPUT!ENTER THE PRIORITY LEVEL AS(LOW,MEDIUM,HIGH).");
            }
        }
        String g;
        LocalDate date=null;
        boolean dates=false;
        while(dates==false){
        try{
            System.out.print("ENTER THE DATE:");
        g=sc.nextLine();    
        date=LocalDate.parse(g);
        dates=true;
        StudySession obj3=new StudySession(a,b,c,d,pri,Status.PENDING,date);
        Sessions.add(obj3);
        }
        catch(DateTimeParseException E){
            System.out.println("INVALID INPUT!CORRECT DATE FORMAT(YYYY-MM-DD).");
        }
    }
    break;
    case 2:
        for(StudySession session:Sessions){
            System.out.println("-----STUDY SESSION PLANNER-----");
            System.out.println("SESSION ID:"+session.sessionID);
            System.out.println("SUBJECT:"+session.subject);
            System.out.println("TOPIC:"+session.topic);
            System.out.println("DURATION:"+session.duration);
            System.out.println("PRIORITY:"+session.priority);
            System.out.println("STATUS:"+session.status);
            System.out.println("DATE:"+session.date);
        }
        break;
        /*SEARCHING THE SESSION USING THE SESSIONID */
        case 3:
        boolean sessionid=false;
        boolean duplic=false;
        int session_id;
        StudySession Matching_session=null;
        while(sessionid==false){
            try{
            System.out.println("ENTER THE SESSION_ID TO SEARCH:");
            session_id=sc.nextInt();
            if(session_id>0){
                duplic=false;
                for(StudySession sess:Sessions){
                    if(session_id==sess.sessionID){
                        duplic=true;
                        Matching_session=sess;
                         break;
                     }
                     }
                     if(duplic==true){
                         sessionid=true;
                         System.out.println("SESSION ID FOUND");
                         System.out.println("SESSION ID:"+Matching_session.sessionID);
                         System.out.println("SUBJECT:"+Matching_session.subject);
                         System.out.println("TOPIC:"+Matching_session.topic);
                         System.out.println("DURATION:"+Matching_session.duration);
                         System.out.println("PRIORITY:"+Matching_session.priority);
                         System.out.println("STATUS:"+Matching_session.status);
                         System.out.println("DATE:"+Matching_session.date);
                     }
                     else{
                        System.out.println("SESSION ID NOT FOUND!");
                     }
                    }
                     else{
                        System.out.println("SESSION ID SHOULD BE POSITIVE.");
                     }
                     }
                    catch(InputMismatchException E){
                        System.out.println("INVALID INPUT!");
                        sc.nextLine();
                    }
                }
                break;
        /*UPDTAING THE DETAILS IN THE PLANNER */
        case 4:
        boolean sessionidd=false;
        boolean dupl=false;
        int session_iD=0;
        StudySession Old_session=null;
        while(sessionidd==false){
            try{
             System.out.println("ENTER THE SESSION_ID TO UPDATE THE DETAILS:");
             session_iD=sc.nextInt();
             if(session_iD>0){
                dupl=false;
                for(StudySession sess:Sessions){
                    if(session_iD==sess.sessionID){
                        dupl=true;
                        Old_session=sess;    
                    }
                }
                if(dupl==true){
                    System.out.println("ENTER THE FIELD TO UPDATE IN THE PLANNER:");
                    sc.nextLine();
                    String to_update=sc.nextLine();
                    
                    if((to_update.equals("subject"))||(to_update.equals("SUBJECT"))){
                        System.out.println("ENTER THE NEW SUBJECT TO UPDATE IN THE PLANNER:");
                        String new_subject=sc.nextLine();
                        Old_session.subject=new_subject;
                        sessionidd=true;
                    }
                    else if((to_update.equals("topic"))||(to_update.equals("TOPIC"))){
                        System.out.println("ENTER THE NEW TOPIC TO UPDATE IN THE PLANNER:");
                        String new_topic=sc.nextLine();
                        Old_session.topic=new_topic;
                        sessionidd=true;
                    }
                    else if((to_update.equals("duration"))||(to_update.equals("DURATION"))){
                        boolean durat=false;
                          while(durat==false){
                            try{
                                System.out.print("ENTER THE NEW DURATION TO UPDATE IN THE PLANNER:");
                                 int new_duration=sc.nextInt();
                                  if(new_duration>0){
                                    Old_session.duration=new_duration;
                                    durat=true;
                                }
                                else{
                                     System.out.println("DURATION MUST BE GREATER THAN ZERO.");
                                     }
                                    }
                                    catch(InputMismatchException E){
                                        System.out.println("INVALID INPUT!");
                                        sc.nextLine();
                                      }
                                     }
                                     sessionidd=true;
                                    }
                    else if((to_update.equals("priority"))||(to_update.equals("PRIORITY"))){
                        boolean prio=false;
                        while(prio==false){
                            try{
                                System.out.print("ENTER THE NEW PRIORITY TO UPDATE IN THE PLANNER:");
                                String new_priority=sc.nextLine();
                                Old_session.priority=Priority.valueOf(new_priority.toUpperCase());
                                prio=true;
                            }
                            catch(IllegalArgumentException E){
                                System.out.println("INVALID INPUT!ENTER THE PRIORITY LEVEL AS(LOW,MEDIUM,HIGH).");
                            }
                        }
                        sessionidd=true;
                    }
                    else if((to_update.equals("date"))||(to_update.equals("DATE"))){
                        boolean datess=false;
                        while(datess==false){
                            try{
                                System.out.print("ENTER THE NEW DATE TO UPDATE IN THE PLANNER:");
                                 String h=sc.nextLine();
                                 LocalDate new_date=LocalDate.parse(h);
                                 Old_session.date=new_date;
                                 datess=true;
                                }
                                catch(DateTimeParseException E){
                                    System.out.println("INVALID INPUT!CORRECT DATE FORMAT(YYYY-MM-DD).");
                                 }
                                }
                                sessionidd=true;
                            }
                            else{
                                System.out.println("ENTER A VALID FIELD (SUBJECT,TOPIC,DURATION,PRIORITY,DATE):"); 
                                continue; 
                            }
                            if(sessionidd==true){
                            System.out.println("-----UPDATED STUDY SESSION PLANNER-----");
                            System.out.println("SESSION ID:"+Old_session.sessionID);
                            System.out.println("SUBJECT:"+Old_session.subject);
                            System.out.println("TOPIC:"+Old_session.topic);
                            System.out.println("DURATION:"+Old_session.duration);
                            System.out.println("PRIORITY:"+Old_session.priority);
                            System.out.println("STATUS:"+Old_session.status);
                            System.out.println("DATE:"+Old_session.date);
                            }
                        }
                        else{
                            System.out.println("SESSION ID NOT FOUND!");
                        }
                     }
             else{
                System.out.println("SESSION ID SHOULD BE POSITIVE");
             }
        }
        catch(InputMismatchException E){
            System.out.println("INVALID INPUT!");
            sc.nextLine();
        }
    }
    break;
    /*DELETING SPECIFIC SESSION FROM THE PLANNER */
    case 5:
    boolean dele=false;
    int session_iD1=0;
    StudySession delete_session=null;
    while(dele==false){
        try{
            System.out.println("ENTER THE SESSION_ID TO DELETE:");
            session_iD1=sc.nextInt();
            if(session_iD1>0){
             for(StudySession delete:Sessions){
                if(session_iD1==delete.sessionID){
                    dele=true;
                    delete_session=delete;
                }
            }
            if(dele==true){
            Sessions.remove(delete_session);
            System.out.println("THE COMPLETE SESSION IS DELETED SUCCESSFULLY");
        }
        else{
            System.out.println("SESSION_ID NOT FOUND!");
        }
    }
    else{
        System.out.println("SESSION ID SHOULD BE POSITIVE.");
    }
}
catch(InputMismatchException E){
    System.out.println("INVALID INPUT!");
    sc.nextLine();
}
    }
    break;
        /*MARKING THE STATUS AS COMPLETED */
        case 6:
        boolean mark=false;
        int session_iD2=0;
        StudySession mark_session=null;
        while(mark==false){
            try{
                System.out.println("ENTER THE SESSION_ID TO MARK IT STATUS AS COMPLETED:");
                session_iD2=sc.nextInt();
                if(session_iD2>0){
                for(StudySession markk:Sessions){
                    if(session_iD2==markk.sessionID){
                        mark=true;
                        mark_session=markk;
                    }
                }
            if(mark==true){
                mark_session.status=Status.COMPLETED;
                System.out.println("THE SESSION IS MARKED AS COMPLETED SUCCESSFULLY.");
            }
            else{
                System.out.println("SESSION_ID NOT FOUND!");
            }
        }
        else{
            System.out.println("SESSION ID SHOULD BE POSITIVE.");
        }
    }
        catch(InputMismatchException E){
            System.out.println("INVALID INPUT!");
            sc.nextLine();
        }
    }
    break;
            /*DISPLAYING THE PENDING SESSIONS */
            case 7:
            boolean foundedd=false;
            pendingcount=0;
            for(StudySession view:Sessions){
                if(view.status==Status.PENDING){
                    foundedd=true;
                System.out.println("-----PENDING SESSIONS-----");
                System.out.println("SESSION ID:"+view.sessionID);
                System.out.println("SUBJECT:"+view.subject);
                System.out.println("TOPIC:"+view.topic);
                System.out.println("DURATION:"+view.duration);
                System.out.println("PRIORITY:"+view.priority);
                System.out.println("STATUS:"+view.status);
                System.out.println("DATE:"+view.date);
                pendingcount++;
            }
        }
            if(foundedd==false){
                 System.out.println("NO PENDING SESSIONS!");
                 }
                 break;
                 case 8:
                    int pendingcountt=0;
                 System.out.println("-----STATISTICS-----");
                 System.out.println("TOTAL SESSIONS:"+Sessions.size());
                 int completedcount=0;
                 for(StudySession complete:Sessions){
                    if(complete.status==Status.COMPLETED){
                        completedcount++;
                    }
                 }
                 for(StudySession pending:Sessions){
                    if(pending.status==Status.PENDING){
                        pendingcountt++;
                    }
                 }
                 System.out.println("COMPLETED SESSIONS:"+completedcount);
                 System.out.println("PENDING SESSIONS:"+pendingcountt);
                 int total_duration=0;
                 for(StudySession duration_session:Sessions){
                    total_duration=total_duration+duration_session.duration;
                 }
                 System.out.println("TOTAL STUDY DURATION OF ALL THE SESSIONS:"+total_duration);
                 break;
                 case 9:
                    System.out.println("EXITING THE STUDY PLANNER.");
                    break;
                    default:
                        System.out.println("INVALID CHOICE!PLEASE ENTER(1-9) ");
                }
            }
            catch(InputMismatchException E){
                System.out.println("INVALID INPUT! PLEASE ENTER A NUMBER.");
                sc.nextLine();
            }
        }
                }
            }