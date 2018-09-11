package com.example.demo;

import com.example.demo.config.JpaConfig;
import com.example.demo.core.domain.ResourceEntity;
import com.example.demo.core.domain.ResourceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { JpaConfig.class },
        loader = AnnotationConfigContextLoader.class)
public class DemoApplicationTests {

    @Resource
    private ResourceRepository resourceRepository;

    @Test
    public void update_created_fields_test() {
        ResourceEntity resourceEntity = ResourceEntity.builder().id(UUID.randomUUID()).name("Jason").build();
        ResourceEntity savedResourceEntity = resourceRepository.save(resourceEntity);

        ResourceEntity differentNameSameIdResourceEntity = ResourceEntity.builder().id(resourceEntity.getId()).name("Bodnar").version(resourceEntity.getVersion()).build();
        ResourceEntity updatedResourceEntity = resourceRepository.save(differentNameSameIdResourceEntity);

        assert savedResourceEntity.getCreatedBy() == updatedResourceEntity.getCreatedBy();
        assert savedResourceEntity.getCreatedDate() == updatedResourceEntity.getCreatedDate();
    }
}
