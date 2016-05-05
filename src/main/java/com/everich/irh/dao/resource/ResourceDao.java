package com.everich.irh.dao.resource;
import java.util.List;
import com.everich.irh.entity.resource.Resource;
public interface ResourceDao {
	List<Resource> findAll();
}
