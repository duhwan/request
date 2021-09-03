package taskmanager.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="processTask", url="http://localhost:8082")
public interface ProcessTaskService {
    @RequestMapping(method= RequestMethod.PATCH, path="/processTasks")
    public void deleteProcessTask(@RequestBody ProcessTask processTask);

}
