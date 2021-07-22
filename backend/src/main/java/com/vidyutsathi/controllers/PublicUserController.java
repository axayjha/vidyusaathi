package com.vidyutsathi.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vidyutsathi.models.BoundingBox;
import com.vidyutsathi.models.Coordinate;
import com.vidyutsathi.models.DistrictMap;
import com.vidyutsathi.models.Feedback;
import com.vidyutsathi.models.LocationCode;
import com.vidyutsathi.models.PowerOrganisation;
import com.vidyutsathi.models.PowerOrganisationInfo;
import com.vidyutsathi.models.PowerMeasurement;
import com.vidyutsathi.models.PublicCustomers;
import com.vidyutsathi.models.PublicUser;
import com.vidyutsathi.models.RegisteredDataviewer;
import com.vidyutsathi.models.StateMap;
import com.vidyutsathi.repository.FeedbackRepository;
import com.vidyutsathi.repository.PowerOrganisationInfoRepository;
import com.vidyutsathi.repository.PowerOrganisationRepository;
import com.vidyutsathi.repository.PublicCustomerRepository;
import com.vidyutsathi.repository.PublicUserRepository;
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
@RequestMapping("/user")
public class PublicUserController {
    
    @Autowired
    FeedbackRepository fbr;

    @Autowired
    PowerOrganisationRepository por;

    @Autowired
    PowerOrganisationInfoRepository poir;


    @Autowired
    PublicCustomerRepository pcr;

    @Autowired
    PublicUserRepository pur;

    @Autowired
    RegisteredDataViewersRepository rdvr;


    @Autowired
    StateMapRepository smr;
    
    // @GetMapping(value="/test")
    // public String getMethodName() {
    //     //Test DB
    //     PowerOrganisation pwo = new PowerOrganisation("WB", "HGY", "HGY", "0001");
    //     BoundingBox sa = new BoundingBox(new Coordinate(1.234, 1.234), new Coordinate(2.111, 2.111));
    //     PowerOrganisationInfo pwio = new PowerOrganisationInfo(pwo, sa, "TEST", "address");
    //     por.save(pwo);
    //     poir.save(pwio);
    //     pwo = new PowerOrganisation("WB", "HGY", "HGY", "0002");
    //     sa = new BoundingBox(new Coordinate(2.111, 2.111), new Coordinate(3.222, 3.222));
    //     pwio = new PowerOrganisationInfo(pwo, sa, "TEST", "address");
    //     por.save(pwo);
    //     poir.save(pwio);

    //     List<String> cuid = new ArrayList<String>();
    //     cuid.add("CUUIIID");
    //     PublicCustomers pc = new PublicCustomers(pwo, cuid);
    //     pcr.save(pc);

    //     PublicUser pu = new PublicUser("arnb.sen@mail.com", "pass",pwo, "CUUIID");
    //     pur.save(pu);

    //     RegisteredDataviewer rdv = new RegisteredDataviewer(pwo, "AU01", "arnb.sen@mail.com", "pass", "G");
    //     rdvr.save(rdv);

    //     Feedback fb = new Feedback(pwo, Long.valueOf(100000), Long.valueOf(100000));
    //     fbr.save(fb);

    //     LocationCode lc = new LocationCode("HOOGHLY", "6000", 10000.0, 1000.0, new BoundingBox(new Coordinate(1.234, 1.234), new Coordinate(3.222, 3.222)));
    //     List<LocationCode> lcl = new ArrayList<LocationCode>();
    //     lcl.add(lc);
    //     DistrictMap dm = new DistrictMap("00", "HOOGHLY", lcl);
    //     List<DistrictMap> dml = new ArrayList<DistrictMap>();
    //     dml.add(dm);
    //     StateMap sm = new StateMap("00", "WEST BENGAL", dml);
    //     smr.save(sm);

    //     return "";


    // }
    
    // @PostMapping(value="/register")
    // public boolean newRegisteredUser(@RequestBody RegisteredDataviewer entity, HttpServletResponse resp) {
    //     String [] code = entity.getAuthorisationCode().split("-");
    //     if (code.length == 5) {
    //         PowerOrganisation provider = por.findByStateCodeAndDistCodeAndLocalCodeAndOrganisationIdentifier(code[0].trim(), code[1].trim(), code[2].trim(), code[3].trim());
    //         RegisteredDataviewer rdv = new RegisteredDataviewer(provider, code[4].trim(), entity.getEmail(), entity.getPassword(), entity.getType());
    //         rdvr.save(rdv);
    //         return true;
    //     } else {
    //         resp.setStatus(400);
    //         return false;
    //     }
    // }
    @CrossOrigin("http://localhost:4200")
    @PostMapping(value="/register")
    public boolean newRegisteredUser(@RequestBody PublicUser entity) {
       if (pur.save(entity) == null)
        return false;
       return true; 
       
    }
    @CrossOrigin("http://localhost:4200")
    @PostMapping(value="/login") 
    public PublicUser login(@RequestBody PublicUser usr) {
        System.out.println(usr);
        PublicUser a = pur.findByEmailAndPassword(usr.getEmail(), usr.getPassword());
        //a.setId(null);
        return a;
    }

    // @CrossOrigin("http://localhost:4200")
    // @PostMapping(value="/verify")
    // public boolean verifyCustID(@RequestBody PowerOrganisation pwrOrg, @RequestBody String customerID) {
    //         return pcr.findByProviderAndCustomerID(pwrOrg, customerID);            
    // }

    
    
    

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/getAll")
	public List<PublicUser> getAll() {
		List <PublicUser> list_of_users = pur.findAll();
		return list_of_users;
	}
    
    // @CrossOrigin("http://localhost:4200")
    // @PostMapping("/getYears")
	// public List<PowerMeasurement> getYears(@RequestBody PublicUser pu) {
	// 	String puId = pu.getEmail();
	// 	PublicUser ppu = pur.findByEmail(puId);
	// 	return ppu.getYearseries();
    // }
    
    // @CrossOrigin("http://localhost:4200")
    // @PostMapping("/getMonths")
	// public List<PowerMeasurement> getMonths(@RequestBody PublicUser pu) {
	// 	String puId = pu.getEmail();
	// 	PublicUser ppu = pur.findByEmail(puId);
	// 	return ppu.getMonthseries();
    // }
    
    // @CrossOrigin("http://localhost:4200")
    // @PostMapping("/getDays")
	// public List<PowerMeasurement> getDays(@RequestBody PublicUser pu) {
	// 	String puId = pu.getEmail();
	// 	PublicUser ppu = pur.findByEmail(puId);
	// 	return ppu.getDayseries();
    // }
    
    


}