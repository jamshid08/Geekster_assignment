package org.geekster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiTest {
@Autowired
    MailHandlerBase mailHandler;  // gets the bean of  MailHandlerBase created by SB



   @Autowired    // will get the object of myClass created using  createname2 because it is primary
    myClass obj;



    @GetMapping("api/call2/james")
    public myClass api2()
    {
        mailHandler.sendMail(obj.toString());
        return obj;


    }





}
