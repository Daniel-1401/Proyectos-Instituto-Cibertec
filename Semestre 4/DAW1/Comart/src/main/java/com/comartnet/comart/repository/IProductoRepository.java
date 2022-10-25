package com.comartnet.comart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comartnet.comart.model.Producto;

@Repository
public interface IProductoRepository extends CrudRepository<Producto, Integer>{

}
