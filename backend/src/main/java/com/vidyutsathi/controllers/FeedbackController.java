package com.vidyutsathi.controllers;

import java.util.ArrayList;
import java.util.List;

import com.vidyutsathi.models.Feedback;
import com.vidyutsathi.models.PowerMeasurement;
import com.vidyutsathi.models.PowerOrganisation;
import com.vidyutsathi.models.PowerOrganisationInfo;
import com.vidyutsathi.repository.FeedbackRepository;
import com.vidyutsathi.repository.PowerOrganisationInfoRepository;
import com.vidyutsathi.repository.PowerOrganisationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/feedback")

public class FeedbackController{

        @Autowired
        FeedbackRepository fbr;

        @Autowired
        PowerOrganisationRepository por;

        @Autowired
        PowerOrganisationInfoRepository poir;

        @CrossOrigin("http://localhost:4200")
        @PostMapping(value="/give")
        public boolean give(@RequestBody Feedback entity) {
                System.out.println(entity.getTimestampEnd());
                PowerOrganisation pr = por.findByStateCodeAndDistCodeAndLocalCodeAndOrganisationIdentifier(entity.getProvider().getStateCode(), entity.getProvider().getDistCode(), entity.getProvider().getLocalCode(), entity.getProvider().getOrganisationIdentifier())
                entity.setProvider(pr);
                if(fbr.save(entity) == null)
                        return false;
                return true;        
        }

        @CrossOrigin("http://localhost:4200")
        @PostMapping(value="/getByLocality")
        public List<Feedback> getByLocality(@RequestBody PowerOrganisation pr) {
                PowerOrganisation po = por.findByStateCodeAndDistCodeAndLocalCodeAndOrganisationIdentifier(pr.getStateCode(), pr.getDistCode(), pr.getLocalCode(), pr.getOrganisationIdentifier());
                return fbr.findAllByProvider(po);

        }


        @CrossOrigin("http://localhost:4200")
        @PostMapping(value="/getByDistrict")
        public List<Feedback> getByDistrict(@RequestBody PowerOrganisation pr ) {
                PowerOrganisation po = por.findByStateCodeAndDistCode(pr.getStateCode(), pr.getDistCode());
                return fbr.findAllByProvider(po);

        }

        @CrossOrigin("http://localhost:4200")
        @PostMapping(value="/getByState")
        public List<Feedback> getByState(@RequestBody PowerOrganisation pr ) {
                PowerOrganisation po = por.findByStateCode(pr.getStateCode());
                return fbr.findAllByProvider(po);

        }

        //TODO LOTTA THINGS

        @CrossOrigin("http://localhost:4200")
        @GetMapping("/getAll")
        public List<Feedback> getAll() {
            List<Feedback> list_of_feedbacks = fbr.findAll();
            return list_of_feedbacks;
        }

        @CrossOrigin("http://localhost:4200")
        @PostMapping(value="/getYearSum")
        public PowerMeasurement getYearSum(@RequestBody PowerOrganisation po) {
                PowerOrganisationInfo poi = poir.findByProvider(po);
                PowerMeasurement pm = new PowerMeasurement(poi.getYearseries().get(0).getTimeseries(), 0, poi.getYearseries().get(0).getUnit_price());
                double total_units_consumed = 0;
                for (PowerMeasurement var : poi.getYearseries()) {
                        total_units_consumed = total_units_consumed + var.getUnits_consumed();
                }
                pm.setUnits_consumed(total_units_consumed);
                return pm;
        }

        @CrossOrigin("http://localhost:4200")
        @PostMapping(value="/getMonthSum")
        public PowerMeasurement getMonthSum(@RequestBody PowerOrganisation po) {
                PowerOrganisationInfo poi = poir.findByProvider(po);
                PowerMeasurement pm = new PowerMeasurement(poi.getMonthseries().get(0).getTimeseries(), 0, poi.getMonthseries().get(0).getUnit_price());
                double total_units_consumed = 0;
                for (PowerMeasurement var : poi.getMonthseries()) {
                        total_units_consumed = total_units_consumed + var.getUnits_consumed();
                }
                pm.setUnits_consumed(total_units_consumed);
                return pm;
        }

        @CrossOrigin("http://localhost:4200")
        @PostMapping(value="/getDaySum")
        public PowerMeasurement getDaySum(@RequestBody PowerOrganisation po) {
                PowerOrganisationInfo poi = poir.findByProvider(po);
                PowerMeasurement pm = new PowerMeasurement(poi.getDayseries().get(0).getTimeseries(), 0, poi.getDayseries().get(0).getUnit_price());
                double total_units_consumed = 0;
                for (PowerMeasurement var : poi.getDayseries()) {
                        total_units_consumed = total_units_consumed + var.getUnits_consumed();
                }
                pm.setUnits_consumed(total_units_consumed);
                return pm;
        }

        @CrossOrigin("http://localhost:4200")
        @PostMapping(value="/getDayMedian")
        public PowerMeasurement getDayMedian(@RequestBody PowerOrganisation po) {
                PowerOrganisationInfo poi = poir.findByProvider(po);
                PowerMeasurement pm = new PowerMeasurement(poi.getDayseries().get(0).getTimeseries(), 0, poi.getDayseries().get(0).getUnit_price());
                double total_units_consumed = 0;
                List<Double> md = new ArrayList<>();
                for (PowerMeasurement var : poi.getDayseries()) {
                        // total_units_consumed = total_units_consumed + var.getUnits_consumed();
                        md.add(var.getUnits_consumed());
                }
                md.sort(null);
                pm.setUnits_consumed(md.get(md.size()/2));
                return pm;
        }

        @CrossOrigin("http://localhost:4200")
        @PostMapping(value="/getTimeDiffMedian")
        public Long getTimeDiffMedian(@RequestBody Feedback fb) {
                List<Feedback> lfb = new ArrayList<>();
                List<Long> md = new ArrayList<>();
                for (Feedback var : fbr.findAll()) {
                        if(var.getTimestampStart()>=fb.getTimestampStart() && var.getTimestampEnd()<=fb.getTimestampEnd()){
                                lfb.add(var);
                                md.add((var.getTimestampEnd()-var.getTimestampStart()));
                        }
                }
                md.sort(null);
                // double total_units_consumed = 0;
                return md.get(md.size()/2);
        }

}