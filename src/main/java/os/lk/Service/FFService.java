package os.lk.Service;

import org.springframework.stereotype.Service;
import os.lk.Entity.Job;
import os.lk.Entity.Storage;
import os.lk.Param.Response.StorageResponse;

import java.util.List;


/**
 * 首次适应算法（FF）
 */
@Service
public class FFService implements MethodService{


    @Override
    public StorageResponse method(List<Job> jobList, List<Storage> storageList, StorageResponse storageResponse){

        for(Job job:jobList){
            for(Storage storage:storageList){
                if(job.getStatus().equals("N") && job.getSize()<=storage.getLeaveSize()){
                    job.setStatus("Y");
                    job.setBlockId(storage.getSid());

                    storage.setJid(storage.getJid() + "|" + job.getId());
                    storage.setLeaveSize(storage.getLeaveSize()-job.getSize());
                    break;
                }
                storageResponse.setStorageList(storageList);

            }
            storageResponse.setJobList(jobList);
        }


        return storageResponse;



    }
}
