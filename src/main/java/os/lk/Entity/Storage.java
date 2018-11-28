package os.lk.Entity;

public class Storage {

    private int Sid;
    private int originalSize;
    private int leaveSize;
    private String jid;

    public Storage() {
    }

    public int getSid() {
        return Sid;
    }

    public void setSid(int sid) {
        Sid = sid;
    }

    public int getOriginalSize() {
        return originalSize;
    }

    public void setOriginalSize(int originalSize) {
        this.originalSize = originalSize;
    }

    public int getLeaveSize() {
        return leaveSize;
    }

    public void setLeaveSize(int leaveSize) {
        this.leaveSize = leaveSize;
    }

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }
}
