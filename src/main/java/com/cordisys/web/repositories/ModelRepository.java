package com.cordisys.web.repositories;

import com.cordisys.web.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository<U extends Model<U>> extends JpaRepository<U, Long> {

}
