package taskmanager;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="requestTasks", path="requestTasks")
public interface RequestTaskRepository extends PagingAndSortingRepository<RequestTask, Long>{


}
