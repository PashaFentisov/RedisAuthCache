package core.redisauthcache.es.repository;

import core.redisauthcache.es.model.ESDevice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface DeviceESRepository extends ElasticsearchRepository<ESDevice, String> {
    @Query("{\"match\": {\"name\": \"?0\"}}}")
    Page<ESDevice> findByName(String name, Pageable pageable);

    @Query("{\"match\": {\"name\": {\"query\": \"?0\", \"fuzziness\": \"AUTO\"}}}")
    Page<ESDevice> findByNameFuzzy(String name, Pageable pageable);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    Page<ESDevice> findByNameUsingCustomQuery(String name, Pageable pageable);
}
