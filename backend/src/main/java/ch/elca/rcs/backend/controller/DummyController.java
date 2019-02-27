package ch.elca.rcs.backend.controller;

import ch.elca.rcs.backend.domain.DummyEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="dummyctrl", description="Just a sample controller for demo purposes")
public class DummyController {

    @ApiOperation(value = "Returns some dummy text", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully returned the text"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Operation not authorized"),
            @ApiResponse(code = 404, message = "Resource not found")
    })
    @RequestMapping(value = "/dummy", method = RequestMethod.POST)
    public String dummy() {
        return "dummy";
    }

    @ApiOperation(value = "Returns some dummy text", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully returned the text"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Operation not authorized"),
            @ApiResponse(code = 404, message = "Resource not found")
    })

    @RequestMapping(value = "/sendDummy", method = RequestMethod.POST)
    public void sendDummy(@RequestBody DummyEntity sendDummy) {
    }
}