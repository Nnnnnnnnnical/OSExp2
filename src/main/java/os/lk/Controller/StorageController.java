package os.lk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import os.lk.Entity.Job;
import os.lk.Entity.Storage;
import os.lk.Param.Response.StorageResponse;
import os.lk.Service.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StorageController {

    @Autowired
    private InitTaskService initTaskService;

    @Autowired
    private FFService ffService;

    @Autowired
    private NFService nfService;

    @Autowired
    private BFService bfService;

    @Autowired
    private WFService wfService;

    @RequestMapping(value = "storage/{method}",method = RequestMethod.POST)
    public StorageResponse storage(@PathVariable("method") String method){

        List<Job> jobList = new ArrayList<>();
        List<Storage> storagesList = new ArrayList<>();
        StorageResponse storageResponse = new StorageResponse();

        initTaskService.initTask(jobList,storagesList,storageResponse);
        if(method.equals("FF")){
            return ffService.method(jobList,storagesList,storageResponse);
        }else if(method.equals("NF")){
            return nfService.method(jobList,storagesList,storageResponse);
        }else if(method.equals("BF")){
            return bfService.method(jobList,storagesList,storageResponse);
        }else if(method.equals("WF")){
            return wfService.method(jobList,storagesList,storageResponse);
        }
        return null;
    }

    @RequestMapping(value = "storage/recover",method = RequestMethod.POST)
    public StorageResponse recover(@RequestBody StorageResponse storageResponse){
        storageResponse.setStorageList(storageResponse.getrStorageList());
        storageResponse.setJobList(storageResponse.getrJobList());
        return storageResponse;
    }
}
