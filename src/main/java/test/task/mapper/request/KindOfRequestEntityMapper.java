package test.task.mapper.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.entity.KindOfRequestEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class KindOfRequestEntityMapper {

    public String toKindOfRequestName(KindOfRequestEntity entity) {
        Objects.requireNonNull(entity);
        return entity.getName();
    }

    public List<String> toKindOfRequestNameList(List<KindOfRequestEntity> kindOfRequestEntities) {
        List<String> names = new ArrayList<>(kindOfRequestEntities.size());
        for (KindOfRequestEntity entity: kindOfRequestEntities) {
            names.add(toKindOfRequestName(entity));
        }
        return names;
    }
}
