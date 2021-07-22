package com.vidyutsathi.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vidyutsathi.models.Coordinate;
import com.vidyutsathi.models.PowerOrganisation;
import com.vidyutsathi.models.PowerOrganisationInfo;
import com.vidyutsathi.models.PowerMeasurement;
import com.vidyutsathi.repository.PowerOrganisationInfoRepository;
import com.vidyutsathi.repository.PowerOrganisationRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/org")
public class PowerOrganisationController {
    
    @Autowired
    PowerOrganisationRepository por;

    @Autowired
    PowerOrganisationInfoRepository poir;

    @CrossOrigin("http://localhost:4200")
    @PostMapping(value="/add")
    public PowerOrganisation addPowerOrganisation(@RequestBody PowerOrganisation po) {
        PowerOrganisation ppo = por.save(po);
        return ppo;
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping(value="/addInfo")
    public PowerOrganisationInfo addPowerOrganisationInfo(@RequestBody PowerOrganisationInfo poi) {
        PowerOrganisationInfo ppoi = poir.save(poi);
        return ppoi;
    }
    
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/getAll")
	public List<PowerOrganisation> getAll() {
		List <PowerOrganisation> list_of_PowerOrganisations = por.findAll();
		return list_of_PowerOrganisations;
    }
    
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/getAllInfo")
	public List<PowerOrganisationInfo> getAllInfo() {
		List <PowerOrganisationInfo> list_of_PowerOrganisationInfos = poir.findAll();
		return list_of_PowerOrganisationInfos;
	}
    
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/delete")
	public void deletePowerOrganisation(@RequestBody PowerOrganisation po) {
		por.deleteById(po.getId());
	}

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/deleteInfo")
	public void deletePowerOrganisationInfo(@RequestBody PowerOrganisationInfo poi) {
		poir.deleteById(poi.getId());
    }
    
    @CrossOrigin("http://localhost:4200")
    @PostMapping(value="/locatePO")
    public PowerOrganisation locatePowerOrganisation(@RequestBody Coordinate co) {
        List <PowerOrganisationInfo> list_of_PowerOrganisationInfos = poir.findAll();
        PowerOrganisationInfo ppoi = list_of_PowerOrganisationInfos.get(0);
        for (PowerOrganisationInfo ipw : list_of_PowerOrganisationInfos) {
            if((ipw.getServiceArea().getUpperLeft().getLat()<co.getLat() && ipw.getServiceArea().getUpperLeft().getLng()<co.getLng()) && (ipw.getServiceArea().getLowerRight().getLat()>co.getLat() && ipw.getServiceArea().getLowerRight().getLng()>co.getLng())){
                ppoi = ipw;
            }
        }
        return ppoi.getProvider();
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/getYears")
	public List<PowerMeasurement> getYears(@RequestBody PowerOrganisationInfo po) {
		PowerOrganisation pop = po.getProvider();
		PowerOrganisationInfo ppo = poir.findByProvider(pop);
		return ppo.getYearseries();
    }
    
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/getMonths")
	public List<PowerMeasurement> getMonths(@RequestBody PowerOrganisationInfo po) {
		PowerOrganisation pop = po.getProvider();
		PowerOrganisationInfo ppo = poir.findByProvider(pop);
		return ppo.getMonthseries();
    }
    
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/getDays")
	public List<PowerMeasurement> getDays(@RequestBody PowerOrganisationInfo po) {
		PowerOrganisation pop = po.getProvider();
		PowerOrganisationInfo ppo = poir.findByProvider(pop);
		return ppo.getDayseries();
    }

}