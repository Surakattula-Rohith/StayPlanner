package com.stackroute.hotelservice.services;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.stackroute.hotelservice.exception.HotelIdDoesNotExistException;
import com.stackroute.hotelservice.exception.HotelNameNotFoundException;
import com.stackroute.hotelservice.exception.HotelOwnerIdAlreadyExistException;
import com.stackroute.hotelservice.exception.HotelOwnerIdDoesNotExistException;
import com.stackroute.hotelservice.model.Hotel;
import com.stackroute.hotelservice.model.HotelOwner;
import com.stackroute.hotelservice.model.Image;
import com.stackroute.hotelservice.repository.HotelOwnerRepository;
import com.stackroute.hotelservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.apache.commons.io.IOUtils;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelOwnerServiceImpl implements HotelOwnerService {
    @Autowired
    HotelOwnerRepository repository;
    @Autowired
    HotelRepository hotelRepository ;
    @Override
    public HotelOwner addHotelOwner(HotelOwner hotelOwner) throws HotelOwnerIdAlreadyExistException {
        HotelOwner hotelOwner1;
        Optional<HotelOwner> optionalHotel = repository.findById(hotelOwner.getOwnerId());
        if(optionalHotel.isPresent()){
            throw new HotelOwnerIdAlreadyExistException("Duplicate Owner Id");
        }
        else{

            Optional<List<Hotel>> optionalHotelList = Optional.ofNullable(hotelOwner.getHotelList());
            optionalHotelList.ifPresent(hotels ->
                hotels.forEach(hotel -> hotelRepository.save(hotel)));
            hotelOwner1= repository.save(hotelOwner);
        }
        return hotelOwner1;

    }
    @Override
    public List<HotelOwner> viewAllHotelOwner() {
        return repository.findAll();
    }

    @Override
    public boolean deleteHotelOwnerbyOwnerId(String ownerId) throws HotelOwnerIdDoesNotExistException {

        Optional<HotelOwner> optionalOwner = repository.findById(ownerId);
        if(optionalOwner.isPresent()){
            repository.deleteById(ownerId);
            return true;
        }else
            throw new HotelOwnerIdDoesNotExistException("Owner Id is not available in DB");
    }

    @Override
    public HotelOwner updateOwner(HotelOwner hotelOwner) throws HotelOwnerIdDoesNotExistException {
        Optional<HotelOwner> optionalOwner = repository.findById(hotelOwner.getOwnerId());
        if(optionalOwner.isPresent()){
            return repository.save(hotelOwner);
        }else
            throw new HotelOwnerIdDoesNotExistException("Owner Id is not Available in DB");
    }

    @Override
    public Optional<HotelOwner> getOwnerByOwnerId(String ownerId) {
        return repository.findById(ownerId);
    }
    @Override
    public HotelOwner addHotel(String ownerId, Hotel hotel) throws HotelOwnerIdDoesNotExistException {
        Optional<HotelOwner> optionalHotelOwner = repository.findById(ownerId);

        if (optionalHotelOwner.isEmpty()) {
            throw new HotelOwnerIdDoesNotExistException("notFound");
        } else {
            HotelOwner hotelOwner = optionalHotelOwner.get();
            List<Hotel> existHotel = hotelOwner.getHotelList();

            if (existHotel == null) {
                existHotel = new ArrayList<>(); // Create a new list if it's null
            }

            existHotel.add(hotel);
            hotelOwner.setHotelList(existHotel);
            Optional<List<Hotel>> optionalHotelList = Optional.ofNullable(hotelOwner.getHotelList());
            optionalHotelList.ifPresent(hotels ->
                    hotels.forEach(hotellist -> hotelRepository.save(hotel)));
            return repository.save(hotelOwner);
        }
    }

//    @Override
//    public List<HotelOwner> getHotelOwnerByAddr(String addr) {
//        return repository.findByAddr(addr);
//    }

    @Override
    public boolean deleteHotel(String ownerId, String hotelId) throws HotelOwnerIdDoesNotExistException, HotelIdDoesNotExistException {
        Optional<HotelOwner> hotelOwner = repository.findById(ownerId);
        if(hotelOwner.isEmpty()){
            throw new HotelOwnerIdDoesNotExistException("Not Found");
        }
        else {
            HotelOwner hotelOwner1 = hotelOwner.get();
            List<Hotel> existHotel = hotelOwner1.getHotelList();
            existHotel.removeIf((med) ->med.getHotelId().equals(hotelId));
            hotelOwner1.setHotelList(existHotel);
            repository.save(hotelOwner1);
            return true;
        }
    }

    @Override
    public Hotel getHotelByName(String ownerId, String hotelName) throws HotelOwnerIdDoesNotExistException, HotelNameNotFoundException {

        Optional<HotelOwner> hotelOwner = repository.findById(ownerId);
        if(ownerId.isEmpty()){
            throw new HotelOwnerIdDoesNotExistException("Not Found");
        }
        else {
            HotelOwner existHotelOwner = hotelOwner.get();
            List<Hotel> existHotelList = existHotelOwner.getHotelList();
            Optional<Hotel> hotelresult = existHotelList.stream().
                    filter(hotel -> hotel.getHotelName().equals(hotelName)).findFirst();

            if(hotelresult.isEmpty()){
                throw new HotelNameNotFoundException("Not Found");
            }
            else {
                return hotelresult.get();
            }
        }


    }
    @Override
    public Hotel getHotelByAddress(String ownerId, String hotelAddress) throws HotelOwnerIdDoesNotExistException, HotelNameNotFoundException {

        Optional<HotelOwner> hotelOwner = repository.findById(ownerId);
        if(ownerId.isEmpty()){
            throw new HotelOwnerIdDoesNotExistException("Not Found");
        }
        else {
            HotelOwner existHotelOwner = hotelOwner.get();
            List<Hotel> existHotelList = existHotelOwner.getHotelList();
            Optional<Hotel> hotelresult = existHotelList.stream().
                    filter(hotel -> hotel.getHotelAddress().equals(hotelAddress)).findFirst();

            if(hotelresult.isEmpty()){
                throw new HotelNameNotFoundException("Not Found");
            }
            else {
                return hotelresult.get();
            }
        }


    }
    @Autowired
    private GridFsTemplate template;
    @Autowired
    private GridFsOperations operations;

    public String addFile(MultipartFile upload) throws IOException {

        //define additional metadata
        DBObject metadata = new BasicDBObject();
        metadata.put("fileSize", upload.getSize());

        //store in database which returns the objectID
        Object fileID = template.store(upload.getInputStream(), upload.getOriginalFilename(), upload.getContentType(), metadata);

        //return as a string
        return fileID.toString();
    }

    public Image downloadFile(String id) throws IOException {

        //search file
        GridFSFile gridFSFile = template.findOne( new Query(Criteria.where("_id").is(id)) );


        //convert uri to byteArray
        //save data to LoadFile class
        Image image = new Image();

        if (gridFSFile != null && gridFSFile.getMetadata() != null) {
            image.setFilename( gridFSFile.getFilename() );

            image.setFileType( gridFSFile.getMetadata().get("_contentType").toString() );

            image.setFileSize( gridFSFile.getMetadata().get("fileSize").toString() );

            image.setFile( IOUtils.toByteArray(operations.getResource(gridFSFile).getInputStream()) );
        }

        return image;
    }

}
