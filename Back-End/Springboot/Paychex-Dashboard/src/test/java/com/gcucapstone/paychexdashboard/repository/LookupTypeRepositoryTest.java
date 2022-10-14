package com.gcucapstone.paychexdashboard.repository;

import com.gcucapstone.paychexdashboard.entity.LookupType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created) 10-14-2022
 * File:           | LookupTypeRepositoryTest.java
 * Version:        | 1.0
 * Description:    | This file will be used to test the repo @ query methods
 *                 | defined in the LookupTypeRepository interface
 * ---------------------------------------------------------------------------
 * Notes:
 *  - Add JUnit test methods for each CarrierRepo method as they are coded
 *---------------------------------------------------------------------------*/
@SpringBootTest
public class LookupTypeRepositoryTest {

    @Autowired
    private LookupTypeRepository lookupTypeRepository;

    @Test
    void findByIdMethod(){
        Long id = 1008L;
        LookupType lookupType = lookupTypeRepository.findById(id).get();

        System.out.println("ID: " + lookupType.getLookupTypeId());
        System.out.println("TYPE: " + lookupType.getLookupType());
    }

    @Test
    void findByIdOrTypeMethod(){
        Long id = 1008L;
        String type = "carrier";

        List<LookupType> lookupTypes = lookupTypeRepository.findByLookupTypeIdOrLookupType(id, type);

        lookupTypes.forEach((l) ->{
            System.out.println("ID: " + l.getLookupTypeId());
            System.out.println("TYPE: " + l.getLookupType());
        });
    }

    @Test
    void findByIdAndTypeMethod(){
        Long id = 1008L;
        String type = "carrier";

        List<LookupType> lookupTypes = lookupTypeRepository.findByLookupTypeIdAndLookupType(id, type);

        lookupTypes.forEach((l) ->{
            System.out.println("ID: " + l.getLookupTypeId());
            System.out.println("TYPE: " + l.getLookupType());
        });
    }


   /* @Test
    void findByNameAndDescriptionMethod(){

        List<Product> products = productRepository.findByNameAndDescription("product 1",
                "product 1 description");

        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }*/

}// LookupTypeRepositoryTest Class
