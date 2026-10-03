import java.time.LocalDate;
class StudySession{
        int sessionID;
        String subject;
        String topic;
        int duration;
        Priority priority;
        Status status;
        LocalDate date;
        StudySession(int sessionID,String subject,String topic,int duration,Priority priority,Status status,LocalDate date){
            this.sessionID=sessionID;
            this.subject=subject;
            this.topic=topic;
            this.duration=duration;
            this.priority=priority;
            this.status=status;
            this.date=date;
        }
}
