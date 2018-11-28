package os.lk.Service;

import com.sun.xml.internal.ws.api.model.MEP;
import org.springframework.stereotype.Service;
import os.lk.Common.Common;
import os.lk.Entity.Job;
import os.lk.Entity.Storage;
import os.lk.Param.Response.StorageResponse;

import java.util.Collections;
import java.util.List;


/**
 * 最佳适应算法（BF）
 */

@Service
public class BFService implements MethodService {
    @Override
    public StorageResponse method(List<Job> jobList, List<Storage> storageList, StorageResponse storageResponse) {
        //按照作业大小从小到大排序
        Collections.sort(jobList, (o1, o2) -> {
            int flag = Common.compareJob(o1, o2);
            return flag;
        });

        for(Job job:jobList){
            int i = 0;

            //按照内存大小从小到大排序
            Collections.sort(storageList, (o1, o2) -> {
                int flag = Common.compareStorage(o1, o2);
                return flag;
            });
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
        storageResponse.setJobList(jobList);
        storageResponse.setStorageList(storageList);


        return storageResponse;
    }
}
