package core.redisauthcache.es.repository;

import core.redisauthcache.es.model.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface DeviceESRepository extends ElasticsearchRepository<Device, String> {
    @Query("{\"match\": {\"name\": \"?0\"}}}")
    Page<Device> findByName(String name, Pageable pageable);

    @Query("{\"match\": {\"name\": {\"query\": \"?0\", \"fuzziness\": \"AUTO\"}}}")
    Page<Device> findByNameFuzzy(String name, Pageable pageable);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    Page<Device> findByNameUsingCustomQuery(String name, Pageable pageable);
}
