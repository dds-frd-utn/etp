package org.utn.frd.dds.etp.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.utn.frd.dds.etp.entity.Consumption;

@Repository
public interface ConsumptionRepository extends CrudRepository<Consumption, String> {
}
