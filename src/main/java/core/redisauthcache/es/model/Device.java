package core.redisauthcache.es.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Objects;

@Document(indexName = "device")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    @Id
    private String id;

    @Field(type = FieldType.Text, analyzer = "my_ngram_analyzer", searchAnalyzer = "my_ngram_analyzer")
    private String name;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Device device = (Device) object;
        return Objects.equals(name, device.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}