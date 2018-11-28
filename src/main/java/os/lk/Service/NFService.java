package os.lk.Service;

import org.springframework.stereotype.Service;
import os.lk.Entity.Job;
import os.lk.Entity.Storage;
import os.lk.Param.Response.StorageResponse;

import java.util.List;


/**
 * 循环首次适应算法
 */
@Service
public class NFService implements MethodService{

    @Override
    public StorageResponse method(List<Job> jobList, List<Storage> storageList, StorageResponse storageResponse) {

        int j = 0;
        for(Job job:jobList){
            for(int i = 0;i<8;i++,j=(++j)%8){
                if(job.getStatus().equals("N") && storageList.get(j).getLeaveSize()>=job.getSize()){
                    job.setStatus("Y");
                    job.setBlockId(storageList.get(j).getSid());

                    storageList.get(j).setLeaveSize(storageList.get(j).getLeaveSize()-job.getSize());
                    storageList.get(j).setJid(storageList.get(j).getJid() + "|" + job.getId());


                    j=(++j)%8;
                    break;
                }

            }

        }
        storageResponse.setStorageList(storageList);
        storageResponse.setJobList(jobList);
        return storageResponse;
    }

}
