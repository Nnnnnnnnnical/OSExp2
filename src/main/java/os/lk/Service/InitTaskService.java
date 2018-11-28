package os.lk.Service;

import org.springframework.stereotype.Service;
import os.lk.Common.Common;
import os.lk.Entity.Job;
import os.lk.Entity.Storage;
import os.lk.Param.Response.StorageResponse;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class InitTaskService {

    public void initTask(List<Job> jobList, List<Storage> storagesList, StorageResponse storageResponse){


        List<Job> rJobList = new ArrayList<>();
        List<Storage> rStoragesList = new ArrayList<>();
        for(int i = 1; i<= Common.Sum; i++)
        {
            Job Job = new Job();
            Job.setId(i);
            Job.setSize((int) (Math.random()*100)%20+1);
            Job.setStatus("N");
            rJobList.add(Job);

            Job job1 = new Job();
            job1.setId(i);
            job1.setSize(Job.getSize());
            job1.setStatus("N");
            jobList.add(job1);

            Storage storage = new Storage();
            storage.setSid(i);
            storage.setJid(" ");
            storage.setOriginalSize((int) (Math.random()*100)%20+1);
            storage.setLeaveSize(storage.getOriginalSize());
            rStoragesList.add(storage);

            Storage storage1 = new Storage();
            storage1.setSid(i);
            storage1.setJid(" ");
            storage1.setOriginalSize(storage.getOriginalSize());
            storage1.setLeaveSize(storage1.getOriginalSize());
            storagesList.add(storage1);
        }

        storageResponse.setrJobList(rJobList);
        storageResponse.setrStorageList(rStoragesList);


    }

}
