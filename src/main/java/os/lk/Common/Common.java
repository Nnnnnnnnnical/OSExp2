package os.lk.Common;

import os.lk.Entity.Job;
import os.lk.Entity.Storage;

import java.util.List;

public class Common {

    public static int Sum = 8;

    public static int compareJob(Object Object1, Object Object2) {
        Job s1 = (Job)Object1;
        Job s2 = (Job)Object2;
        double size1 = s1.getSize();
        double size2 = s2.getSize();
        if (size1 < size2) {
            return -1;
        } else if (size1 == size2) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int compareStorage(Object Object1, Object Object2) {
        Storage s1 = (Storage)Object1;
        Storage s2 = (Storage)Object2;
        double leaveSize1 = s1.getLeaveSize();
        double leaveSize2 = s2.getLeaveSize();
        if (leaveSize1 > leaveSize2) {
            return 1;
        } else if (leaveSize1 == leaveSize2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void getResult(Job job, List<Storage> storageList,int i){
        for(Storage storage:storageList){
            if(job.getStatus().equals("N") && job.getSize()<=storageList.get(i).getLeaveSize()){
                job.setBlockId(storageList.get(i).getSid());
                job.setStatus("Y");

                storage.setLeaveSize(storage.getLeaveSize()-job.getSize());
                storage.setJid(storage.getJid() + "|" + job.getId());

                break;
            }
            i++;
        }
    }
}
