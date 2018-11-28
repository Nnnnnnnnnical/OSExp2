package os.lk.Service;

import org.springframework.stereotype.Service;
import os.lk.Common.Common;
import os.lk.Entity.Job;
import os.lk.Entity.Storage;
import os.lk.Param.Response.StorageResponse;

import java.util.Collections;
import java.util.List;

/**
 * 最坏适应算法（WF）
 */

@Service
public class WFService implements MethodService {
    @Override
    public StorageResponse method(List<Job> jobList, List<Storage> storageList, StorageResponse storageResponse) {
        //按照作业大小从小到大排序
        Collections.sort(jobList, (o1, o2) -> {
            int flag = Common.compareJob(o1, o2);
            return flag;
        });

        for(Job job:jobList){
            int i = 0;

            //按照内存大小从大到小排序
            Collections.sort(storageList, (o1, o2) -> {
                int flag = Common.compareStorage(o1, o2);
                return flag;
            });
            Collections.reverse(storageList);
            Common.getResult(job,storageList,i);

        }
        storageResponse.setJobList(jobList);
        storageResponse.setStorageList(storageList);


        return storageResponse;
    }
}
