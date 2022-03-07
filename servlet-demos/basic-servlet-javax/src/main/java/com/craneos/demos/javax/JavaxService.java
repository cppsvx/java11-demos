package com.craneos.demos.javax;

import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("javaxmessage")
public class JavaxService extends Application {

    public String getMessage(){
        return "done!";
    }

}