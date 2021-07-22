package com.vidyutsathi.controllers;


import static org.mockito.ArgumentMatchers.isNull;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vidyutsathi.models.BoundingBox;
import com.vidyutsathi.models.Coordinate;
import com.vidyutsathi.models.DistrictMap;
import com.vidyutsathi.models.LocationCode;
import com.vidyutsathi.models.PowerOrganisation;
import com.vidyutsathi.models.RegisteredDataviewer;
import com.vidyutsathi.models.StateMap;
import com.vidyutsathi.repository.PowerOrganisationRepository;
import com.vidyutsathi.repository.RegisteredDataViewersRepository;
import com.vidyutsathi.repository.StateMapRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/dataviewer")
public class RegisteredDataviewerController {
      @Autowired
      RegisteredDataViewersRepository rdvr;
    @Autowired
    PowerOrganisationRepository por;


//       @CrossOrigin("http://localhost:4200")
//       @PostMapping("/register")
//       public boolean registerDataviewer(@RequestBody RegisteredDataviewer entity) {

//                 if(rdvr.save(entity) == null)
//                         return false;
//                 return true;        
//       }

        @CrossOrigin("http://localhost:4200")
        @PostMapping(value = "/register")
        public boolean newRegisteredUser(@RequestBody RegisteredDataviewer entity, HttpServletResponse resp) {
                String[] code = entity.getAuthorisationCode().split("-");
                if (code.length == 5) {
                        PowerOrganisation provider = por.findByStateCodeAndDistCodeAndLocalCodeAndOrganisationIdentifier(code[0].trim(),code[1].trim(), code[2].trim(), code[3].trim());
                        RegisteredDataviewer rdv = new RegisteredDataviewer(provider, code[4].trim(), entity.getEmail(),
                                        entity.getPassword(), entity.getType());
                        rdvr.save(rdv);
                        return true;
                } else {
                        resp.setStatus(400);
                        return false;
                }
        }

      @CrossOrigin("http://localhost:4200")
      @PostMapping("/login")
      public RegisteredDataviewer login(@RequestBody RegisteredDataviewer rdv) {
              RegisteredDataviewer rd = rdvr.findByEmailAndPassword(rdv.getEmail(),rdv.getPassword());
              return rd;

      }
}