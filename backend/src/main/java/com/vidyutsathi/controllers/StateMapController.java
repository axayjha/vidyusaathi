package com.vidyutsathi.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vidyutsathi.models.BoundingBox;
import com.vidyutsathi.models.Coordinate;
import com.vidyutsathi.models.DistrictMap;
import com.vidyutsathi.models.LocationCode;
import com.vidyutsathi.models.PowerOrganisation;
import com.vidyutsathi.models.StateMap;
import com.vidyutsathi.repository.StateMapRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/state")
public class StateMapController {
    

    @Autowired
    StateMapRepository smr;
    
    @CrossOrigin("http://localhost:4200")
    @PostMapping(value="/add")
    public StateMap addStateMap(@RequestBody StateMap sm) {
        StateMap psm = smr.save(sm);
        return psm;
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping(value="/addDist")
    public StateMap addDistrictMap(@RequestBody StateMap sm) {
        StateMap psm = smr.findByStateCode(sm.getStateCode());
        List<DistrictMap> dl = new ArrayList<>();
        dl.addAll(psm.getDistrictList());
        dl.addAll(sm.getDistrictList());
        psm.setDistrictList(dl);
        smr.save(psm);
        return psm;
    }
    
    @CrossOrigin("http://localhost:4200")
    @PostMapping(value="/addLoc")
    public StateMap addLocationCode(@RequestBody StateMap sm) {
        StateMap psm = smr.findByStateCode(sm.getStateCode());
        for (DistrictMap var : psm.getDistrictList()) {
            if(var.getDistCode().equals(sm.getDistrictList().get(0).getDistCode())){
                List<LocationCode> ll = new ArrayList<>();
                ll.addAll(var.getLocality());
                ll.addAll(sm.getDistrictList().get(0).getLocality());
                var.setLocality(ll);
                smr.save(psm);
                break;
            }
        }
        // psm.getDistrictList().addAll(sm.getDistrictList());
        return psm;
    }

    @CrossOrigin("http://localhost:4200")

    @GetMapping("/getAll")
	public List<StateMap> getAll() {
		List<StateMap> list_of_statemaps = smr.findAll();
		return list_of_statemaps;
	}
    
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/delete")
	public void deleteStateMap(@RequestBody StateMap sm) {
		smr.deleteById(sm.getId());
    }
    
    @CrossOrigin("http://localhost:4200")
    @PostMapping(value="/locateState")
    public StateMap locateStateMap(@RequestBody Coordinate co) {
        List<StateMap> list_of_StateMaps = smr.findAll();
        StateMap psm = list_of_StateMaps.get(0);
        for (StateMap i : list_of_StateMaps) {
            for (DistrictMap j : i.getDistrictList()) { 
                for (LocationCode ipw : j.getLocality()) {
                    if((ipw.getBoundingBox().getUpperLeft().getLat()<co.getLat() && ipw.getBoundingBox().getUpperLeft().getLng()<co.getLng()) && (ipw.getBoundingBox().getLowerRight().getLat()>co.getLat() && ipw.getBoundingBox().getLowerRight().getLng()>co.getLng())){
                        psm = i;
                        List<LocationCode> ll = new ArrayList<>();
                        ll.add(ipw);
                        DistrictMap k = new DistrictMap(j);
                        k.setLocality(ll);
                        List<DistrictMap> dl = new ArrayList<>();
                        dl.add(k);
                        psm.setDistrictList(dl);
                        break;
                    }
                }
            }
        }
        return psm;
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping(value="/getStateName")
    public StateMap getStateMapName(@RequestBody StateMap sm) {
        StateMap psm = smr.findByStateCode(sm.getStateCode());
        for (DistrictMap var : psm.getDistrictList()) { 
            if(var.getDistCode().equals(sm.getDistrictList().get(0).getDistCode())){
                for (LocationCode ipw : var.getLocality()) {
                    if(ipw.getLocationCode().equals(sm.getDistrictList().get(0).getLocality().get(0).getLocationCode())){
                        List<LocationCode> ll = new ArrayList<>();
                        ll.add(ipw);
                        DistrictMap k = new DistrictMap(var);
                        k.setLocality(ll);
                        List<DistrictMap> dl = new ArrayList<>();
                        dl.add(k);
                        psm.setDistrictList(dl);
                        break;
                    }
                }
            }
        }

        return psm;
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping(value="/getPOState")
    public StateMap getPOStateMap(@RequestBody PowerOrganisation po) {
        StateMap psm = smr.findByStateCode(po.getStateCode());
        for (DistrictMap var : psm.getDistrictList()) { 
            if(var.getDistCode().equals(po.getDistCode())){
                for (LocationCode ipw : var.getLocality()) {
                    if(ipw.getLocationCode().equals(po.getLocalCode())){
                        List<LocationCode> ll = new ArrayList<>();
                        ll.add(ipw);
                        DistrictMap k = new DistrictMap(var);
                        k.setLocality(ll);
                        List<DistrictMap> dl = new ArrayList<>();
                        dl.add(k);
                        psm.setDistrictList(dl);
                        break;
                    }
                }
            }
        }
        
        return psm;
    }


}