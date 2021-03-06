package com.example.demo.WebService;

import java.util.Arrays;
import java.util.List;

import com.example.demo.Security.EncryptPassword;
import com.example.demo.ServiceImpl.AdminServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.ServiceImpl.BusinessServiceImpl;
import com.example.demo.entities.Business;
import org.springframework.web.client.RestTemplate;

// basic Url
//http://localhost:9091
@RestController
@RequestMapping("/rest")
@Api(value = "BusinessIn Business")

public class BusinessRest {

    @Autowired
    BusinessServiceImpl businessServiceImpl;
    @Autowired
    AdminServiceImpl adminServiceImpl;

    // insert
    @ApiOperation(value = "View a list of available Business", response = Business.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully Added "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 204, message = "Not Countent Found"),
            @ApiResponse(code = 400, message = "bad Request please Fill All parameters ")
    }
    )
    @RequestMapping(value = "/business", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> insert(@RequestBody Business busines) {
        if (busines == null) {
            return new ResponseEntity<String>("Please add Business details !!", HttpStatus.NO_CONTENT);

        }

        // check email , password
        if (busines.getEmail() == "") {

            return new ResponseEntity<String>("Please provide the Email and password", HttpStatus.BAD_REQUEST);

        }


        Business b = businessServiceImpl.saveBusiness(busines);

        return new ResponseEntity<Business>(b, HttpStatus.CREATED);

    }

    // getById
    @ApiOperation(value = "View available Business", response = Business.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/business/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> Getspecific(@PathVariable("id") String id) {

        Business business = businessServiceImpl.getBusinessById(Integer.parseInt(id));
        if (business == null) {
            return new ResponseEntity<String>("Business Not Found !!",
                    HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<Business>(business, HttpStatus.OK);

        }


    }

    // getAll
    @ApiOperation(value = "View a list of available Business", response = Business.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/business", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> GetAll() {
        List<Business> business = businessServiceImpl.getAll();
        if (business.size() == 0) {
            return new ResponseEntity<String>("Business Not Found !!",
                    HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<List<Business>>(business, HttpStatus.OK);

        }


    }


    // Update General
    @ApiOperation(value = "Update Avaliable Business", response = Business.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Updated "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/business", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> UpdateTopic(@RequestBody Business busines) {

        Business business = businessServiceImpl.updateBusiness(busines);
        if (business == null) {
            return new ResponseEntity<String>("Business Not Found !!", HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<Business>(business, HttpStatus.OK);

        }
    }
    // Update Password


    // Delete Business Account From System
    @ApiOperation(value = "Delete Available Business", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Deleted "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/business/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> DeleteTopic(@PathVariable("id") int id) {
        // delete all admins and all products first by cascading option
        int result = businessServiceImpl.deleteBusinessByAvailable(id);
        if (result == 0) {
            return new ResponseEntity<String>("Business Not Found !!", HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<String>("Done Delete Business ", HttpStatus.OK);

        }

    }


    // get all cities by Country
    @ApiOperation(value = "View available city", response = Business.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/business/city", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> GetCityDone(
            @RequestParam(required = true, name = "country", defaultValue = "egypt") String country

    ) {

        // HttpHeaders
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Mashape-Key", "OHpIbZrnlnmshrI4PGSy2pEEqF2Qp1kHQbgjsnjKWrcv5fTqEz");

        // HttpEntity<String>: To get result as String.
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method, and Headers.
        ResponseEntity<String> response = restTemplate.exchange("https://andruxnet-world-cities-v1.p.mashape.com/?query=" + country + "&searchby=country", //
                HttpMethod.GET, entity, String.class);

        String result = response.getBody();

        System.out.println(result);

        return new ResponseEntity<String>(result, HttpStatus.OK);


    }


}
