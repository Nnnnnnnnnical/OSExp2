package os.lk.Param.Response;

import os.lk.Entity.Job;
import os.lk.Entity.Storage;

import java.util.List;

public class StorageResponse {

    private List<Job> rJobList;//处理前的作业
    private List<Storage> rStorageList;//处理前的存储
    private List<Job> JobList;//处理后的作业
    private List<Storage> storageList;//处理后的存储

    public List<Job> getrJobList() {
        return rJobList;
    }

    public void setrJobList(List<Job> rJobList) {
        this.rJobList = rJobList;
    }

    public List<Storage> getrStorageList() {
        return rStorageList;
    }

    public void setrStorageList(List<Storage> rStorageList) {
        this.rStorageList = rStorageList;
    }

    public List<Job> getJobList() {
        return JobList;
    }

    public void setJobList(List<Job> jobList) {
        JobList = jobList;
    }

    public List<Storage> getStorageList() {
        return storageList;
    }

    public void setStorageList(List<Storage> storageList) {
        this.storageList = storageList;
    }
}
