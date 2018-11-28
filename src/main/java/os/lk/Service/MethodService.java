package os.lk.Service;

import os.lk.Entity.Job;
import os.lk.Entity.Storage;
import os.lk.Param.Response.StorageResponse;

import java.util.List;

public interface MethodService {

    public StorageResponse method(List<Job> jobList, List<Storage> storageList, StorageResponse storageResponse);
}
