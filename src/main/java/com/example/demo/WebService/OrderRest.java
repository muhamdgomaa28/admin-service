package com.example.demo.WebService;


import com.example.demo.ServiceImpl.orderServiceImpl;
import com.example.demo.entities.Customers;
import com.example.demo.entities.Orders;
import com.example.demo.entities.Payment;
import com.example.demo.entities.Shippers;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// basic Url
//http://localhost:8080
@RestController
@RequestMapping("/rest")
public class OrderRest {

    @Autowired
    orderServiceImpl orderService;
    /*
     * in this week
     * ...where work_details.dated <= current_date and (work_details.dated + 0) >= (current_date - 7)
     *
     * in this month
     * select so from SomeObject so where MONTH(so.date) = MONTH(:date)
     *
     *
     * */


    // insert
    @ApiOperation(value = "View a list of available Orders", response = Orders.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully Added "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 204, message = "Not Countent Found"),
            @ApiResponse(code = 400, message = "bad Request please Fill All parameters ")
    }
    )
    @RequestMapping(value = "/order", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> insert(
            @RequestParam(required = true, name = "payment", defaultValue = "0") int paymentId,
            @RequestParam(required = true, name = "shipper", defaultValue = "0") int shipperId,
            @RequestParam(required = true, name = "customer") int customerId,

            @RequestBody Orders order) {
        if (order == null) {
            return new ResponseEntity<String>("Please add Orders details !!", HttpStatus.NO_CONTENT);

        }
        order.setPayment(new Payment(paymentId));
        order.setShippers(new Shippers(shipperId));
        order.setCustomers(new Customers(customerId));

        // encrypt password before insert Orders
        Orders b = orderService.saveOrders(order);

        return new ResponseEntity<Orders>(b, HttpStatus.CREATED);

    }


// get orders in this week

    @ApiOperation(value = "View a list of available Orders", response = Orders.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/order/week", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> GetAllInWeek() {
        List<Orders> orders = orderService.getAllInWeek();
        if (orders.size() == 0) {
            return new ResponseEntity<String>("Orders Not Found !!",
                    HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);

        }


    }


// get orders in this month

    @ApiOperation(value = "View a list of available Orders", response = Orders.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/order/month", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> GetAllInMonth() {
        List<Orders> orders = orderService.getAllInMonth();
        if (orders.size() == 0) {
            return new ResponseEntity<String>("Orders Not Found !!",
                    HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);

        }


    }


    //getById
    @ApiOperation(value = "View available Orders", response = Orders.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> Getspecific(@PathVariable("id") int id) {

        Orders order = orderService.getOrdersById(id);
        if (order == null) {
            return new ResponseEntity<String>("Orders Not Found !!",
                    HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<Orders>(order, HttpStatus.OK);

        }


    }

    // getAll Orders 
    // getAll
    @ApiOperation(value = "View a list of available Orders", response = Orders.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/order", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> GetAll() {
        List<Orders> orders = orderService.getAll();
        if (orders.size() == 0) {
            return new ResponseEntity<String>("Orders Not Found !!",
                    HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);

        }


    }

    // Delete Order From System
    @ApiOperation(value = "Delete Available Order", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Deleted "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> DeleteOrder(@PathVariable("id") int id) {
        int result = orderService.deleteOrdersByAvailable(id);
        if (result == 0) {
            return new ResponseEntity<String>("Order Not Found !!", HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<String>("Done Delete Order ", HttpStatus.OK);

        }

    }


}
