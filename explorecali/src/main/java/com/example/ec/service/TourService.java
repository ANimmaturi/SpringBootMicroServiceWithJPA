package com.example.ec.service;

import com.example.ec.model.Difficulty;
import com.example.ec.model.Region;
import com.example.ec.model.Tour;
import com.example.ec.model.TourPackage;
import com.example.ec.repo.TourPackageRepository;
import com.example.ec.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TourService {

    private TourPackageRepository tourPackageRepository;
    private TourRepository tourRepository;

    @Autowired
    public TourService(TourPackageRepository tourPackageRepository, TourRepository tourRepository) {
        this.tourPackageRepository = tourPackageRepository;
        this.tourRepository = tourRepository;
    }

    public Tour createTour(String title, String description, String blurb, Integer price, String duration,String bullets
    ,String keywords,String tourPackageCode, Difficulty difficulty, Region region){
        Optional<TourPackage> tourPackage = tourPackageRepository.findById(tourPackageCode);

        if(!tourPackage.isPresent()){
            throw new RuntimeException("tour package does not exist:" + tourPackage);
        }
        TourPackage existingTourPackage = tourPackage.get();

        return tourRepository.save(new Tour(title,description,blurb,price,duration,bullets,keywords,existingTourPackage,region,difficulty));
    }

    public  Iterable<Tour> lookup(){
        return tourRepository.findAll();
    }

    public long total(){
        return tourRepository.count();
    }
}
